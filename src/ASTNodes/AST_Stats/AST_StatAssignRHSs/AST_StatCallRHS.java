package ASTNodes.AST_Stats.AST_StatAssignRHSs;

import ASTNodes.AST_Exprs.AST_Expr;
import ASTNodes.AST_Exprs.AST_ExprIdent;
import ASTNodes.AST_Node;
import ASTNodes.AST_FuncDecl;
import ASTNodes.AST_Program;
import ASTNodes.AST_ParamList;
import ASTNodes.AST_Param;
import IdentifierObjects.FunctionObj;
import IdentifierObjects.BaseTypeObj;
import IdentifierObjects.IDENTIFIER;
import InstructionSet.Instruction;
import Registers.RegisterAllocation;
import SymbolTable.SymbolTable;
import ErrorMessages.MissingParameterError;
import ErrorMessages.TypeError;
import ErrorMessages.UndefinedFunctionError;
import src.FilePosition;
import VisitorClass.AST_NodeVisitor;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * Class representing node in AST tree for CALL ASSIGNMENT
 */
public class  AST_StatCallRHS extends AST_StatAssignRHS {

  //Syntactic attributes
  String funcName;
  int numOfExpr;
  List<AST_Expr> ast_exprList;
  ParserRuleContext ctx;
  SymbolTable symbolTable;

  /**
   * Constructor for class - initialises class variables
   *
   * @param numberOfChildren - Shows the number of parameters in the parameter list of function
   */
  public AST_StatCallRHS(int numberOfChildren, ParserRuleContext ctx, SymbolTable symbolTable) {
    ast_exprList = new ArrayList<>();
    if (numberOfChildren == 4) {
      this.numOfExpr = 0;
    } else {
      this.numOfExpr = (numberOfChildren - 3) / 2;
    }
    this.funcName = null;
    this.ctx = ctx;
    this.symbolTable = symbolTable;
  }

  /**
   * Gets all children nodes of current node
   *
   * @return list of AST nodes that are the children of the current node
   */
  @Override
  public ArrayDeque<AST_Node> getNodes() {
    ArrayDeque<AST_Node> returnList = new ArrayDeque<>();
    if (ast_exprList.size() == 0) {
      return null;
    }
    for (AST_Expr expr : ast_exprList) {
      returnList.addLast(expr);
    }
    return returnList;
  }

  /**
   * Sets syntactic attributes of class variables by assigning it a value
   *
   * @param value - Value to be assigned to class variable
   */
  public void setSyntacticAttributes(String value, SymbolTable ST) {
    if (funcName == null) {
      this.funcName = value;
      identifier = ST.lookupAll(funcName);
    } else {
      System.out.println("Unrecognised String Attribute" + this.getClass().getSimpleName());
    }
  }

  /**
   * Gets syntactic attributes of class variables
   *
   * @param strToGet - Value to be retrieved from class variable
   */
  public String getSyntacticAttributes(String strToGet) {
    if (strToGet.equals("funcName")) {
      return funcName;
    } else {
      System.out.println("Unrecognised String Attribute" + this.getClass().getSimpleName());
      return null;
    }
  }

  /**
   * @param ST - Parameter of current symbol table in scope
   * @return - Returns the type of the identifier variable
   */
  @Override
  public String getType(SymbolTable ST) {
    //FunctionObj type = (FunctionObj)ST.lookupAll(funcName);
    System.out.println(ST.symMap.containsKey("f"));
    return "int"; //((FunctionObj)ST.lookupAll(funcName)).getReturnTypeName();
  }

  /**
   * Returns true if the embedded Nodes have value
   */
  public boolean isEmbeddedNodesFull() {
    return ast_exprList.size() == numOfExpr;
  }

  /**
   * @param astToGet Shows which child to get from current node
   * @param counter  Shows which child of child to get from current node
   * @return Returns the required child AST Node (determined by the astToGet parameter)
   */
  @Override
  public AST_Node getEmbeddedAST(String astToGet, int counter) {
    if (astToGet.equals("ast_exprList")) {
      return ast_exprList.get(counter);
    }
    System.out.println("Unrecognised AST Node at class: " + this.getClass().getSimpleName());
    return null;
  }

  /**
   * @param astToSet  Shows which child to set from current node
   * @param nodeToSet Shows which child of child to set from current node
   */
  @Override
  public void setEmbeddedAST(String astToSet, AST_Node nodeToSet) {
    if (astToSet.equals("expr")) {
      ast_exprList.add((AST_Expr) nodeToSet);
    } else {
      System.out.println("Unrecognised AST Node at class: " + this.getClass().getSimpleName());
    }
  }

  /**
   * Semantic Analysis and print error message if needed
   *
   */
  @Override
  public boolean CheckSemantics() {

    SymbolTable ST = this.symbolTable;
    System.out.println(funcName);
    System.out.println(ast_exprList);
    System.out.println(ST.getScope());

    //Nested function call case
    if (ST.getScope().equals("param_list") && ST.lookup(funcName) == null) {
      AST_Node tempNode = this;
      while (!(tempNode instanceof AST_FuncDecl)) {
        tempNode = tempNode.getParentNode();
      }

      if (!((AST_FuncDecl) tempNode).getFuncName().equals(funcName)) {
        new UndefinedFunctionError(new FilePosition(ctx)).printAll();
      }
      //Check parameters of paramList against expressions
      if (ast_exprList.size() > 0) {
        List<AST_Param> parameters = new ArrayList<>();
        parameters = ((AST_ParamList) tempNode.getEmbeddedAST("paramList", 0)).getListParam();

        if (parameters.size() != ast_exprList.size()) {
          new MissingParameterError(new FilePosition(ctx)).printAll();
        }

        for (int i = 0; i < ast_exprList.size(); i++) {
          String typeExpr = ast_exprList.get(i).getType();
          String typeParam = ((parameters.get(i)).getEmbeddedAST("ast_type", 0)).toString();
          if (!typeExpr.equals(typeParam)) {
            new TypeError(new FilePosition(ctx)).printAll();
          }
        }
      }
    } else {
      //Non-nested function call case
      //Check parameters of paramList against expressions

      if (ast_exprList.size() > 0) {

        System.out.println(ast_exprList);
        AST_Node parent = this.getParentNode();
        System.out.println("Parent node is");
        System.out.println(parent);
        System.out.println(ST.lookupAll(funcName));

        List<IDENTIFIER> parameters = new ArrayList<>();

        //if it is a baseType obj, we add it to a list instead of assigning it
        if (ST.lookupAll(funcName) instanceof BaseTypeObj) {
          parameters.add(ST.lookupAll(funcName));
        } else if (ST.lookupAll(funcName) instanceof FunctionObj) {
          //TODO BaseTypeObj cannot cast to FunctionObj
          parameters = (((FunctionObj) (ST.lookupAll(funcName))).getparamListObj()).getParamObjList();
        }


        //checking if number of parameters is as expected
        if (parameters.size() != ast_exprList.size()) {
          new MissingParameterError(new FilePosition(ctx)).printAll();
          return false;
        }

        //Debug statement to see what is inside param
        System.out.println("List params are: ");
        for (IDENTIFIER param : parameters) {
          System.out.println(param);
        }
        System.out.println("ast_exprList.size: " + ast_exprList.size());

        for (int i = 0; i < ast_exprList.size(); i++) {

          //TODO check whether the type of param is the same as when it is declared

          //TODO set the value for ast_exprList because right now it is null
          IDENTIFIER typeParam = (IDENTIFIER) parameters.get(i);

          //Debug statement
          for (AST_Expr ast : ast_exprList) {
            System.out.println("AST_EXPR are");
            System.out.println(ast);
            System.out.println(ast.getIdentifier());
          }
          System.out.println("first elem: " + ast_exprList.get(i));
          System.out.println(ast_exprList);
          ast_exprList.get(i).printContents();

          //when size of the list i 1
          if (ast_exprList.size() == 1) {
            if (ast_exprList.get(i) instanceof AST_ExprIdent) {
              System.out.println("Hey, I'm instance of AST_ExprIdent");
              String varName = ((AST_ExprIdent) ast_exprList.get(i)).getVarName();
              SymbolTable tempST = ST;
              IDENTIFIER typeExpr = tempST.lookup(varName);
              System.out.println(typeExpr);

              while (typeExpr == null) {
                System.out.println("typeExpr is null");
                tempST = tempST.encSymTable;
                typeExpr = tempST.lookup(varName);
              }

              //TODO maybe there is a better method to check if it's a function call, then check both enc and current ST
              //check if it's null so can reassign again (hard coding)

              System.out.println("varName is:" + varName);
              System.out.println("typeExpr is: " + typeExpr);
              //IDENTIFIER typeParam = parameters.get(i);
              System.out.println("typeParam is: " + typeParam);
              if (!typeExpr.equals(typeParam)) {
                new TypeError(new FilePosition(ctx)).printAll();
                return false;
              } else {
                return true;
              }
            } else {
              System.out.println("Hello I'm here");
              IDENTIFIER typeExpr = ast_exprList.get(i).getIdentifier();
              //IDENTIFIER typeParam = parameters.get(i);
              if (!typeExpr.equals(typeParam)) {
                new TypeError(new FilePosition(ctx)).printAll();
                return false;
              } else {
                return true;
              }
            }
          }

          //Cases when the element is instance of AST_ExprIdent
          if (ast_exprList.get(i) instanceof AST_ExprIdent) {
            String varName = ((AST_ExprIdent) ast_exprList.get(i)).getVarName();
            IDENTIFIER typeExpr = ST.encSymTable.lookup(varName);

            while (!(parent instanceof AST_FuncDecl)) {
              if (parent instanceof AST_Program) {
                typeExpr = ST.lookup(varName);
                break;
              }
              parent = parent.getParentNode();
            }

            System.out.println("varName is:" + varName);
            System.out.println("typeExpr is: " + typeExpr);
            //IDENTIFIER typeParam = parameters.get(i);
            System.out.println("typeParam is: " + typeParam);

            if (typeExpr.toString().contains(typeParam.toString()) || typeParam.toString().contains(typeExpr.toString())) {
              return true;
            } else {
              new TypeError(new FilePosition(ctx)).printAll();
              return false;
            }
          }

          IDENTIFIER typeExpr = ast_exprList.get(i).getIdentifier();
          System.out.println(typeExpr);

          System.out.println();

          //IDENTIFIER typeParam = parameters.get(i);
          System.out.println(typeParam);

          if (!(typeExpr.toString().contains(typeParam.toString()) || typeParam.toString().contains(typeExpr.toString()))) {
            new TypeError(new FilePosition(ctx)).printAll();
            return false;
          }
        }
      }
      //Debug statement
      System.out.println(funcName);
      //TODO ST.lookup(funcname) returns null
      System.out.println(ST.lookup(funcName));
      //TODO this statement also has NullPointer exception
      setIdentifier(((FunctionObj) (ST.lookup(funcName))).getReturnType());
    }


    return true;
  }

  /**
   * Helper method to convert list of params to string
   */
  private String paramsToString() {
    String res = "(";
    for (int i = 0; i < ast_exprList.size(); i++) {
      res += (ast_exprList.get(i).toString() + ",");
    }
    return res + ")";
  }

  /**
   * Called from visitor
   *
   * @param ST
   */
  @Override
  public void Check(SymbolTable ST) {
    if (CheckSemantics()) {

    }

//    while(!ST.getScope().equals("TargetScope")){
//      ST = ST.encSymTable;
//    }

    //Do symbol table stuff
  }

  /**
   * Used for testing - Prints out contents of current AST node
   */
  @Override
  public void printContents() {
    System.out.println(this.getClass().getSimpleName() + ": ");
    System.out.println("funcName: " + funcName);
    System.out.println("numOfExpr: " + numOfExpr);
    if (ast_exprList.size() == numOfExpr) {
      System.out.println("ast_exprList: List full");
    } else {
      System.out.println("ast_exprList has size: " + ast_exprList.size());
    }
  }

  public void accept(AST_NodeVisitor visitor) {
    visitor.visit(this);
    for(AST_Expr expr : ast_exprList){
      expr.accept(visitor);
    }
  }

  public void genInstruction(List<Instruction> instructionList, RegisterAllocation registerAllocation) throws Exception {

  }

  public List<AST_Expr> getAst_exprList() {
    return ast_exprList;
  }
}

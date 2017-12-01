package ASTNodes.AST_Stats.AST_StatAssignRHSs;

import ASTNodes.AST_Exprs.AST_Expr;
import ASTNodes.AST_Exprs.AST_ExprArrayElem;
import ASTNodes.AST_Exprs.AST_ExprIdent;
import ASTNodes.AST_Exprs.AST_ExprLiter;
import ASTNodes.AST_Node;
import ASTNodes.AST_FuncDecl;
import ASTNodes.AST_ParamList;
import ASTNodes.AST_Param;
import ErrorMessages.TypeMismatchError;
import IdentifierObjects.FunctionObj;
import IdentifierObjects.BaseTypeObj;
import IdentifierObjects.IDENTIFIER;
import InstructionSet.Instruction;
import InstructionSet.InstructionCall;
import Registers.RegisterARM;
import Registers.RegisterAllocation;
import SymbolTable.SymbolTable;
import ErrorMessages.MissingParameterError;
import ErrorMessages.TypeError;
import ErrorMessages.UndefinedFunctionError;
import ErrorMessages.FilePosition;
import VisitorClass.AST_NodeVisitor;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * Class representing node in AST tree for CALL ASSIGNMENT
 */
public class AST_StatCallRHS extends AST_StatAssignRHS {

  //Syntactic attributes
  String funcName;
  int numOfExpr;
  List<AST_Expr> ast_exprList;
  ParserRuleContext ctx;
  SymbolTable symbolTable;

  InstructionCall instrCall;

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
   */
  @Override
  public boolean CheckSemantics() {

    SymbolTable ST = this.symbolTable;

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

        AST_Node parent = this.getParentNode();

        List<IDENTIFIER> parameters = new ArrayList<>();

        //if it is a baseType obj, we add it to a list instead of assigning it
        if (ST.lookupAll(funcName) instanceof BaseTypeObj) {
          parameters.add(ST.lookupAll(funcName));
        } else if (ST.lookupAll(funcName) instanceof FunctionObj) {
          parameters = (((FunctionObj) (ST.lookupAll(funcName))).getparamListObj()).getParamObjList();
        }


        //checking if number of parameters is as expected
        if (parameters.size() != ast_exprList.size()) {
          new MissingParameterError(new FilePosition(ctx)).printAll();
          return false;
        }

        for (int i = 0; i < ast_exprList.size(); i++) {

          IDENTIFIER typeParam = (IDENTIFIER) parameters.get(i);

          //when size of the list i 1
          if (ast_exprList.size() == 1) {
            if (ast_exprList.get(0) instanceof AST_ExprIdent) {
              String varName = ((AST_ExprIdent) ast_exprList.get(i)).getVarName();
              SymbolTable tempST = ST;
              IDENTIFIER typeExpr = tempST.lookup(varName);

              while (typeExpr == null) {
                tempST = tempST.encSymTable;
                typeExpr = tempST.lookup(varName);
              }

              //check if it's null so can reassign again (hard coding)
              if (!typeExpr.equals(typeParam)) {
                new TypeError(new FilePosition(ctx)).printAll();
                return false;
              } else {
                return true;
              }
            } else if (ast_exprList.get(0) instanceof AST_ExprArrayElem) {
              String arrayName = ((AST_ExprArrayElem) ast_exprList.get(0)).getArrayName();
              SymbolTable tempST = this.symbolTable;
              IDENTIFIER typeExpr = tempST.lookup(arrayName);

              while (typeExpr == null) {
                tempST = tempST.encSymTable;
                typeExpr = tempST.lookup(arrayName);
              }

              if (typeExpr.toString().contains(typeParam.toString())
                  || typeParam.toString().contains(typeExpr.toString())) {
                return true;
              } else {
                new TypeError(new FilePosition(ctx)).printAll();
                return false;
              }

            } else if (ast_exprList.get(0) instanceof AST_ExprLiter) {
              String literal = ((AST_ExprLiter) ast_exprList.get(0)).getLiteral();

              if (typeParam.toString().contains("char[]")
                  || typeParam.toString().contains("str")) {
                if (literal.contains("char[]") || literal.contains("str")) {
                  return true;
                } else {
                  new TypeMismatchError(new FilePosition(ctx)).printAll();
                  return false;
                }
              } else if (typeParam.toString().contains(literal)
                  || literal.contains(typeParam.toString())) {
                return true;
              } else {
                new TypeMismatchError(new FilePosition(ctx)).printAll();
                return false;
              }

            } else {
              IDENTIFIER typeExpr = ast_exprList.get(0).getIdentifier();
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

            SymbolTable tempST = ST;
            IDENTIFIER typeExpr = tempST.lookup(varName);

            while (typeExpr == null) {
              tempST = tempST.encSymTable;
              typeExpr = tempST.lookup(varName);
            }

            if (typeExpr.toString().contains(typeParam.toString()) || typeParam.toString().contains(typeExpr.toString())) {
              return true;
            } else {
              new TypeError(new FilePosition(ctx)).printAll();
              return false;
            }
          }

          IDENTIFIER typeExpr = ast_exprList.get(i).getIdentifier();

          if (!(typeExpr.toString().contains(typeParam.toString()) || typeParam.toString().contains(typeExpr.toString()))) {
            new TypeError(new FilePosition(ctx)).printAll();
            return false;
          }
        }
      } else {

      }

      SymbolTable temporaryST = ST;
      IDENTIFIER type = temporaryST.lookup(funcName);

      while (type == null) {
        temporaryST = temporaryST.encSymTable;
        type = temporaryST.lookup(funcName);
      }
      setIdentifier(((FunctionObj) (type)).getReturnType());
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
    for (AST_Expr expr : ast_exprList) {
      expr.accept(visitor);
    }
  }

  @Override
  public void acceptInstr(List<String> assemblyCode) {
    for (AST_Expr expr : ast_exprList) {
      expr.acceptInstr(assemblyCode);
    }
    assemblyCode.add(instrCall.getResultBlock());
  }

  @Override
  public RegisterARM acceptRegister(RegisterAllocation registerAllocation) throws Exception {
    for (AST_Expr expr : ast_exprList) {
      expr.acceptRegister(registerAllocation);
    }
    registerAllocation.freeRegister(registerAllocation.searchByTypeValue("result"));
    registerAllocation.addRegisterInUse(RegisterARM.r0, "result");
  }

  public void genInstruction(List<Instruction> instructionList, RegisterAllocation registerAllocation) throws Exception {

    FunctionObj functionObj = (FunctionObj) symbolTable.lookupAll(funcName);
    String returnType = functionObj.returnType.toString();

    InstructionCall instructionCall = new InstructionCall(funcName, returnType);
    instructionList.add(instructionCall);
    instrCall = instructionCall;
  }

  public List<AST_Expr> getAst_exprList() {
    return ast_exprList;
  }

  public String getFuncName() {
    return funcName;
  }
}

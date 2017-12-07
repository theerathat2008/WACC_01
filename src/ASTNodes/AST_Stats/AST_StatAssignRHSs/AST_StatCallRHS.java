package ASTNodes.AST_Stats.AST_StatAssignRHSs;

import ASTNodes.AST_Exprs.*;
import ASTNodes.AST_Node;
import ASTNodes.AST_FuncDecl;
import ASTNodes.AST_ParamList;
import ASTNodes.AST_Param;
import ASTNodes.AST_Stats.AST_StatAssign;
import ASTNodes.AST_Stats.AST_StatAssignLHSs.AST_StatIdentLHS;
import ASTNodes.AST_Stats.AST_StatExpr;
import ErrorMessages.TypeMismatchError;
import IdentifierObjects.FunctionObj;
import IdentifierObjects.BaseTypeObj;
import IdentifierObjects.IDENTIFIER;
import InstructionSet.Instruction;
import InstructionSet.InstructionCall;
import InstructionSet.InstructionLibraryFunction;
import Registers.RegisterARM;
import Registers.RegisterAllocation;
import Registers.RegisterUsage;
import SymbolTable.SymbolTable;
import ErrorMessages.MissingParameterError;
import ErrorMessages.TypeError;
import ErrorMessages.UndefinedFunctionError;
import ErrorMessages.FilePosition;
import VisitorClass.AST_NodeVisitor;
import org.antlr.v4.runtime.ParserRuleContext;
import java.util.*;
import static Registers.RegisterUsageBuilder.aRegisterUsageBuilder;

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
  List<String> standardLibrary;
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
    this.standardLibrary = Arrays.asList("max", "min", "factorial", "avg", "pow") ;
    this.funcName = null;
    this.ctx = ctx;
    this.symbolTable = symbolTable;
  }

  /**
   * Gets all children nodes of current node
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
   * @param ST
   */
  @Override
  public void Check(SymbolTable ST) {
    if (CheckSemantics()) {

    }
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

  /**
   * Used to flag special cases where the register needs a stack implementation before the backend parse
   * @param regAlloc
   */
  @Override
  public void acceptPreProcess(RegisterAllocation regAlloc) {
    for (AST_Expr expr : ast_exprList) {

      if(expr instanceof AST_ExprIdent){
         AST_ExprIdent tempNode = (AST_ExprIdent)expr;
         String varName = tempNode.getVarName();
         //regAlloc.addToStackOnlyVar(varName);
      }
      expr.acceptPreProcess(regAlloc);
    }
  }

  /**
   * Part of the visitor code gen pattern, used to generate the instruction classes
   * which are added to the instruction list
   * @param visitor
   */
  public void accept(AST_NodeVisitor visitor) {
    visitor.visit(this);
    for (AST_Expr expr : ast_exprList) {
      expr.accept(visitor);
    }
  }

  /**
   * Function that is iterates through the ast_nodes and adds the instruction blocks
   * in the right order to the assembly code list
   * @param assemblyCode
   */
  @Override
  public void acceptInstr(List<String> assemblyCode) {
    List<String> callList = instrCall.getVarCallBlocks();


    for(int i = 0; i < ast_exprList.size(); i++){
      AST_Expr expr = ast_exprList.get(i);
      String callBlock = callList.get(i);
      if(expr instanceof AST_ExprLiter || expr instanceof AST_ExprBinary || expr instanceof AST_ExprUnary){

        expr.acceptInstr(assemblyCode);
      }
      assemblyCode.add(callBlock);
    }
    assemblyCode.add(instrCall.getResultBlock());
  }

  /**
   * Load all the function arguments into the right registers which is done in AST_ParamList
   * Evaluate the expression, Don't care about the evaluation of the expressions
   * Return r0 as the evaluation of the actual function call is stored in there
   *
   * The possible vars that could be loaded are ExprIdent, Arrays and Pairs
   * In the case of ExprIdent: Find the varName
   *                           Find the current storage location of that var in (reg/Stack)
   *                           Find the destination storage location of that var is in (funcReg/funcStack)
   *                           Print out an assembly line to match the (reg/Stack) to (funcReg/funcStack)
   *
   *
   * Need to match stack allocated space for param vars with the stack allocated space for the loaded vars
   * For standard library pass r4 and r5 to all functions apart from factorial which only requires r4.
   */

  /**
   * Want to store the evaluation of the two registers result of the binary expression
   * Format is expr BinOp expr
   * Store the returned result of the two expr into a result reg
   * Free the two registers after having got the evaluation of the two stores in the regs
   */
  @Override
  public RegisterARM acceptRegister(RegisterAllocation registerAllocation) throws Exception {

    int counter = 0;

    for (AST_Expr expr : ast_exprList) {
      if (expr instanceof AST_ExprIdent) {
        AST_ExprIdent tempNode = (AST_ExprIdent) expr;
        String varName = tempNode.getVarName();
        String type = "null";


        String src = registerAllocation.searchByVarValue(varName).name();

        String dst = registerAllocation.searchByFuncVarCounter(counter, funcName).name();


        if (src.equals("NULL_REG") && dst.equals("NULL_REG")) {
          src = registerAllocation.getStackLocation(varName);
          dst = registerAllocation.getFuncStackLocationCounter(funcName, counter);


          RegisterUsage resultUsage = aRegisterUsageBuilder()
                  .withUsageType("interType")
                  .withScope(registerAllocation.getCurrentScope())
                  .build();
          RegisterARM interReg = registerAllocation.useRegister(resultUsage);
          registerAllocation.freeRegister(interReg);
          // LDR inter, Src
          // STR inter, Dst
          type = "stack, stack";
          instrCall.genCallInstruction(src, dst, type, interReg);
        } else if (src.equals("NULL_REG")) {
          src = registerAllocation.getStackLocation(varName);

          RegisterUsage resultUsage = aRegisterUsageBuilder()
                  .withUsageType("interType")
                  .withScope(registerAllocation.getCurrentScope())
                  .build();
          RegisterARM interReg = registerAllocation.useRegister(resultUsage);
          registerAllocation.freeRegister(interReg);

          type = "reg, stack";
          // LDR inter, src
          // MOV dst, inter
          instrCall.genCallInstruction(src, dst, type, interReg);
        } else if (dst.equals("NULL_REG")) {
          dst = registerAllocation.getFuncStackLocationCounter(funcName, counter);

          type = "stack, reg";
          // LDR src, dst
          instrCall.genCallInstruction(src, dst, type, RegisterARM.NULL_REG);
        } else {
          type = "reg, reg";
          instrCall.genCallInstruction(src, dst, type, RegisterARM.NULL_REG);
        }
      } else if (expr instanceof AST_ExprLiter) {
        RegisterARM resultReg = expr.acceptRegister(registerAllocation);
        registerAllocation.freeRegister(resultReg);

        String src = resultReg.name();
        String dst = registerAllocation.searchByFuncVarCounter(counter, funcName).name();
        String type = "reg, reg";
        if (dst.equals("NULL_REG")) {
          dst = registerAllocation.getFuncStackLocationCounter(funcName, counter);
          type = "stack, reg";
          // LDR src, dst
          instrCall.genCallInstruction(src, dst, type, RegisterARM.NULL_REG);
        }

        registerAllocation.freeRegister(resultReg);
        instrCall.genCallInstruction(src, dst, type, RegisterARM.NULL_REG);
      } else if (expr instanceof AST_ExprBinary || expr instanceof AST_ExprUnary) {
        RegisterARM resultReg = expr.acceptRegister(registerAllocation);
        registerAllocation.freeRegister(resultReg);

        String dst = resultReg.name();
        String src = registerAllocation.searchByFuncVarCounter(counter, funcName).name();
        String type = "reg, reg";
        if (dst.equals("NULL_REG")) {
          dst = registerAllocation.getFuncStackLocationCounter(funcName, counter);
          type = "stack, reg";
          // LDR src, dst
          instrCall.genCallInstruction(src, dst, type, RegisterARM.NULL_REG);
        }
        registerAllocation.freeRegister(resultReg);
        instrCall.genCallInstruction(src, dst, type, RegisterARM.NULL_REG);
      }

        counter++;
      }
      return RegisterARM.r0;
    }

  /**
   * takes the embeded information corresponding to the specific instruction class and generates blocks
   * of assembly code for that instruction class
   * The embeded information is mainly the registers which is allocated using registerAllocation.
   * @param instructionList
   * @param registerAllocation
   * @throws Exception
   */
  public void genInstruction(List<Instruction> instructionList, RegisterAllocation registerAllocation) throws Exception {

    String returnType = "null";
    IDENTIFIER obj = symbolTable.lookupAll(funcName);

    if(obj instanceof FunctionObj){
      FunctionObj functionObj = (FunctionObj)obj;
      returnType = functionObj.returnType.toString();
    } else {
      BaseTypeObj baseTypeObj = (BaseTypeObj)obj;
      returnType = baseTypeObj.toString();
    }

    InstructionCall instructionCall = new InstructionCall(funcName, returnType);
    instructionList.add(instructionCall);
    instrCall = instructionCall;

    if (standardLibrary.contains(funcName)) {
      instructionList.add(new InstructionLibraryFunction(funcName, instructionList, registerAllocation));
    }

  }

  /**
   * @return Return the ast_exprList attribute
   */
  public List<AST_Expr> getAst_exprList() {
    return ast_exprList;
  }

  /**
   * @return Return the funcName attribute
   */
  public String getFuncName() {
    return funcName;
  }
}

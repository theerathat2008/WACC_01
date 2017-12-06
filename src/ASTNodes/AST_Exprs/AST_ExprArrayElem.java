package ASTNodes.AST_Exprs;

import ASTNodes.AST_FuncDecl;
import ASTNodes.AST_Node;
import ASTNodes.AST_Program;
import InstructionSet.Instruction;
import InstructionSet.InstructionAccessArrayElem;
import InstructionSet.InstructionBlocks.InstructionCheck.InstructionCheckArrayBounds;
import InstructionSet.InstructionBlocks.InstructionError.InstructionErrorRuntime;
import InstructionSet.InstructionBlocks.InstructionPrintBlocks.InstructionPrintBlocksString;

import Registers.RegisterARM;

import Registers.RegisterAllocation;
import Registers.RegisterUsage;
import SymbolTable.SymbolTable;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import VisitorClass.AST_NodeVisitor;

import IdentifierObjects.*;

import static Registers.RegisterUsageBuilder.aRegisterUsageBuilder;

/**
 * Class representing node in AST tree for EXPRESSIONS that are Array Elements
 */
public class AST_ExprArrayElem extends AST_Expr {

  //Syntactic attributes
  String arrayName;
  int numOfExpr;
  List<AST_Expr> ast_exprList; //format was a[expr][expr]
  InstructionAccessArrayElem arrayElemInstr;
  SymbolTable st;

  //Semantic attribute

  /**
   * Constructor for class - initialises class variables
   *
   * @param numberOfChildren - Shows the number of expressions
   */
  public AST_ExprArrayElem(int numberOfChildren, SymbolTable st) {
    this.ast_exprList = new ArrayList<>();
    this.numOfExpr = (numberOfChildren - 1) / 3;
    this.arrayName = null;
    this.st = st;
  }

  /**
   * Gets all children nodes of current node
   *
   * @return list of AST nodes that are the children of the current node
   */
  @Override
  public ArrayDeque<AST_Node> getNodes() {
    ArrayDeque<AST_Node> returnList = new ArrayDeque<>();
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
  @Override
  public void setSyntacticAttributes(String value) {
    if (arrayName == null) {
      this.arrayName = value;
    } else {
      System.out.println("Unrecognised String Attribute" + this.getClass().getSimpleName());
    }
  }


  /**
   * Gets syntactic attributes of class variables
   *
   * @param strToGet - Value to be retrieved from class variable
   */
  @Override
  public String getSyntacticAttributes(String strToGet) {
    if (strToGet.equals("arrayName")) {
      return arrayName;
    } else {
      System.out.println("Unrecognised String Attribute" + this.getClass().getSimpleName());
      return null;
    }
  }

  /**
   * Returns true if the embedded Nodes have value
   */
  @Override
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
      if (ast_exprList.size() == 1) {
        identifier = new ArrayObj(null, ast_exprList.get(0).identifier);
      }
    } else {
      System.out.println("Unrecognised AST Node at class: " + this.getClass().getSimpleName());
    }
    setType(ast_exprList.get(0).type + "[]");
  }

  /**
   * Semantic Analysis and print error message if needed
   */
  @Override
  public boolean CheckSemantics() {
    setType(ast_exprList.get(0).type + "[]");
    return true;
  }


  /**
   * Used for testing - Prints out contents of current AST node
   */
  @Override
  public void printContents() {
    System.out.println(this.getClass().getSimpleName() + ": ");
    System.out.println("arrayName: " + arrayName);
    System.out.println("numOfExpr: " + numOfExpr);
    if (ast_exprList.size() == numOfExpr) {
      System.out.println("ast_exprList: list full");
    } else {
      System.out.println("ast_exprList has size: " + ast_exprList.size());
    }
  }

  @Override
  public void acceptPreProcess(RegisterAllocation regAlloc) {

    //Set a flag for acceptRegister in statVarDecl using a list in registerallocation to declare the var on the stack
    // since it is used in read and the statarraylitrhs assembly code works with stacks
    regAlloc.addToStackOnlyVar(arrayName);

    for (AST_Expr expr : ast_exprList) {
      expr.acceptPreProcess(regAlloc);
    }
  }

  @Override
  public void accept(AST_NodeVisitor visitor) {
    visitor.visit(this);
    for (AST_Expr expr : ast_exprList) {
      expr.accept(visitor);
    }
  }

  @Override
  public void acceptInstr(List<String> assemblyCode) {
    assemblyCode.add(arrayElemInstr.getResultBlock());
  }


  /**
   * Format is varName [ expr ]
   * Doesn't require any registers allocated
   * Could be used as an access point for arrays stores on the heap
   * allocateRegisters(RegisterARM resultReg, RegisterARM posReg, RegisterARM arrayLocation)
   *
   * ArrayLocationReg is the memory address of the array variable
   * posReg is just a temp reg
   * resultReg is just temp reg and holds the final result i.e. the value at the array index
   */

  @Override
  public RegisterARM acceptRegister(RegisterAllocation registerAllocation) throws Exception {


    RegisterUsage resultUsage = aRegisterUsageBuilder()
        .withUsageType("resultType")
        .withScope(registerAllocation.getCurrentScope())
        .build();
    RegisterARM result = registerAllocation.useRegister(resultUsage);

    RegisterUsage tempReg = aRegisterUsageBuilder()
        .withUsageType("tempType")
        .withScope(registerAllocation.getCurrentScope())
        .build();
    RegisterARM tempPos = registerAllocation.useRegister(tempReg);
    registerAllocation.freeRegister(tempPos);

    arrayElemInstr.allocateRegisters(result, tempPos);


    //WORK OUT ARRAY LOCATION
    boolean isFuncStat = true;
    AST_Node tempNode = this;
    while(!(tempNode instanceof AST_FuncDecl)){
      tempNode = tempNode.getParentNode();
      if(tempNode instanceof AST_Program){
        //System.out.println(varName + " not in func stat");
        isFuncStat = false;
        break;
      }
    }

    String stackLocation = "SP_NULL";
    arrayElemInstr.allocateLocation(stackLocation, true);

    if(isFuncStat){
      String funcName = ((AST_FuncDecl) tempNode).getFuncName();
      stackLocation = registerAllocation.searchByFuncVarValue(arrayName, funcName).name();
      if(stackLocation.equals("NULL_REG")){
        stackLocation = registerAllocation.getFuncStackLocation(funcName,arrayName);
        arrayElemInstr.allocateLocation(stackLocation, true);
      } else {
        arrayElemInstr.allocateLocation(stackLocation, false);
      }
    } else {
      stackLocation = registerAllocation.getStackLocation(arrayName);
      if(stackLocation.equals("null")){
        stackLocation = registerAllocation.searchByVarValue(arrayName).name();
        arrayElemInstr.allocateLocation(stackLocation, false);
      } else {
        arrayElemInstr.allocateLocation(stackLocation, true);
      }
    }

    return result;
  }

  public void setExprType() {
    type = ast_exprList.get(0).type;
  }

  /**
   * TODO Produces Assembly code?
   * Needs to get heap location on array elem when allocating registers
   * in pair elem lhs, newpairRhs, pairelemRhs, callAssign, return, print, println
   */

  public void genInstruction(List<Instruction> instructionList, RegisterAllocation registerAllocation) throws Exception {

    InstructionAccessArrayElem InstructionAccessArrayElem
            = new InstructionAccessArrayElem(((AST_ExprLiter) ast_exprList.get(0)).constant, getType(), false);
    arrayElemInstr = InstructionAccessArrayElem;
    instructionList.add(arrayElemInstr);

    //Puts out of bounds code in
    String neg = "ArrayIndexOutOfBoundsError: negative index\\n\\0";
    String large = "ArrayIndexOutOfBoundsError: index too large\\n\\0";
    registerAllocation.addString(large);
    registerAllocation.addString(neg);
    int negIndex = registerAllocation.getStringID(neg);
    int largeIndex = registerAllocation.getStringID(large);
    InstructionCheckArrayBounds instructionCheckArrayBounds
            = new InstructionCheckArrayBounds(negIndex, largeIndex);
    if (!instructionList.contains(instructionCheckArrayBounds)) {
      instructionList.add(instructionCheckArrayBounds);
    }

    InstructionErrorRuntime instructionErrorRuntime
            = new InstructionErrorRuntime();
    if (!instructionList.contains(instructionErrorRuntime)) {
      instructionList.add(instructionErrorRuntime);
    }

    registerAllocation.addString("%.*s\\0");
    InstructionPrintBlocksString instructionPrintString = new InstructionPrintBlocksString(registerAllocation.getStringID("%.*s\\0"));
    if (!instructionList.contains(instructionPrintString)) {
      instructionList.add(instructionPrintString);
    }

  }

  public String getArrayName() {
    return arrayName;
  }
}

package ASTNodes.AST_Stats.AST_StatAssignLHSs;

import ASTNodes.AST_Exprs.AST_Expr;
import ASTNodes.AST_Exprs.AST_ExprLiter;
import ASTNodes.AST_FuncDecl;
import ASTNodes.AST_Node;
import ASTNodes.AST_Program;
import InstructionSet.Instruction;
import InstructionSet.InstructionBlocks.InstructionCheck.InstructionCheckArrayBounds;
import InstructionSet.InstructionBlocks.InstructionError.InstructionErrorRuntime;
import InstructionSet.InstructionBlocks.InstructionPrintBlocks.InstructionPrintBlocksString;
import InstructionSet.InstructionDeclOrAss.InstructionAssArrayElem.InstructionAssArrayElem;
import Registers.RegisterARM;
import Registers.RegisterAllocation;
import Registers.RegisterUsage;
import SymbolTable.SymbolTable;
import VisitorClass.AST_NodeVisitor;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import IdentifierObjects.*;

import static Registers.RegisterUsageBuilder.aRegisterUsageBuilder;

/**
 * Class representing node in AST tree for DECLARING ARRAY VARIABLE
 */
public class AST_StatArrayElemLHS extends AST_StatAssignLHS {

  //Syntactic attributes
  String identName;
  public List<AST_Expr> ast_exprList;
  int numOfExpr;
  InstructionAssArrayElem arrayElemInstr;

  /**
   * Constructor for class - initialises class variables
   *
   * @param numberOfChildren - Shows the number of parameters in the parameter list of function
   */
  public AST_StatArrayElemLHS(int numberOfChildren) {
    ast_exprList = new ArrayList<>();
    this.numOfExpr = (numberOfChildren - 1) / 3;
    this.identName = null;
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
    if (identName == null) {
      this.identName = value;
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
    if (strToGet.equals("identName")) {
      return identName;
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
        identifier = new ArrayObj(ast_exprList.get(0).getIdentifier());
      }
    } else {
      System.out.println("Unrecognised AST Node at class: " + this.getClass().getSimpleName());
    }
  }

  /**
   * Semantic Analysis and print error message if needed
   */
  @Override
  public boolean CheckSemantics() {
    return true;
  }

  /**
   * Called from visitor
   *
   * @param ST
   */
  @Override
  public void Check(SymbolTable ST) {
    if (CheckSemantics()) {
      setType(ast_exprList.get(0).getType());
    }
  }

  public String getType(SymbolTable ST) {
    return null;
  }

  /**
   * Used for testing - Prints out contents of current AST node
   */
  @Override
  public void printContents() {
    System.out.println(this.getClass().getSimpleName() + ": ");
    System.out.println("identName: " + identName);
    System.out.println("numOfExpr: " + numOfExpr);
    if (ast_exprList.size() == numOfExpr) {
      System.out.println("ast_exprList: List full");
    } else {
      System.out.println("ast_exprList has size: " + ast_exprList.size());
    }
  }

  @Override
  public void acceptPreProcess(RegisterAllocation regAlloc) {

    //Set a flag for acceptRegister in statVarDecl using a list in registerallocation to declare the var on the stack
    // since it is used in read and the statarraylitrhs assembly code works with stacks
    regAlloc.addToStackOnlyVar(identName);

    for (AST_Expr expr : ast_exprList) {
      expr.acceptPreProcess(regAlloc);
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
  }

  @Override
  public RegisterARM acceptRegister(RegisterAllocation registerAllocation) throws Exception {
    for (AST_Expr expr : ast_exprList) {
      expr.acceptRegister(registerAllocation);
    }

    return RegisterARM.NULL_REG;
  }

  public List<AST_Expr> getAst_exprList() {
    return ast_exprList;
  }

  /**
   *
   */



  public void genInstruction(List<Instruction> instructionList, RegisterAllocation registerAllocation) throws Exception {

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

  public String getIdentName() {
    return identName;
  }
}

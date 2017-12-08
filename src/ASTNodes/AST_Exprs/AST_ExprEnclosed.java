package ASTNodes.AST_Exprs;

import ASTNodes.AST_Node;
import ASTNodes.AST_Separator;
import InstructionSet.Instruction;
import Registers.RegisterARM;
import Registers.RegisterAllocation;
import SymbolTable.SymbolTable;
import java.util.ArrayDeque;
import java.util.List;
import VisitorClass.AST_NodeVisitor;

/**
 * Class representing node in AST tree for ENCLOSED EXPRESSIONS
 */
public class AST_ExprEnclosed extends AST_Expr {

  //Syntactic attributes
  AST_Separator leftSepAST;
  AST_Expr exprAST;
  AST_Separator rightSepAST;

  /**
   * Constructor for class - initialises class variables
   */
  public AST_ExprEnclosed() {
    this.leftSepAST = new AST_Separator();
    this.leftSepAST.setSyntacticAttributes("(");
    this.exprAST = null;
    this.rightSepAST = new AST_Separator();
    this.rightSepAST.setSyntacticAttributes(")");
  }

  /**
   * Gets all children nodes of current node
   * @return list of AST nodes that are the children of the current node
   */
  @Override
  public ArrayDeque<AST_Node> getNodes() {
    ArrayDeque<AST_Node> returnList = new ArrayDeque<>();
    returnList.addLast(leftSepAST);
    returnList.addLast(exprAST);
    returnList.addLast(rightSepAST);
    return returnList;
  }

  /**
   * Sets syntactic attributes of class variables by assigning it a value
   * @param value - Value to be assigned to class variable
   */
  @Override
  public void setSyntacticAttributes(String value) {
    System.out.println("No String Syntactic Attributes in class: " + this.getClass().getSimpleName());
  }

  /**
   * Gets syntactic attributes of class variables
   * @param strToGet - Value to be retrieved from class variable
   */
  @Override
  public String getSyntacticAttributes(String strToGet) {
    System.out.println("No String Syntactic Attributes in class: " + this.getClass().getSimpleName());
    return null;
  }

  /**
   * Returns true if the embedded Nodes have value
   */
  @Override
  public boolean isEmbeddedNodesFull() {
    return leftSepAST != null && exprAST != null && rightSepAST != null;
  }

  /**
   * @param astToGet Shows which child to get from current node
   * @param counter  Shows which child of child to get from current node
   * @return Returns the required child AST Node (determined by the astToGet parameter)
   */
  @Override
  public AST_Node getEmbeddedAST(String astToGet, int counter) {
    if (astToGet.equals("leftSepAST")) {
      return leftSepAST;
    } else if (astToGet.equals("exprAST")) {
      return exprAST;
    } else if (astToGet.equals("rightSepAST")) {
      return rightSepAST;
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
    if (astToSet.equals("leftSepAST")) {
      leftSepAST = (AST_Separator) nodeToSet;
    } else if (astToSet.equals("expr")) {
      exprAST = (AST_Expr) nodeToSet;
    } else if (astToSet.equals("rightSepAST")) {
      rightSepAST = (AST_Separator) nodeToSet;
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
   * @param ST
   */
  @Override
  public void Check(SymbolTable ST) {
    if (CheckSemantics()) {
      setType(exprAST.type);
      //Do symbol table stuff
    }
  }

  /**
   * Used for testing - Prints out contents of current AST node
   */
  @Override
  public void printContents() {
    System.out.println(this.getClass().getSimpleName() + ": ");
    if (leftSepAST == null) {
      System.out.println("leftSepAST: null");
    } else {
      System.out.println("leftSepAST: has content");
    }
    if (exprAST == null) {
      System.out.println("exprAST: null");
    } else {
      System.out.println("exprAST: has content");
    }
    if (rightSepAST == null) {
      System.out.println("rightSepAST: null");
    } else {
      System.out.println("rightSepAST: has content");
    }
  }

  /**
   * Used to flag special cases where the register needs a stack implementation before the backend parse
   * @param regAlloc
   */
  @Override
  public void acceptPreProcess(RegisterAllocation regAlloc) {
    exprAST.acceptPreProcess(regAlloc);
  }

  /**
   * Part of the visitor code gen pattern, used to generate the instruction classes
   * which are added to the instruction list
   * @param visitor
   */
  public void accept(AST_NodeVisitor visitor) {
    visitor.visit(this);
    leftSepAST.accept(visitor);
    exprAST.accept(visitor);
    rightSepAST.accept(visitor);
  }

  /**
   * General case to call acceptNode
   * @param visitor
   */
  public int acceptRootNode(AST_NodeVisitor visitor) {
    visitor.visit(this);

    int result = 0;

    if (exprAST instanceof AST_ExprLiter) {
      result = ((AST_ExprLiter) exprAST).acceptNode(visitor);
    } else if (exprAST instanceof AST_ExprBinary) {
      result = ((AST_ExprBinary) exprAST).acceptNode(visitor);
    } else if (exprAST instanceof AST_ExprUnary) {
      result = ((AST_ExprUnary) exprAST).acceptNode(visitor);
    }

    return result;
  }

  /**
   * Function that is iterates through the ast_nodes and adds the instruction blocks
   * in the right order to the assembly code list
   * @param assemblyCode
   */
  @Override
  public void acceptInstr(List<String> assemblyCode) {
    exprAST.acceptInstr(assemblyCode);
  }

  /**
   * Return the evaluation of the expr register
   * No explicit register allocation here
   */

  /**
   * Want to store the evaluation of the two registers result of the binary expression
   * Format is expr BinOp expr
   * Store the returned result of the two expr into a result reg
   * Free the two registers after having got the evaluation of the two stores in the regs
   */
  @Override
  public RegisterARM acceptRegister(RegisterAllocation registerAllocation) throws Exception {
    return exprAST.acceptRegister(registerAllocation);
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
    System.out.println("Holder class enclosed expression, doesn't generate assembly code");
  }

  /**
   * return the exprAST attributes
   * @return
   */
  public AST_Expr getExprAST() {
    return exprAST;
  }
}

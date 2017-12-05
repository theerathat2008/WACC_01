package ASTNodes.AST_Exprs;

import ASTNodes.AST_Node;
import InstructionSet.Instruction;
import InstructionSet.InstructionCheck.InstructionCheckArrayBounds;
import Registers.RegisterAllocation;
import SymbolTable.SymbolTable;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import VisitorClass.AST_NodeVisitor;

import IdentifierObjects.*;

/**
 * Class representing node in AST tree for EXPRESSIONS that are Array Elements
 */
public class AST_ExprArrayElem extends AST_Expr {

  //Syntactic attributes
  String arrayName;
  int numOfExpr;
  List<AST_Expr> ast_exprList;
  //Semantic attribute

  /**
   * Constructor for class - initialises class variables
   *
   * @param numberOfChildren - Shows the number of expressions
   */
  public AST_ExprArrayElem(int numberOfChildren) {
    this.ast_exprList = new ArrayList<>();
    this.numOfExpr = (numberOfChildren - 1) / 3;
    this.arrayName = null;
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
      setType(ast_exprList.get(0).type + "[]");
    }

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
  public void accept(AST_NodeVisitor visitor) {
    visitor.visit(this);
    for (AST_Expr expr : ast_exprList) {
      expr.accept(visitor);
    }
  }

  /**
   * General case to call acceptNode
   * have to return as a list for arrays
   * @param visitor
   */
  public List<Integer> acceptRootNode(AST_NodeVisitor visitor) {
    visitor.visit(this);

    List<Integer> listResult = new ArrayList<>();

    for (AST_Expr expr : ast_exprList) {
      int result = 0;
      if (expr instanceof AST_ExprLiter) {
        result = ((AST_ExprLiter) expr).acceptNode(visitor);
      } else if (expr instanceof AST_ExprBinary) {
        result = ((AST_ExprBinary) expr).acceptNode(visitor);
      } else if (expr instanceof AST_ExprUnary) {
        result = ((AST_ExprUnary) expr).acceptNode(visitor);
      }
      listResult.add(result);
    }

    return listResult;
  }

  @Override
  public void acceptInstr(List<String> assemblyCode) {

  }

  @Override
  public void acceptRegister(RegisterAllocation registerAllocation) throws Exception {
    for (AST_Expr expr : ast_exprList) {
      expr.acceptRegister(registerAllocation);
    }
  }


  /**
   * TODO Produces Assembly code?
   * Needs to get heap location on array elem when allocating registers
   * in pair elem lhs, newpairRhs, pairelemRhs, callAssign, return, print, println
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
  }

  public String getArrayName() {
    return arrayName;
  }
}

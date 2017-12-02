package ASTNodes.AST_TYPES;

import ASTNodes.AST_Node;
import InstructionSet.Instruction;
import Registers.RegisterARM;
import Registers.RegisterAllocation;
import SymbolTable.SymbolTable;
import VisitorClass.AST_NodeVisitor;

import java.util.ArrayDeque;
import java.util.List;

import IdentifierObjects.*;

public class AST_ArrayType extends AST_Type {
  //Syntactic attributes
  AST_Type ast_type;

  /**
   * Constructor for class - initialises class variables to NULL
   */
  public AST_ArrayType() {
    this.ast_type = null;
  }

  /**
   * Gets all children nodes of current node
   *
   * @return list of AST nodes that are the children of the current node
   */
  @Override
  public ArrayDeque<AST_Node> getNodes() {
    ArrayDeque<AST_Node> returnList = new ArrayDeque<>();
    returnList.addLast(ast_type);
    return returnList;
  }

  /**
   * Returns true if the embedded Nodes have value
   */
  @Override
  public boolean isEmbeddedNodesFull() {
    return ast_type != null;
  }

  /**
   * Sets syntactic attributes of class variables by assigning it a value
   *
   * @param value - Value to be assigned to class variable
   */
  @Override
  public void setSyntacticAttributes(String value) {
    System.out.println("No Syntactic Attribute");
  }

  /**
   * Gets syntactic attributes of class variables
   *
   * @param strToGet - Value to be retrieved from class variable
   */
  @Override
  public String getSyntacticAttributes(String strToGet) {
    System.out.println("No Syntactic Attribute");
    return null;
  }

  /**
   * @param astToGet Shows which child to get from current node
   * @param counter  Shows which child of child to get from current node
   * @return Returns the required child AST Node (determined by the astToGet parameter)
   */
  @Override
  public AST_Node getEmbeddedAST(String astToGet, int counter) {
    if (astToGet.equals("ast_type")) {
      return ast_type;
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
    if (astToSet.equals("ast_type")) {
      ast_type = (AST_Type) nodeToSet;
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
    }
  }

  /**
   * @return - Returns a string representation of the current node
   */
  public String toString() {
    return ast_type.toString() + "[]";
  }

  /**
   * Used for testing - Prints out contents of current AST node
   */
  @Override
  public void printContents() {
    System.out.println(this.getClass().getSimpleName() + ": ");
    if (ast_type == null) {
      System.out.println("ast_type: null");
    } else {
      System.out.println("ast_type: has content");
    }
  }

  public void accept(AST_NodeVisitor visitor) {
    visitor.visit(this);
    ast_type.accept(visitor);
  }

  @Override
  public void acceptInstr(List<String> assemblyCode) {

  }

  @Override
  public RegisterARM acceptRegister(RegisterAllocation registerAllocation) throws Exception {
    return RegisterARM.NULL_REG;
  }

  /**
   * @return returns the identifier of the attribute
   */
  public IDENTIFIER getIdentifier() {
    return new ArrayObj(null, ast_type.getIdentifier());
  }

  public void genInstruction(List<Instruction> instructionList, RegisterAllocation registerAllocation) throws Exception {

  }
}

package ASTNodes.AST_Stats.AST_StatAssignRHSs;

import ASTNodes.AST_Node;
import ASTNodes.AST_Stats.AST_Stat;
import InstructionSet.Instruction;
import Registers.RegisterARM;
import Registers.RegisterAllocation;
import SymbolTable.SymbolTable;
import VisitorClass.AST_NodeVisitor;

import java.util.ArrayDeque;
import java.util.List;

import IdentifierObjects.*;

/**
 * Class representing node in AST tree for ASSIGNMENT BASE CLASS
 */
public class AST_StatAssignRHS extends AST_Stat {

  //Syntactic attribute
  public IDENTIFIER identifier;

  /**
   * Gets all children nodes of current node
   *
   * @return list of AST nodes that are the children of the current node
   */
  @Override
  public ArrayDeque<AST_Node> getNodes() {
    System.out.println("BASE AST Node at: " + this.getClass().getSimpleName());
    return null;
  }

  /**
   * Sets syntactic attributes of class variables by assigning it a value
   *
   * @param value - Value to be assigned to class variable
   */
  @Override
  public void setSyntacticAttributes(String value) {
    System.out.println("Base AST Node");
  }

  /**
   * Gets syntactic attributes of class variables
   *
   * @param strToGet - Value to be retrieved from class variable
   */
  @Override
  public String getSyntacticAttributes(String strToGet) {
    System.out.println("Base AST Node");
    return null;
  }

  /**
   * @return returns the type of the expression
   */
  public String getType(SymbolTable ST) {
    return null;
  }

  /**
   * @param astToGet Shows which child to get from current node
   * @param counter  Shows which child of child to get from current node
   * @return Returns the required child AST Node (determined by the astToGet parameter)
   */
  @Override
  public AST_Node getEmbeddedAST(String astToGet, int counter) {
    System.out.println("Base AST Node.");
    return null;
  }

  /**
   * Returns true if the embedded Nodes have value
   */
  @Override
  public boolean isEmbeddedNodesFull() {
    return true;
  }

  /**
   * @param astToSet  Shows which child to set from current node
   * @param nodeToSet Shows which child of child to set from current node
   */
  @Override
  public void setEmbeddedAST(String astToSet, AST_Node nodeToSet) {
    System.out.println("Base AST Node.");
  }

  /**
   * //Semantic Analysis and print error message if needed
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
      //Do symbol table stuff
    }
  }

  /**
   * Used for testing - Prints out contents of current AST node
   */
  @Override
  public void printContents() {
    System.out.println("BASE CLASS");
  }

  @Override
  public void acceptPreProcess(RegisterAllocation regAlloc) {

  }

  /**
   * @return returns the identifier of the attribute
   */
  public IDENTIFIER getIdentifier() {
    return identifier;
  }

  /**
   * @param identifier - sets the identifier of the current attribute
   */
  public void setIdentifier(IDENTIFIER identifier) {
    this.identifier = identifier;
  }

  public void accept(AST_NodeVisitor visitor) {
    visitor.visit(this);
  }

  @Override
  public void acceptInstr(List<String> assemblyCode) {

  }

  /**
   * Base class returns null
   */

  @Override
  public RegisterARM acceptRegister(RegisterAllocation registerAllocation) throws Exception {
    return RegisterARM.NULL_REG;
  }

  public void genInstruction(List<Instruction> instructionList, RegisterAllocation registerAllocation) throws Exception {

  }
}

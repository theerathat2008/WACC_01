package ASTNodes;


import InstructionSet.Instruction;
import Registers.RegisterARM;
import SymbolTable.SymbolTable;
import VisitorClass.AST_NodeVisitor;
import Registers.RegisterAllocation;

import java.util.ArrayDeque;
import java.util.List;


/**
 * Empty Base class for the AST Nodes that is generated for the parse tree
 */
public abstract class AST_Node {

  //private field to store parent node
  protected AST_Node parentNode;

  /**
   * Return the parent node of the node called
   */
  public AST_Node getParentNode() {
    return parentNode;
  }

  /**
   * set the parent node of the node parameter
   *
   * @param nodeToSet
   */
  public void setParentNode(AST_Node nodeToSet) {
    parentNode = nodeToSet;
  }

  /**
   * Return classname in string form
   */
  @Override
  public String toString() {
    return this.getClass().getSimpleName();
  }

  /**
   * Gets all children nodes of current node
   */
  public abstract ArrayDeque<AST_Node> getNodes();

  /**
   * Sets syntactic attributes of class variables by assigning it a value
   *
   * @param value - Value to be assigned to class variable
   */
  public abstract void setSyntacticAttributes(String value);

  /**
   * Gets syntactic attributes of class variables
   *
   * @param strToGet - Value to be retrieved from class variable
   */
  public abstract String getSyntacticAttributes(String strToGet);

  /**
   * Returns true if the embedded Nodes have values
   */
  public abstract boolean isEmbeddedNodesFull();

  /**
   * Return embedded AST nodes if they exist
   *
   * @param astToGet
   * @param counter
   */
  public abstract AST_Node getEmbeddedAST(String astToGet, int counter);

  /**
   * Set embeded AST nodes if they exist
   *
   * @param astToSet
   * @param nodeToSet
   */
  public abstract void setEmbeddedAST(String astToSet, AST_Node nodeToSet);

  /**
   * Semantic Analysis and print error message if needed
   */
  public abstract boolean CheckSemantics();

  /**
   * Called from visitor
   *
   * @param ST
   */
  public abstract void Check(SymbolTable ST);

  /**
   * Used for testing - Prints out contents of current AST node
   */
  public abstract void printContents();


  public abstract void accept(AST_NodeVisitor visitor);

  public abstract void acceptInstr(List<String> assemblyCode);

  public abstract RegisterARM acceptRegister(RegisterAllocation registerAllocation) throws Exception;

  public abstract void genInstruction(List<Instruction> instructionList, RegisterAllocation registerAllocation) throws Exception;

}

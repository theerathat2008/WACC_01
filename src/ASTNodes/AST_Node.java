package ASTNodes;

import InstructionSet.Instruction;
import Registers.RegisterARM;
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
   * @param value - Value to be assigned to class variable
   */
  public abstract void setSyntacticAttributes(String value);

  /**
   * Gets syntactic attributes of class variables
   * @param strToGet - Value to be retrieved from class variable
   */
  public abstract String getSyntacticAttributes(String strToGet);

  /**
   * Returns true if the embedded Nodes have values
   */
  public abstract boolean isEmbeddedNodesFull();

  /**
   * Return embedded AST nodes if they exist
   * @param astToGet
   * @param counter
   */
  public abstract AST_Node getEmbeddedAST(String astToGet, int counter);

  /**
   * Set embeded AST nodes if they exist
   * @param astToSet
   * @param nodeToSet
   */
  public abstract void setEmbeddedAST(String astToSet, AST_Node nodeToSet);

  /**
   * Semantic Analysis and print error message if needed
   */
  public abstract boolean CheckSemantics();

  /**
   * Used for testing - Prints out contents of current AST node
   */
  public abstract void printContents();

  /**
   * Used to flag special cases where the register needs a stack implementation before the backend parse
   * @param regAlloc
   */
  public abstract void acceptPreProcess(RegisterAllocation regAlloc);

  /**
   * Part of the visitor code gen pattern, used to generate the instruction classes
   * which are added to the instruction list
   * @param visitor
   */
  public abstract void accept(AST_NodeVisitor visitor);

  /**
   * Function that is iterates through the ast_nodes and adds the instruction blocks
   * in the right order to the assembly code list
   * @param assemblyCode
   */
  public abstract void acceptInstr(List<String> assemblyCode);

  /**
   * Evaluate both sides of the stat assign and store their results in the registers
   * Returns a null reg as there is no result evaluation
   */
  public abstract RegisterARM acceptRegister(RegisterAllocation registerAllocation) throws Exception;

  /**
   * takes the embeded information corresponding to the specific instruction class and generates blocks
   * of assembly code for that instruction class
   * The embeded information is mainly the registers which is allocated using registerAllocation.
   * @param instructionList
   * @param registerAllocation
   * @throws Exception
   */
  public abstract void genInstruction(List<Instruction> instructionList, RegisterAllocation registerAllocation) throws Exception;

}

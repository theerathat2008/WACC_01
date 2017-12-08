package ASTNodes.AST_TYPES;

import ASTNodes.AST_Node;
import ASTNodes.AST_TYPES.AST_PairElemTypes.AST_PairElemType;
import InstructionSet.Instruction;
import Registers.RegisterARM;
import Registers.RegisterAllocation;
import IdentifierObjects.*;
import VisitorClass.AST_NodeVisitor;
import java.util.ArrayDeque;
import java.util.List;

/**
 * Class representing node in AST tree for PAIRTYPE
 */
public class AST_PairType extends AST_Type {

  //Syntactic attributes
  AST_PairElemType pairElemTypeFst;
  AST_PairElemType pairElemTypeSnd;

  /**
   * Constructor for class - initialises class variables TO NULL
   */
  public AST_PairType() {
    this.pairElemTypeFst = null;
    this.pairElemTypeSnd = null;
  }

  /**
   * Gets all children nodes of current node
   * @return list of AST nodes that are the children of the current node
   */
  @Override
  public ArrayDeque<AST_Node> getNodes() {
    ArrayDeque<AST_Node> returnList = new ArrayDeque<>();
    returnList.addLast(pairElemTypeFst);
    returnList.addLast(pairElemTypeSnd);
    return returnList;
  }

  /**
   * Returns true if the embedded Nodes have value
   */
  @Override
  public boolean isEmbeddedNodesFull() {
    return pairElemTypeFst != null && pairElemTypeSnd != null;
  }

  /**
   * Sets syntactic attributes of class variables by assigning it a value
   * @param value - Value to be assigned to class variable
   */
  @Override
  public void setSyntacticAttributes(String value) {
    System.out.println("No Syntactic Attribute");
  }

  /**
   * Gets syntactic attributes of class variables
   * @param strToGet - Value to be retrieved from class variable
   */
  @Override
  public String getSyntacticAttributes(String strToGet) {
    System.out.println("No Syntactic Attribute");
    return null;
  }

  /**
   * @return returns the identifier of the attribute
   */
  public IDENTIFIER getIdentifier() {
    return new PairObj(null, pairElemTypeFst.getIdentifier(), pairElemTypeSnd.getIdentifier());
  }

  /**
   * @param astToGet Shows which child to get from current node
   * @param counter  Shows which child of child to get from current node
   * @return Returns the required child AST Node (determined by the astToGet parameter)
   */
  @Override
  public AST_Node getEmbeddedAST(String astToGet, int counter) {
    if (astToGet.equals("pairElemTypeFst")) {
      return pairElemTypeFst;
    } else if (astToGet.equals("pairElemTypeSnd")) {
      return pairElemTypeSnd;
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
    if (astToSet.equals("pairElemType")) {
      if (pairElemTypeFst == null) {
        pairElemTypeFst = (AST_PairElemType) nodeToSet;
      } else if (pairElemTypeSnd == null) {
        pairElemTypeSnd = (AST_PairElemType) nodeToSet;
      } else {
        System.out.println("pairElemTypeFst and pairElemTypeSnd in AST_PairType have already been assigned.");
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
   * @return Returns a string representation of the class node
   */
  public String toString() {
    return "PAIR(" + pairElemTypeFst.toString() + "," + pairElemTypeSnd.toString() + ")";
  }

  /**
   * Used for testing - Prints out contents of current AST node
   */
  @Override
  public void printContents() {
    System.out.println(this.getClass().getSimpleName() + ": ");
    if (pairElemTypeFst == null) {
      System.out.println("pairElemTypeFst: null");
    } else {
      System.out.println("pairElemTypeFst: has content");
    }
    if (pairElemTypeSnd == null) {
      System.out.println("pairElemTypeSnd: null");
    } else {
      System.out.println("pairElemTypeSnd: has content");
    }
  }

  /**
   * Used to flag special cases where the register needs a stack implementation before the backend parse
   * @param regAlloc
   */
  @Override
  public void acceptPreProcess(RegisterAllocation regAlloc) {

  }

  /**
   * Part of the visitor code gen pattern, used to generate the instruction classes
   * which are added to the instruction list
   * @param visitor
   */
  public void accept(AST_NodeVisitor visitor) {
    visitor.visit(this);
    pairElemTypeFst.accept(visitor);
    pairElemTypeSnd.accept(visitor);
  }

  /**
   * Function that is iterates through the ast_nodes and adds the instruction blocks
   * in the right order to the assembly code list
   * @param assemblyCode
   */
  @Override
  public void acceptInstr(List<String> assemblyCode) {

  }

  /**
   * Evaluate both sides of the stat assign and store their results in the registers
   * Returns a null reg as there is no result evaluation
   */
  @Override
  public RegisterARM acceptRegister(RegisterAllocation registerAllocation) throws Exception {
    return RegisterARM.NULL_REG;
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

  }
}

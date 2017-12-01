package ASTNodes.AST_Stats;

import ASTNodes.AST_Node;
import InstructionSet.Instruction;
import Registers.RegisterARM;
import Registers.RegisterAllocation;
import SymbolTable.SymbolTable;
import VisitorClass.AST_NodeVisitor;

import java.util.ArrayDeque;
import java.util.List;


public class AST_StatMult extends AST_Stat {

  //Syntactic attributes
  AST_Stat stat1;
  AST_Stat stat2;
  //Semantic attribute

  /**
   * Assign the class variables when called
   */
  public AST_StatMult() {
    this.stat1 = null;
    this.stat2 = null;
  }

  /**
   * Gets all children nodes of current node
   *
   * @return list of AST nodes that are the children of the current node
   */
  @Override
  public ArrayDeque<AST_Node> getNodes() {
    ArrayDeque<AST_Node> returnList = new ArrayDeque<>();
    returnList.addLast(stat1);
    returnList.addLast(stat2);
    return returnList;
  }

  /**
   * Sets syntactic attributes of class variables by assigning it a value
   *
   * @param value - Value to be assigned to class variable
   */
  @Override
  public void setSyntacticAttributes(String value) {
    System.out.println("No String Syntactic Attributes in class: " + this.getClass().getSimpleName());
  }

  /**
   * Gets syntactic attributes of class variables
   *
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
    return stat1 != null && stat2 != null;
  }

  /**
   * @param astToGet Shows which child to get from current node
   * @param counter  Shows which child of child to get from current node
   * @return Returns the required child AST Node (determined by the astToGet parameter)
   */
  @Override
  public AST_Node getEmbeddedAST(String astToGet, int counter) {
    if (astToGet.equals("stat1")) {
      return stat1;
    } else if (astToGet.equals("stat2")) {
      return stat2;
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
    if (astToSet.equals("statement")) {
      if (stat1 == null) {
        stat1 = (AST_Stat) nodeToSet;
      } else if (stat2 == null) {
        stat2 = (AST_Stat) nodeToSet;
      } else {
        System.out.println("Stat1 and Stat2 in AST_StatMult have already been assigned.");
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
      //Do symbol table stuff
    }
  }

  /**
   * Used for testing - Prints out contents of current AST node
   */
  @Override
  public void printContents() {
    System.out.println(this.getClass().getSimpleName() + ": ");
    if (stat1 == null) {
      System.out.println("stat1: null");
    } else {
      System.out.println("stat1: has content");
    }
    if (stat2 == null) {
      System.out.println("stat2: null");
    } else {
      System.out.println("stat2: has content");
    }
  }


  public void accept(AST_NodeVisitor visitor) {
    visitor.visit(this);
    stat1.accept(visitor);
    stat2.accept(visitor);
  }

  @Override
  public void acceptInstr(List<String> assemblyCode) {
    stat1.acceptInstr(assemblyCode);
    stat2.acceptInstr(assemblyCode);
  }

  /**
   * No explicit register allocation
   * Return a null Reg as no result evaluation
   */
  @Override
  public RegisterARM acceptRegister(RegisterAllocation registerAllocation) throws Exception {
    stat1.acceptRegister(registerAllocation);
    stat2.acceptRegister(registerAllocation);
    return RegisterARM.NULL_REG;
  }

  /**
   * StatMult doesn't produce any assembly code
   * Its a holder ast node for two statements which are evalutaed in the right order
   */


  public void genInstruction(List<Instruction> instructionList, RegisterAllocation registerAllocation) throws Exception {
    System.out.println("Stat mult doesn't produce any assembly code ");
  }

}

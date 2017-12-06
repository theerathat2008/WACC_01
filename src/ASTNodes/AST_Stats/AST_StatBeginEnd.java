package ASTNodes.AST_Stats;

import ASTNodes.AST_Node;
import InstructionSet.Instruction;
import Registers.RegisterARM;
import Registers.RegisterAllocation;
import SymbolTable.SymbolTable;
import VisitorClass.AST_NodeVisitor;

import java.util.ArrayDeque;
import java.util.List;

public class AST_StatBeginEnd extends AST_Stat {

  //Syntactic attributes
  AST_Stat statAST;
  public SymbolTable symbolTable;

  /**
   * Assign the class variables when called
   */
  public AST_StatBeginEnd(SymbolTable ST) {
    this.statAST = null;
    symbolTable = new SymbolTable("begin_end");
    ST.childTables.add(symbolTable);
    symbolTable.setEncSymTable(ST);
  }

  /**
   * Gets all children nodes of current node
   *
   * @return list of AST nodes that are the children of the current node
   */
  @Override
  public ArrayDeque<AST_Node> getNodes() {
    ArrayDeque<AST_Node> returnList = new ArrayDeque<>();
    returnList.addLast(statAST);
    return returnList;
  }

  /**
   * Returns true if the embedded Nodes have value
   */
  @Override
  public boolean isEmbeddedNodesFull() {
    return statAST != null;
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
   * @param astToGet Shows which child to get from current node
   * @param counter  Shows which child of child to get from current node
   * @return Returns the required child AST Node (determined by the astToGet parameter)
   */
  @Override
  public AST_Node getEmbeddedAST(String astToGet, int counter) {
    if (astToGet.equals("statAST")) {
      return statAST;
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
      statAST = (AST_Stat) nodeToSet;
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
    if (statAST == null) {
      System.out.println("statAST: null");
    } else {
      System.out.println("statAST: has content");
    }
    symbolTable.printKeysTable(symbolTable);
  }

  @Override
  public void acceptPreProcess(RegisterAllocation regAlloc) {
    statAST.acceptPreProcess(regAlloc);
  }

  public void accept(AST_NodeVisitor visitor) {
    visitor.visit(this);
    statAST.accept(visitor);
  }

  @Override
  public void acceptInstr(List<String> assemblyCode) {
    statAST.acceptInstr(assemblyCode);
  }


  /**
   * Returns a null reg as there is no result evaluation
   */
  @Override
  public RegisterARM acceptRegister(RegisterAllocation registerAllocation) throws Exception {
    String oldScope = registerAllocation.getCurrentScope();
    registerAllocation.setCurrentScope("BeginEnd");
    statAST.acceptRegister(registerAllocation);
    registerAllocation.setCurrentScope(oldScope);
    return RegisterARM.NULL_REG;
  }

  /**
   * Begin and end just define new scopes but don't generate new assembly code
   * so registers mapped to values called from within a begin end scope will have different
   * values if they have the same duplicate name, see scopeRedefine wacc example
   * This by making adding additional scope information to the string value in the Map of either
   * register values in use or the stack memory address map
   */

  public void genInstruction(List<Instruction> instructionList, RegisterAllocation registerAllocation) throws Exception {
    System.out.println("Begin and end doesn't generate new assembly code");
  }
}

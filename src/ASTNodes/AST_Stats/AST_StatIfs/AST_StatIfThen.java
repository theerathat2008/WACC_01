package ASTNodes.AST_Stats.AST_StatIfs;

import ASTNodes.AST_Node;
import ASTNodes.AST_Stats.AST_Stat;
import SymbolTable.SymbolTable;
import java.util.ArrayDeque;


public class AST_StatIfThen extends AST_StatSubIf{


  //Syntactic attributes
  AST_Stat thenStat;
  public SymbolTable symbolTable;
  //Semantic attribute

  /**
   * Assign the class variables when called
   */
  public AST_StatIfThen(SymbolTable ST) {
    this.thenStat = null;
    symbolTable = new SymbolTable("then");
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
    returnList.addLast(thenStat);
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
    return thenStat != null;
  }

  /**
   * @param astToGet Shows which child to get from current node
   * @param counter  Shows which child of child to get from current node
   * @return Returns the required child AST Node (determined by the astToGet parameter)
   */
  @Override
  public AST_Node getEmbeddedAST(String astToGet, int counter) {
    if (astToGet.equals("thenStat")) {
      return thenStat;
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
      thenStat = (AST_Stat) nodeToSet;
    } else {
      System.out.println("Unrecognised AST Node at class: " + this.getClass().getSimpleName());
    }
  }

  /**
   * Semantic Analysis and print error message if needed
   *
   * @param ST
   */
  @Override
  protected boolean CheckSemantics(SymbolTable ST) {
    return true;
  }

  /**
   * Called from visitor
   *
   * @param ST
   */
  @Override
  public void Check(SymbolTable ST) {
    if (CheckSemantics(ST)) {
      //Do symbol table stuff
    }
  }

  /**
   * Used for testing - Prints out contents of current AST node
   */
  @Override
  public void printContents() {
    System.out.println(this.getClass().getSimpleName() + ": ");
    if (thenStat == null) {
      System.out.println("thenStat: null");
    } else {
      System.out.println("thenStat: has content");
    }
    symbolTable.printKeysTable(symbolTable);
  }
}

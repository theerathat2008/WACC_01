package ASTNodes.AST_Stats;

import ASTNodes.AST_Node;
import ASTNodes.AST_Stats.AST_StatAssignLHSs.AST_StatAssignLHS;
import SymbolTable.SymbolTable;

import java.util.ArrayDeque;

public class AST_StatRead extends AST_Stat{

  //Syntactic attributes
  AST_StatAssignLHS ast_statAssignLHS;
  //Semantic attribute

  /**
   * Assign the class variables when called
   */
  public AST_StatRead(){
    this.ast_statAssignLHS = null;
  }

  /**
   * Gets all children nodes of current node
   * @return list of AST nodes that are the children of the current node
   */
  @Override
  public ArrayDeque<AST_Node> getNodes(){
    ArrayDeque<AST_Node> returnList = new ArrayDeque<>();
    returnList.addLast(ast_statAssignLHS);
    return returnList;
  }

  /**
   * Sets syntactic attributes of class variables by assigning it a value
   * @param value - Value to be assigned to class variable
   */
  @Override
  public void setSyntacticAttributes(String value){
    System.out.println("No String Syntactic Attributes in class: " + this.getClass().getSimpleName());
  }

  /**
   * Gets syntactic attributes of class variables
   * @param strToGet - Value to be retrieved from class variable
   */
  @Override
  public String getSyntacticAttributes(String strToGet){
    System.out.println("No String Syntactic Attributes in class: " + this.getClass().getSimpleName());
    return null;
  }

  /**
   * Returns true if the embedded Nodes have value
   */
  @Override
  public boolean isEmbeddedNodesFull(){
    return ast_statAssignLHS != null;
  }

  /**
   * @param astToGet Shows which child to get from current node
   * @param counter Shows which child of child to get from current node
   * @return Returns the required child AST Node (determined by the astToGet parameter)
   */
  @Override
  public AST_Node getEmbeddedAST(String astToGet, int counter){
    if(astToGet.equals("ast_statAssignLHS")){
      return ast_statAssignLHS;
    }
    System.out.println("Unrecognised AST Node at class: " + this.getClass().getSimpleName());
    return null;
  }

  /**
   * @param astToSet Shows which child to set from current node
   * @param nodeToSet Shows which child of child to set from current node
   */
  @Override
  public void setEmbeddedAST(String astToSet, AST_Node nodeToSet){
    if(astToSet.equals("ast_statAssignLHS")){
      ast_statAssignLHS = (AST_StatAssignLHS) nodeToSet;
    } else {
      System.out.println("Unrecognised AST Node at class: " + this.getClass().getSimpleName());
    }
  }

  /**
   * Semantic Analysis and print error message if needed
   * @param ST
   * @return
   */
  @Override
  protected boolean CheckSemantics(SymbolTable ST){
    return true;
  }

  /**
   * Called from visitor
   * @param ST
   */
  @Override
  public void Check(SymbolTable ST){
    if(CheckSemantics(ST)){
      //Do symbol table stuff
    }
  }

  /**
   * Used for testing - Prints out contents of current AST node
   */
  @Override
  public void printContents(){
    System.out.println(this.getClass().getSimpleName() + ": ");
    if(ast_statAssignLHS == null){
      System.out.println("stat1: null");
    } else {
      System.out.println("stat1: has content");
    }
  }
}

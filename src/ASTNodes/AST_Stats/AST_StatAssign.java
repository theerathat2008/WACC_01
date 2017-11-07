package ASTNodes.AST_Stats;

import ASTNodes.AST_Node;
import ASTNodes.AST_Stats.AST_StatAssignLHSs.AST_StatAssignLHS;
import ASTNodes.AST_Stats.AST_StatAssignRHSs.AST_StatAssignRHS;
import SymbolTable.SymbolTable;
import src.ErrorMessages.TypeMismatchError;
import src.FilePosition;

import java.util.ArrayDeque;

/**
 * Class representing node in AST tree for ASSIGNMENT STATEMENTS
 */
public class AST_StatAssign extends AST_Stat{
  //Syntactic attributes
  AST_StatAssignLHS ast_statAssignLHS;
  AST_StatAssignRHS ast_statAssignRHS;

  /**
   * Constructor for class - initialises class variables to NULL
   */
  public AST_StatAssign(){
    this.ast_statAssignLHS = null;
    this.ast_statAssignRHS = null;
  }

  /**
   * Gets all children nodes of current node
   * @return list of AST nodes that are the children of the current node
   */
  @Override
  public ArrayDeque<AST_Node> getNodes(){
    ArrayDeque<AST_Node> returnList = new ArrayDeque<>();
    returnList.addLast(ast_statAssignLHS);
    returnList.addLast(ast_statAssignRHS);
    return returnList;
  }

  /**
   * Returns true if the embedded Nodes have value
   */
  @Override
  public boolean isEmbeddedNodesFull(){
    return ast_statAssignLHS != null && ast_statAssignRHS != null;
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
   * @param astToGet Shows which child to get from current node
   * @param counter Shows which child of child to get from current node
   * @return Returns the required child AST Node (determined by the astToGet parameter)
   */
  @Override
  public AST_Node getEmbeddedAST(String astToGet, int counter){
    if(astToGet.equals("ast_statAssignLHS")){
      return ast_statAssignLHS;
    } else if (astToGet.equals("ast_statAssignRHS")){
      return ast_statAssignRHS;
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
    } else if (astToSet.equals("statAssignRHS")){
      ast_statAssignRHS = (AST_StatAssignRHS) nodeToSet;
    } else {
      System.out.println("Unrecognised AST Node at class: " + this.getClass().getSimpleName());
    }
  }


  //Semantic Analysis and print error message if needed
  protected boolean CheckSemantics(SymbolTable ST){
    if (ast_statAssignLHS.getType(ST).equals(ast_statAssignRHS.getType(ST))) {
      return true;
    } else {
      new TypeMismatchError(new FilePosition(ctx)).printAll();
      return false;
    }
  }

  // Called from visitor
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
      System.out.println("ast_statAssignLHS: null");
    } else {
      System.out.println("ast_statAssignLHS: has content");
    }
    if(ast_statAssignRHS == null){
      System.out.println("ast_statAssignRHS: null");
    } else {
      System.out.println("ast_statAssignRHS: has content");
    }
  }

}

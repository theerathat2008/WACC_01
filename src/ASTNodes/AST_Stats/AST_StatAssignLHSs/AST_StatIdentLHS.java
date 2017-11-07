package ASTNodes.AST_Stats.AST_StatAssignLHSs;

import ASTNodes.AST_Node;
import SymbolTable.SymbolTable;
import java.util.ArrayDeque;

/**
 * Class representing node in AST tree for DECLARING IDENTIFIERS
 */
public class AST_StatIdentLHS extends AST_StatAssignLHS{
  //Syntactic attributes
  String identName;

  /**
   * Constructor for class - initialises class variables
   * @param numberOfChildren - Shows the number of parameters in the parameter list of function
   */
  public AST_StatIdentLHS(){
    this.identName = null;

  }

  /**
   * Gets all children nodes of current node
   * @return list of AST nodes that are the children of the current node
   */
  @Override
  public ArrayDeque<AST_Node> getNodes(){
    System.out.println("Terminal AST Node at: " + this.getClass().getSimpleName());
    return null;
  }

  /**
   * Sets syntactic attributes of class variables by assigning it a value
   * @param value - Value to be assigned to class variable
   */
  @Override
  public void setSyntacticAttributes(String value){
    if(identName == null){
      this.identName = value;
    } else {
      System.out.println("Unrecognised String Attribute" + this.getClass().getSimpleName());
    }
  }

  /**
   * Gets syntactic attributes of class variables
   * @param strToGet - Value to be retrieved from class variable
   */
  @Override
  public String getSyntacticAttributes(String strToGet){
    if(strToGet.equals("identName")){
      return identName;
    } else {
      System.out.println("Unrecognised String Attribute" + this.getClass().getSimpleName());
      return null;
    }
  }

  /**
   * Returns true if the embedded Nodes have value
   */
  @Override
  public boolean isEmbeddedNodesFull(){
    return true;
  }

  /**
   * @param astToGet Shows which child to get from current node
   * @param counter Shows which child of child to get from current node
   * @return Returns the required child AST Node (determined by the astToGet parameter)
   */
  @Override
  public AST_Node getEmbeddedAST(String astToGet, int counter){
    System.out.println("Terminal AST Node at: " + this.getClass().getSimpleName());
    return null;
  }

  /**
   * @param astToSet Shows which child to set from current node
   * @param nodeToSet Shows which child of child to set from current node
   */
  @Override
  public void setEmbeddedAST(String astToSet, AST_Node nodeToSet){
    System.out.println("Terminal AST Node at: " + this.getClass().getSimpleName());
  }


  @Override
  //Semantic Analysis and print error message if needed
  protected boolean CheckSemantics(SymbolTable ST){
    return true;
  }

  @Override
  // Called from visitor
  public void Check(SymbolTable ST){
    if(CheckSemantics(ST)){
      setType(ST.lookupAll(identName).toString());
    }
  }

  /**
   * Used for testing - Prints out contents of current AST node
   */
  @Override
  public void printContents(){
    System.out.println(this.getClass().getSimpleName() + ": ");
    System.out.println("identName: " + identName);
  }
}

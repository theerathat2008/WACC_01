package ASTNodes.AST_TYPES;

import ASTNodes.AST_Node;
import ASTNodes.AST_TYPES.AST_PairElemTypes.AST_PairElemType;
import ASTNodes.AST_TYPES.AST_Type;
import SymbolTable.SymbolTable;

import java.util.ArrayDeque;

/**
 * Class representing node in AST tree for PAIRTYPE
 */
public class AST_PairType extends AST_Type{
  //Syntactic attributes
  AST_PairElemType pairElemTypeFst;
  AST_PairElemType pairElemTypeSnd;

  /**
   * Constructor for class - initialises class variables TO NULL
   */
  public AST_PairType(){
    this.pairElemTypeFst = null;
    this.pairElemTypeSnd = null;
  }

  /**
   * Gets all children nodes of current node
   * @return list of AST nodes that are the children of the current node
   */
  @Override
  public ArrayDeque<AST_Node> getNodes(){
    ArrayDeque<AST_Node> returnList = new ArrayDeque<>();
    returnList.addLast(pairElemTypeFst);
    returnList.addLast(pairElemTypeSnd);
    return returnList;
  }

  @Override
  public boolean isEmbeddedNodesFull(){
    return pairElemTypeFst != null && pairElemTypeSnd != null;
  }

  /**
   * Sets syntactic attributes of class variables by assigning it a value
   * @param value - Value to be assigned to class variable
   */
  @Override
  public void setSyntacticAttributes(String value){
    System.out.println("No Syntactic Attribute");
  }


  /**
   * Gets syntactic attributes of class variables
   * @param strToGet - Value to be retrieved from class variable
   */
  @Override
  public String getSyntacticAttributes(String strToGet){
    System.out.println("No Syntactic Attribute");
    return null;
  }

  /**
   * @param astToGet Shows which child to get from current node
   * @param counter Shows which child of child to get from current node
   * @return Returns the required child AST Node (determined by the astToGet parameter)
   */
  @Override
  public AST_Node getEmbeddedAST(String astToGet, int counter){
    if(astToGet.equals("pairElemTypeFst")){
      return pairElemTypeFst;
    } else if (astToGet.equals("pairElemTypeSnd")){
      return pairElemTypeSnd;
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
    if(astToSet.equals("pairElemType")){
      if (pairElemTypeFst == null){
        pairElemTypeFst = (AST_PairElemType) nodeToSet;
      } else if (pairElemTypeSnd == null){
        pairElemTypeSnd = (AST_PairElemType) nodeToSet;
      } else {
        System.out.println("pairElemTypeFst and pairElemTypeSnd in AST_PairType have already been assigned.");
      }
    } else {
      System.out.println("Unrecognised AST Node at class: " + this.getClass().getSimpleName());
    }
  }

  //Semantic Analysis and print error message if needed
  @Override
  protected boolean CheckSemantics(SymbolTable ST){
    return true;
  }

  // Called from visitor
  @Override
  public void Check(SymbolTable ST){
    if(CheckSemantics(ST)){
      //Do symbol table stuff
    }
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
  public void printContents(){
    System.out.println(this.getClass().getSimpleName() + ": ");
    if(pairElemTypeFst == null){
      System.out.println("pairElemTypeFst: null");
    } else {
      System.out.println("pairElemTypeFst: has content");
    }
    if(pairElemTypeSnd == null){
      System.out.println("pairElemTypeSnd: null");
    } else {
      System.out.println("pairElemTypeSnd: has content");
    }
  }
}

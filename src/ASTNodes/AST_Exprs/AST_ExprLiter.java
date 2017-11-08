package ASTNodes.AST_Exprs;

import ASTNodes.AST_Node;
import SymbolTable.SymbolTable;
import java.util.ArrayDeque;

/**
 * Class representing node in AST tree for LITERAL EXPRESSIONS
 */
public class AST_ExprLiter extends AST_Expr{
  //Syntactic attributes
  String constant;    //TODO change to content
  String literal;

  /**
   * Constructor for class - initialises class variables to NULL
   */
  public AST_ExprLiter(){
    this.constant = null;
    this.literal = null;

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
    if(constant == null){
      this.constant = value;
    } else if(literal == null){
      this.literal = value;
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
    if(strToGet.equals("constant")){
      return constant;
    } else if(strToGet.equals("literal")){
      return literal;
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


  //Semantic Analysis and print error message if needed
  protected boolean CheckSemantics(SymbolTable ST){
    return true;
  }

  // Called from visitor
  public void Check(SymbolTable ST){
    if(CheckSemantics(ST)){
      if (literal.equals("INT_LITER")) {
        setType("int");
      } else if (literal.equals("BOOL_LITER")) {
        setType("bool");
      } else if (literal.equals("CHAR_LITER")) {
        setType("char");
      } else if(literal.equals("STRING_LITER")) {
        setType("string");
      } else if(literal.equals("PAIR_LITER")) {
        setType("pair");
      } else {
        setType("null");
      }
    }
  }

  /**
   * Used for testing - Prints out contents of current AST node
   */
  @Override
  public void printContents(){
    System.out.println(this.getClass().getSimpleName() + ": ");
    System.out.println("constant: " + constant);
    System.out.println("literal: " + literal);

  }
}

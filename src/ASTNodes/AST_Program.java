package ASTNodes;

import ASTNodes.AST_Stats.AST_Stat;
import SymbolTable.SymbolTable;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;


/**
 * Class representing node in AST tree for PROGRAM
 */
public class AST_Program extends AST_Node {

  //Syntactic attributes
  List<AST_FuncDecl> funcDeclList;
  int numOfFunc;
  AST_Stat statement;

  /**
   * Assign the member variables when called and set the number of children
   */
  public AST_Program(int numberOfChildren) {
    this.numOfFunc = numberOfChildren - 4;
    this.funcDeclList = new ArrayList<>();
    statement = null;
  }

  /**
   * Gets all children nodes of current node
   *
   * @return list of AST nodes that are the children of the current node
   */
  @Override
  public ArrayDeque<AST_Node> getNodes() {
    ArrayDeque<AST_Node> returnList = new ArrayDeque<>();
    for (AST_FuncDecl funcDecl : funcDeclList) {
      returnList.addLast(funcDecl);
    }
    returnList.addLast(statement);
    return returnList;
  }

  /**
   * Sets syntactic attributes of class variables - Holder function to implement abstract method
   * Never called - used for debug purposes
   *
   * @param value - Value to be assigned to class variable
   */
  @Override
  public void setSyntacticAttributes(String value) {
    System.out.println("No String Syntactic Attributes in class: " + this.getClass().getSimpleName());
  }

  /**
   * Gets syntactic attributes of class variables - Holder function to implement abstract method
   * Never called - used for debug purposes
   *
   * @param strToGet - Value to be retrieved from class variable
   */
  @Override
  public String getSyntacticAttributes(String strToGet) {
    System.out.println("No String Syntactic Attributes in class: " + this.getClass().getSimpleName());
    return null;
  }

  /**
   * Returns true if the embedded Nodes have values
   */
  @Override
  public boolean isEmbeddedNodesFull() {
    return funcDeclList.size() == numOfFunc && statement != null;
  }

  /**
   * @param astToGet Shows which child to get from current node
   * @param counter  Shows which child of child to get from current node
   * @return Returns the required child AST Node (determined by the astToGet parameter)
   */
  @Override
  public AST_Node getEmbeddedAST(String astToGet, int counter) {
    if (astToGet.equals("functionList")) {
      return funcDeclList.get(counter);
    } else if (astToGet.equals("statement")) {
      return statement;
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
    if (astToSet.equals("functionList")) {
      funcDeclList.add(((AST_FuncDecl) nodeToSet));
    } else if (astToSet.equals("statement")) {
      statement = (AST_Stat) nodeToSet;
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
      //Do symbol table stuff     Nothing to check here (I think)
    } else {

    }
  }

  /**
   * Used for testing - Prints out contents of current AST node
   */
  @Override
  public void printContents() {
    System.out.println(this.getClass().getSimpleName() + ": ");
    System.out.println("numOfFunc: " + numOfFunc);
    if (funcDeclList == null) {
      System.out.println("funcDeclList: null");
    } else {
      System.out.println("funcDeclList: has content");
    }
    if (statement == null) {
      System.out.println("statement: null");
    } else {
      System.out.println("statement: has content");
    }
  }
}

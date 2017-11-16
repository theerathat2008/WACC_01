package ASTNodes;


import SymbolTable.SymbolTable;
import ASTNodes.AST_TYPES.AST_Type;

import java.util.ArrayDeque;
import java.util.List;

import VisitorClass.AST_NodeVisitor;

import IdentifierObjects.*;

/**
 * Class representing node in AST tree for PARAMS
 */
public class AST_Param extends AST_Node {

  //Syntactic attributes
  AST_Type ast_type;
  String paramName;

  /**
   * Constructor for node class initialising variables to null
   */
  public AST_Param() {
    this.paramName = null;
    this.ast_type = null;
  }

  public String getParamName() {
    return paramName;
  }


  /**
   * Gets all children nodes of current node
   *
   * @return list of AST nodes that are the children of the current node
   */
  @Override
  public ArrayDeque<AST_Node> getNodes() {
    ArrayDeque<AST_Node> returnList = new ArrayDeque<>();
    returnList.addLast(ast_type);
    return returnList;
  }

  /**
   * Sets syntactic attributes of class variables by assigning it a value
   *
   * @param value - Value to be assigned to class variable
   */
  @Override
  public void setSyntacticAttributes(String value) {
    if (paramName == null) {
      this.paramName = value;
    } else {
      System.out.println("Unrecognised String Attribute" + this.getClass().getSimpleName());
    }
  }

  /**
   * Gets syntactic attributes of class variables
   *
   * @param strToGet - Value to be retrieved from class variable
   */
  @Override
  public String getSyntacticAttributes(String strToGet) {
    if (strToGet.equals("paramName")) {
      return paramName;
    } else {
      System.out.println("Unrecognised String Attribute" + this.getClass().getSimpleName());
      return null;
    }
  }

  /**
   * Returns true if the embedded Nodes have value
   */
  @Override
  public boolean isEmbeddedNodesFull() {
    return ast_type != null;
  }

  /**
   * @param astToGet Shows which child to get from current node
   * @param counter  Shows which child of child to get from current node
   * @return Returns the required child AST Node (determined by the astToGet parameter)
   */
  @Override
  public AST_Node getEmbeddedAST(String astToGet, int counter) {
    if (astToGet.equals("ast_type")) {
      return ast_type;
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
    if (astToSet.equals("ast_type")) {
      ast_type = (AST_Type) nodeToSet;
    } else {
      System.out.println("Unrecognised AST Node at class: " + this.getClass().getSimpleName());
    }
  }

  /**
   * Semantic Analysis and print error message if needed
   *
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
      while (!ST.getScope().equals("param_list")) {
        ST = ST.encSymTable;
      }
      ST.add(paramName, ast_type.getIdentifier());
    }
  }

  public void Assign() {
    ((AST_FuncDecl) parentNode.getParentNode()).symbolTable.add(paramName, ast_type.getIdentifier());
  }

  public IDENTIFIER getIdentifier() {
    return ast_type.getIdentifier();
  }

  /**
   * Used for testing - Prints out contents of current AST node
   */
  @Override
  public void printContents() {
    System.out.println(this.getClass().getSimpleName() + ": ");
    if (ast_type == null) {
      System.out.println("ast_type: null");
    } else {
      System.out.println("ast_type: has content");
    }
    System.out.println("paramName: " + paramName);
  }

  public void accept(AST_NodeVisitor visitor) {
    visitor.visit(this);
    ast_type.accept(visitor);
  }

  @Override
  public void genCode(List<String> instructions) {

  }
}

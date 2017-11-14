package ASTNodes.AST_Exprs;

import ASTNodes.AST_Node;
import SymbolTable.SymbolTable;
import VisitorClass.AST_NodeVisitor;
import java.util.ArrayDeque;

import IdentifierObjects.*;

/**
 * Class representing node in AST tree for UNARY EXPRESSIONS
 */
public class AST_ExprUnary extends AST_Expr {

  //Syntactic attributes
  String opName;
  AST_Expr astExpr;

  /**
   * Constructor for class - initialises class variables to NULL
   */
  public AST_ExprUnary() {
    this.opName = null;
    this.astExpr = null;
  }

  /**
   * Gets all children nodes of current node
   *
   * @return list of AST nodes that are the children of the current node
   */
  @Override
  public ArrayDeque<AST_Node> getNodes() {
    ArrayDeque<AST_Node> returnList = new ArrayDeque<>();
    returnList.addLast(astExpr);
    return returnList;
  }

  /**
   * Returns true if the embedded Nodes have value
   */
  @Override
  public boolean isEmbeddedNodesFull() {
    return astExpr != null;
  }

  /**
   * Sets syntactic attributes of class variables by assigning it a value
   *
   * @param value - Value to be assigned to class variable
   */
  @Override
  public void setSyntacticAttributes(String value) {
    if (opName == null) {
      this.opName = value;
      if (opName.equals("!")) {
        identifier = new BaseTypeObj(null, "bool");
      } else if (opName.equals("-")) {
        identifier = new BaseTypeObj(null, "int");
      } else if (opName.equals("len")) {
        identifier = new BaseTypeObj(null, "int");
      } else if (opName.equals("ord")) {
        identifier = new BaseTypeObj(null, "int");
      } else if (opName.equals("chr")) {
        identifier = new BaseTypeObj(null, "char");
      } else {
        identifier = null;
      }
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
    if (strToGet.equals("opName")) {
      return opName;

    } else {
      System.out.println("Unrecognised String Attribute" + this.getClass().getSimpleName());
      return null;
    }
  }

  /**
   * @param astToGet Shows which child to get from current node
   * @param counter  Shows which child of child to get from current node
   * @return Returns the required child AST Node (determined by the astToGet parameter)
   */
  @Override
  public AST_Node getEmbeddedAST(String astToGet, int counter) {
    if (astToGet.equals("astExpr")) {
      return astExpr;
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
    if (astToSet.equals("expr")) {
      astExpr = (AST_Expr) nodeToSet;
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
      if (opName.equals("!")) {
        setType("bool");
      } else if (opName.equals("-")) {
        setType("int");
      } else if (opName.equals("len")) {
        setType("int");
      } else if (opName.equals("ord")) {
        setType("int");
      } else if (opName.equals("chr")) {
        setType("char");
      } else {
        setType("null");
      }
    }
  }

  /**
   * Used for testing - Prints out contents of current AST node
   */
  @Override
  public void printContents() {
    System.out.println(this.getClass().getSimpleName() + ": ");
    System.out.println("opName: " + opName);
    if (astExpr == null) {
      System.out.println("astExpr: null");
    } else {
      System.out.println("astExpr: has content");
    }
  }

  public void accept(AST_NodeVisitor visitor) {
    visitor.visit(this);
    astExpr.accept(visitor);
  }
}

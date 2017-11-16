package ASTNodes.AST_Exprs;

import ASTNodes.AST_Node;
import SymbolTable.SymbolTable;

import java.util.ArrayDeque;
import VisitorClass.AST_NodeVisitor;
import IdentifierObjects.*;

/**
 * Class representing node in AST tree for BINARY EXPRESSIONS
 */
public class AST_ExprBinary extends AST_Expr {

  //Syntactic attributes
  String opName;
  AST_Expr exprLeftAST;
  AST_Expr exprRightAST;

  /**
   * Constructor for class - initialises class variables to NULL
   */
  public AST_ExprBinary() {
    this.exprLeftAST = null;
    this.exprRightAST = null;
    this.opName = null;
  }

  /**
   * Gets all children nodes of current node
   *
   * @return list of AST nodes that are the children of the current node
   */
  @Override
  public ArrayDeque<AST_Node> getNodes() {
    ArrayDeque<AST_Node> returnList = new ArrayDeque<>();
    returnList.addLast(exprLeftAST);
    returnList.addLast(exprRightAST);
    return returnList;
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
      if (opName.equals("*")) {
        identifier = new BaseTypeObj(null, "int");
      } else if (opName.equals("/")) {
        identifier = new BaseTypeObj(null, "int");
      } else if (opName.equals("%")) {
        identifier = new BaseTypeObj(null, "int");
      } else if (opName.equals("+")) {
        identifier = new BaseTypeObj(null, "int");
      } else if (opName.equals("-")) {
        identifier = new BaseTypeObj(null, "int");
      } else {
        identifier = new BaseTypeObj(null, "bool");
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
   * Returns true if the embedded Nodes have value
   */
  @Override
  public boolean isEmbeddedNodesFull() {
    return exprLeftAST != null && exprRightAST != null;
  }

  /**
   * @param astToGet Shows which child to get from current node
   * @param counter  Shows which child of child to get from current node
   * @return Returns the required child AST Node (determined by the astToGet parameter)
   */
  @Override
  public AST_Node getEmbeddedAST(String astToGet, int counter) {
    if (astToGet.equals("exprLeftAST")) {
      return exprLeftAST;
    } else if (astToGet.equals("exprRightAST")) {
      return exprRightAST;
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
      if (exprLeftAST == null) {
        exprLeftAST = (AST_Expr) nodeToSet;
      } else if (exprRightAST == null) {
        exprRightAST = (AST_Expr) nodeToSet;
      } else {
        System.out.println("If and then in AST_StatIf have already been assigned.");
      }
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
      if (opName.equals("*")) {
        setType("int");
      } else if (opName.equals("/")) {
        setType("int");
      } else if (opName.equals("%")) {
        setType("int");
      } else if (opName.equals("+")) {
        setType("int");
      } else if (opName.equals("-")) {
        setType("int");
      } else {
        setType("bool");
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
    if (exprLeftAST == null) {
      System.out.println("exprLeftAST: null");
    } else {
      System.out.println("exprLeftAST: has content");
    }
    if (exprRightAST == null) {
      System.out.println("exprRightAST: null");
    } else {
      System.out.println("exprRightAST: has content");
    }
  }

  public void accept(AST_NodeVisitor visitor) {
    visitor.visit(this);
    exprLeftAST.accept(visitor);
    exprRightAST.accept(visitor);
  }

}

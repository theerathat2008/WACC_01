package ASTNodes.AST_Stats.AST_StatAssignRHSs;

import ASTNodes.AST_Exprs.AST_Expr;
import ASTNodes.AST_Node;
import SymbolTable.SymbolTable;
import VisitorClass.AST_NodeVisitor;
import java.util.ArrayDeque;

/**
 * Class representing node in AST tree for NEW PAIR ASSIGNMENT
 */
public class AST_StatNewPairRHS extends AST_StatAssignRHS {

  //Syntactic attributes
  AST_Expr ast_expr_first;
  AST_Expr ast_expr_second;

  /**
   * Constructor for class - initialises class variables to NULL
   */
  public AST_StatNewPairRHS() {
    this.ast_expr_first = null;
    this.ast_expr_second = null;
  }

  /**
   * Gets all children nodes of current node
   *
   * @return list of AST nodes that are the children of the current node
   */
  @Override
  public ArrayDeque<AST_Node> getNodes() {
    ArrayDeque<AST_Node> returnList = new ArrayDeque<>();
    returnList.addLast(ast_expr_first);
    returnList.addLast(ast_expr_second);
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
    return ast_expr_first != null && ast_expr_second != null;
  }

  /**
   * @param astToGet Shows which child to get from current node
   * @param counter  Shows which child of child to get from current node
   * @return Returns the required child AST Node (determined by the astToGet parameter)
   */
  @Override
  public AST_Node getEmbeddedAST(String astToGet, int counter) {
    if (astToGet.equals("ast_expr_first")) {
      return ast_expr_first;
    } else if (astToGet.equals("ast_expr_second")) {
      return ast_expr_second;
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
      if (ast_expr_first == null) {
        ast_expr_first = (AST_Expr) nodeToSet;
      } else if (ast_expr_second == null) {
        ast_expr_second = (AST_Expr) nodeToSet;
      } else {
        System.out.println("If and then in AST_StatIf have already been assigned.");
      }
    } else if (astToSet.equals("ast_expr_second")) {
      ast_expr_second = (AST_Expr) nodeToSet;
    } else {
      System.out.println("Unrecognised AST Node at class: " + this.getClass().getSimpleName());
    }
  }

  /**
   * @param ST - Parameter of current symbol table in scope
   * @return - Returns the type of the identifier variable
   */
  public String getType(SymbolTable ST) {
    return "PAIR(" + ast_expr_first.toString() + "," + ast_expr_second + ")";
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
    if (ast_expr_first == null) {
      System.out.println("ast_expr_first: null");
    } else {
      System.out.println("ast_expr_first: has content");
    }
    if (ast_expr_second == null) {
      System.out.println("ast_expr_second: null");
    } else {
      System.out.println("ast_expr_second: has content");
    }
  }

  public void accept(AST_NodeVisitor visitor) {
    visitor.visit(this);
    ast_expr_first.accept(visitor);
    ast_expr_second.accept(visitor);
  }
}

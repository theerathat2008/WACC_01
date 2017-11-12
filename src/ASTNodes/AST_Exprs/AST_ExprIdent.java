package src.ASTNodes.AST_Exprs;

import src.ASTNodes.AST_Node;
import src.IdentifierObjects.*;
import src.SymbolTable.SymbolTable;
import src.ErrorMessages.UndefinedIdentError;
import src.FilePosition;
import org.antlr.v4.runtime.ParserRuleContext;


import java.util.ArrayDeque;

/**
 * Class representing node in AST tree for IDENT EXPRESSIONS
 */
public class AST_ExprIdent extends AST_Expr {

  //Syntactic attributes
  String varName;
  ParserRuleContext ctx;

  /**
   * Constructor for class - initialises class variables to NULL
   */
  public AST_ExprIdent(ParserRuleContext ctx) {
    this.varName = null;
    this.ctx = ctx;
  }

  /**
   * Gets all children nodes of current node
   *
   * @return list of AST nodes that are the children of the current node
   */
  @Override
  public ArrayDeque<AST_Node> getNodes() {
    System.out.println("Terminal AST Node at: " + this.getClass().getSimpleName());
    return null;
  }

  /**
   * Sets syntactic attributes of class variables by assigning it a value
   *
   * @param value - Value to be assigned to class variable
   */
  @Override
  public void setSyntacticAttributes(String value) {
    if (varName == null) {
      this.varName = value;
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
    if (strToGet.equals("varName")) {
      return varName;
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
    return true;
  }

  /**
   * @param astToGet Shows which child to get from current node
   * @param counter  Shows which child of child to get from current node
   * @return Returns the required child AST Node (determined by the astToGet parameter)
   */
  @Override
  public AST_Node getEmbeddedAST(String astToGet, int counter) {
    System.out.println("Terminal AST Node at: " + this.getClass().getSimpleName());
    return null;
  }

  /**
   * @param astToSet  Shows which child to set from current node
   * @param nodeToSet Shows which child of child to set from current node
   */
  @Override
  public void setEmbeddedAST(String astToSet, AST_Node nodeToSet) {
    System.out.println("Terminal AST Node at: " + this.getClass().getSimpleName());
  }

  /**
   * Semantic Analysis and print error message if needed
   *
   * @param ST
   */
  @Override
  protected boolean CheckSemantics(SymbolTable ST) {
    if (ST.lookupAll(varName) != null) {
      return true;
    } else {
      new UndefinedIdentError(new FilePosition(ctx)).printAll();
      return false;
    }
  }

  /**
   * Called from visitor
   *
   * @param ST
   */
  @Override
  public void Check(SymbolTable ST) {
    if (CheckSemantics(ST)) {
      //ST.add(varName, ST.stringToIdent(varName,type));
      setType(ST.lookupAll(varName).toString());
    }
  }

  /**
   * Used for testing - Prints out contents of current AST node
   */
  @Override
  public void printContents() {
    System.out.println(this.getClass().getSimpleName() + ": ");
    System.out.println("varName: " + varName);
  }
}

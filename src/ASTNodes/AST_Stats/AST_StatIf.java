package src.ASTNodes.AST_Stats;


import src.ASTNodes.AST_Exprs.AST_Expr;
import src.ASTNodes.AST_Node;
import src.ErrorMessages.TypeError;
import src.FilePosition;
import src.SymbolTable.SymbolTable;
import antlr.WaccParser;

import java.util.ArrayDeque;
import src.waccVisitor;

public class AST_StatIf extends AST_Stat {

  //Syntactic attributes
  AST_Expr expr;
  AST_Stat thenStat;
  AST_Stat elseStat;
  //Semantic attribute
  WaccParser.IF_STATContext ctx;

  /**
   * Assign the class variables when called
   */
  public AST_StatIf(WaccParser.IF_STATContext ctx) {
    this.expr = null;
    this.thenStat = null;
    this.elseStat = null;
    this.ctx = ctx;
  }

  /**
   * Gets all children nodes of current node
   *
   * @return list of AST nodes that are the children of the current node
   */
  @Override
  public ArrayDeque<AST_Node> getNodes() {
    ArrayDeque<AST_Node> returnList = new ArrayDeque<>();
    returnList.addLast(expr);
    returnList.addLast(thenStat);
    returnList.addLast(elseStat);
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
    return expr != null && thenStat != null && elseStat != null;
  }

  /**
   * @param astToGet Shows which child to get from current node
   * @param counter  Shows which child of child to get from current node
   * @return Returns the required child AST Node (determined by the astToGet parameter)
   */
  @Override
  public AST_Node getEmbeddedAST(String astToGet, int counter) {
    if (astToGet.equals("expr")) {
      return expr;
    } else if (astToGet.equals("thenStat")) {
      return thenStat;
    } else if (astToGet.equals("elseStat")) {
      return elseStat;
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
      expr = (AST_Expr) nodeToSet;
    } else if (astToSet.equals("statement")) {

      if (thenStat == null) {
        thenStat = (AST_Stat) nodeToSet;
      } else if (elseStat == null) {
        elseStat = (AST_Stat) nodeToSet;
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
   * @param ST
   */
  @Override
  protected boolean CheckSemantics(SymbolTable ST) {

    //get type of the expr of the context to see whether it is equal to type bool
    //maybe needs .getExprType?
    if (getExprType(ctx.expr()).equals("bool")) {
      return true;
    } else {
      new TypeError(new FilePosition(ctx)).printAll();
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
      //Do symbol table stuff
    }
  }

  /**
   * Used for testing - Prints out contents of current AST node
   */
  @Override
  public void printContents() {
    System.out.println(this.getClass().getSimpleName() + ": ");
    if (expr == null) {
      System.out.println("expr: null");
    } else {
      System.out.println("expr: has content");
    }
    if (thenStat == null) {
      System.out.println("thenStat: null");
    } else {
      System.out.println("thenStat: has content");
    }
    if (elseStat == null) {
      System.out.println("elseStat: null");
    } else {
      System.out.println("elseStat: has content");
    }
  }
}

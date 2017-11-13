package src.ASTNodes.AST_Stats;

import src.ASTNodes.AST_Exprs.AST_Expr;
import src.ASTNodes.AST_FuncDecl;
import src.ASTNodes.AST_Node;
import src.ASTNodes.AST_Program;
import src.ErrorMessages.OutOfBoundsError;
import src.ErrorMessages.TypeMismatchError;
import src.SymbolTable.SymbolTable;
import src.ErrorMessages.TypeError;
import src.FilePosition;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.ArrayDeque;

public class AST_StatExpr extends AST_Stat {

  //Syntactic attributes
  AST_Expr expr;
  ParserRuleContext ctx;

  /**
   * Assign the class variables when called
   *
   * @param ctx
   */
  public AST_StatExpr(ParserRuleContext ctx) {
    this.expr = null;
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
    return returnList;
  }

  /**
   * Returns true if the embedded Nodes have value
   */
  @Override
  public boolean isEmbeddedNodesFull() {
    return expr != null;
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
    if (statName.equals("FREE")) {
      return expr.getIdentifier().toString().contains("[]") || expr.getIdentifier().toString().startsWith("PAIR(");
    } else if (statName.equals("RETURN")) {
      AST_Node parent = getParentNode();
      while (!(parent instanceof AST_FuncDecl)) {
        if (parent instanceof AST_Program) {
          System.out.println("Return statement not inside of a function.");
          new TypeError(new FilePosition(ctx)).printAll();
          return false;
        }
        parent = getParentNode();
        System.out.println("Going to AST parent, looking for function");
      }
      AST_FuncDecl temp = (AST_FuncDecl) parent;
      if (temp.ast_type.getIdentifier().equals(expr.getIdentifier())) {
        return true;
      } else {
        System.out.println("Return type of the return statement must matched the function's" +
                "return type.");
        new TypeMismatchError(new FilePosition(ctx)).printAll();
        return false;
      }
    } else if (statName.equals("EXIT")) {
      //Integer followed the keyword 'exit' must be in the range of 0-256

      //expression must be of type int
      if (!expr.getIdentifier().toString().equals("int")) {
        System.out.println("Statement following exit must be of type 'int'.");
        new TypeError(new FilePosition(ctx)).printAll();
        return false;
      }

      //integer in the range 0-256
      String exprString = expr.getIdentifier().toString();
      if (Integer.parseInt(exprString) < 0 || Integer.parseInt(exprString) > 256) {
        System.out.println("The exit code given is out of range. It should be inside the interval" +
                "of 0 and 256.");
        new OutOfBoundsError(new FilePosition(ctx)).printAll();
        return false;
      }

    } else if (statName.equals("PRINT")) {
      //expression inside print can only be of type string, char, int, bool, array types, pair
      String exprString = expr.getIdentifier().toString();
      if (!(exprString.equals("string") || exprString.equals("char") || exprString.equals("int")
              || exprString.equals("bool") || exprString.contains("pair")
              || exprString.contains("[]"))) {
        System.out.println("The type of argument can only be of type 'string' 'char' 'int' " +
                "'bool' 'array types' 'pair'." );
        new TypeError(new FilePosition(ctx)).printAll();
        return false;
      }
      return true;
    } else if (statName.equals("PRINTLN")) {
      //expression inside print can only be of type string, char, int, bool, array types, pair
      String exprString = expr.getIdentifier().toString();
      if (!(exprString.equals("string") || exprString.equals("char") || exprString.equals("int")
              || exprString.equals("bool") || exprString.contains("pair")
              || exprString.contains("[]"))) {
        System.out.println("The type of argument can only be of type 'string' 'char' 'int' " +
                "'bool' 'array types' 'pair'." );
        new TypeError(new FilePosition(ctx)).printAll();
        return false;
      }
      return true;
    }
    new TypeError(new FilePosition(ctx)).printAll();
    return false;
  }

  /**
   * Called from visitor
   *
   * @param ST
   */
  @Override
  public void Check(SymbolTable ST) {
    //CheckSemantics(ST))
    //Do symbol table stuff
  }

  /**
   * Used for testing - Prints out contents of current AST node
   */
  @Override
  public void printContents() {
    System.out.println(this.getClass().getSimpleName() + ": ");
    super.printContents();
    if (expr == null) {
      System.out.println("expr: null");
    } else {
      System.out.println("expr: has content");
    }
  }
}

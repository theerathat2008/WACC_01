package src.ASTNodes.AST_Exprs;

import org.antlr.v4.runtime.ParserRuleContext;
import src.ASTNodes.AST_Node;
import src.ErrorMessages.TypeError;
import src.FilePosition;
import src.SymbolTable.SymbolTable;

import java.util.ArrayDeque;

import src.IdentifierObjects.*;

/**
 * Class representing node in AST tree for UNARY EXPRESSIONS
 */
public class AST_ExprUnary extends AST_Expr {

  //Syntactic attributes
  String opName;
  AST_Expr astExpr;
  ParserRuleContext ctx;

  /**
   * Constructor for class - initialises class variables to NULL
   */
  public AST_ExprUnary(ParserRuleContext ctx) {
    this.opName = null;
    this.astExpr = null;
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

    //TODO
    // if unaryOp ='!', conditional expression must be of type bool
    if (opName.equals("!")) {
      if (!astExpr.getIdentifier().toString().equals("bool")) {
        System.out.println("Unary operator '!' can only be used when the statement is of type 'bool'.");
        new TypeError(new FilePosition(ctx)).printAll();
        return false;
      }
    }

    //if unaryOp = '-', expression must be of type int
    if (opName.equals("-")) {
      if (!astExpr.getIdentifier().toString().equals("int")) {
        System.out.println("Unary operator '-' can only be used with statement of type 'int'.");
        new TypeError(new FilePosition(ctx)).printAll();
        return false;
      }
    }

    //TODO
    //if unaryOp = 'len', array must be of valid type
    if (opName.equals("len")) {
      System.out.println("The array after the keyword 'len' is with an invalid type");
      new TypeError(new FilePosition(ctx)).printAll();
      return false;
    }

    //if unaryOp = 'ord', statement must be of type char
    if (opName.equals("ord")) {
      if (!astExpr.getIdentifier().toString().equals("char")) {
        System.out.println("The statement after the keyword 'ord' must be of type 'char'.");
        new TypeError(new FilePosition(ctx)).printAll();
        return false;
      }
    }

    if (opName.equals("chr")) {
      if (!astExpr.getIdentifier().toString().equals("int")) {
        System.out.println("The statement after the keyword 'chr' must be of type 'int'.");
        new TypeError(new FilePosition(ctx)).printAll();
        return false;
      }
    }
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
}

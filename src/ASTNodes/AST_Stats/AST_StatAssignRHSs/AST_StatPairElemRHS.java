package src.ASTNodes.AST_Stats.AST_StatAssignRHSs;

import org.antlr.v4.runtime.ParserRuleContext;
import src.ASTNodes.AST_Exprs.AST_Expr;
import src.ASTNodes.AST_Exprs.AST_ExprIdent;
import src.ASTNodes.AST_FuncDecl;
import src.ASTNodes.AST_Node;
import src.ASTNodes.AST_Program;
import src.ErrorMessages.TypeError;
import src.FilePosition;
import src.IdentifierObjects.IDENTIFIER;
import src.SymbolTable.SymbolTable;
import src.VisitorClass.AST_NodeVisitor;
import java.util.ArrayDeque;

/**
 * Class representing node in AST tree for PAIR ASSIGNMENT
 */
public class AST_StatPairElemRHS extends AST_StatAssignRHS {

  //Syntactic attributes
  String typeName;
  AST_Expr ast_expr;
  ParserRuleContext ctx;
  SymbolTable symbolTable;

  /**
   * Constructor for class - initialises class variables to NULL
   */
  public AST_StatPairElemRHS(ParserRuleContext ctx, SymbolTable symbolTable) {
    this.ast_expr = null;
    this.typeName = null;
    this.ctx = ctx;
    this.symbolTable = symbolTable;
  }

  /**
   * Gets all children nodes of current node
   *
   * @return list of AST nodes that are the children of the current node
   */
  @Override
  public ArrayDeque<AST_Node> getNodes() {
    ArrayDeque<AST_Node> returnList = new ArrayDeque<>();
    returnList.addLast(ast_expr);
    return returnList;
  }

  /**
   * Sets syntactic attributes of class variables by assigning it a value
   *
   * @param value - Value to be assigned to class variable
   */
  @Override
  public void setSyntacticAttributes(String value) {
    if (typeName == null) {
      this.typeName = value;
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
    if (strToGet.equals("typeName")) {
      return typeName;
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
    return ast_expr != null;
  }

  /**
   * @param astToGet Shows which child to get from current node
   * @param counter  Shows which child of child to get from current node
   * @return Returns the required child AST Node (determined by the astToGet parameter)
   */
  @Override
  public AST_Node getEmbeddedAST(String astToGet, int counter) {
    if (astToGet.equals("ast_expr")) {
      return ast_expr;
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
      ast_expr = (AST_Expr) nodeToSet;
    } else {
      System.out.println("Unrecognised AST Node at class: " + this.getClass().getSimpleName());
    }
  }

  /**
   * @param ST - Parameter of current symbol table in scope
   * @return - Returns the type of the identifier variable
   */
  public String getType(SymbolTable ST) {
    return ast_expr.getType();
  }

  /**
   * Semantic Analysis and print error message if needed
   *
   */
  @Override
  public boolean CheckSemantics() {

    SymbolTable ST = this.symbolTable;
    AST_Node parent = getParentNode();

    if (ast_expr instanceof AST_ExprIdent) {
      System.out.println("Hey, I'm instance of AST_ExprIdent");
      String varName = ((AST_ExprIdent) ast_expr).getVarName();
      AST_Node tempNode = this.getParentNode();
      IDENTIFIER typeExpr = ST.encSymTable.lookup(varName);
      System.out.println("Enclosed typeExpr: ");
      System.out.println(typeExpr);

      while (!(tempNode instanceof AST_FuncDecl)) {
        if (tempNode instanceof AST_Program) {
          typeExpr = ST.lookup(varName);
          break;
        }
        tempNode = tempNode.getParentNode();
      }
      System.out.println("typeExpr after: ");
      System.out.println(typeExpr);

      if (typeExpr.toString().equals("int") || typeExpr.toString().equals("bool")
              || typeExpr.toString().equals("char") || typeExpr.toString().contains("PAIR") || typeExpr.toString().contains("str")) {
        return true;
      } else {
        new TypeError((new FilePosition(ctx))).printAll();
        return false;
      }

    }
    //check for valid pair elem types
    if (!(typeName.equals("int") || typeName.equals("bool") || typeName.equals("char") ||
            typeName.contains("PAIR") || typeName.contains("str"))) {
      System.out.println("Invalid type for pair elem.");
      new TypeError(new FilePosition(ctx)).printAll();
      return false;
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
    if (CheckSemantics()) {
      //Do symbol table stuff
    }
  }

  /**
   * Used for testing - Prints out contents of current AST node
   */
  @Override
  public void printContents() {
    System.out.println(this.getClass().getSimpleName() + ": ");
    System.out.println("typeName: " + typeName);
    if (ast_expr == null) {
      System.out.println("ast_expr: null");
    } else {
      System.out.println("ast_expr: has content");
    }
  }
  public void accept(AST_NodeVisitor visitor) {
    visitor.visit(this);
    ast_expr.accept(visitor);
  }
}

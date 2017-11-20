package src.ASTNodes.AST_Exprs;

import org.antlr.v4.runtime.ParserRuleContext;
import src.ASTNodes.AST_FuncDecl;
import src.ASTNodes.AST_Node;
import src.ASTNodes.AST_Program;
import src.ErrorMessages.TypeError;
import src.ErrorMessages.TypeMismatchError;
import src.FilePosition;
import src.SymbolTable.SymbolTable;
import src.VisitorClass.AST_NodeVisitor;
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
  SymbolTable symbolTable;

  /**
   * Constructor for class - initialises class variables to NULL
   */
  public AST_ExprUnary(ParserRuleContext ctx, SymbolTable symbolTable) {
    this.opName = null;
    this.astExpr = null;
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
   */
  @Override
  public boolean CheckSemantics() {

    //TODO
    // if unaryOp ='!', conditional expression must be of type bool

    SymbolTable ST = this.symbolTable;

    /*if (opName.equals("!")) {
      //TODO astExpr has null value --> fix
      if (!astExpr.getIdentifier().toString().equals("bool")) {
        System.out.println("Unary operator '!' can only be used when the statement is of type 'bool'.");
        new TypeError(new FilePosition(ctx)).printAll();
        return false;
      } else {
        return true;
      }
    }*/
    if (opName.equals("!")) {
      if (astExpr instanceof AST_ExprEnclosed) {
        return true;
      } else if (astExpr instanceof AST_ExprIdent) {
        //SymbolTable ST = this.symbolTable;
        System.out.println(astExpr);
        astExpr.printContents();
        String varName = ((AST_ExprIdent) astExpr).getVarName();
        IDENTIFIER type = ST.lookup(varName);

        AST_Node parent = getParentNode();
        //if parent is instance of AST_FuncDecl, search in encSymTable instead
        if (parent instanceof AST_FuncDecl) {
          type = ST.encSymTable.lookup(varName);
        }
        //Debug statement
        System.out.println(type);
        if (type.toString().equals("bool")) {
          return true;
        } else {
          System.out.println("Unary operator '!' can only be used with statement of type 'bool'.");
          new TypeMismatchError(new FilePosition(ctx)).printAll();
          return false;
        }
      } else {
        new TypeError(new FilePosition(ctx)).printAll();
        return false;
      }
    }

    //if unaryOp = '-', expression must be of type int
    if (opName.equals("-")) {
      if (astExpr instanceof AST_ExprEnclosed) {
        return true;
      } else if (astExpr instanceof AST_ExprIdent) {
        //SymbolTable ST = this.symbolTable;
        System.out.println(astExpr);
        astExpr.printContents();
        String varName = ((AST_ExprIdent) astExpr).getVarName();

        IDENTIFIER type = ST.lookup(varName);

        AST_Node parent = getParentNode();
        //if parent is instance of AST_FuncDecl, search in encSymTable instead
        if (parent instanceof AST_FuncDecl) {
          type = ST.encSymTable.lookup(varName);
        }
        //Debug statement
        System.out.println(type);
        if (type.toString().equals("int")) {
          return true;
        } else {
          System.out.println("Unary operator '-' can only be used with statement of type 'int'.");
          new TypeMismatchError(new FilePosition(ctx)).printAll();
          return false;
        }
      }
    }

    //TODO
    //if unaryOp = 'len', array must be of valid type
    if (opName.equals("len")) {

      if (astExpr instanceof AST_ExprEnclosed) {
        return true;
      } else if (astExpr instanceof AST_ExprIdent) {
        //SymbolTable ST = this.symbolTable;
        System.out.println(astExpr);
        astExpr.printContents();
        String varName = ((AST_ExprIdent) astExpr).getVarName();
        IDENTIFIER type = ST.lookup(varName);

        AST_Node parent = getParentNode();
        //if parent is instance of AST_FuncDecl, search in encSymTable instead
        if (parent instanceof AST_FuncDecl) {
          type = ST.encSymTable.lookup(varName);
        }

        //Debug statement
        System.out.println(type);
        if (type.toString().equals("char") || type.toString().equals("bool") || type.toString().equals("string")
                || type.toString().contains("[]") || type.toString().contains("pair")) {
          return true;
        } else {
          System.out.println("Unary operator 'len' can only be used with statement of type 'char' 'bool'" +
                  "'string' 'array' 'pair'.");
          new TypeError(new FilePosition(ctx)).printAll();
          return false;
        }
      } else {
        new TypeError(new FilePosition(ctx)).printAll();
        return false;
      }
    }

    //if unaryOp = 'ord', statement must be of type char
    if (opName.equals("ord")) {

      //Debug statement
      System.out.println("hi");
      System.out.println(astExpr.getIdentifier());

      if (astExpr instanceof AST_ExprEnclosed) {
        return true;
      } else if (astExpr instanceof AST_ExprIdent) {
        //SymbolTable ST = this.symbolTable;
        System.out.println(astExpr);
        astExpr.printContents();

        System.out.println(astExpr.getIdentifier());
        String varName = ((AST_ExprIdent) astExpr).getVarName();

        IDENTIFIER type = ST.lookup(varName);

        AST_Node parent = getParentNode();
        //if parent is instance of AST_FuncDecl, search in encSymTable instead
        if (parent instanceof AST_FuncDecl) {
          type = ST.encSymTable.lookup(varName);
        }

        System.out.println(varName);
        System.out.println(type);

        //Debug statement
        System.out.println(type);
        if (type.toString().equals("char")) {
          return true;
        } else {
          System.out.println("Unary operator 'ord' can only be used with statement of type 'char'.");
          new TypeError(new FilePosition(ctx)).printAll();
          return false;
        }
      } else if (astExpr.getIdentifier().toString().equals("char")) {
        return true;
      } else {
        new TypeError(new FilePosition(ctx)).printAll();
        return false;
      }
    }

    if (opName.equals("chr")) {

      if (astExpr instanceof AST_ExprEnclosed) {
        return true;
      } else if (astExpr instanceof AST_ExprIdent) {
        //SymbolTable ST = this.symbolTable;
        System.out.println(astExpr.getIdentifier());
        astExpr.printContents();
        String varName = ((AST_ExprIdent) astExpr).getVarName();
        System.out.println(varName);

        /*AST_Node parent = getParentNode();
        System.out.println(parent);
        IDENTIFIER type;
        if (parent instanceof AST_Program) {
          type = ST.encSymTable.lookup(varName);
        } else {
          type = ST.lookup(varName);
        }*/

        //TODO check if enclose
        //encSymTable because it is enclosed for asciiTable.wacc
        System.out.println(astExpr);
        IDENTIFIER type = ST.lookup(varName);

        AST_Node parent = getParentNode();
        //if parent is instance of AST_FuncDecl, search in encSymTable instead
        if (parent instanceof AST_FuncDecl) {
          type = ST.encSymTable.lookup(varName);
        }

        //Debug statement
        System.out.println(type);
        if (type.toString().equals("int")) {
          return true;
        } else {
          System.out.println("Unary operator 'chr' can only be used with statement of type 'int'.");
          new TypeMismatchError(new FilePosition(ctx)).printAll();
          return false;
        }
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
    if (CheckSemantics()) {
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
      //Debug statement
      System.out.println(astExpr);
    }
  }

  public void accept(AST_NodeVisitor visitor) {
    visitor.visit(this);
    astExpr.accept(visitor);
  }
}

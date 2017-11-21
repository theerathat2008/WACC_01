package ASTNodes.AST_Stats;

import ASTNodes.AST_Exprs.*;
import ASTNodes.AST_FuncDecl;
import ASTNodes.AST_Node;
import ASTNodes.AST_Program;
import IdentifierObjects.IDENTIFIER;
import InstructionSet.Instruction;
import Registers.RegisterAllocation;
import SymbolTable.SymbolTable;
import ErrorMessages.TypeError;
import ErrorMessages.TypeMismatchError;

import src.FilePosition;
import org.antlr.v4.runtime.ParserRuleContext;
import VisitorClass.AST_NodeVisitor;

import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.List;

public class AST_StatExpr extends AST_Stat {

  //Syntactic attributes
  AST_Expr expr;
  ParserRuleContext ctx;
  SymbolTable symbolTable;
  /**
   * Assign the class variables when called
   *
   * @param ctx
   */
  public AST_StatExpr(ParserRuleContext ctx, SymbolTable symbolTable) {
    this.expr = null;
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
   */
  @Override
  public boolean CheckSemantics() {
    SymbolTable ST = this.symbolTable;
    AST_Node parent = getParentNode();

    if (statName.equals("free")) {
      System.out.println(expr);
      System.out.println(expr.getIdentifier());
      if (expr instanceof AST_ExprIdent) {
        String varName = ((AST_ExprIdent) expr).getVarName();
        AST_Node tempNode = this.getParentNode();
        IDENTIFIER typeExpr = ST.encSymTable.lookup(varName);

        while (!(tempNode instanceof AST_FuncDecl)) {
          if (tempNode instanceof AST_Program) {
            typeExpr = ST.lookup(varName);
            break;
          }
          tempNode = tempNode.getParentNode();
        }
        if (ST.lookup(varName) == null) {
          typeExpr = ST.encSymTable.lookup(varName);
        }
        System.out.println("The typeExpr is: ");
        System.out.println(typeExpr);
        if (typeExpr.toString().contains("PAIR") || typeExpr.toString().contains("[]")) {
          return true;
        } else {
          new TypeError(new FilePosition(ctx)).printAll();
          return false;
        }
      } else {
        if (expr.getIdentifier().toString().contains("[]") || expr.getIdentifier().toString().contains("PAIR")) {
          return true;
        } else {
          new TypeError(new FilePosition(ctx)).printAll();
          return false;
        }
      }

    } else if (statName.equals("return")) {


      //search until find function declaration
      while (!(parent instanceof AST_FuncDecl)) {
        if (parent instanceof AST_Program) {
          System.out.println("Return statement not inside of a function.");
          new TypeError(new FilePosition(ctx)).printAll();
          return false;
        }

        parent = parent.getParentNode();

        System.out.println("Going to AST parent, looking for function");
      }

      //check if the return type is the same type as function type
      AST_FuncDecl temp = (AST_FuncDecl) parent;

      if (expr instanceof AST_ExprIdent) {
        String varName = ((AST_ExprIdent) expr).getVarName();
        AST_Node tempNode = this.getParentNode();
        IDENTIFIER typeExpr = ST.encSymTable.lookup(varName);

        while (!(tempNode instanceof AST_FuncDecl)) {
          if (tempNode instanceof AST_Program) {
            typeExpr = ST.lookup(varName);
            break;
          }
          tempNode = tempNode.getParentNode();
        }
        if (temp.ast_type.getIdentifier().equals(typeExpr)) {
          return true;
        } else {
          new TypeMismatchError(new FilePosition(ctx)).printAll();
          return false;
        }
      }

      //debug message
      System.out.println(temp.ast_type.getIdentifier().toString());
      if (expr.getIdentifier() == null) {
        System.out.println("null");
        System.out.println(expr.getType());
      }

      /* TODO expr has null value */
      if (expr instanceof AST_ExprEnclosed || expr instanceof AST_ExprBinary
              || expr instanceof AST_ExprUnary) {
        return true;
      } else if ((temp.ast_type.getIdentifier().equals(expr.getIdentifier()))) {
        return true;
      } else {
        new TypeMismatchError(new FilePosition(ctx)).printAll();
        return false;
      }
    } else if (statName.equals("exit")) {
      //Debug statement
      System.out.println(expr);
      if (expr instanceof AST_ExprUnary || expr instanceof AST_ExprEnclosed) {
        if (expr.getIdentifier().toString().equals("int")) {
          return true;
        } else {
          System.out.println("Expression after exit statement must be of type int.");
          new TypeError(new FilePosition(ctx)).printAll();
          return false;
        }
      } else if (expr instanceof AST_ExprIdent) {
        System.out.println(expr);
        expr.printContents();
        String varName = ((AST_ExprIdent) expr).getVarName();

        AST_Node tempNode = this.getParentNode();
        IDENTIFIER type = ST.encSymTable.lookup(varName);

        while (!(tempNode instanceof AST_FuncDecl)) {
          if (tempNode instanceof AST_Program) {
            type = ST.lookup(varName);
            break;
          }
          tempNode = tempNode.getParentNode();
        }
        //Debug statement
        System.out.println(type);
        if (type.toString().equals("int")) {
          return true;
        } else {
          new TypeMismatchError(new FilePosition(ctx)).printAll();
          return false;
        }
      } else {
        return true;
      }
    } else if (statName.equals("print")) {
      return true;
    } else if (statName.equals("println")) {
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

  public void accept(AST_NodeVisitor visitor) {
    visitor.visit(this);
    expr.accept(visitor);
  }

  public void genInstruction(List<Instruction> instructionList, RegisterAllocation registerAllocation) throws Exception {

  }
}

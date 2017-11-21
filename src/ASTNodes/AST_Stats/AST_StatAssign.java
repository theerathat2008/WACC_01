package ASTNodes.AST_Stats;

import ASTNodes.AST_Node;
import ASTNodes.AST_Stats.AST_StatAssignLHSs.AST_StatAssignLHS;
import ASTNodes.AST_Stats.AST_StatAssignRHSs.AST_StatAssignRHS;
import InstructionSet.Instruction;
import Registers.RegisterAllocation;
import SymbolTable.SymbolTable;
import ErrorMessages.TypeMismatchError;
import src.FilePosition;
import org.antlr.v4.runtime.ParserRuleContext;
import src.VisitorClass.AST_NodeVisitor;
import java.util.ArrayDeque;
import java.util.List;

/**
 * Class representing node in AST tree for ASSIGNMENT STATEMENTS
 */
public class AST_StatAssign extends AST_Stat {
  //Syntactic attributes
  AST_StatAssignLHS ast_statAssignLHS;
  AST_StatAssignRHS ast_statAssignRHS;
  ParserRuleContext ctx;
  SymbolTable symbolTable;

  /**
   * Constructor for class - initialises class variables to NULL
   */
  public AST_StatAssign(ParserRuleContext ctx, SymbolTable symbolTable) {
    this.ast_statAssignLHS = null;
    this.ast_statAssignRHS = null;
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
    returnList.addLast(ast_statAssignLHS);
    returnList.addLast(ast_statAssignRHS);
    return returnList;
  }

  /**
   * Returns true if the embedded Nodes have value
   */
  @Override
  public boolean isEmbeddedNodesFull() {
    return ast_statAssignLHS != null && ast_statAssignRHS != null;
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
   * @param astToGet Shows which child to get from current node
   * @param counter  Shows which child of child to get from current node
   * @return Returns the required child AST Node (determined by the astToGet parameter)
   */
  @Override
  public AST_Node getEmbeddedAST(String astToGet, int counter) {
    if (astToGet.equals("ast_statAssignLHS")) {
      return ast_statAssignLHS;
    } else if (astToGet.equals("ast_statAssignRHS")) {
      return ast_statAssignRHS;
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
    if (astToSet.equals("ast_statAssignLHS")) {
      ast_statAssignLHS = (AST_StatAssignLHS) nodeToSet;
    }
    if (astToSet.equals("statAssignRHS")) {
      ast_statAssignRHS = (AST_StatAssignRHS) nodeToSet;
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

    System.out.println("checking semantic of assign statement");
    System.out.println(ast_statAssignLHS.toString());
    System.out.println(ast_statAssignRHS.toString());
    System.out.println("LHS identifier is: " + ast_statAssignLHS.getIdentifier());
    System.out.println("RHS identifier is: " + ast_statAssignRHS.getIdentifier());

    IDENTIFIER typeLHS = null;
    IDENTIFIER typeRHS = null;

    if (ast_statAssignLHS instanceof AST_StatArrayElemLHS) {
      System.out.println("I'm instance of AST_StatArrayElemLHS");
      //check the size of the array if it contains any element inside
      if (((AST_StatArrayElemLHS) ast_statAssignLHS).getAst_exprList().size() != 0) {
        System.out.println("I'm inside if statement");
        System.out.println(((AST_StatArrayElemLHS) ast_statAssignLHS).getAst_exprList().get(0));
        AST_Expr firstElem = ((AST_StatArrayElemLHS) ast_statAssignLHS).getAst_exprList().get(0);

        //check if it is instace of AST_ExprIdent if it is an ident
        if (firstElem instanceof AST_ExprEnclosed) {
          return true;
        } else if (firstElem instanceof AST_ExprIdent) {
          String varName = ((AST_ExprIdent) firstElem).getVarName();
          System.out.println(varName);
          typeLHS = ST.encSymTable.lookup(varName);
          System.out.println(typeLHS);
        } else {
          typeLHS = ast_statAssignLHS.getIdentifier();
        }
      } else {
        typeLHS = ast_statAssignLHS.getIdentifier();
      }


      System.out.println("ast_statAssignRHS");
      if (ast_statAssignRHS instanceof AST_StatExprRHS) {
        AST_Expr ast_expr = ((AST_StatExprRHS) ast_statAssignRHS).getAst_expr();

        if (ast_expr instanceof AST_ExprIdent) {
          System.out.println("RHS is instance of AST_ExprIdent");
          String varName = ((AST_ExprIdent) ast_expr).getVarName();
          System.out.println(varName);
          typeRHS = ST.encSymTable.lookup(varName);
          System.out.println(typeRHS);
        } else {
          typeRHS = ast_statAssignRHS.getIdentifier();
        }
      } else {
        typeRHS  =ast_statAssignRHS.getIdentifier();
      }

      //TODO implement general cases for typeLHS and typeRHS

    } else {
      typeLHS = ast_statAssignLHS.getIdentifier();
      typeRHS = ast_statAssignRHS.getIdentifier();
    }

    if (typeLHS.toString().contains(typeRHS.toString()) || typeRHS.toString().contains(typeLHS.toString())) {
      return true;
    } else {
      new TypeMismatchError(new FilePosition(ctx)).printAll();
      return false;
    }

    /*String identifierLHS = ast_statAssignLHS.getIdentifier().toString();
    String identifierRHS = ast_statAssignRHS.getIdentifier().toString();

    if (identifierLHS.contains(identifierRHS) || identifierRHS.contains(identifierLHS)) {
      return true;
    } else {
      new TypeMismatchError(new FilePosition(ctx)).printAll();
      return false;
    }*/
  }

  /**
   * Called from visitor
   *
   * @param ST
   */
  @Override
  public void Check(SymbolTable ST) {
    CheckSemantics();
  }

  /**
   * Used for testing - Prints out contents of current AST node
   */
  @Override
  public void printContents() {
    System.out.println(this.getClass().getSimpleName() + ": ");
    if (ast_statAssignLHS == null) {
      System.out.println("ast_statAssignLHS: null");
    } else {
      System.out.println("ast_statAssignLHS: has content");
    }
    if (ast_statAssignRHS == null) {
      System.out.println("ast_statAssignRHS: null");
    } else {
      System.out.println("ast_statAssignRHS: has content");
      ast_statAssignRHS.printContents();
    }
  }

  public void accept(AST_NodeVisitor visitor) {
    visitor.visit(this);
    ast_statAssignLHS.accept(visitor);
    ast_statAssignRHS.accept(visitor);
  }

  public void genInstruction(List<Instruction> instructionList, RegisterAllocation registerAllocation) throws Exception {

  }
}

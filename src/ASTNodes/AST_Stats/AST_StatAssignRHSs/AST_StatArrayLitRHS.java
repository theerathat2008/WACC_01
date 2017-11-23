package ASTNodes.AST_Stats.AST_StatAssignRHSs;

import InstructionSet.Instruction;
import Registers.RegisterAllocation;
import org.antlr.v4.runtime.ParserRuleContext;
import ASTNodes.AST_Exprs.AST_Expr;
import ASTNodes.AST_Node;
import ErrorMessages.TypeMismatchError;
import src.FilePosition;
import SymbolTable.SymbolTable;
import VisitorClass.AST_NodeVisitor;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import IdentifierObjects.*;

/**
 * Class representing node in AST tree for ARRAY LITERAL ASSIGNMENT
 */
public class AST_StatArrayLitRHS extends AST_StatAssignRHS {

  //Syntactic attributes
  List<AST_Expr> ast_exprList;
  int numOfExpr;
  String type;
  ParserRuleContext ctx;

  /**
   * Constructor for class - initialises class variables
   *
   * @param numberOfChildren - Shows the number of parameters in the parameter list of function
   */
  public AST_StatArrayLitRHS(int numberOfChildren, ParserRuleContext ctx) {
    ast_exprList = new ArrayList<>();
    if (numberOfChildren == 2) {
      this.numOfExpr = 0;
    } else {
      this.numOfExpr = (numberOfChildren - 1) / 2;
    }
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
    for (AST_Expr expr : ast_exprList) {
      returnList.addLast(expr);
    }
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
    return ast_exprList.size() == numOfExpr;
  }

  /**
   * @param astToGet Shows which child to get from current node
   * @param counter  Shows which child of child to get from current node
   * @return Returns the required child AST Node (determined by the astToGet parameter)
   */
  @Override
  public AST_Node getEmbeddedAST(String astToGet, int counter) {
    if (astToGet.equals("ast_exprList")) {
      return ast_exprList.get(counter);
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
      ast_exprList.add((AST_Expr) nodeToSet);
      if (ast_exprList.size() == 1) {
        identifier = new ArrayObj(ast_exprList.get(0).getIdentifier());
        System.out.println(identifier);
      }
    } else {
      System.out.println("Unrecognised AST Node at class: " + this.getClass().getSimpleName());
    }
  }

  public String getTypeOfArray(){
    if (ast_exprList.size() > 0) {
      return ast_exprList.get(0).getType();
    }
    return "EMPTY ARRAY IN GETTYPEOFARRAY STATARRAYLITRHS";

  }

  /**
   * @param ST - Parameter of current symbol table in scope
   * @return - Returns the type of the identifier variable
   */
  public String getType(SymbolTable ST) {
    return ast_exprList.get(0).toString() + "[]";
  }

  /**
   * Semantic Analysis and print error message if needed
   *
   */
  @Override
  public boolean CheckSemantics() {

    //Debug statement
    System.out.println(ast_exprList);
    System.out.println(numOfExpr);
    System.out.println(type);

    //empty array is always true
    if (ast_exprList == null) {
      return true;
    } else if (numOfExpr == 0 || numOfExpr == 1) {
      return true;
    } else {
      //get type of the first index in the array
      AST_Expr firstElem = ast_exprList.get(0);
      System.out.println(firstElem);

      //check if every elements in the array has the same type
      /*for (AST_Expr exprList : ast_exprList) {
        System.out.println(exprList);
        System.out.println(firstElem);
        if (!exprList.equals(firstElem)) {
          new TypeMismatchError(new FilePosition(ctx)).printAll();
          return false;
        }
      }*/
      System.out.println(ast_exprList.get(1));
      for (int i = 1; i < numOfExpr; i++) {
        System.out.println("I'm inside the for loop");
        System.out.println(ast_exprList.get(i));
        if ((ast_exprList.get(i).toString()).contains(firstElem.toString()) || firstElem.toString().contains(ast_exprList.get(i).toString())) {
          System.out.println("Same type");
        } else {
          new TypeMismatchError(new FilePosition(ctx)).printAll();
          return false;
        }
      }
      return true;
    }
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
    System.out.println("numOfExpr: " + numOfExpr);
    if (ast_exprList.size() == numOfExpr) {
      System.out.println("ast_exprList: List full");
    } else {
      System.out.println("ast_exprList has size: " + ast_exprList.size());
    }
  }


  public void accept(AST_NodeVisitor visitor) {
    visitor.visit(this);
    for(AST_Expr expr : ast_exprList){
      expr.accept(visitor);
    }
  }

  @Override
  public void acceptInstr(List<String> assemblyCode) {

  }

  public void genInstruction(List<Instruction> instructionList, RegisterAllocation registerAllocation) throws Exception {

  }

}

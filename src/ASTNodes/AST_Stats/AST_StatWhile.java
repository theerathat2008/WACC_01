package ASTNodes.AST_Stats;


import ASTNodes.AST_Exprs.AST_ExprIdent;
import IdentifierObjects.IDENTIFIER;
import InstructionSet.Instruction;
import InstructionSet.InstructionWhile;
import Registers.RegisterAllocation;
import org.antlr.v4.runtime.ParserRuleContext;
import ASTNodes.AST_Exprs.AST_Expr;
import ASTNodes.AST_Node;
import ErrorMessages.TypeError;
import src.FilePosition;
import SymbolTable.SymbolTable;
import VisitorClass.AST_NodeVisitor;

import java.util.ArrayDeque;
import java.util.List;

public class AST_StatWhile extends AST_Stat {

  //Syntactic attributes
  AST_Expr exprAST;
  AST_Stat statAST;
  public SymbolTable symbolTable;
  //Semantic attribute
  ParserRuleContext ctx;

  /**
   * Assign the class variables when called
   */

  public AST_StatWhile(SymbolTable ST) {
    this.exprAST = null;
    this.statAST = null;
    symbolTable = new SymbolTable("while");
    ST.childTables.add(symbolTable);
    symbolTable.setEncSymTable(ST);

  }

  /**
   * Gets all children nodes of current node
   *
   * @return list of AST nodes that are the children of the current node
   */
  @Override
  public ArrayDeque<AST_Node> getNodes() {
    ArrayDeque<AST_Node> returnList = new ArrayDeque<>();
    returnList.addLast(exprAST);
    returnList.addLast(statAST);
    return returnList;
  }

  /**
   * Returns true if the embedded Nodes have value
   */
  @Override
  public boolean isEmbeddedNodesFull() {
    return exprAST != null && statAST != null;
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
    if (astToGet.equals("expr")) {
      return exprAST;
    } else if (astToGet.equals("statAST")) {
      return statAST;
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
      exprAST = (AST_Expr) nodeToSet;
    } else if (astToSet.equals("statement")) {
      statAST = (AST_Stat) nodeToSet;
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
    //get type for the expression inside the while statement (while(....0) must be of type bool
    if (exprAST instanceof AST_ExprIdent) {
      System.out.println("I'm instance of AST_ExprLiter");
      String varName = ((AST_ExprIdent)exprAST).getVarName();
      SymbolTable tempST = this.symbolTable;
      IDENTIFIER type = tempST.lookup(varName);

      while (type == null) {
        System.out.println("type is null");
        tempST = tempST.encSymTable;
        type = tempST.lookup(varName);
      }

      if (type.toString().contains("bool")) {
        return true;
      } else {
        new TypeError(new FilePosition(ctx)).printAll();
        return false;
      }

    }

    String condition = exprAST.getIdentifier().toString();

    if (!(condition.equals("bool"))) {
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
    if (exprAST == null) {
      System.out.println("exprAST: null");
    } else {
      System.out.println("exprAST: has content");
    }
    if (statAST == null) {
      System.out.println("statAST: null");
    } else {
      System.out.println("statAST: has content");
    }
    symbolTable.printKeysTable(symbolTable);
  }

  public void accept(AST_NodeVisitor visitor) {
    visitor.visit(this);
    exprAST.accept(visitor);
    statAST.accept(visitor);
  }


  /**
   * Generates instruction while which requires one register which holds the result of the expression evalutation
   */

  public void genInstruction(List<Instruction> instructionList, RegisterAllocation registerAllocation) throws Exception {
    InstructionWhile instructionWhile = new InstructionWhile();
    //Allocate registers for exprReg
    instructionList.add(instructionWhile);

  }
}

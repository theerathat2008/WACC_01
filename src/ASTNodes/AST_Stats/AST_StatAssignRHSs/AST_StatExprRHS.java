package ASTNodes.AST_Stats.AST_StatAssignRHSs;

import ASTNodes.AST_Exprs.AST_Expr;
import ASTNodes.AST_Node;
import IdentifierObjects.IDENTIFIER;
import InstructionSet.Instruction;
import InstructionSet.InstructionDeclOrAss.*;
import InstructionSet.InstructionDeclOrAss.InstructionDeclAssArray.InstructionDeclAssArrayBool;
import InstructionSet.InstructionDeclOrAss.InstructionDeclAssArray.InstructionDeclAssArrayChar;
import InstructionSet.InstructionDeclOrAss.InstructionDeclAssArray.InstructionDeclAssArrayInt;
import InstructionSet.InstructionDeclOrAss.InstructionDeclAssArray.InstructionDeclAssArrayString;
import Registers.RegisterAllocation;
import SymbolTable.SymbolTable;
import VisitorClass.AST_NodeVisitor;
import java.util.ArrayDeque;
import java.util.List;

/**
 * Class representing node in AST tree for EXPRESSION ASSIGNMENT
 */
public class AST_StatExprRHS extends AST_StatAssignRHS {

  //Syntactic attributes
  AST_Expr ast_expr;

  /**
   * Constructor for class - initialises class variables to NULL
   */
  public AST_StatExprRHS() {
    this.ast_expr = null;
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
   * Semantic Analysis and print error message if needed
   *
   */
  @Override
  public boolean CheckSemantics() {
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
      System.out.println(ast_expr.getIdentifier());
      identifier = ast_expr.getIdentifier();
    }
  }

  /**
   * Used for testing - Prints out contents of current AST node
   */
  @Override
  public void printContents() {
    System.out.println(this.getClass().getSimpleName() + ": ");
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

  @Override
  public void acceptInstr(List<String> assemblyCode) {

  }

  @Override
  public void acceptRegister(RegisterAllocation registerAllocation) throws Exception {

  }

  public void genInstruction(List<Instruction> instructionList, RegisterAllocation registerAllocation) throws Exception {

    String type = ast_expr.getType();

    switch (type) {
      case ("int"):
        InstructionDeclAssInt instructionDeclAssInt = new InstructionDeclAssInt();
        instructionList.add(instructionDeclAssInt);
        break;
      case ("string"):
        InstructionDeclAssString instructionDeclAssString = new InstructionDeclAssString();//registerAllocation.getStringID(GETTHEDATA));
        instructionList.add(instructionDeclAssString);
        break;
      case ("char"):
        InstructionDeclAssChar instructionDeclAssChar = new InstructionDeclAssChar();
        instructionList.add(instructionDeclAssChar);
        break;
      case ("pair"):
        //TODO find arguments for below line
        //InstructionDeclAssPair instructionDeclAssPair = new InstructionDeclAssPair();//GETTHEDATA.TYPE, GETTHEDATA.TYPE, GETTHEDATA, GETTHEDATA);
        //instructionList.add(instructionDeclAssPair);
        break;
      case ("bool"):
        InstructionDeclAssBool instructionDeclAssBool = new InstructionDeclAssBool();
        instructionList.add(instructionDeclAssBool);
        break;

      case ("array"):
        System.out.println("TODO implement array statexprrhs");
       // type = ((AST_StatArrayLitRHS) ast_assignRHS).getTypeOfArray();
/*
        switch (type) {
          case ("int"):
            InstructionDeclAssArrayInt instructionDeclAssArrayInt
                    = new InstructionDeclAssArrayInt();
            instructionList.add(instructionDeclAssArrayInt);
            break;

          case ("string"):
            InstructionDeclAssArrayString instructionDeclAssArrayString
                    = new InstructionDeclAssArrayString(GETDATA, MSGSLIST);
            instructionList.add(instructionDeclAssArrayString);
            //TODO MESSAGES!


          case ("char"):
            InstructionDeclAssArrayChar instructionDeclAssArrayChar
                    = new InstructionDeclAssArrayChar(GETDATA);
            instructionList.add(instructionDeclAssArrayChar);
            break;

          case ("bool"):
            InstructionDeclAssArrayBool instructionDeclAssArrayBool
                    = new InstructionDeclAssArrayBool(GETDATA);
            instructionList.add(instructionDeclAssArrayBool);
            break;

          default:
            break;
        }*/

    }


  }


  public IDENTIFIER getIdentifier() {
    return ast_expr.getIdentifier();
  }

  public AST_Expr getAst_expr() {
    return ast_expr;
  }
}

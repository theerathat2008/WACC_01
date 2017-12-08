package ASTNodes.AST_Stats.AST_StatAssignRHSs;

import ASTNodes.AST_Exprs.AST_Expr;
import ASTNodes.AST_Node;
import IdentifierObjects.IDENTIFIER;
import InstructionSet.Instruction;
import InstructionSet.InstructionDeclOrAss.*;
import Registers.RegisterARM;
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
   * @param value - Value to be assigned to class variable
   */
  @Override
  public void setSyntacticAttributes(String value) {
    System.out.println("No String Syntactic Attributes in class: " + this.getClass().getSimpleName());
  }

  /**
   * Gets syntactic attributes of class variables
   * @param strToGet - Value to be retrieved from class variable
   */
  @Override
  public String getSyntacticAttributes(String strToGet) {
    System.out.println("No String Syntactic Attributes in class: " + this.getClass().getSimpleName());
    return null;
  }

  /**
   * @return returns the identifier of the attribute
   */
  public IDENTIFIER getIdentifier() {
    return ast_expr.getIdentifier();
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
    if (astToSet.equals("expr") || astToSet.equals("sideEffect")) {
      ast_expr = (AST_Expr) nodeToSet;

    } else {
      System.out.println("Unrecognised AST Node at class: " + this.getClass().getSimpleName());
    }
  }

  /**
   * Semantic Analysis and print error message if needed
   */
  @Override
  public boolean CheckSemantics() {
    return true;
  }

  /**
   * Called from visitor
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

  /**
   * Used to flag special cases where the register needs a stack implementation before the backend parse
   * @param regAlloc
   */
  @Override
  public void acceptPreProcess(RegisterAllocation regAlloc) {
    ast_expr.acceptPreProcess(regAlloc);
  }

  /**
   * Part of the visitor code gen pattern, used to generate the instruction classes
   * which are added to the instruction list
   * @param visitor
   */
  public void accept(AST_NodeVisitor visitor) {
    visitor.visit(this);
    ast_expr.accept(visitor);
  }

  /**
   * Function that is iterates through the ast_nodes and adds the instruction blocks
   * in the right order to the assembly code list
   * @param assemblyCode
   */
  @Override
  public void acceptInstr(List<String> assemblyCode) {
    ast_expr.acceptInstr(assemblyCode);
  }

  /**
   * Want to store the evaluation of the two registers result of the binary expression
   * Format is expr BinOp expr
   * Store the returned result of the two expr into a result reg
   * Free the two registers after having got the evaluation of the two stores in the regs
   */
  @Override
  public RegisterARM acceptRegister(RegisterAllocation registerAllocation) throws Exception {
    return ast_expr.acceptRegister(registerAllocation);
  }

  /**
   * takes the embeded information corresponding to the specific instruction class and generates blocks
   * of assembly code for that instruction class
   * The embeded information is mainly the registers which is allocated using registerAllocation.
   * @param instructionList
   * @param registerAllocation
   * @throws Exception
   */
  public void genInstruction(List<Instruction> instructionList, RegisterAllocation registerAllocation) throws Exception {

    String type = ast_expr.getType();

    if (type != null) {
      switch (type) {
        case ("int"):
          InstructionDeclAssInt instructionDeclAssInt = new InstructionDeclAssInt();
          instructionList.add(instructionDeclAssInt);
          break;
        case ("string"):
          InstructionDeclAssString instructionDeclAssString = new InstructionDeclAssString();
          instructionList.add(instructionDeclAssString);
          break;
        case ("char"):
          InstructionDeclAssChar instructionDeclAssChar = new InstructionDeclAssChar();
          instructionList.add(instructionDeclAssChar);
          break;
        case ("pair"):
          break;
        case ("bool"):
          InstructionDeclAssBool instructionDeclAssBool = new InstructionDeclAssBool();
          instructionList.add(instructionDeclAssBool);
          break;

        case ("array"):

      }
    }
  }

  /**
   * @return Return the ast_expr attribute
   */
  public AST_Expr getAst_expr() {
    return ast_expr;
  }
}

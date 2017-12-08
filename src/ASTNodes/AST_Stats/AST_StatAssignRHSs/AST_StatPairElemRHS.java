package ASTNodes.AST_Stats.AST_StatAssignRHSs;

import ASTNodes.AST_Exprs.*;
import InstructionSet.Instruction;
import InstructionSet.InstructionAccessPairElem;
import InstructionSet.InstructionBlocks.InstructionCheck.InstructionCheckNullPointer;
import InstructionSet.InstructionBlocks.InstructionError.InstructionErrorRuntime;
import InstructionSet.InstructionBlocks.InstructionPrintBlocks.InstructionPrintBlocksString;
import Registers.RegisterARM;
import Registers.RegisterAllocation;
import org.antlr.v4.runtime.ParserRuleContext;
import ASTNodes.AST_Node;
import ErrorMessages.TypeError;
import ErrorMessages.FilePosition;
import IdentifierObjects.IDENTIFIER;
import SymbolTable.SymbolTable;
import VisitorClass.AST_NodeVisitor;
import java.util.ArrayDeque;
import java.util.List;

/**
 * Class representing node in AST tree for PAIR ASSIGNMENT
 */
public class AST_StatPairElemRHS extends AST_StatAssignRHS {

  //Syntactic attributes
  String typeName;
  AST_Expr ast_expr;
  ParserRuleContext ctx;
  SymbolTable symbolTable;
  InstructionAccessPairElem instructionAccessPairElem;

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
    if (typeName == null) {
      this.typeName = value;
    } else {
      System.out.println("Unrecognised String Attribute" + this.getClass().getSimpleName());
    }
  }

  /**
   * Gets syntactic attributes of class variables
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
   */
  @Override
  public boolean CheckSemantics() {

    SymbolTable ST = this.symbolTable;
    AST_Node parent = getParentNode();

    if (ast_expr instanceof AST_ExprIdent) {
      String varName = ((AST_ExprIdent) ast_expr).getVarName();
      AST_Node tempNode = this.getParentNode();
      SymbolTable tempST = ST;
      IDENTIFIER typeExpr = tempST.lookup(varName);

      while (typeExpr == null) {
        tempST = tempST.encSymTable;
        typeExpr = tempST.lookup(varName);
      }

      if (typeExpr.toString().equals("int") || typeExpr.toString().equals("bool")
          || typeExpr.toString().equals("char") || typeExpr.toString().contains("PAIR")
          || typeExpr.toString().contains("str")) {
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

  /**
   * Used to flag special cases where the register needs a stack implementation before the backend parse
   * @param regAlloc
   */
  @Override
  public void acceptPreProcess(RegisterAllocation regAlloc) {
    //Set a flag for acceptRegister in statVarDecl using a list in registerallocation to declare the var on the stack
    // since it is used in read and the statpairlemerhs assembly code works with stacks
    AST_ExprIdent tempNode = (AST_ExprIdent)ast_expr;
    regAlloc.addToStackOnlyVar(tempNode.getVarName());

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
   * General case to call acceptNode
   * @param visitor
   */
  public int acceptRootNode(AST_NodeVisitor visitor) {
    visitor.visit(this);

    int result = 0;

    if (ast_expr instanceof AST_ExprLiter) {
      result = ((AST_ExprLiter) ast_expr).acceptNode(visitor);
    } else if (ast_expr instanceof AST_ExprBinary) {
      result = ((AST_ExprBinary) ast_expr).acceptNode(visitor);
    } else if (ast_expr instanceof AST_ExprUnary) {
      result = ((AST_ExprUnary) ast_expr).acceptNode(visitor);
    }

    return result;
  }

  /**
   * Function that is iterates through the ast_nodes and adds the instruction blocks
   * in the right order to the assembly code list
   * @param assemblyCode
   */
  @Override
  public void acceptInstr(List<String> assemblyCode) {

    ast_expr.acceptInstr(assemblyCode);
    assemblyCode.add(instructionAccessPairElem.getResultBlock());
  }

  /**
   * Want to store the evaluation of the two registers result of the binary expression
   * Format is expr BinOp expr
   * Store the returned result of the two expr into a result reg
   * Free the two registers after having got the evaluation of the two stores in the regs
   */
  @Override
  public RegisterARM acceptRegister(RegisterAllocation registerAllocation) throws Exception {

    RegisterARM resultReg = ast_expr.acceptRegister(registerAllocation);

    instructionAccessPairElem.allocateRegisters(RegisterARM.r0, resultReg);
    return resultReg;
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
    instructionAccessPairElem
        = new InstructionAccessPairElem(typeName);
    instructionList.add(instructionAccessPairElem);

    registerAllocation.addString("NullReferenceError: dereference a null reference\\n\\0");
    registerAllocation.addString("%.*s\\0");

    instructionList.add(new InstructionCheckNullPointer(
        registerAllocation.getStringID("NullReferenceError: dereference a null reference\\n\\0")));

    instructionList.add(new InstructionErrorRuntime());
    instructionList.add(new InstructionPrintBlocksString(
        registerAllocation.getStringID("%.*s\\0")
    ));
  }

  /**
   * @return Return the ast_expr attribute
   */
  public AST_Expr getAst_expr() {
    return ast_expr;
  }

  /**
   * @return Return the typeName attribute
   */
  public String getTypeName() {
    return typeName;
  }
}

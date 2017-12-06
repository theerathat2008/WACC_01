package ASTNodes.AST_SideEffect;

import ASTNodes.AST_Exprs.AST_Expr;
import ASTNodes.AST_Node;
import IdentifierObjects.BaseTypeObj;
import InstructionSet.Instruction;
import InstructionSet.InstructionBlocks.InstructionError.InstructionDivByZero;
import InstructionSet.InstructionBlocks.InstructionError.InstructionErrorOverflow;
import InstructionSet.InstructionBlocks.InstructionError.InstructionErrorRuntime;
import InstructionSet.InstructionBlocks.InstructionPrintBlocks.InstructionPrintBlocksString;
import InstructionSet.InstructionSideEffect;
import Registers.RegisterARM;
import Registers.RegisterAllocation;
import SymbolTable.SymbolTable;
import VisitorClass.AST_NodeVisitor;

import java.util.ArrayDeque;
import java.util.List;

public class AST_SideEffectBinary extends AST_SideEffect{

  //Syntactic attributes
  // String type;
  // IDENTIFIER identifier;
  AST_Expr expr;
  InstructionSideEffect instr;
  String op;
  String identName;

  /**
   * Gets all children nodes of current node
   *
   * @return list of AST nodes that are the children of the current node
   */
  @Override
  public ArrayDeque<AST_Node> getNodes() {
    System.out.println("Base AST Node at: " + this.getClass().getSimpleName());
    return null;
  }

  /**
   * Returns true if the embedded Nodes have value
   */
  @Override
  public boolean isEmbeddedNodesFull() {
    return true;
  }

  /**
   * Sets syntactic attributes of class variables by assigning it a value
   *
   * @param value - Value to be assigned to class variable
   */
  @Override
  public void setSyntacticAttributes(String value) {
    //System.out.println("Base AST Node");
    if (op == null) {
      this.op = value;
      System.out.println("Attempting to set identifier to int");
      setIdentifier(new BaseTypeObj(null, "int"));
    } else if (identName == null) {
      this.identName = value;
    } else {
      System.out.println("Error, no more attributes to assign");
    }



  }

  /**
   * Gets syntactic attributes of class variables
   *
   * @param strToGet - Value to be retrieved from class variable
   */
  @Override
  public String getSyntacticAttributes(String strToGet) {
    System.out.println("Base AST Node");
    return null;
  }

  /**
   * @param astToGet Shows which child to get from current node
   * @param counter  Shows which child of child to get from current node
   * @return Returns the required child AST Node (determined by the astToGet parameter)
   */
  @Override
  public AST_Node getEmbeddedAST(String astToGet, int counter) {
    System.out.println("Base AST Node.");
    return null;
  }

  /**
   * @param astToSet  Shows which child to set from current node
   * @param nodeToSet Shows which child of child to set from current node
   */
  @Override
  public void setEmbeddedAST(String astToSet, AST_Node nodeToSet) {
    System.out.println("Embedded node in sideEffectBinary is: " + nodeToSet.toString());
    this.expr = (AST_Expr) nodeToSet;
    System.out.println("Embedded node in sideEffectBinary is: " + expr.toString());
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
   *
   * @param ST
   */
  @Override
  public void Check(SymbolTable ST) {
    if (CheckSemantics()) {
      //Do symbol table stuff
    }
  }



  public String getExprType() {
    //if (this instanceof ASTEXPR)
    return "";
  }


  /**
   * Used for testing - Prints out contents of current AST node
   */
  @Override
  public void printContents() {
    System.out.println(this.getClass().getSimpleName() + ": ");
    System.out.println("BASE TYPE");
  }

  @Override
  public void acceptPreProcess(RegisterAllocation regAlloc) {
    expr.acceptPreProcess(regAlloc);
  }

  public void accept(AST_NodeVisitor visitor) {
    expr.accept(visitor);
    visitor.visit(this);
  }

  @Override
  public void acceptInstr(List<String> assemblyCode) {
    expr.acceptInstr(assemblyCode);
    assemblyCode.add(instr.block1);
  }

  /**
   * x+=5
   * 5 is the result of the evaluation of the embedded expr
   * x should be embedded in this ast class as identName
   */

  @Override
  public RegisterARM acceptRegister(RegisterAllocation registerAllocation) throws Exception {
    //need registers for expr and identifier.
    RegisterARM src = expr.acceptRegister(registerAllocation);
    registerAllocation.freeRegister(src);

    instr.allocateRegisters(registerAllocation.searchByVarValue(identName), src);

    return registerAllocation.searchByVarValue(identName);
  }



  /**
   * Doesn't produce any assembly code
   * Doesn't use any registers
   */


  @Override
  public void genInstruction(List<Instruction> instructionList, RegisterAllocation registerAllocation) throws Exception {
    InstructionSideEffect instructionSideEffect = new InstructionSideEffect(op);
    instr = instructionSideEffect;
    instructionList.add(instructionSideEffect);

    if (op.equals("/")) {
      registerAllocation.addString("DivideByZeroError: divide or modulo by zero\\n\\0");
      InstructionDivByZero divByZero = new InstructionDivByZero();
      divByZero.setOutputMessageNumber(registerAllocation.
              getStringID("DivideByZeroError: divide or modulo by zero\\n\\0"));
      instructionList.add(divByZero);
    } else {
      registerAllocation.addString("OverflowError: the result is too small/large to store in a 4-byte signed-integer.\\n");
      InstructionErrorOverflow errorOverflow = new InstructionErrorOverflow(registerAllocation.
              getStringID("OverflowError: the result is too small/large to store in a 4-byte signed-integer.\\n"));
      instructionList.add(errorOverflow);
    }

    registerAllocation.addString("%.*s\\0");
    InstructionPrintBlocksString instructionPrintString = new InstructionPrintBlocksString(registerAllocation.getStringID("%.*s\\0"));
    instructionList.add(instructionPrintString);

    instructionList.add(new InstructionErrorRuntime());
  }

}

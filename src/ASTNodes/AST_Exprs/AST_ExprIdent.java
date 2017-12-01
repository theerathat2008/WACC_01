package ASTNodes.AST_Exprs;

import ASTNodes.AST_Node;
import InstructionSet.Instruction;
import InstructionSet.InstructionAssignIdent;
import Registers.RegisterARM;
import Registers.RegisterAllocation;
import Registers.RegisterUsage;
import SymbolTable.SymbolTable;
import ErrorMessages.UndefinedIdentError;
import ErrorMessages.FilePosition;
import org.antlr.v4.runtime.ParserRuleContext;
import VisitorClass.AST_NodeVisitor;

import static Registers.RegisterUsageBuilder.*;

import java.util.ArrayDeque;
import java.util.List;

import static java.lang.System.exit;

/**
 * Class representing node in AST tree for IDENT EXPRESSIONS
 */
public class AST_ExprIdent extends AST_Expr {

  //Syntactic attributes
  String varName;
  ParserRuleContext ctx;
  SymbolTable symbolTable;
  InstructionAssignIdent instr;

  /**
   * Constructor for class - initialises class variables to NULL
   */
  public AST_ExprIdent(ParserRuleContext ctx, SymbolTable symbolTable) {
    this.symbolTable = symbolTable;
    this.varName = null;
    this.ctx = ctx;
  }

  /**
   * Gets all children nodes of current node
   *
   * @return list of AST nodes that are the children of the current node
   */
  @Override
  public ArrayDeque<AST_Node> getNodes() {
    System.out.println("Terminal AST Node at: " + this.getClass().getSimpleName());
    return null;
  }

  /**
   * Sets syntactic attributes of class variables by assigning it a value
   *
   * @param value - Value to be assigned to class variable
   */
  @Override
  public void setSyntacticAttributes(String value) {
    if (varName == null) {
      this.varName = value;
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
    if (strToGet.equals("varName")) {
      return varName;
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
    return true;
  }

  /**
   * @param astToGet Shows which child to get from current node
   * @param counter  Shows which child of child to get from current node
   * @return Returns the required child AST Node (determined by the astToGet parameter)
   */
  @Override
  public AST_Node getEmbeddedAST(String astToGet, int counter) {
    System.out.println("Terminal AST Node at: " + this.getClass().getSimpleName());
    return null;
  }

  /**
   * @param astToSet  Shows which child to set from current node
   * @param nodeToSet Shows which child of child to set from current node
   */
  @Override
  public void setEmbeddedAST(String astToSet, AST_Node nodeToSet) {
    System.out.println("Terminal AST Node at: " + this.getClass().getSimpleName());
  }

  /**
   * Semantic Analysis and print error message if needed
   */
  @Override
  public boolean CheckSemantics() {
    SymbolTable ST = this.symbolTable;

    if (ST.lookupAll(varName) != null) {
      setType(ST.lookupAll(varName).toString());
    } else {
      System.out.println("Errors detected during compilation! Exit code 200 returned.");
      System.out.println("#semantic_error#");
      System.out.println("ERROR: Case should be sensitive" + new FilePosition(ctx));
      exit(200);
    }


    if (ST.lookupAll(varName) != null) {
      setType(ST.lookupAll(varName).toString());
      return true;
    } else {
      new UndefinedIdentError(new FilePosition(ctx)).printAll();
      return false;
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
      //ST.add(varName, ST.stringToIdent(varName,type));
      setType(ST.lookupAll(varName).toString());
    }
  }

  /**
   * Used for testing - Prints out contents of current AST node
   */
  @Override
  public void printContents() {
    System.out.println(this.getClass().getSimpleName() + ": ");
    System.out.println("varName: " + varName);
  }

  public String getVarName() {
    return varName;
  }

  public void accept(AST_NodeVisitor visitor) {
    visitor.visit(this);
  }

  @Override
  public void acceptInstr(List<String> assemblyCode) {
    assemblyCode.add(instr.block1);
  }

  /**
   * allocate one register which is the results register
   * another register which takes the stack address of the variables
   */
  @Override
  public RegisterARM acceptRegister(RegisterAllocation registerAllocation) throws Exception {

    RegisterUsage usage = aRegisterUsageBuilder()
        .withScope(registerAllocation.getCurrentScope())
        .withUsageType("exprType")
        .withSubType("resultType")
        .withVarName(varName)
        .build();

    RegisterARM resultReg = registerAllocation.useRegister(usage);

    //Check if varName is allocated on the stack or in a register
    String stackLocation = registerAllocation.getStackLocation(varName);
    if(stackLocation.equals("null")){
      stackLocation = registerAllocation.searchByVarValue(varName).name();
      if(stackLocation.equals("NULL_REG")) {
        System.out.println("Error variable: " + varName + " never assigned in AST_ExprIdent");
      }
    }

    instr.registerAllocation(resultReg);
    instr.allocateLocation(stackLocation);

    return resultReg;
  }


  /**
   * Effectively a variable name so need to get stack or register location of the variable linked
   * to varName member variable.
   */

  public void genInstruction(List<Instruction> instructionList, RegisterAllocation registerAllocation) throws Exception {

    InstructionAssignIdent instructionAssignIdent = new InstructionAssignIdent();
    instructionList.add(instructionAssignIdent);
    instr = instructionAssignIdent;

  }

}

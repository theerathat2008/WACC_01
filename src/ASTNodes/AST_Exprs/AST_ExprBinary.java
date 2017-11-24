package ASTNodes.AST_Exprs;

import ASTNodes.AST_Node;
import InstructionSet.Instruction;
import InstructionSet.InstructionArithmetic;
import InstructionSet.InstructionComparison;
import Registers.RegisterARM;
import Registers.RegisterAllocation;
import SymbolTable.SymbolTable;

import java.util.ArrayDeque;
import java.util.List;

import VisitorClass.AST_NodeVisitor;
import IdentifierObjects.*;

/**
 * Class representing node in AST tree for BINARY EXPRESSIONS
 */
public class AST_ExprBinary extends AST_Expr {

  //Syntactic attributes
  String opName;
  AST_Expr exprLeftAST;
  AST_Expr exprRightAST;
  InstructionArithmetic instrA;
  InstructionComparison instrC;

  /**
   * Constructor for class - initialises class variables to NULL
   */
  public AST_ExprBinary() {
    this.exprLeftAST = null;
    this.exprRightAST = null;
    this.opName = null;
  }

  /**
   * Gets all children nodes of current node
   *
   * @return list of AST nodes that are the children of the current node
   */
  @Override
  public ArrayDeque<AST_Node> getNodes() {
    ArrayDeque<AST_Node> returnList = new ArrayDeque<>();
    returnList.addLast(exprLeftAST);
    returnList.addLast(exprRightAST);
    return returnList;
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
      if (opName.equals("*")) {
        identifier = new BaseTypeObj(null, "int");
      } else if (opName.equals("/")) {
        identifier = new BaseTypeObj(null, "int");
      } else if (opName.equals("%")) {
        identifier = new BaseTypeObj(null, "int");
      } else if (opName.equals("+")) {
        identifier = new BaseTypeObj(null, "int");
      } else if (opName.equals("-")) {
        identifier = new BaseTypeObj(null, "int");
      } else {
        identifier = new BaseTypeObj(null, "bool");
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
   * Returns true if the embedded Nodes have value
   */
  @Override
  public boolean isEmbeddedNodesFull() {
    return exprLeftAST != null && exprRightAST != null;
  }

  /**
   * @param astToGet Shows which child to get from current node
   * @param counter  Shows which child of child to get from current node
   * @return Returns the required child AST Node (determined by the astToGet parameter)
   */
  @Override
  public AST_Node getEmbeddedAST(String astToGet, int counter) {
    if (astToGet.equals("exprLeftAST")) {
      return exprLeftAST;
    } else if (astToGet.equals("exprRightAST")) {
      return exprRightAST;
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
      if (exprLeftAST == null) {
        exprLeftAST = (AST_Expr) nodeToSet;
      } else if (exprRightAST == null) {
        exprRightAST = (AST_Expr) nodeToSet;
      } else {
        System.out.println("If and then in AST_StatIf have already been assigned.");
      }
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
      if (opName.equals("*")) {
        setType("int");
      } else if (opName.equals("/")) {
        setType("int");
      } else if (opName.equals("%")) {
        setType("int");
      } else if (opName.equals("+")) {
        setType("int");
      } else if (opName.equals("-")) {
        setType("int");
      } else {
        setType("bool");
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
    if (exprLeftAST == null) {
      System.out.println("exprLeftAST: null");
    } else {
      System.out.println("exprLeftAST: has content");
    }
    if (exprRightAST == null) {
      System.out.println("exprRightAST: null");
    } else {
      System.out.println("exprRightAST: has content");
    }
  }

  public void accept(AST_NodeVisitor visitor) {
    visitor.visit(this);
    exprLeftAST.accept(visitor);
    exprRightAST.accept(visitor);
  }

  @Override
  public void acceptInstr(List<String> assemblyCode) {
    exprLeftAST.acceptInstr(assemblyCode);
    exprRightAST.acceptInstr(assemblyCode);
    if(opName.equals("*") || opName.equals("/") || opName.equals("%") || opName.equals("+") || opName.equals("-")) {
      assemblyCode.add(instrA.block1);
    } else {
      assemblyCode.add(instrC.block1);
    }
  }

  @Override
  public void acceptRegister(RegisterAllocation registerAllocation) throws Exception {

    RegisterARM reg1 = registerAllocation.useRegister("expr");
    RegisterARM reg2 = registerAllocation.useRegister("expr");

    exprLeftAST.acceptRegister(registerAllocation);
    exprRightAST.acceptRegister(registerAllocation);



    if(opName.equals("*") || opName.equals("/") || opName.equals("%") || opName.equals("+") || opName.equals("-")){
      RegisterARM dst = registerAllocation.searchByValue("result");
      instrA.allocateRegisters(dst, reg1, reg2);
    } else {
      RegisterARM dst = registerAllocation.useRegister("expr");
      instrC.allocateRegisters(reg1, reg2, dst);
    }

  }


  /**
   * Generates assembly code in InstructionComparison and InstructionArithmetic depending on the
   * opName:  MULT   *  Needs registers to be allocated  InstructionArithmetic
   *          DIV    /  Needs registers to be allocated  InstructionArithmetic
   *          MOD    %  Needs registers to be allocated  InstructionArithmetic
   *          PLUS   +  Needs registers to be allocated  InstructionArithmetic
   *          MINUS  -  Needs registers to be allocated  InstructionArithmetic
   *
   *          GRTHAN >  Needs registers to be allocated  InstructionComparison
   *          GREQTO >= Needs registers to be allocated  InstructionComparison
   *          LSTHAN <  Needs registers to be allocated  InstructionComparison
   *          LSEQTO <= Needs registers to be allocated  InstructionComparison
   *          EQTO   == Needs registers to be allocated  InstructionComparison
   *          NEQTO  != Needs registers to be allocated  InstructionComparison
   *          AND    && Needs registers to be allocated  InstructionComparison
   *          OR     || Needs registers to be allocated  InstructionComparison
   *          TODO ALLOCATE REGISTER HERE
   */

  public void genInstruction(List<Instruction> instructionList, RegisterAllocation registerAllocation) throws Exception {

    if(opName.equals("*") || opName.equals("/") || opName.equals("%") || opName.equals("+") || opName.equals("-")){
      InstructionArithmetic instructionArithmetic = new InstructionArithmetic(opName);

      instructionList.add(instructionArithmetic);
      instrA = instructionArithmetic;
    } else {
      InstructionComparison instructionCompare = new InstructionComparison(opName);
      //RegisterARM reg1, RegisterARM reg2, RegisterARM reg3

      instructionList.add(instructionCompare);
      instrC = instructionCompare;

    }
  }
}

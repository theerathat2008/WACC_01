package ASTNodes;

import ASTNodes.AST_Stats.AST_Stat;
import IdentifierObjects.BaseTypeObj;
import IdentifierObjects.FunctionObj;
import IdentifierObjects.ParamListObj;
import InstructionSet.Instruction;
import InstructionSet.InstructionProgram;
import Registers.RegisterARM;
import Registers.RegisterAllocation;
import SymbolTable.SymbolTable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import VisitorClass.AST_NodeVisitor;

/**
 * Class representing node in AST tree for PROGRAM
 */
public class AST_Program extends AST_Node {

  //Syntactic attributes
  List<AST_FuncDecl> funcDeclList;
  int numOfFunc;
  AST_Stat statement;
  public SymbolTable symbolTable;
  InstructionProgram instr;

  private List<String> listInt = new ArrayList<>();
  private List<String> listOp = new ArrayList<>();

  /**
   * Assign the member variables when called and set the number of children
   */
  public AST_Program(int numberOfChildren) {
    this.numOfFunc = numberOfChildren - 4;
    this.funcDeclList = new ArrayList<>();
    statement = null;
    symbolTable = new SymbolTable("program");
  }

  /**
   * Gets all children nodes of current node
   * @return list of AST nodes that are the children of the current node
   */
  @Override
  public ArrayDeque<AST_Node> getNodes() {
    ArrayDeque<AST_Node> returnList = new ArrayDeque<>();
    for (AST_FuncDecl funcDecl : funcDeclList) {
      returnList.addLast(funcDecl);
    }
    returnList.addLast(statement);
    return returnList;
  }

  /**
   * Sets syntactic attributes of class variables - Holder function to implement abstract method
   * Never called - used for debug purposes
   * @param value - Value to be assigned to class variable
   */
  @Override
  public void setSyntacticAttributes(String value) {
    System.out.println("No String Syntactic Attributes in class: " + this.getClass().getSimpleName());
  }

  /**
   * Gets syntactic attributes of class variables - Holder function to implement abstract method
   * Never called - used for debug purposes
   * @param strToGet - Value to be retrieved from class variable
   */
  @Override
  public String getSyntacticAttributes(String strToGet) {
    System.out.println("No String Syntactic Attributes in class: " + this.getClass().getSimpleName());
    return null;
  }

  /**
   * Returns true if the embedded Nodes have values
   */
  @Override
  public boolean isEmbeddedNodesFull() {
    return funcDeclList.size() == numOfFunc && statement != null;
  }

  /**
   * @param astToGet Shows which child to get from current node
   * @param counter  Shows which child of child to get from current node
   * @return Returns the required child AST Node (determined by the astToGet parameter)
   */
  @Override
  public AST_Node getEmbeddedAST(String astToGet, int counter) {
    if (astToGet.equals("functionList")) {
      return funcDeclList.get(counter);
    } else if (astToGet.equals("statement")) {
      return statement;
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
    if (astToSet.equals("functionList")) {
      funcDeclList.add(((AST_FuncDecl) nodeToSet));
      ((AST_FuncDecl) nodeToSet).symbolTable.encSymTable = symbolTable;
      symbolTable.addChild(((AST_FuncDecl) nodeToSet).symbolTable);
      addStandardLibrary();
    } else if (astToSet.equals("statement")) {
      statement = (AST_Stat) nodeToSet;
    } else {
      System.out.println("Unrecognised AST Node at class: " + this.getClass().getSimpleName());
    }

  }

  /**
   * Add keyword min, max, avg, pow, factorial to the standard library
   */
  private void addStandardLibrary() {

    symbolTable.add("min", new FunctionObj("min", new BaseTypeObj("int"),
            new ParamListObj(Arrays.asList(new BaseTypeObj("int"), new BaseTypeObj("int")))));
    symbolTable.add("max", new FunctionObj("max", new BaseTypeObj("int"),
            new ParamListObj(Arrays.asList(new BaseTypeObj("int"), new BaseTypeObj("int")))));
    symbolTable.add("avg", new FunctionObj("avg", new BaseTypeObj("int"),
            new ParamListObj(Arrays.asList(new BaseTypeObj("int"), new BaseTypeObj("int")))));
    symbolTable.add("pow", new FunctionObj("pow", new BaseTypeObj("int"),
            new ParamListObj(Arrays.asList(new BaseTypeObj("int"), new BaseTypeObj("int")))));
    symbolTable.add("factorial", new FunctionObj("factorial", new BaseTypeObj("int"),
            new ParamListObj(Arrays.asList(new BaseTypeObj("int")))));

  }

  /**
   * Semantic Analysis and print error message if needed
   */
  @Override
  public boolean CheckSemantics() {

    return true;
  }

  /**
   * Used for testing - Prints out contents of current AST node
   */
  @Override
  public void printContents() {
    System.out.println(this.getClass().getSimpleName() + ": ");
    System.out.println("numOfFunc: " + numOfFunc);
    if (funcDeclList == null) {
      System.out.println("funcDeclList: null");
    } else {
      System.out.println("funcDeclList: has content");
    }
    if (statement == null) {
      System.out.println("statement: null");
    } else {
      System.out.println("statement: has content");
    }
    System.out.println("Printing Symbol Table: ");
    symbolTable.printKeysTable(symbolTable);
  }

  /**
   * Used to flag special cases where the register needs a stack implementation before the backend parse
   * @param regAlloc
   */
  @Override
  public void acceptPreProcess(RegisterAllocation regAlloc) {
    for (AST_FuncDecl func : funcDeclList) {
      func.acceptPreProcess(regAlloc);
    }
    statement.acceptPreProcess(regAlloc);
  }

  /**
   * Part of the visitor code gen pattern, used to generate the instruction classes
   * which are added to the instruction list
   * @param visitor
   */
  public void accept(AST_NodeVisitor visitor) {
    visitor.visit(this);
    for (AST_FuncDecl func : funcDeclList) {
      func.accept(visitor);
    }
    statement.accept(visitor);
  }

  /**
   * Function that is iterates through the ast_nodes and adds the instruction blocks
   * in the right order to the assembly code list
   * @param assemblyCode
   */
  @Override
  public void acceptInstr(List<String> assemblyCode) {
    assemblyCode.add(instr.block0);
    for (AST_FuncDecl func : funcDeclList) {
      func.acceptInstr(assemblyCode);
    }
    assemblyCode.add(instr.block1);
    statement.acceptInstr(assemblyCode);
    assemblyCode.add(instr.block2);
  }

  /**
   * Doesn't have any registers but does set the scope on entry to be "globalScope"
   * returns NULL_REG as there is no results reg
   */
  @Override
  public RegisterARM acceptRegister(RegisterAllocation registerAllocation) throws Exception {
    registerAllocation.setCurrentScope("globalScope");
    for (AST_FuncDecl func : funcDeclList) {
      func.acceptRegister(registerAllocation);
    }
    statement.acceptRegister(registerAllocation);
    registerAllocation.setCurrentScope("globalScope");
    return RegisterARM.NULL_REG;
  }

  /**
   * Produces the outer assembly code of the main program branch
   * Doesn't use any registers
   */

  /**
   * takes the embeded information corresponding to the specific instruction class and generates blocks
   * of assembly code for that instruction class
   * The embeded information is mainly the registers which is allocated using registerAllocation.
   * @param instructionList
   * @param registerAllocation
   * @throws Exception
   */
  @Override
  public void genInstruction(List<Instruction> instructionList, RegisterAllocation registerAllocation) throws Exception {
    InstructionProgram instruction = new InstructionProgram(registerAllocation);
    instructionList.add(instruction);
    instr = instruction;
  }

}

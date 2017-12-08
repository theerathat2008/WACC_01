package ASTNodes;

import ASTNodes.AST_Stats.AST_Stat;
import IdentifierObjects.FunctionObj;
import IdentifierObjects.IDENTIFIER;
import IdentifierObjects.ParamListObj;
import InstructionSet.Instruction;
import InstructionSet.InstructionFunction;
import Registers.RegisterARM;
import Registers.RegisterAllocation;
import SymbolTable.SymbolTable;
import ASTNodes.AST_TYPES.AST_Type;
import org.antlr.v4.runtime.ParserRuleContext;
import ErrorMessages.FunctionRedeclarationError;
import ErrorMessages.FilePosition;
import VisitorClass.AST_NodeVisitor;
import java.util.ArrayDeque;
import java.util.List;

/**
 * Class representing node in AST tree for FUNCTION
 */
public class AST_FuncDecl extends AST_Node {

  //Syntactic attributes
  public AST_Type ast_type;
  String funcName;
  int numOfChildren;
  AST_ParamList paramList;
  AST_Stat statement;
  ParserRuleContext ctx;
  public SymbolTable symbolTable;
  InstructionFunction instr;
  boolean hasReturn;

  /**
   * Class constructor
   * Assign the member variables when called and set the number of children
   */
  public AST_FuncDecl(int numOfChildren, ParserRuleContext ctx) {
    this.numOfChildren = numOfChildren;
    this.ast_type = null;
    this.funcName = null;
    this.paramList = null;
    this.statement = null;
    this.ctx = ctx;
    this.hasReturn = false;
    symbolTable = new SymbolTable("function");

  }

  /**
   * Gets all children nodes of current node
   * @return list of AST nodes that are the children of the current node
   */
  @Override
  public ArrayDeque<AST_Node> getNodes() {
    ArrayDeque<AST_Node> returnList = new ArrayDeque<>();
    returnList.addLast(ast_type);
    if (paramList != null) {
      returnList.addLast(paramList);
    }
    returnList.addLast(statement);
    return returnList;
  }

  /**
   * returns true if the function has any parameters
   */
  public boolean checkForParamList() {
    return numOfChildren == 8;
  }

  /**
   * Returns true if the embedded Nodes have values
   */
  @Override
  public boolean isEmbeddedNodesFull() {
    if (numOfChildren == 7) {
      return ast_type != null && statement != null;
    }
    return ast_type != null && statement != null && paramList != null;
  }

  /**
   * Sets syntactic attributes of class variables by assigning it a value
   * @param value - Value to be assigned to class variable
   */
  @Override
  public void setSyntacticAttributes(String value) {
    if (funcName == null) {
      this.funcName = value;
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
    if (strToGet.equals("funcName")) {
      return funcName;
    } else {
      System.out.println("Unrecognised String Attribute" + this.getClass().getSimpleName());
      return null;
    }
  }

  /**
   * @param astToGet Shows which child to get from current node
   * @param counter  Shows which child of child to get from current node
   * @return Returns the required child AST Node (determined by the astToGet parameter)
   */
  @Override
  public AST_Node getEmbeddedAST(String astToGet, int counter) {
    if (astToGet.equals("paramList")) {
      return paramList;
    } else if (astToGet.equals("statement")) {
      return statement;
    } else if (astToGet.equals("ast_type")) {
      return ast_type;
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
    if (astToSet.equals("paramList")) {
      paramList = (AST_ParamList) nodeToSet;
      paramList.symbolTable.encSymTable = symbolTable;
      symbolTable.addChild(paramList.symbolTable);
      symbolTable.changeScope("param_list");

    } else if (astToSet.equals("statement")) {
      statement = (AST_Stat) nodeToSet;
    } else if (astToSet.equals("ast_type")) {
      ast_type = (AST_Type) nodeToSet;
    } else {
      System.out.println("Unrecognised AST Node at class for " + astToSet + " : " + this.getClass().getSimpleName());
    }
  }

  /**
   * @return Returns the return type of the function
   */
  public String getReturnTypeName() {
    return ast_type.toString();
  }

  /**
   * Semantic Analysis and print error message if needed
   */
  @Override
  public boolean CheckSemantics() {
    SymbolTable ST = this.symbolTable;

    SymbolTable tempST = ST;

    IDENTIFIER type = tempST.lookup(funcName);

    if (type == null) {
      return true;

    } else {

      if (ast_type.getIdentifier().toString().contains(type.toString())) {
        return true;
      } else {
        System.out.println("Error on line " + ctx.getStart().getLine() + ". Function of same name already defined");
        new FunctionRedeclarationError(new FilePosition(ctx)).printAll();
        return false;
      }

    }
  }

  /**
   * Called from visitor
   * @param ST
   */
  @Override
  public void Check(SymbolTable ST) {

    if (CheckSemantics()) {

      while (!ST.getScope().equals("global")) {
        ST = ST.encSymTable;
      }
    }
  }

  public void Assign() {
    SymbolTable ST = symbolTable;
    while (!ST.getScope().equals("program")) {
      ST = ST.encSymTable;
    }
    if (checkForParamList()) {
      ST.add(funcName, new FunctionObj(funcName, ast_type.getIdentifier(), (ParamListObj) paramList.getIdentifier()));
    } else {
      ST.add(funcName, new FunctionObj(funcName, ast_type.getIdentifier(), null));
    }
  }

  /**
   * Used for testing - Prints out contents of current AST node
   */
  @Override
  public void printContents() {
    System.out.println(this.getClass().getSimpleName() + ": ");
    System.out.println("Funcname: " + funcName);
    if (paramList == null) {
      System.out.println("ParamList: null");
    } else {
      System.out.println("ParamList: has content");
    }
    if (statement == null) {
      System.out.println("statement: null");
    } else {
      System.out.println("statement: has content");
    }
    if (ast_type == null) {
      System.out.println("ast_type: null");
    } else {
      System.out.println("ast_type: has content");
    }
    symbolTable.printKeysTable(symbolTable);
  }

  /**
   * Used to flag special cases where the register needs a stack implementation before the backend parse
   * @param regAlloc
   */
  @Override
  public void acceptPreProcess(RegisterAllocation regAlloc) {
    if (checkForParamList()) {
      paramList.acceptPreProcess(regAlloc);
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
    ast_type.accept(visitor);
    if (checkForParamList()) {
      paramList.accept(visitor);
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
    assemblyCode.add(instr.block1);
    statement.acceptInstr(assemblyCode);
    assemblyCode.add(instr.block2);
  }

  /**
   * Doesn't require any registers but does set the scope to be functionScope on entry and global scope on exit
   * Returns the result register which in this case is null
   * Frees the function registers allocated in AST_ParamList after their usage in the statements
   */
  @Override
  public RegisterARM acceptRegister(RegisterAllocation registerAllocation) throws Exception {
    registerAllocation.setCurrentScope("funcScope");
    ast_type.acceptRegister(registerAllocation);
    if (checkForParamList()){
      paramList.acceptRegister(registerAllocation);
    }
    statement.acceptRegister(registerAllocation);

    registerAllocation.freeAllFuncReg(funcName);

    registerAllocation.setCurrentScope("globalScope");

    return RegisterARM.NULL_REG;
  }

  /**
   * Produces the outer assembly code for the function
   * Doesn't require registers
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
    InstructionFunction instructionFunction = new InstructionFunction(funcName, registerAllocation);
    instructionList.add(instructionFunction);
    instr = instructionFunction;
  }


  /**
   * @return Return the funcName attribute
   */
  public String getFuncName() {
    return funcName;
  }

}

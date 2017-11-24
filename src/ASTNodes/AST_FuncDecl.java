package ASTNodes;

import ASTNodes.AST_Stats.AST_Stat;
import ErrorMessages.TypeError;
import IdentifierObjects.FunctionObj;
import IdentifierObjects.IDENTIFIER;
import IdentifierObjects.ParamListObj;
import InstructionSet.Instruction;
import InstructionSet.InstructionFunction;
import Registers.RegisterAllocation;
import SymbolTable.SymbolTable;
import ASTNodes.AST_TYPES.AST_Type;
import org.antlr.v4.runtime.ParserRuleContext;
import ErrorMessages.FunctionRedeclarationError;
import src.FilePosition;
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

  public void setHasReturnTrue() {
    this.hasReturn = true;
  }

  //Semantic attribute

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

  public String getFuncName() {
    return funcName;
  }

  /**
   * Gets all children nodes of current node
   *
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
   *
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
   *
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
   *
   * @param ST
   */
  @Override
  public void Check(SymbolTable ST) {

    if (CheckSemantics()) {
      //Add function to global scope i.e. program
      //IDENTIFIER funcObj = new FunctionObj(funcName, ast_type.getIdentifier(), this);
      //((FunctionObj) funcObj).setParamListObj((ParamListObj) ST.lookup(funcName.concat("_paramList")));

      while (!ST.getScope().equals("global")) {
        ST = ST.encSymTable;
      }
      //ST.add(funcName, funcObj);

    }


    //System.out.println(ST.encSymTable.lookup(funcName)==null);
    //Create new symbol table   DONE
    //Add necessary contents specific to func to symbol table  DONE
    //set enclosing symbol table to curr symbol table   does this before check
    //Set curr symbol table to new symbol table

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

  public void accept(AST_NodeVisitor visitor) {
    visitor.visit(this);
    ast_type.accept(visitor);
    if(checkForParamList()){
      paramList.accept(visitor);
    }
    statement.accept(visitor);
  }

  @Override
  public void acceptInstr(List<String> assemblyCode) {
    assemblyCode.add(instr.block1);
    statement.acceptInstr(assemblyCode);
    assemblyCode.add(instr.block2);
  }

  /**
   * Doesn't require any registers
   */
  @Override
  public void acceptRegister(RegisterAllocation registerAllocation) throws Exception {
    ast_type.acceptRegister(registerAllocation);
    if(checkForParamList()){
      paramList.acceptRegister(registerAllocation);
    }
    statement.acceptRegister(registerAllocation);
  }


  /**
   * Produces the outer assembly code for the function
   * Doesn't require registers
   */
  @Override
  public void genInstruction(List<Instruction> instructionList, RegisterAllocation registerAllocation) throws Exception {
    InstructionFunction instructionFunction = new InstructionFunction(funcName);
    instructionList.add(instructionFunction);
    instr = instructionFunction;
  }

}

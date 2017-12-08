package ASTNodes.AST_Stats.AST_StatAssignRHSs;

import ASTNodes.AST_Stats.AST_StatAssignLHSs.AST_StatIdentLHS;
import ASTNodes.AST_Exprs.AST_ExprBinary;
import ASTNodes.AST_Exprs.AST_ExprLiter;
import ASTNodes.AST_Exprs.AST_ExprUnary;
import InstructionSet.Instruction;
import InstructionSet.InstructionDeclOrAss.InstructionArrayDeclAss;
import Registers.RegisterARM;
import Registers.RegisterAllocation;
import Registers.RegisterUsage;
import org.antlr.v4.runtime.ParserRuleContext;
import ASTNodes.AST_Exprs.AST_Expr;
import ASTNodes.AST_Node;
import ErrorMessages.TypeMismatchError;
import ErrorMessages.FilePosition;
import SymbolTable.SymbolTable;
import VisitorClass.AST_NodeVisitor;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import static Registers.RegisterUsageBuilder.*;
import IdentifierObjects.*;

/**
 * Class representing node in AST tree for ARRAY LITERAL ASSIGNMENT
 */
public class AST_StatArrayLitRHS extends AST_StatAssignRHS {

  //Syntactic attributes
  List<AST_Expr> ast_exprList;
  int numOfExpr;
  String type;
  ParserRuleContext ctx;
  InstructionArrayDeclAss instr;
  int currentPos = 0;

  /**
   * Constructor for class - initialises class variables
   * @param numberOfChildren - Shows the number of parameters in the parameter list of function
   */
  public AST_StatArrayLitRHS(int numberOfChildren, ParserRuleContext ctx) {
    ast_exprList = new ArrayList<>();
    if (numberOfChildren == 2) {
      this.numOfExpr = 0;
    } else {
      this.numOfExpr = (numberOfChildren - 1) / 2;
    }
    this.ctx = ctx;
  }

  /**
   * Gets all children nodes of current node
   * @return list of AST nodes that are the children of the current node
   */
  @Override
  public ArrayDeque<AST_Node> getNodes() {
    ArrayDeque<AST_Node> returnList = new ArrayDeque<>();
    for (AST_Expr expr : ast_exprList) {
      returnList.addLast(expr);
    }
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
   * Returns true if the embedded Nodes have value
   */
  @Override
  public boolean isEmbeddedNodesFull() {
    return ast_exprList.size() == numOfExpr;
  }

  /**
   * @param astToGet Shows which child to get from current node
   * @param counter  Shows which child of child to get from current node
   * @return Returns the required child AST Node (determined by the astToGet parameter)
   */
  @Override
  public AST_Node getEmbeddedAST(String astToGet, int counter) {
    if (astToGet.equals("ast_exprList")) {
      return ast_exprList.get(counter);
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
      ast_exprList.add((AST_Expr) nodeToSet);
      if (ast_exprList.size() == 1) {
        identifier = new ArrayObj(ast_exprList.get(0).getIdentifier());
        System.out.println(identifier);
      }
    } else {
      System.out.println("Unrecognised AST Node at class: " + this.getClass().getSimpleName());
    }
  }

  /**
   * @return Return type of array, otherwise return a message
   */
  public String getTypeOfArray() {
    if (ast_exprList.size() > 0) {
      return ast_exprList.get(0).getType();
    }
    return "EMPTY ARRAY IN GETTYPEOFARRAY STATARRAYLITRHS";

  }

  /**
   * @return Return size of array
   */
  public int getArraySize() {
    this.type = getTypeOfArray();
    if (type.equals("bool") || type.equals("char")) {
      return numOfExpr;
    }
    return (numOfExpr) * 4;
  }

  /**
   * @return Return size of elem
   */
  public int getElemSize() {
    this.type = getTypeOfArray();
    currentPos++;
    if (type.equals("bool") || type.equals("char")) {
      return 1;
    }
    return 4;
  }

  /**
   * @param ST - Parameter of current symbol table in scope
   * @return - Returns the type of the identifier variable
   */
  public String getType(SymbolTable ST) {
    return ast_exprList.get(0).toString() + "[]";
  }

  /**
   * Semantic Analysis and print error message if needed
   */
  @Override
  public boolean CheckSemantics() {

    //empty array is always true
    if (ast_exprList == null) {
      return true;
    } else if (numOfExpr == 0 || numOfExpr == 1) {
      return true;
    } else {
      //get type of the first index in the array
      AST_Expr firstElem = ast_exprList.get(0);

      for (int i = 1; i < numOfExpr; i++) {
        if ((ast_exprList.get(i).toString()).contains(firstElem.toString()) || firstElem.toString().contains(ast_exprList.get(i).toString())) {
          System.out.println("Same type");
        } else {
          new TypeMismatchError(new FilePosition(ctx)).printAll();
          return false;
        }
      }
      return true;
    }
  }

  /**
   * Called from visitor
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
    System.out.println("numOfExpr: " + numOfExpr);
    if (ast_exprList.size() == numOfExpr) {
      System.out.println("ast_exprList: List full");
    } else {
      System.out.println("ast_exprList has size: " + ast_exprList.size());
    }
  }

  /**
   * Used to flag special cases where the register needs a stack implementation before the backend parse
   * @param regAlloc
   */
  @Override
  public void acceptPreProcess(RegisterAllocation regAlloc) {
    for (AST_Expr expr : ast_exprList) {
      expr.acceptPreProcess(regAlloc);
    }
  }

  /**
   * Part of the visitor code gen pattern, used to generate the instruction classes
   * which are added to the instruction list
   * @param visitor
   */
  public void accept(AST_NodeVisitor visitor) {
    visitor.visit(this);
    for (AST_Expr expr : ast_exprList) {
      expr.accept(visitor);
    }
  }

  /**
   * General case to call acceptNode
   * have to return as a list for arrays
   * @param visitor
   */
  public List<Integer> acceptRootNode(AST_NodeVisitor visitor) {
    visitor.visit(this);

    List<Integer> listResult = new ArrayList<>();

    for (AST_Expr expr : ast_exprList) {
      int result = 0;
      if (expr instanceof AST_ExprLiter) {
        result = ((AST_ExprLiter) expr).acceptNode(visitor);
      } else if (expr instanceof AST_ExprBinary) {
        result = ((AST_ExprBinary) expr).acceptNode(visitor);
      } else if (expr instanceof AST_ExprUnary) {
        result = ((AST_ExprUnary) expr).acceptNode(visitor);
      }
      listResult.add(result);
    }

    return listResult;
  }

  /**
   * Function that is iterates through the ast_nodes and adds the instruction blocks
   * in the right order to the assembly code list
   * @param assemblyCode
   */
  @Override
  public void acceptInstr(List<String> assemblyCode) {
    int count = 0;
    assemblyCode.add(instr.getResultBlock1());
    for (AST_Expr expr : ast_exprList) {
      count++;
      expr.acceptInstr(assemblyCode);
      instr.setDisp(count * getElemSize());
      instr.genInstruction();
      assemblyCode.add(instr.getResultBlock());
    }
    assemblyCode.add(instr.getResultBlock2());

  }

  /**
   * Format is: [ (expr (COMMA expr)*)? ]
   * Returns null reg as statement evaluation isn't used
   * allocateRegisters(r0, RegisterARM inter, RegisterARM memoryAddress)
   */

  /**
   * Want to store the evaluation of the two registers result of the binary expression
   * Format is expr BinOp expr
   * Store the returned result of the two expr into a result reg
   * Free the two registers after having got the evaluation of the two stores in the regs
   */
  @Override
  public RegisterARM acceptRegister(RegisterAllocation registerAllocation) throws Exception {

    RegisterUsage usage = aRegisterUsageBuilder()
        .withScope(registerAllocation.getCurrentScope())
        .withUsageType("resultType")
        .build();

    RegisterARM memoryAddress = registerAllocation.useRegister(usage);

    RegisterARM intertempReg = RegisterARM.NULL_REG;

    for (AST_Expr expr : ast_exprList) {
      intertempReg = expr.acceptRegister(registerAllocation);
      registerAllocation.freeRegister(intertempReg);
    }

    if (intertempReg.equals(RegisterARM.NULL_REG)) {
      RegisterUsage tempReg = aRegisterUsageBuilder()
              .withUsageType("tempType")
              .withScope(registerAllocation.getCurrentScope())
              .build();
      RegisterARM tempPos = registerAllocation.useRegister(tempReg);
      intertempReg = tempPos;
    }
    
    instr.allocateRegisters(RegisterARM.r0, intertempReg, memoryAddress);
    registerAllocation.freeRegister(intertempReg);
    return memoryAddress;
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
    this.type = getTypeOfArray();
    String strType;

    if (type.equals("bool") || type.equals("char")) {
      strType = "STRB";
    } else {
      strType = "STR";
    }

    InstructionArrayDeclAss instructionArrayDeclAss
        = new InstructionArrayDeclAss(getArraySize(), numOfExpr, strType);
    this.currentPos++;
    instructionList.add(instructionArrayDeclAss);
    instr = instructionArrayDeclAss;

  }

}

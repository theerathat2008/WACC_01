package ASTNodes.AST_Stats;

import ASTNodes.AST_FuncDecl;
import ASTNodes.AST_Program;
import ASTNodes.AST_Stats.AST_StatAssignLHSs.AST_StatArrayElemLHS;
import ASTNodes.AST_Stats.AST_StatAssignLHSs.AST_StatIdentLHS;
import InstructionSet.Instruction;
import InstructionSet.InstructionRead;
import InstructionSet.InstructionBlocks.InstructionReadBlocks.InstructionReadBlocksChar;
import InstructionSet.InstructionBlocks.InstructionReadBlocks.InstructionReadBlocksInt;
import Registers.RegisterARM;
import Registers.RegisterAllocation;
import Registers.RegisterUsage;
import Registers.StackLocation;
import org.antlr.v4.runtime.ParserRuleContext;
import ASTNodes.AST_Node;
import ASTNodes.AST_Stats.AST_StatAssignLHSs.AST_StatAssignLHS;
import ASTNodes.AST_Stats.AST_StatAssignLHSs.AST_StatPairElemLHS;
import ASTNodes.AST_Exprs.AST_ExprIdent;
import ASTNodes.AST_Exprs.AST_Expr;
import ErrorMessages.TypeError;
import ErrorMessages.FilePosition;
import SymbolTable.SymbolTable;
import VisitorClass.AST_NodeVisitor;
import IdentifierObjects.IDENTIFIER;

import java.util.ArrayDeque;
import java.util.List;

import static Registers.RegisterUsageBuilder.aRegisterUsageBuilder;

public class AST_StatRead extends AST_Stat {

  //Syntactic attributes
  AST_StatAssignLHS ast_statAssignLHS;
  //Semantic attribute
  ParserRuleContext ctx;
  SymbolTable symbolTable;
  InstructionRead instr;

  /**
   * Assign the class variables when called
   */
  public AST_StatRead(ParserRuleContext ctx, SymbolTable symbolTable) {
    this.symbolTable = symbolTable;
    this.ast_statAssignLHS = null;
    this.ctx = ctx;
  }

  /**
   * Gets all children nodes of current node
   *
   * @return list of AST nodes that are the children of the current node
   */
  @Override
  public ArrayDeque<AST_Node> getNodes() {
    ArrayDeque<AST_Node> returnList = new ArrayDeque<>();
    returnList.addLast(ast_statAssignLHS);
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
    return ast_statAssignLHS != null;
  }

  /**
   * @param astToGet Shows which child to get from current node
   * @param counter  Shows which child of child to get from current node
   * @return Returns the required child AST Node (determined by the astToGet parameter)
   */
  @Override
  public AST_Node getEmbeddedAST(String astToGet, int counter) {
    if (astToGet.equals("ast_statAssignLHS")) {
      return ast_statAssignLHS;
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
    if (astToSet.equals("ast_statAssignLHS")) {
      ast_statAssignLHS = (AST_StatAssignLHS) nodeToSet;
    } else {
      System.out.println("Unrecognised AST Node at class: " + this.getClass().getSimpleName());
    }
  }

  /**
   * Semantic Analysis and print error message if needed
   *
   * @return
   */
  @Override
  public boolean CheckSemantics() {

    SymbolTable ST = this.symbolTable;

    if (ast_statAssignLHS instanceof AST_StatPairElemLHS) {
      AST_Expr ast_expr = ((AST_StatPairElemLHS) ast_statAssignLHS).getAst_expr();

      if (ast_expr instanceof AST_ExprIdent) {
        String varName = ((AST_ExprIdent) ast_expr).getVarName();
        SymbolTable tempST = this.symbolTable;
        IDENTIFIER typeName = tempST.lookup(varName);

        AST_Node tempNodeRHS = this.getParentNode();

        while (typeName == null) {
          tempST = tempST.encSymTable;
          typeName = tempST.lookup(varName);
        }

        String typeString = typeName.toString();
        System.out.println(typeString);

        if (typeString.equals("char") || typeString.equals("int")
            || typeString.contains("pair") || typeString.contains("PAIR(")) {
          return true;
        } else {
          new TypeError(new FilePosition(ctx)).printAll();
          return false;
        }
      }
    }

    System.out.println("reach here");
    String type = ast_statAssignLHS.getIdentifier().toString();

    //only valid if it is of type char and int
    if (!(type.equals("char") || type.equals("int") || type.contains("pair"))) {
      new TypeError(new FilePosition(ctx)).printAll();
      return false;
    }
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

  /**
   * Used for testing - Prints out contents of current AST node
   */
  @Override
  public void printContents() {
    System.out.println(this.getClass().getSimpleName() + ": ");
    if (ast_statAssignLHS == null) {
      System.out.println("stat1: null");
    } else {
      System.out.println("stat1: has content");
    }
  }

  public void accept(AST_NodeVisitor visitor) {
    visitor.visit(this);
    ast_statAssignLHS.accept(visitor);
  }

  @Override
  public void acceptInstr(List<String> assemblyCode) {
    ast_statAssignLHS.acceptInstr(assemblyCode);
    assemblyCode.add(instr.resultBlock);
  }

  /**
   * No expr evaluated therefore the reg returned is null
   */
  @Override
  public RegisterARM acceptRegister(RegisterAllocation registerAllocation) throws Exception {


    RegisterARM dstReg = ast_statAssignLHS.acceptRegister(registerAllocation);
    registerAllocation.freeRegister(dstReg);

    RegisterUsage resultUsage = aRegisterUsageBuilder()
        .withUsageType("interType")
        .withScope(registerAllocation.getCurrentScope())
        .build();
    RegisterARM interReg = registerAllocation.useRegister(resultUsage);
    registerAllocation.freeRegister(interReg);

    instr.allocateRegisters(RegisterARM.r0, interReg);

    if (ast_statAssignLHS instanceof AST_StatIdentLHS) {
      //Varname should always be allocated on the normal stack or the func stack

      AST_StatIdentLHS ast_statIdentLHS = (AST_StatIdentLHS)ast_statAssignLHS;
      String identName = ast_statIdentLHS.getIdentName();

      //WORK OUT ARRAY LOCATION
      boolean isFuncStat = true;
      AST_Node tempNode = this;
      while(!(tempNode instanceof AST_FuncDecl)){
        tempNode = tempNode.getParentNode();
        if(tempNode instanceof AST_Program){
          //System.out.println(varName + " not in func stat");
          isFuncStat = false;
          break;
        }
      }

      String stackLocation = "SP_NULL";

      if(isFuncStat){
        String funcName = ((AST_FuncDecl) tempNode).getFuncName();
        stackLocation = registerAllocation.getFuncStackLocation(funcName,identName);
      } else {
        stackLocation = registerAllocation.getStackLocation(identName);
      }
      if(stackLocation.equals("null")){
        System.out.println("problem in ast stat read allocating " + identName + " to the stack");
        System.out.println(identName + " allocated on the func stack: " + isFuncStat);
      }

      instr.allocateLocation(stackLocation);
      //Return the final store register
      return RegisterARM.NULL_REG;


    } else if(ast_statAssignLHS instanceof AST_StatArrayElemLHS){

    } else if(ast_statAssignLHS instanceof AST_StatPairElemLHS){

    }

    return RegisterARM.NULL_REG;
  }

  /**
   * Generates an read instruction depending on what type the statLHS has
   * InstructionReadBlocks is the base type
   * InstructionReadBlocksBool
   * InstructionReadBlocksInt
   * Allocates one register
   */


  public void genInstruction(List<Instruction> instructionList, RegisterAllocation registerAllocation) throws Exception {
    if(ast_statAssignLHS instanceof  AST_StatIdentLHS){

      String type = ast_statAssignLHS.getIdentifier().toString();
      InstructionRead instructionRead = new InstructionRead(type);
      //register allocation
      instructionList.add(instructionRead);
      instr = instructionRead;

      int message = 0;
      switch (type) {
        case ("int"):
          registerAllocation.addString(" %d\0");
          InstructionReadBlocksInt instructionPrintReadInt = new InstructionReadBlocksInt(registerAllocation.getStringID(" %d\0"));
          instructionList.add(instructionPrintReadInt);
          break;
        case ("char"):
          registerAllocation.addString(" %c\0");
          InstructionReadBlocksChar instructionPrintReadChar = new InstructionReadBlocksChar(registerAllocation.getStringID(" %c\0"));
          instructionList.add(instructionPrintReadChar);
          break;
        default:
          break;
      }

    } else if(ast_statAssignLHS instanceof AST_StatArrayElemLHS){

    } else if(ast_statAssignLHS instanceof AST_StatPairElemLHS){

    }



  }


}

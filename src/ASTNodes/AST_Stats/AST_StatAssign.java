package ASTNodes.AST_Stats;


import ASTNodes.AST_Exprs.AST_Expr;
import ASTNodes.AST_Exprs.AST_ExprEnclosed;
import ASTNodes.AST_Exprs.AST_ExprIdent;
import ASTNodes.AST_Exprs.AST_ExprLiter;
import ASTNodes.AST_FuncDecl;
import ASTNodes.AST_Exprs.*;
import ASTNodes.AST_Node;
import ASTNodes.AST_Program;
import ASTNodes.AST_Stats.AST_StatAssignLHSs.AST_StatArrayElemLHS;
import ASTNodes.AST_Stats.AST_StatAssignLHSs.AST_StatAssignLHS;
import ASTNodes.AST_Stats.AST_StatAssignLHSs.AST_StatIdentLHS;
import ASTNodes.AST_Stats.AST_StatAssignLHSs.AST_StatPairElemLHS;
import ASTNodes.AST_Stats.AST_StatAssignRHSs.AST_StatAssignRHS;
import ASTNodes.AST_Stats.AST_StatAssignRHSs.AST_StatCallRHS;
import ASTNodes.AST_Stats.AST_StatAssignRHSs.AST_StatExprRHS;
import ASTNodes.AST_Stats.AST_StatAssignRHSs.AST_StatPairElemRHS;
import ASTNodes.AST_TYPES.AST_PairElemTypes.AST_PairElemType;
import IdentifierObjects.IDENTIFIER;
import InstructionSet.Instruction;
import InstructionSet.InstructionAssignIdentLHS;
import InstructionSet.InstructionDeclOrAss.InstructionAssArrayElem.InstructionAssArrayElem;
import InstructionSet.InstructionDeclOrAss.InstructionAssPairElem;
import Registers.RegisterARM;
import Registers.RegisterAllocation;
import Registers.RegisterUsage;
import SymbolTable.SymbolTable;
import ErrorMessages.TypeMismatchError;
import ErrorMessages.FilePosition;
import org.antlr.v4.runtime.ParserRuleContext;
import VisitorClass.AST_NodeVisitor;
import static Registers.RegisterUsageBuilder.*;
import java.util.ArrayDeque;
import java.util.List;
import static java.lang.System.exit;
import static java.lang.System.setOut;

/**
 * Class representing node in AST tree for ASSIGNMENT STATEMENTS
 */
public class AST_StatAssign extends AST_Stat {
  //Syntactic attributes
  AST_StatAssignLHS ast_statAssignLHS;
  AST_StatAssignRHS ast_statAssignRHS;
  ParserRuleContext ctx;
  SymbolTable symbolTable;
  InstructionAssignIdentLHS instrIdentLHS;
  InstructionAssArrayElem instrArrayElemLHS;
  InstructionAssPairElem instrPairElemLHS;

  /**
   * Constructor for class - initialises class variables to NULL
   */
  public AST_StatAssign(ParserRuleContext ctx, SymbolTable symbolTable) {
    this.ast_statAssignLHS = null;
    this.ast_statAssignRHS = null;
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
    returnList.addLast(ast_statAssignLHS);
    returnList.addLast(ast_statAssignRHS);
    return returnList;
  }

  /**
   * Returns true if the embedded Nodes have value
   */
  @Override
  public boolean isEmbeddedNodesFull() {
    return ast_statAssignLHS != null && ast_statAssignRHS != null;
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
   * @param astToGet Shows which child to get from current node
   * @param counter  Shows which child of child to get from current node
   * @return Returns the required child AST Node (determined by the astToGet parameter)
   */
  @Override
  public AST_Node getEmbeddedAST(String astToGet, int counter) {
    if (astToGet.equals("ast_statAssignLHS")) {
      return ast_statAssignLHS;
    } else if (astToGet.equals("ast_statAssignRHS")) {
      return ast_statAssignRHS;
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
    } else if (astToSet.equals("statAssignRHS")) {
      ast_statAssignRHS = (AST_StatAssignRHS) nodeToSet;
    } else {
      System.out.println("Unrecognised AST Node at class: " + this.getClass().getSimpleName());
    }
  }

  /**
   * Semantic Analysis and print error message if needed
   */
  @Override
  public boolean CheckSemantics() {

    SymbolTable ST = this.symbolTable;

    IDENTIFIER typeLHS = ast_statAssignLHS.getIdentifier();
    IDENTIFIER typeRHS = ast_statAssignRHS.getIdentifier();

    if (ast_statAssignLHS instanceof AST_StatArrayElemLHS) {
      //check the size of the array if it contains any element inside
      String identName = ((AST_StatArrayElemLHS) ast_statAssignLHS).getIdentName();
      SymbolTable temporaryST = this.symbolTable;
      typeLHS = temporaryST.lookup(identName);

      while (typeLHS == null) {
        temporaryST = temporaryST.encSymTable;
        typeLHS = temporaryST.lookup(identName);
      }

      if (((AST_StatArrayElemLHS) ast_statAssignLHS).getAst_exprList().size() != 0) {
        AST_Expr firstElem = ((AST_StatArrayElemLHS) ast_statAssignLHS).getAst_exprList().get(0);

        //check if it is instace of AST_ExprIdent if it is an ident
        if (firstElem instanceof AST_ExprEnclosed) {
          return true;
        } else if (firstElem instanceof AST_ExprIdent) {
          String varName = ((AST_ExprIdent) firstElem).getVarName();

          SymbolTable tempST = this.symbolTable;
          typeLHS = tempST.lookup(varName);

          while (typeLHS == null) {
            tempST = tempST.encSymTable;
            typeLHS = tempST.lookup(varName);
          }
        }
        if (firstElem instanceof AST_ExprLiter) {
          String literal = ((AST_ExprLiter) firstElem).getLiteral();
          String constant = ((AST_ExprLiter) firstElem).getConstant();

          //meaning it's accessing an array
          if (literal.equals("int")) {
            if (typeLHS.toString().contains("str")) {
              //make typeLHs = char || check the type of the first elem
              return true;

            }
          }
        } else {
          typeLHS = ast_statAssignLHS.getIdentifier();
        }
      } else {
        typeLHS = ast_statAssignLHS.getIdentifier();
      }

      if (ast_statAssignRHS instanceof AST_StatExprRHS) {
        AST_Expr ast_expr = ((AST_StatExprRHS) ast_statAssignRHS).getAst_expr();

        if (ast_expr instanceof AST_ExprIdent) {
          String varName = ((AST_ExprIdent) ast_expr).getVarName();
          typeRHS = ST.encSymTable.lookup(varName);
        } else {
          typeRHS = ast_statAssignRHS.getIdentifier();
        }
      } else {
        typeRHS = ast_statAssignRHS.getIdentifier();
      }

    }

    if (ast_statAssignRHS instanceof AST_StatExprRHS) {
      AST_Expr ast_expr = ((AST_StatExprRHS) ast_statAssignRHS).getAst_expr();

      if (ast_expr instanceof AST_ExprIdent) {
        String varName = ((AST_ExprIdent) ast_expr).getVarName();
        SymbolTable tempST = ST;
        typeRHS = tempST.lookup(varName);


        AST_Node tempNodeRHS = this.getParentNode();

        while (typeRHS == null) {
          tempST = tempST.encSymTable;
          typeRHS = tempST.lookup(varName);
        }
      } else {
        typeRHS = ast_statAssignRHS.getIdentifier();
      }
    } else if (ast_statAssignRHS instanceof AST_StatPairElemRHS) {
      AST_Expr ast_expr = ((AST_StatPairElemRHS) ast_statAssignRHS).getAst_expr();

      if (ast_expr instanceof AST_ExprIdent) {
        String varName = ((AST_ExprIdent) ast_expr).getVarName();
        SymbolTable tempST = ST;
        typeRHS = tempST.lookup(varName);

        AST_Node tempNodeRHS = this.getParentNode();

        while (typeRHS == null) {
          tempST = tempST.encSymTable;
          typeRHS = tempST.lookup(varName);
        }

        String exprType = ((AST_StatPairElemRHS) ast_statAssignRHS).getTypeName();

        if (exprType.equals("fst")) {
          return true;
        } else if (exprType.equals("snd")) {
          return true;
        }

      } else {
        typeRHS = ast_statAssignRHS.getIdentifier();
      }

    } else if (ast_statAssignRHS instanceof AST_StatCallRHS) {
      List<AST_Expr> exprList = ((AST_StatCallRHS) ast_statAssignRHS).getAst_exprList();
      String funcName = ((AST_StatCallRHS) ast_statAssignRHS).getFuncName();

      SymbolTable tempST = ST;
      typeRHS = tempST.lookup(funcName);

      while (typeRHS == null) {
        tempST = tempST.encSymTable;
        typeRHS = tempST.lookup(funcName);
      }

    } else {
      typeRHS = ast_statAssignRHS.getIdentifier();
    }

    if (ast_statAssignLHS instanceof AST_StatPairElemLHS) {

      AST_Expr expr = ((AST_StatPairElemLHS) ast_statAssignLHS).getAst_expr();

      if (expr instanceof AST_ExprIdent) {
        String varName = ((AST_ExprIdent) expr).getVarName();
        SymbolTable tempST = ST;
        typeLHS = tempST.lookup(varName);

        AST_Node tempNode = this.getParentNode();

        while (typeLHS == null) {
          tempST = tempST.encSymTable;
          typeLHS = tempST.lookup(varName);
        }

        if (typeLHS.toString().contains("PAIR(")) {
          String typeExpr = ((AST_StatPairElemLHS) ast_statAssignLHS).getTypeName();

          if (typeExpr.equals("fst")) {
            return true;
          } else if (typeExpr.equals("snd")) {
            return true;
          }
        }

      } else {
        typeLHS = ast_statAssignLHS.getIdentifier();
      }
    }

    if (typeLHS == null) {
      System.out.println("Errors detected during compilation! Exit code 200 returned.");
      System.out.println("#semantic_error#");
      System.out.println("ERROR: Variable is not declared" + new FilePosition(ctx));
      exit(200);
    }

    if (typeLHS.toString().contains("FUNCTION")) {
      //cannot assign to a function
      System.out.println("Errors detected during compilation! Exit code 200 returned.");
      System.out.println("#semantic_error#");
      System.out.println("ERROR: Attempt to assign to a function is invalid" + new FilePosition(ctx));
      exit(200);
    }
    if (typeLHS.toString().contains("PAIR(") && typeRHS.toString().contains("PAIR(")) {
      String stringLHS = typeLHS.toString();
      String pairLHS = stringLHS.substring(stringLHS.indexOf("P"), stringLHS.indexOf(")"));
      String stringRHS = typeRHS.toString();
      String pairRHS = stringRHS.substring(stringRHS.indexOf("P"), stringRHS.indexOf(")"));
      if (pairLHS.contains(pairRHS) || pairRHS.contains(pairLHS)) {
        return true;
      } else {
        new TypeMismatchError(new FilePosition(ctx)).printAll();
        return false;
      }
    }
    if (typeLHS.toString().contains(typeRHS.toString()) || typeRHS.toString().contains(typeLHS.toString())) {
      return true;
    } else {
      new TypeMismatchError(new FilePosition(ctx)).printAll();
      return false;
    }
  }

  /**
   * Called from visitor
   * @param ST
   */
  @Override
  public void Check(SymbolTable ST) {
    CheckSemantics();
  }

  /**
   * Used for testing - Prints out contents of current AST node
   */
  @Override
  public void printContents() {
    System.out.println(this.getClass().getSimpleName() + ": ");
    if (ast_statAssignLHS == null) {
      System.out.println("ast_statAssignLHS: null");
    } else {
      System.out.println("ast_statAssignLHS: has content");
    }
    if (ast_statAssignRHS == null) {
      System.out.println("ast_statAssignRHS: null");
    } else {
      System.out.println("ast_statAssignRHS: has content");
      ast_statAssignRHS.printContents();
    }
  }

  /**
   * Used to flag special cases where the register needs a stack implementation before the backend parse
   * @param regAlloc
   */
  @Override
  public void acceptPreProcess(RegisterAllocation regAlloc) {


    //Set a flag for acceptRegister in statVarDecl using a list in registerallocation to declare the var on the stack
    // since it is used in read and the statarraylitrhs assembly code works with stacks
    if (ast_statAssignLHS instanceof AST_StatIdentLHS) {

      //Check if varName is allocated on the stack or in a register
      AST_StatIdentLHS ast_statIdentLHS = (AST_StatIdentLHS) ast_statAssignLHS;

      //StackLocation
      //Register

      //FuncStackLocation
      //FuncRegister

      //WORK OUT ARRAY LOCATION
      boolean isFuncStat = true;
      AST_Node tempNode = this;
      while (!(tempNode instanceof AST_FuncDecl)) {
        tempNode = tempNode.getParentNode();
        if (tempNode instanceof AST_Program) {
          isFuncStat = false;
          break;
        }
      }
      if(isFuncStat){
      }
    }

    ast_statAssignLHS.acceptPreProcess(regAlloc);
    ast_statAssignRHS.acceptPreProcess(regAlloc);
  }

  /**
   * Part of the visitor code gen pattern, used to generate the instruction classes
   * which are added to the instruction list
   * @param visitor
   */
  public void accept(AST_NodeVisitor visitor) {
    visitor.visit(this);
    ast_statAssignLHS.accept(visitor);
    ast_statAssignRHS.accept(visitor);
  }

  /**
   * General case to call acceptNode
   * can onlt do on the leftLHS
   * @param visitor
   */
  public int acceptRootNode(AST_NodeVisitor visitor) {
    visitor.visit(this);

    int result = 0;

    if (ast_statAssignRHS instanceof AST_StatExprRHS || ast_statAssignRHS instanceof AST_StatPairElemRHS) {
      AST_Expr ast_exprRHS = ((AST_StatExprRHS) ast_statAssignRHS).getAst_expr();

      if (ast_exprRHS instanceof AST_ExprLiter) {
        result = ((AST_ExprLiter) ast_exprRHS).acceptNode(visitor);
      } else if (ast_exprRHS instanceof AST_ExprBinary) {
        result = ((AST_ExprBinary) ast_exprRHS).acceptNode(visitor);
      } else if (ast_exprRHS instanceof AST_ExprUnary) {
        result = ((AST_ExprUnary) ast_exprRHS).acceptNode(visitor);
      }

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

    ast_statAssignRHS.acceptInstr(assemblyCode);

    if (ast_statAssignLHS instanceof AST_StatIdentLHS) {
      assemblyCode.add(instrIdentLHS.getBlock1());
    } else if (ast_statAssignLHS instanceof AST_StatArrayElemLHS) {

      assemblyCode.add(instrArrayElemLHS.getResultBlock1());
      //assemblyCode.add("\n\n\n");
      AST_Expr tempNode = ((AST_StatArrayElemLHS) ast_statAssignLHS).ast_exprList.get(0);
      tempNode.acceptInstr(assemblyCode);

      assemblyCode.add(instrArrayElemLHS.getResultBlock2());

    } else if (ast_statAssignLHS instanceof AST_StatPairElemLHS){
      AST_ExprIdent ast_exprIdent = (AST_ExprIdent) ((AST_StatPairElemLHS) ast_statAssignLHS).getAst_expr();
      ast_exprIdent.acceptInstr(assemblyCode);
      assemblyCode.add(instrPairElemLHS.getResultBlock());
    }

  }

  /**
   * Evaluate both sides of the stat assign and store their results in the registers
   */
  @Override
  public RegisterARM acceptRegister(RegisterAllocation registerAllocation) throws Exception {
    registerAllocation.printfreeReg();

    RegisterARM regRight = ast_statAssignRHS.acceptRegister(registerAllocation);

    //Don't care about the result of the left reg
    RegisterARM regLeft = ast_statAssignLHS.acceptRegister(registerAllocation);


    //registerAllocation.freeRegister(regLeft);

    if (ast_statAssignLHS instanceof AST_StatIdentLHS) {
      registerAllocation.freeRegister(regRight);

      //Check if varName is allocated on the stack or in a register
      AST_StatIdentLHS ast_statIdentLHS = (AST_StatIdentLHS) ast_statAssignLHS;

      //StackLocation
      //Register

      //FuncStackLocation
      //FuncRegister

      //WORK OUT ARRAY LOCATION
      boolean isFuncStat = true;
      AST_Node tempNode = this;
      while(!(tempNode instanceof AST_FuncDecl)){
        tempNode = tempNode.getParentNode();
        if(tempNode instanceof AST_Program){
          isFuncStat = false;
          break;
        }
      }

      String stackLocation = "SP_NULL";

      if(isFuncStat){
        String funcName = ((AST_FuncDecl) tempNode).getFuncName();
        stackLocation = registerAllocation.searchByFuncVarValue(ast_statIdentLHS.getIdentName(), funcName).name();
        if(stackLocation.equals("NULL_REG")){
          stackLocation = registerAllocation.getFuncStackLocation(funcName, ast_statIdentLHS.getIdentName());
          instrIdentLHS.registerAllocation(regRight);
          instrIdentLHS.setUsingStack(true);
          instrIdentLHS.allocateLocation(stackLocation);
        } else {
          instrIdentLHS.registerAllocation(regRight);
          instrIdentLHS.setUsingStack(false);
          instrIdentLHS.allocateLocation(stackLocation);
        }
      } else {
        stackLocation = registerAllocation.getStackLocation(ast_statIdentLHS.getIdentName());
        if(stackLocation.equals("null")){
          stackLocation = registerAllocation.searchByVarValue(ast_statIdentLHS.getIdentName()).name();
          instrIdentLHS.registerAllocation(regRight);
          instrIdentLHS.setUsingStack(false);
          instrIdentLHS.allocateLocation(stackLocation);
        } else {
          instrIdentLHS.registerAllocation(regRight);
          instrIdentLHS.setUsingStack(true);
          instrIdentLHS.allocateLocation(stackLocation);
        }
      }

      //Don't care output result in stat assign
      return regLeft;

    } else if(ast_statAssignLHS instanceof AST_StatArrayElemLHS){



      RegisterUsage resultUsage = aRegisterUsageBuilder()
              .withUsageType("resultType")
              .withScope(registerAllocation.getCurrentScope())
              .build();
      RegisterARM result = registerAllocation.useRegister(resultUsage);

      RegisterUsage tempReg = aRegisterUsageBuilder()
              .withUsageType("tempType")
              .withScope(registerAllocation.getCurrentScope())
              .build();
      RegisterARM tempPos = registerAllocation.useRegister(tempReg);
      registerAllocation.freeRegister(tempPos);

      instrArrayElemLHS.allocateRegisters(result, tempPos, regRight);


      //WORK OUT ARRAY LOCATION
      boolean isFuncStat = true;
      AST_Node tempNode = this;
      while(!(tempNode instanceof AST_FuncDecl)){
        tempNode = tempNode.getParentNode();
        if(tempNode instanceof AST_Program){
          isFuncStat = false;
          break;
        }
      }

      String stackLocation = "SP_NULL";
      instrArrayElemLHS.allocateLocation(stackLocation, true);

      if(isFuncStat){
        String funcName = ((AST_FuncDecl) tempNode).getFuncName();
        stackLocation = registerAllocation.searchByFuncVarValue(((AST_StatArrayElemLHS)ast_statAssignLHS).getIdentName(), funcName).name();
        if(stackLocation.equals("NULL_REG")){
          stackLocation = registerAllocation.getFuncStackLocation(funcName,((AST_StatArrayElemLHS)ast_statAssignLHS).getIdentName());
          instrArrayElemLHS.allocateLocation(stackLocation, true);
        } else {
          instrArrayElemLHS.allocateLocation(stackLocation, false);
        }
      } else {
        stackLocation = registerAllocation.getStackLocation(((AST_StatArrayElemLHS)ast_statAssignLHS).getIdentName());
        if(stackLocation.equals("null")){
          stackLocation = registerAllocation.searchByVarValue(((AST_StatArrayElemLHS)ast_statAssignLHS).getIdentName()).name();
          instrArrayElemLHS.allocateLocation(stackLocation, false);
        } else {
          instrArrayElemLHS.allocateLocation(stackLocation, true);
        }
      }

      instrArrayElemLHS.allocateLocation(stackLocation, true);

      registerAllocation.freeRegister(regRight);
      registerAllocation.freeRegister(regLeft);

      return result;

    } else if(ast_statAssignLHS instanceof AST_StatPairElemLHS){

      AST_StatPairElemLHS ast_statIdentLHS = (AST_StatPairElemLHS) ast_statAssignLHS;
      AST_ExprIdent ast_exprIdent = (AST_ExprIdent) ast_statIdentLHS.getAst_expr();
      String pairName = ast_exprIdent.getVarName();

      boolean isFuncStat = true;
      AST_Node tempNode = this;
      while(!(tempNode instanceof AST_FuncDecl)){
        tempNode = tempNode.getParentNode();
        if(tempNode instanceof AST_Program){
          isFuncStat = false;
          break;
        }
      }

      String stackLocation = "SP_NULL";
      instrPairElemLHS.allocateLocation(stackLocation);

      if(isFuncStat){
        String funcName = ((AST_FuncDecl) tempNode).getFuncName();
        //stackLocation = registerAllocation.searchByFuncVarValue(((AST_StatPairElemLHS)ast_statAssignLHS).identifier.getName(), funcName).name();

        stackLocation = registerAllocation.getFuncStackLocation(funcName, pairName);
        if(stackLocation.equals("null")){
          //Pairs always allocated on the stack
          System.out.println("ERROR, never should reach this case");
        }
        instrPairElemLHS.allocateLocation(stackLocation);

      } else {

        stackLocation = registerAllocation.getStackLocation(pairName);
        if(stackLocation.equals("null")){
          //Pairs always allocated on the stack
          System.out.println("ERROR, never should reach this case");
        }
        instrPairElemLHS.allocateLocation(stackLocation);
      }

      AST_ExprIdent ident = (AST_ExprIdent) ((AST_StatPairElemLHS) ast_statAssignLHS).getAst_expr();
      RegisterARM pairLocReg = ident.acceptRegister(registerAllocation);

      instrPairElemLHS.allocateRegisters(RegisterARM.r0, pairLocReg, regRight);

      registerAllocation.freeRegister(regRight);
      registerAllocation.freeRegister(regLeft);

      return pairLocReg;
    }
    System.out.println("Nothing done in AST_StatAssign as lhs class was:  " + ast_statAssignLHS.getClass().getSimpleName());
    return regLeft;
  }

  /**
   * Needs two register corresponding to the destination and source in two lines
   * and an intermediate register to hold the value
   * MOV r4, #'Z'    ->CHAR
   * STRB r4, [sp]
   * or
   * LDR r4, =20     ->INT
   * STR r4, [sp]
   * or
   * LDR r4, =msg_1   ->STRING
   * STR r4, [sp]
   * or
   * STRB r4, [sp]    ->BOOL
   * LDRSB r4, [sp]
   */

  /**
   * @param tempNode
   * @return Return string with position in the array, otherwise return a default string
   */
  public String getPosInArray(AST_StatArrayElemLHS tempNode){
    if (tempNode.ast_exprList.get(0) instanceof AST_ExprLiter) {
      return ((AST_ExprLiter) tempNode.ast_exprList.get(0)).getConstant();
    } else if (tempNode.ast_exprList.get(0) instanceof AST_ExprIdent) {

    }

    return "getPosInArray() to be implemented";
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
    if (ast_statAssignLHS instanceof AST_StatIdentLHS){
      String type = "UNASSIGNED";

      try {
        type = ast_statAssignRHS.getIdentifier().toString();
      } catch (NullPointerException n) {
        try {
          //type = ((AST_StatExprRHS) ast_statAssignRHS).getAst_expr().getIdentifier().getName();
          //type = ((AST_StatIdentLHS) ast_statAssignLHS).;
        } catch (Exception e) {
          type = ((AST_StatIdentLHS) ast_statAssignLHS).getIdentName();
        }
      }
      InstructionAssignIdentLHS instructionAssignIdentLHS = new InstructionAssignIdentLHS(type);
      instructionList.add(instructionAssignIdentLHS);
      instrIdentLHS = instructionAssignIdentLHS;
    } else if(ast_statAssignLHS instanceof AST_StatArrayElemLHS){

      String type = ((AST_StatExprRHS) ast_statAssignRHS).getAst_expr().getType();

      InstructionAssArrayElem instructionAssArrayElem = new InstructionAssArrayElem(type, true);
      instructionList.add(instructionAssArrayElem);
      instrArrayElemLHS = instructionAssArrayElem;

    } else if(ast_statAssignLHS instanceof AST_StatPairElemLHS){
      instrPairElemLHS = new InstructionAssPairElem(((AST_StatPairElemLHS) ast_statAssignLHS).getTypeName());
      instructionList.add(instrPairElemLHS);

    }
  }
}

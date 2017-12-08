package ASTNodes.AST_Stats;

import ASTNodes.AST_Exprs.*;
import ASTNodes.AST_FuncDecl;
import ASTNodes.AST_Node;
import ASTNodes.AST_Program;
import ASTNodes.AST_Separator;
import IdentifierObjects.IDENTIFIER;
import InstructionSet.*;
import InstructionSet.InstructionBlocks.InstructionError.InstructionErrorRuntime;
import InstructionSet.InstructionBlocks.InstructionFreePairBlock;
import InstructionSet.InstructionBlocks.InstructionPrintBlocks.*;
import InstructionSet.InstructionBlocks.InstructionPrintBlocks.InstructionPrintBlocksBool;
import InstructionSet.InstructionBlocks.InstructionPrintBlocks.InstructionPrintBlocksString;
import Registers.RegisterARM;
import Registers.RegisterAllocation;
import SymbolTable.SymbolTable;
import ErrorMessages.TypeError;
import ErrorMessages.TypeMismatchError;
import ErrorMessages.FilePosition;
import org.antlr.v4.runtime.ParserRuleContext;
import VisitorClass.AST_NodeVisitor;
import java.util.ArrayDeque;
import java.util.List;

public class AST_StatExpr extends AST_Stat {

  //Syntactic attributes
  AST_Expr expr;
  ParserRuleContext ctx;
  SymbolTable symbolTable;
  Instruction instr;
  Instruction instrPrintLn;
  Instruction instrPrintLine;
  Instruction instrPrintType;

  /**
   * Assign the class variables when called
   * @param ctx
   */
  public AST_StatExpr(ParserRuleContext ctx, SymbolTable symbolTable) {
    this.expr = null;
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
    returnList.addLast(expr);
    return returnList;
  }

  /**
   * Returns true if the embedded Nodes have value
   */
  @Override
  public boolean isEmbeddedNodesFull() {
    return expr != null;
  }

  /**
   * @param astToGet Shows which child to get from current node
   * @param counter  Shows which child of child to get from current node
   * @return Returns the required child AST Node (determined by the astToGet parameter)
   */
  @Override
  public AST_Node getEmbeddedAST(String astToGet, int counter) {
    if (astToGet.equals("expr")) {
      return expr;
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
      expr = (AST_Expr) nodeToSet;
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
    AST_Node parent = getParentNode();

    if (statName.equals("free")) {
      if (expr instanceof AST_ExprIdent) {
        String varName = ((AST_ExprIdent) expr).getVarName();
        AST_Node tempNode = this.getParentNode();

        SymbolTable tempST = ST;
        IDENTIFIER typeExpr = tempST.lookup(varName);

        while (typeExpr == null) {
          tempST = tempST.encSymTable;
          typeExpr = tempST.lookup(varName);
        }

        if (typeExpr.toString().contains("PAIR") || typeExpr.toString().contains("[]")) {
          return true;
        } else {
          new TypeError(new FilePosition(ctx)).printAll();
          return false;
        }
      } else {
        if (expr.getIdentifier().toString().contains("[]") || expr.getIdentifier().toString().contains("PAIR")) {
          return true;
        } else {
          new TypeError(new FilePosition(ctx)).printAll();
          return false;
        }
      }

    } else if (statName.equals("return")) {

      //search until find function declaration
      while (!(parent instanceof AST_FuncDecl)) {
        if (parent instanceof AST_Program) {
          System.out.println("Return statement not inside of a function.");
          new TypeError(new FilePosition(ctx)).printAll();
          return false;
        }

        parent = parent.getParentNode();

      }

      //check if the return type is the same type as function type
      AST_FuncDecl temp = (AST_FuncDecl) parent;

      if (expr instanceof AST_ExprIdent) {
        String varName = ((AST_ExprIdent) expr).getVarName();
        AST_Node tempNode = this.getParentNode();
        SymbolTable tempST = this.symbolTable;
        IDENTIFIER typeExpr = tempST.lookup(varName);

        while (typeExpr == null) {
          tempST = tempST.encSymTable;
          typeExpr = tempST.lookup(varName);
        }
        if (temp.ast_type.getIdentifier().equals(typeExpr)) {
          return true;
        } else {
          new TypeMismatchError(new FilePosition(ctx)).printAll();
          return false;
        }
      }


      if (expr instanceof AST_ExprEnclosed || expr instanceof AST_ExprBinary
          || expr instanceof AST_ExprUnary) {
        return true;
      } else if ((temp.ast_type.getIdentifier().equals(expr.getIdentifier()))) {
        return true;
      } else {
        new TypeMismatchError(new FilePosition(ctx)).printAll();
        return false;
      }
    } else if (statName.equals("exit")) {
      if (expr instanceof AST_ExprUnary || expr instanceof AST_ExprEnclosed) {
        if (expr.getIdentifier().toString().equals("int")) {
          return true;
        } else {
          System.out.println("Expression after exit statement must be of type int.");
          new TypeError(new FilePosition(ctx)).printAll();
          return false;
        }
      } else if (expr instanceof AST_ExprIdent) {
        System.out.println(expr);
        expr.printContents();
        String varName = ((AST_ExprIdent) expr).getVarName();

        AST_Node tempNode = this.getParentNode();
        SymbolTable tempST = ST;
        IDENTIFIER type = tempST.lookup(varName);

        while (type == null) {
          System.out.println("type is null");
          tempST = tempST.encSymTable;
          type = tempST.lookup(varName);
        }
        if (type.toString().equals("int")) {
          return true;
        } else {
          new TypeMismatchError(new FilePosition(ctx)).printAll();
          return false;
        }
      } else if (expr instanceof AST_ExprLiter) {
        String literals = ((AST_ExprLiter) expr).getLiteral();

        //can only be of type int after exit
        if (literals.contains("int")) {
          return true;
        } else {
          new TypeError(new FilePosition(ctx)).printAll();
          return false;
        }
      } else {
        return true;
      }
    } else if (statName.equals("print")) {
      return true;
    } else if (statName.equals("println")) {
      return true;
    }
    new TypeError(new FilePosition(ctx)).printAll();
    return false;
  }

  /**
   * Called from visitor
   * @param ST
   */
  @Override
  public void Check(SymbolTable ST) {
    //Do symbol table stuff
  }

  /**
   * Used for testing - Prints out contents of current AST node
   */
  @Override
  public void printContents() {
    System.out.println(this.getClass().getSimpleName() + ": ");
    super.printContents();
    if (expr == null) {
      System.out.println("expr: null");
    } else {
      System.out.println("expr: has content");
    }
  }

  /**
   * Used to flag special cases where the register needs a stack implementation before the backend parse
   * @param regAlloc
   */
  @Override
  public void acceptPreProcess(RegisterAllocation regAlloc) {
    expr.acceptPreProcess(regAlloc);
  }

  /**
   * Part of the visitor code gen pattern, used to generate the instruction classes
   * which are added to the instruction list
   * @param visitor
   */
  public void accept(AST_NodeVisitor visitor) {
    visitor.visit(this);
    expr.accept(visitor);
  }

  /**
   * General case to call acceptNode
   * @param visitor
   */
  public int acceptRootNode(AST_NodeVisitor visitor) {
    visitor.visit(this);

    int result = 0;

    if (expr instanceof AST_ExprLiter) {
      result = ((AST_ExprLiter) expr).acceptNode(visitor);
    } else if (expr instanceof AST_ExprBinary) {
      result = ((AST_ExprBinary) expr).acceptNode(visitor);
    } else if (expr instanceof AST_ExprUnary) {
      result = ((AST_ExprUnary) expr).acceptNode(visitor);
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
    expr.acceptInstr(assemblyCode);

    switch (statName) {
      case ("free"):
        InstructionFreePair instructionFreePair = (InstructionFreePair) instr;
        assemblyCode.add(instructionFreePair.getResultBlock());
        break;

      case ("return"):
        InstructionReturn instructionReturn = (InstructionReturn) instr;
        assemblyCode.add(instructionReturn.getResultBlock());
        break;

      case ("exit"):
        InstructionExit instructionExit = (InstructionExit) instr;
        assemblyCode.add(instructionExit.getResultBlock());
        break;

      case ("println"):
      case ("print"):
        InstructionPrint instructionPrint = (InstructionPrint) instr;
        assemblyCode.add(instructionPrint.getResultBlock());
        if (statName.equals("println")) {
          InstructionPrintln instructionPrintln = (InstructionPrintln) instrPrintLine;
          assemblyCode.add(instructionPrintln.getResultBlock());
        }
        break;
      default:
        System.out.println("Unrecognised statement type in AST_StatExpr");
    }

  }

  /**
   * Evaluate both sides of the stat assign and store their results in the registers
   * Returns a null reg as there is no result evaluation
   */
  @Override
  public RegisterARM acceptRegister(RegisterAllocation registerAllocation) throws Exception {

    RegisterARM evalResult = expr.acceptRegister(registerAllocation);
    String type;

    switch (statName) {
      case ("free"):

        try {
          InstructionFreePair instructionFreePair = (InstructionFreePair) instr;
          instructionFreePair.allocateRegisters(RegisterARM.r0, evalResult);
          registerAllocation.freeRegister(evalResult);

        } catch (ClassCastException e) {

        }
        break;

      case ("return"):
        InstructionReturn instructionReturn = (InstructionReturn) instr;
        instructionReturn.allocateRegisters(RegisterARM.r0, evalResult);
        registerAllocation.freeRegister(evalResult);
        break;

      case ("exit"):
        InstructionExit instructionExit = (InstructionExit) instr;
        instructionExit.allocateRegisters(RegisterARM.r0, evalResult);
        registerAllocation.freeRegister(evalResult);

        break;

      case ("println"):
        InstructionPrintBlocksLn instructionPrintLn = (InstructionPrintBlocksLn) instrPrintLn;
        instructionPrintLn.allocateRegisters(RegisterARM.r0);

      case ("print"):

        type = expr.getType();


        if (type != null) {

          switch (type) {
            case ("int"):
              InstructionPrintBlocksInt instructionPrintBlocksInt = (InstructionPrintBlocksInt) instrPrintType;
              instructionPrintBlocksInt.allocateRegisters(RegisterARM.r0, RegisterARM.r1);
              break;
            case ("string"):  //falls through to "str" case.
            case ("str"):
              InstructionPrintBlocksString instructionPrintString = (InstructionPrintBlocksString) instrPrintType;
              instructionPrintString.allocateRegisters(RegisterARM.r0, RegisterARM.r1, RegisterARM.r2);
              break;
            case ("char"):
              break;
            case ("pair"):
              if (expr instanceof AST_ExprLiter) {

              } else {
                InstructionPrintBlocksRef instrPrintBlocksRef = (InstructionPrintBlocksRef) instrPrintType;
                instrPrintBlocksRef.allocateRegisters(RegisterARM.r0, RegisterARM.r1);
              }

              break;
            case ("array"):
              InstructionPrintBlocksRef instructionPrintBlocksRef = (InstructionPrintBlocksRef) instrPrintType;
              instructionPrintBlocksRef.allocateRegisters(RegisterARM.r0, RegisterARM.r1);
              break;

            case ("bool"):
              InstructionPrintBlocksBool instructionPrintBool = (InstructionPrintBlocksBool) instrPrintType;
              instructionPrintBool.allocateRegisters(RegisterARM.r0);
              break;
            default:
              break;
          }


          InstructionPrint instructionPrint = (InstructionPrint) instr;
          instructionPrint.allocateRegisters(RegisterARM.r0, evalResult);
          registerAllocation.freeRegister(evalResult);

        } else {

          InstructionPrint instructionPrint = (InstructionPrint) instr;
          instructionPrint.allocateRegisters(RegisterARM.r0, evalResult);
          registerAllocation.freeRegister(evalResult);
        }

        break;
      default:
        System.out.println("Unrecognised statement type in AST_StatExpr");
    }

    return RegisterARM.NULL_REG;
  }

  /**
   * FREE expr
   * RETURN expr
   * EXIT expr
   * PRINT expr
   * PRINTLN expr
   */

  /**
   * @return Return false if already contain block
   */
  public boolean blockContains() {

    return false;
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

    switch (statName) {
      case ("free"):
        registerAllocation.addString("NullReferenceError: dereference a null reference\\n\\0");
        InstructionFreePair instructionFreePair = new InstructionFreePair();
        instructionList.add(instructionFreePair);

        InstructionFreePairBlock instructionFreePairBlock = new InstructionFreePairBlock(registerAllocation.getStringID("NullReferenceError: dereference a null reference\\n\\0"));
        InstructionErrorRuntime instructionErrorRuntime = new InstructionErrorRuntime();
        String strMsg = "%.*s\\0";
        registerAllocation.addString(strMsg);
        InstructionPrintBlocksString instructionPrintBlocksString = new InstructionPrintBlocksString(registerAllocation.getStringID(strMsg));
        instructionList.add(instructionPrintBlocksString);
        instructionList.add(instructionFreePairBlock);
        instructionList.add(instructionErrorRuntime);

        instr = instructionFreePair;
        break;

      case ("return"):
        InstructionReturn instructionReturn = new InstructionReturn(expr.getType());
        instructionList.add(instructionReturn);
        instr = instructionReturn;
        break;

      case ("exit"):
        InstructionExit instructionExit = new InstructionExit();
        instructionList.add(instructionExit);
        instr = instructionExit;
        break;

      case ("println"):
        //No break so it executes print too
        registerAllocation.addString("\\0");
        InstructionPrintBlocksLn instructionPrintLn = new InstructionPrintBlocksLn(registerAllocation.getStringID("\\0"));
        instructionList.add(instructionPrintLn);
        instrPrintLn = instructionPrintLn;
      case ("print"):
        if (expr instanceof AST_ExprArrayElem) {
          AST_ExprArrayElem tempNode = (AST_ExprArrayElem) expr;
          tempNode.setExprType();
        }
        String type = expr.getType();


        if (expr instanceof  AST_ExprEnclosed){
          AST_ExprEnclosed tempNode = (AST_ExprEnclosed) expr;
          type = getEmebeddedType(tempNode);
        }

        if (type != null) {
          switch (type) {
            case ("int"):
              registerAllocation.addString("%d\\0");
              InstructionPrintBlocksInt instructionPrintInt = new InstructionPrintBlocksInt(registerAllocation.getStringID("%d\\0"));


              instructionList.add(instructionPrintInt);


              instrPrintType = instructionPrintInt;
              break;
            case ("string"):    //"string" case falls through to "str" case to prevent issues.
            case ("str"):
              registerAllocation.addString("%.*s\\0");
              InstructionPrintBlocksString instructionPrintString = new InstructionPrintBlocksString(registerAllocation.getStringID("%.*s\\0"));

                instructionList.add(instructionPrintString);



              instrPrintType = instructionPrintString;
              break;
            case ("char"):
              break;
            case ("pair"):
              //No break since pair and array are the same
              if (expr instanceof AST_ExprLiter) {
                registerAllocation.addString("%p\\0");
                InstructionPrintBlocksRef instructionPrintBlocksRef = new InstructionPrintBlocksRef(registerAllocation.getStringID("%p\\0"));
                instructionList.add(instructionPrintBlocksRef);
                instrPrintType = instructionPrintBlocksRef;
              }
              break;

            case ("bool"):
              registerAllocation.addString("true\\0");
              registerAllocation.addString("false\\0");
              InstructionPrintBlocksBool instructionPrintBool = new InstructionPrintBlocksBool(
                  registerAllocation.getStringID("true\\0"),
                  registerAllocation.getStringID("false\\0"));
              instructionList.add(instructionPrintBool);
              instrPrintType = instructionPrintBool;
              break;
            default:
              if(type.contains("[") || type.contains("PAIR")){
                registerAllocation.addString("%p\\0");
                InstructionPrintBlocksRef instructionPrintBlocksRef = new InstructionPrintBlocksRef(registerAllocation.getStringID("%p\\0"));
                instructionList.add(instructionPrintBlocksRef);
                instrPrintType = instructionPrintBlocksRef;
              }
              System.out.println("type is : " + type);
              break;
          }


          InstructionPrintln instructionPrintlnLine = new InstructionPrintln();
          instructionList.add(instructionPrintlnLine);
          instrPrintLine = instructionPrintlnLine;


          InstructionPrint instructionPrint = new InstructionPrint(type);
          instructionList.add(instructionPrint);
          instr = instructionPrint;

        } else {

          InstructionPrintln instructionPrintlnLine = new InstructionPrintln();
          instructionList.add(instructionPrintlnLine);
          instrPrintLine = instructionPrintlnLine;
          String emebededType = "null";
          if (expr instanceof AST_ExprBinary) {
            AST_ExprBinary tempNode = (AST_ExprBinary) expr;
            emebededType = getEmebeddedType(tempNode);
          } else if (expr instanceof AST_ExprUnary) {
            AST_ExprUnary tempNode = (AST_ExprUnary) expr;
            emebededType = getEmebeddedType(tempNode);
          }

          InstructionPrint instructionPrint = new InstructionPrint(emebededType);
          instructionList.add(instructionPrint);
          instr = instructionPrint;

        }
        break;


      default:
        System.out.println("Unrecognised statement type in AST_StatExpr");
    }

  }

  /**
   * @param root
   * @return Return the type of the embedded root node, otherwise return null
   */
  public String getEmebeddedType(AST_Node root) {

    //Go from root to a terminal node either AST_ExprIdent or AST_ExprLit
    if (root.getNodes() != null) {
      for (AST_Node node : root.getNodes()) {
        if (node instanceof AST_ExprIdent) {
          AST_ExprIdent tempNode = (AST_ExprIdent) node;
          return tempNode.getType();
        } else if (node instanceof AST_ExprLiter) {
          AST_ExprLiter tempNode = (AST_ExprLiter) node;
          return tempNode.getLiteral();
        } else if (node instanceof AST_Separator){
          continue;
        }
        System.out.println(node.getClass().getSimpleName());
        return getEmebeddedType(node);
      }
    } else {
      System.out.println("Root node is a terminal node");
      System.out.println("root is " + root.getClass().getSimpleName());
    }
    return "null";
  }

}

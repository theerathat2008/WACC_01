package ASTNodes.AST_Stats;

import ASTNodes.AST_Exprs.*;
import ASTNodes.AST_FuncDecl;
import ASTNodes.AST_Node;
import ASTNodes.AST_Program;
import IdentifierObjects.IDENTIFIER;
import InstructionSet.*;
import InstructionSet.InstructionError.InstructionErrorRuntime;
import InstructionSet.InstructionPrintBlocks.*;
import InstructionSet.InstructionPrintBlocks.InstructionPrintBlocksBool;
import InstructionSet.InstructionPrintBlocks.InstructionPrintBlocksString;
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
   *
   * @param ctx
   */
  public AST_StatExpr(ParserRuleContext ctx, SymbolTable symbolTable) {
    this.expr = null;
    this.ctx = ctx;
    this.symbolTable = symbolTable;
  }

  /**
   * Gets all children nodes of current node
   *
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
      System.out.println(expr);
      System.out.println(expr.getIdentifier());
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
   *
   * @param ST
   */
  @Override
  public void Check(SymbolTable ST) {
    //CheckSemantics(ST))
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

  public void accept(AST_NodeVisitor visitor) {
    visitor.visit(this);
    expr.accept(visitor);
  }

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

  @Override
  public void acceptRegister(RegisterAllocation registerAllocation) throws Exception {
//    String type;
//    System.out.println("StatName is: " + statName);
//
//
//    switch (statName) {
//      case ("free"):
//
//        break;
//
//      case ("return"):
//        registerAllocation.useRegister("expr");
//        expr.acceptRegister(registerAllocation);
//
//        RegisterARM reg2 = registerAllocation.searchByValue("expr");
//        InstructionReturn instructionReturn = (InstructionReturn) instr;
//        instructionReturn.allocateRegisters(RegisterARM.r0, reg2);
//        registerAllocation.freeRegister(reg2);
//        break;
//
//      case ("exit"):
//        registerAllocation.useRegister("expr");
//        expr.acceptRegister(registerAllocation);
//
//        RegisterARM reg1 = registerAllocation.searchByValue("expr");
//        InstructionExit instructionExit = (InstructionExit) instr;
//        instructionExit.allocateRegisters(RegisterARM.r0, reg1);
//        registerAllocation.freeRegister(reg1);
//
//        break;
//
//      case ("println"):
//
//
//        InstructionPrintBlocksLn instructionPrintLn = (InstructionPrintBlocksLn) instrPrintLn;
//        instructionPrintLn.allocateRegisters(RegisterARM.r0);
//
//
//      case ("print"):
//        type = expr.getType();
//        System.out.println("Type is at print: " + type);
//
//        if (type != null) {
//
//          switch (type) {
//            case ("int"):
//              InstructionPrintBlocksInt instructionPrintBlocksInt = (InstructionPrintBlocksInt) instrPrintType;
//              instructionPrintBlocksInt.allocateRegisters(RegisterARM.r0, RegisterARM.r1);
//              break;
//            case ("string"):  //falls through to "str" case.
//            case ("str"):
//              InstructionPrintBlocksString instructionPrintString = (InstructionPrintBlocksString) instrPrintType;
//              instructionPrintString.allocateRegisters(RegisterARM.r0, RegisterARM.r1, RegisterARM.r2);
//              break;
//            case ("char"):
//              //CHECK IS CHAR IS NEEDED
//              break;
//            case ("pair"):
//              //No break since pair and array are the same
//            case ("array"):
//              InstructionPrintBlocksRef instructionPrintBlocksRef = (InstructionPrintBlocksRef) instrPrintType;
//              instructionPrintBlocksRef.allocateRegisters(RegisterARM.r0, RegisterARM.r1);
//              break;
//
//            case ("bool"):
//              InstructionPrintBlocksBool instructionPrintBool = (InstructionPrintBlocksBool) instrPrintType;
//              instructionPrintBool.allocateRegisters(RegisterARM.r0);
//            default:
//              break;
//          }
//
//          RegisterARM reg3 = registerAllocation.useRegister("expr");
//
//          expr.acceptRegister(registerAllocation);
//
//          InstructionPrint instructionPrint = (InstructionPrint) instr;
//          System.out.println("Allocating registers for print: " + reg3);
//          instructionPrint.allocateRegisters(RegisterARM.r0, reg3);
//
//        } else {
//          RegisterARM reg3 = registerAllocation.useRegister("result");
//
//          expr.acceptRegister(registerAllocation);
//
//
//          InstructionPrint instructionPrint = (InstructionPrint) instr;
//          //System.out.println("Allocating registers for print: " + reg3);
//          instructionPrint.allocateRegisters(RegisterARM.r0, reg3);
//        }
//
//
//        break;
//      default:
//        System.out.println("Unrecognised statement type in AST_StatExpr");
//    }
  }


  /**
   * FREE expr
   * RETURN expr
   * EXIT expr
   * PRINT expr
   * PRINTLN expr
   */


  public void genInstruction(List<Instruction> instructionList, RegisterAllocation registerAllocation) throws Exception {
    //TODO Delete Unimplememnted Intstructionstatexpr class

    //REGISTER ALLOCATION TODO
    //SP ALLOCATION TODO
    System.out.println("Statement type is: " + statName);

    switch (statName) {
      case ("free"):
        registerAllocation.addString("NullReferenceError: dereference a null reference\\n\\0");
        InstructionFreePair instructionFreePair = new InstructionFreePair();
        instructionList.add(instructionFreePair);

        InstructionFreePairBlock instructionFreePairBlock = new InstructionFreePairBlock(registerAllocation.getStringID("NullReferenceError: dereference a null reference\\n\\0"));
        InstructionErrorRuntime instructionErrorRuntime = new InstructionErrorRuntime();
        if (!instructionList.contains(instructionFreePairBlock)) {
          instructionList.add(instructionFreePairBlock);
          //TODO put this at special position of list dedicated to end of file instructions.
        }
        if (!instructionList.contains(instructionErrorRuntime)) {
          instructionList.add(instructionErrorRuntime);
        }

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
        if (!instructionList.contains(instructionPrintLn)) {
          instructionList.add(instructionPrintLn);
        }
        instrPrintLn = instructionPrintLn;

        break;
      case ("print"):
        String type = expr.getType();
        if (type != null) {
          switch (type) {
            case ("int"):
              registerAllocation.addString("%d\\0");
              InstructionPrintBlocksInt instructionPrintInt = new InstructionPrintBlocksInt(registerAllocation.getStringID("%d\\0"));
              if (!instructionList.contains(instructionPrintInt)) {
                instructionList.add(instructionPrintInt);
              }
              instrPrintType = instructionPrintInt;
              break;
            case ("string"):    //"string" case falls through to "str" case to prevent issues.
            case ("str"):
              registerAllocation.addString("%.*s\\0");
              InstructionPrintBlocksString instructionPrintString = new InstructionPrintBlocksString(registerAllocation.getStringID("%.*s\\0"));
              if (!instructionList.contains(instructionPrintString)) {
                instructionList.add(instructionPrintString);
              }
              instrPrintType = instructionPrintString;
              break;
            case ("char"):
              break;
            case ("pair"):
              //No break since pair and array are the same
            case ("array"):
              registerAllocation.addString("%p\\0");
              InstructionPrintBlocksRef instructionPrintBlocksRef = new InstructionPrintBlocksRef(registerAllocation.getStringID("%p\\0"));
              if (!instructionList.contains(instructionPrintBlocksRef)) {
                instructionList.add(instructionPrintBlocksRef);
              }
              instrPrintType = instructionPrintBlocksRef;
              break;

            case ("bool"):
              registerAllocation.addString("true");
              registerAllocation.addString("false");
              InstructionPrintBlocksBool instructionPrintBool = new InstructionPrintBlocksBool(registerAllocation.getStringID("true"), registerAllocation.getStringID("false"));
              if (!instructionList.contains(instructionPrintBool)) {
                instructionList.add(instructionPrintBool);
              }
              instrPrintType = instructionPrintBool;
            default:
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
            System.out.println("BINAAAAAAAAAAAAAAAAAAAAA");

          } else if (expr instanceof AST_ExprUnary) {
            AST_ExprUnary tempNode = (AST_ExprUnary) expr;
            emebededType = getEmebeddedType(tempNode);
          }

          System.out.println("Embedded null type is: " + emebededType);

          InstructionPrint instructionPrint = new InstructionPrint(emebededType);
          instructionList.add(instructionPrint);
          instr = instructionPrint;

        }


        break;
      default:
        System.out.println("Unrecognised statement type in AST_StatExpr");
    }

  }

  public String getEmebeddedType(AST_Node root) {
    if (root.getNodes() != null) {
      for (AST_Node node : root.getNodes()) {
        if (node instanceof AST_ExprIdent) {
          AST_ExprIdent tempNode = (AST_ExprIdent) node;
          return tempNode.getType();
        } else if (node instanceof AST_ExprLiter) {
          AST_ExprLiter tempNode = (AST_ExprLiter) node;
          return tempNode.getLiteral();
        }
        getEmebeddedType(node);
      }
    }
    return null;
  }

}

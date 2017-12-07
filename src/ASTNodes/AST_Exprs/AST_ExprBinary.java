package ASTNodes.AST_Exprs;

import ASTNodes.AST_Node;
import ErrorMessages.TypeError;
import ErrorMessages.TypeMismatchError;
import ErrorMessages.FilePosition;
import InstructionSet.Instruction;

import Registers.RegisterUsage;

import InstructionSet.InstructionBlocks.InstructionError.InstructionDivByZero;
import InstructionSet.InstructionBlocks.InstructionError.InstructionErrorOverflow;
import InstructionSet.InstructionBlocks.InstructionError.InstructionErrorRuntime;
import InstructionSet.InstructionBlocks.InstructionPrintBlocks.InstructionPrintBlocksInt;
import InstructionSet.InstructionBlocks.InstructionPrintBlocks.InstructionPrintBlocksString;

import org.antlr.v4.runtime.ParserRuleContext;
import InstructionSet.InstructionArithmetic;
import InstructionSet.InstructionComparison;
import Registers.RegisterARM;
import Registers.RegisterAllocation;
import SymbolTable.SymbolTable;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import static Registers.RegisterUsageBuilder.*;

import VisitorClass.AST_NodeVisitor;
import IdentifierObjects.*;

import static java.lang.System.exit;

import ASTNodes.AST_Program;

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
  SymbolTable symbolTable;
  ParserRuleContext ctx;
  AST_Program program;

  /**
   * Constructor for class - initialises class variables to NULL
   */
  public AST_ExprBinary(ParserRuleContext ctx, SymbolTable symbolTable, AST_Program program) {
    this.exprLeftAST = null;
    this.exprRightAST = null;
    this.opName = null;
    this.symbolTable = symbolTable;
    this.ctx = ctx;
    this.program = program;
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
   */
  @Override
  public boolean CheckSemantics() {

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

    SymbolTable ST = this.symbolTable;

    //constantEvaluation();

    if (exprLeftAST instanceof AST_ExprIdent) {
      SymbolTable tempST = ST;
      String varNameLHS = ((AST_ExprIdent) exprLeftAST).getVarName();
      IDENTIFIER typeLHS = tempST.lookup(varNameLHS);

      while (typeLHS == null) {
        tempST = tempST.encSymTable;
        typeLHS = tempST.lookup(varNameLHS);
      }

      if (typeLHS.toString().contains("[]")) {
        new TypeError(new FilePosition(ctx)).printAll();
        return false;
      }
    }

    if (exprRightAST instanceof AST_ExprIdent) {

    }

    if (opName.equals("+") || opName.equals("-")) {

      if (exprLeftAST instanceof AST_ExprIdent && exprRightAST instanceof AST_ExprIdent) {
        String varNameLHS = ((AST_ExprIdent) exprLeftAST).getVarName();
        SymbolTable tempLHSST = ST;
        IDENTIFIER typeLHS = tempLHSST.lookup(varNameLHS);

        while (typeLHS == null) {
          tempLHSST = tempLHSST.encSymTable;
          typeLHS = tempLHSST.lookup(varNameLHS);
        }

        String varNameRHS = ((AST_ExprIdent) exprRightAST).getVarName();
        SymbolTable tempRHSST = ST;
        IDENTIFIER typeRHS = tempRHSST.lookup(varNameRHS);

        while (typeRHS == null) {
          tempRHSST = tempRHSST.encSymTable;
          try {
            typeRHS = tempRHSST.lookup(varNameRHS);
          } catch (NullPointerException e) {
            typeRHS = null;
            break;
          }
        }

        if (typeRHS == null) {
          System.out.println("Errors detected during compilation! Exit code 200 returned.");
          System.out.println("#semantic_error#");
          System.out.println("Error: Undecalred variable access");
          exit(200);
          return false;
        }

        if (!typeLHS.toString().contains(typeRHS.toString())) {
          new TypeMismatchError(new FilePosition(ctx)).printAll();
          return false;
        }
      }

      if (exprLeftAST.getIdentifier() != null && exprRightAST.getIdentifier() != null) {
        IDENTIFIER typeLHS = exprLeftAST.getIdentifier();
        IDENTIFIER typeRHS = exprRightAST.getIdentifier();

        //can only be of type int
        if (!typeLHS.toString().contains("int")) {
          new TypeError(new FilePosition(ctx)).printAll();
          return false;
        }

        if (!typeLHS.toString().contains(typeRHS.toString())) {
          new TypeMismatchError(new FilePosition(ctx)).printAll();
          return false;
        }

        if (typeLHS.toString().contains(typeRHS.toString())
            || typeRHS.toString().contains(typeLHS.toString())) {
          return true;
        } else {
          new TypeMismatchError(new FilePosition(ctx)).printAll();
          return false;
        }
      }
    } else if (opName.equals("<") || opName.equals(">")) {
      if (exprLeftAST instanceof AST_ExprIdent) {
        String varNameLHS = ((AST_ExprIdent) exprLeftAST).getVarName();
        SymbolTable tempST = ST;
        IDENTIFIER typeLHS = tempST.lookup(varNameLHS);

        while (typeLHS == null) {
          tempST = tempST.encSymTable;
          typeLHS = tempST.lookup(varNameLHS);
        }

        if (typeLHS.toString().contains("PAIR(")) {
          new TypeError(new FilePosition(ctx)).printAll();
          return false;
        }

      }
    } else if (opName.equals("||") || opName.equals("&&")) {
      //expect type bool arguments
      if (exprLeftAST.getIdentifier() != null) {
        if (!exprLeftAST.getIdentifier().toString().contains("bool")) {
          new TypeError(new FilePosition(ctx)).printAll();
          return false;
        }
      }
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

  @Override
  public void acceptPreProcess(RegisterAllocation regAlloc) {
    exprLeftAST.acceptPreProcess(regAlloc);
    exprRightAST.acceptPreProcess(regAlloc);
  }

  public void accept(AST_NodeVisitor visitor) {
    visitor.visit(this);
    exprLeftAST.accept(visitor);
    exprRightAST.accept(visitor);
  }

  public int acceptNode(AST_NodeVisitor visitor) {
    visitor.visit(this);

    System.out.println("+++++++++++++++++++++++++++++++++");
    System.out.println("Start evaluating constant");

    if (exprLeftAST instanceof AST_ExprIdent) {
      System.out.println("exprLeftAST is instance of AST_ExprIdent");
      System.out.println("Not evaluating");
    }

    if (exprRightAST instanceof AST_ExprIdent) {
      System.out.println("exprRightAST is instance of AST_ExprIdent");
      System.out.println("Not evaluating");
    }

    //The parser already did the precedence work
    //call from class in that use expr
    int result = 0;

    if (exprLeftAST instanceof AST_ExprLiter && exprRightAST instanceof AST_ExprLiter) {
      int result1 = ((AST_ExprLiter) exprLeftAST).acceptNode(visitor);
      int result2 = ((AST_ExprLiter) exprRightAST).acceptNode(visitor);

      String exprLeft = ((AST_ExprLiter) exprLeftAST).getConstant();
      String exprRight = ((AST_ExprLiter) exprRightAST).getConstant();

      //add precedences
      if (opName.equals("+")) {
        result = result1 + result2;
      } else if (opName.equals("-")) {
        result = result1 - result2;
      } else if (opName.equals("*")) {
        result = result1 * result2;
      } else if (opName.equals("/")) {
        result = result1 / result2;
      } else if (opName.equals("%")) {
        result = result1 % result2;
      } else if (opName.equals("&&") || opName.equals("||")) {
        if (opName.equals("&&")) {
          //only case that is true must be when both sides are true
          if (exprLeft.equals("true") && exprRight.equals("true")) {
            result = 1;
          }
        } else if (opName.equals("||")) {
          //only false case is when both are false
          if (!(exprLeft.equals("false") && exprRight.equals("false"))) {
            result = 1;
          }
        }
      }
    } else if (exprLeftAST instanceof AST_ExprLiter) {

      if (exprRightAST instanceof AST_ExprBinary) {
        int result1 = ((AST_ExprLiter) exprLeftAST).acceptNode(visitor);

        //needs to get the result of previous binary oper first inorder to do arithmetic
        int result2 = ((AST_ExprBinary) exprRightAST).acceptNode(visitor);

        String exprLeft = ((AST_ExprLiter) exprLeftAST).getConstant();
        String exprRight = String.valueOf(result2);
        if (result2 == 1) {
          exprRight = "true";
        } else if (result2 == 0) {
          exprRight = "false";
        }

        if (opName.equals("+")) {
          result = result1 + result2;
        } else if (opName.equals("-")) {
          result = result1 - result2;
        } else if (opName.equals("*")) {
          result = result1 * result2;
        } else if (opName.equals("/")) {
          result = result1 / result2;
        } else if (opName.equals("%")) {
          result = result1 % result2;
        } else if (opName.equals("&&") || opName.equals("||")) {
          if (opName.equals("&&")) {
            //only case that is true must be when both sides are true
            if (exprLeft.equals("true") && exprRight.equals("true")) {
              result = 1;
            }
          } else if (opName.equals("||")) {
            //only false case is when both are false
            if (!(exprLeft.equals("false") && exprRight.equals("false"))) {
              result = 1;
            }
          }
        }
      }

    } else if (exprRightAST instanceof AST_ExprLiter) {
      int result2 = ((AST_ExprLiter) exprRightAST).acceptNode(visitor);

      if (exprLeftAST instanceof AST_ExprBinary) {
        int result1 = ((AST_ExprBinary) exprLeftAST).acceptNode(visitor);

        String exprLeft = String.valueOf(result1);
        if (result1 == 1) {
          exprLeft  = "true";
        } else if (result1 == 0) {
          exprLeft = " false";
        }

        String exprRight = ((AST_ExprLiter) exprRightAST).getConstant();

        if (opName.equals("+")) {
          result = result1 + result2;
        } else if (opName.equals("-")) {
          result = result1 - result2;
        } else if (opName.equals("*")) {
          result = result1 * result2;
        } else if (opName.equals("/")) {
          result = result1 / result2;
        } else if (opName.equals("%")) {
          result = result1 % result2;
        } else if (opName.equals("&&") || opName.equals("||")) {
          if (opName.equals("&&")) {
            //only case that is true must be when both sides are true
            if (exprLeft.equals("true") && exprRight.equals("true")) {
              result = 1;
            }
          } else if (opName.equals("||")) {
            //only false case is when both are false
            if (!(exprLeft.equals("false") && exprRight.equals("false"))) {
              result = 1;
            }
          }
        }
      }
    } else if (exprLeftAST instanceof AST_ExprBinary && exprRightAST instanceof AST_ExprBinary) {
      //when the two cases are instance of AST_ExprBinary
      int result1 = ((AST_ExprBinary) exprLeftAST).acceptNode(visitor);
      int result2 = ((AST_ExprBinary) exprRightAST).acceptNode(visitor);

      String exprLeft = String.valueOf(result1);
      if (result1 == 1) {
        exprLeft = "true";
      } else if (result1 == 0) {
        exprLeft = "false";
      }

      String exprRight = String.valueOf(result2);
      if (result2 == 1) {
        exprRight = "true";
      } else if (result2 == 0) {
        exprRight = "false";
      }

      if (opName.equals("+")) {
        result = result1 + result2;
      } else if (opName.equals("-")) {
        result = result1 - result2;
      } else if (opName.equals("*")) {
        result = result1 * result2;
      } else if (opName.equals("/")) {
        result = result1 / result2;
      } else if (opName.equals("%")) {
        result = result1 % result2;
      } else if (opName.equals("&&") || opName.equals("||")) {
        if (opName.equals("&&")) {
          //only case that is true must be when both sides are true
          if (exprLeft.equals("true") && exprRight.equals("true")) {
            result = 1;
          }
        } else if (opName.equals("||")) {
          //only false case is when both are false
          if (!(exprLeft.equals("false") && exprRight.equals("false"))) {
            result = 1;
          }
        }
      }
    }

    System.out.println(result);
    return result;
  }

  @Override
  public void acceptInstr(List<String> assemblyCode) {
    exprLeftAST.acceptInstr(assemblyCode);
    exprRightAST.acceptInstr(assemblyCode);
    if (opName.equals("*") || opName.equals("/") || opName.equals("%") || opName.equals("+") || opName.equals("-")) {
      assemblyCode.add(instrA.block1);
    } else {
      assemblyCode.add(instrC.block1);
    }
  }

  /**
   * Want to store the evaluation of the two registers result of the binary expression
   * Format is expr BinOp expr
   * Store the returned result of the two expr into a result reg
   * Free the two registers after having got the evaluation of the two stores in the regs
   */


  @Override

  public RegisterARM acceptRegister(RegisterAllocation registerAllocation) throws Exception {


    RegisterARM regLeft = exprLeftAST.acceptRegister(registerAllocation);
    RegisterARM regRight = exprRightAST.acceptRegister(registerAllocation);

    registerAllocation.freeRegister(regLeft);
    registerAllocation.freeRegister(regRight);

    RegisterUsage resultUsage = aRegisterUsageBuilder()
        .withUsageType("exprType")
        .withSubType("resultType")
        .withScope(registerAllocation.getCurrentScope())
        .withOperationType(opName)
        .build();
    RegisterARM dst = registerAllocation.useRegister(resultUsage);

    if ( opName.equals("+") || opName.equals("-")) {
      instrA.allocateRegisters(dst, regLeft, regRight);
    } else if(opName.equals("*")){
      dst = regLeft;
      instrA.allocateRegisters(RegisterARM.NULL_REG, regLeft, regRight);
    } else if(opName.equals("/")){
      dst = RegisterARM.r0;
      instrA.allocateRegisters(RegisterARM.NULL_REG, regLeft, regRight);
    } else if (opName.equals("%")){
      dst = RegisterARM.r1;
      instrA.allocateRegisters(RegisterARM.NULL_REG, regLeft, regRight);
    } else {
      instrC.allocateRegisters(regLeft, regRight, dst);
    }
    return dst;
  }


  /**
   * Generates assembly code in InstructionComparison and InstructionArithmetic depending on the
   * opName:  MULT   *  Needs registers to be allocated  InstructionArithmetic
   * DIV    /  Needs registers to be allocated  InstructionArithmetic
   * MOD    %  Needs registers to be allocated  InstructionArithmetic
   * PLUS   +  Needs registers to be allocated  InstructionArithmetic
   * MINUS  -  Needs registers to be allocated  InstructionArithmetic
   * <p>
   * GRTHAN >  Needs registers to be allocated  InstructionComparison
   * GREQTO >= Needs registers to be allocated  InstructionComparison
   * LSTHAN <  Needs registers to be allocated  InstructionComparison
   * LSEQTO <= Needs registers to be allocated  InstructionComparison
   * EQTO   == Needs registers to be allocated  InstructionComparison
   * NEQTO  != Needs registers to be allocated  InstructionComparison
   * AND    && Needs registers to be allocated  InstructionComparison
   * OR     || Needs registers to be allocated  InstructionComparison
   * TODO ALLOCATE REGISTER HERE
   */

  public void genInstruction(List<Instruction> instructionList, RegisterAllocation registerAllocation) throws Exception {

    if (opName.equals("*") || opName.equals("/") || opName.equals("%") || opName.equals("+") || opName.equals("-")) {
      InstructionArithmetic instructionArithmetic = new InstructionArithmetic(opName);

      instructionList.add(instructionArithmetic);
      instrA = instructionArithmetic;
    } else {


      InstructionComparison instructionCompare = new InstructionComparison(opName);
      //RegisterARM reg1, RegisterARM reg2, RegisterARM reg3


      instructionList.add(instructionCompare);
      instrC = instructionCompare;

    }

    if (opName.equals("+") || opName.equals("-") || opName.equals("*")) {
      registerAllocation.addString("OverflowError: the result is too small/large to store in a 4-byte signed-integer.\\n");
      InstructionErrorOverflow errorOverflow = new InstructionErrorOverflow(registerAllocation.
              getStringID("OverflowError: the result is too small/large to store in a 4-byte signed-integer.\\n"));
      instructionList.add(errorOverflow);
      registerAllocation.addString("%.*s\\0");
      InstructionPrintBlocksString instructionPrintString = new InstructionPrintBlocksString(registerAllocation.getStringID("%.*s\\0"));
      instructionList.add(instructionPrintString);

      instructionList.add(new InstructionErrorRuntime());
    }

    if (opName.equals("/") || opName.equals("%")) {
      registerAllocation.addString("DivideByZeroError: divide or modulo by zero\\n\\0");
      InstructionDivByZero divByZero = new InstructionDivByZero();
      divByZero.setOutputMessageNumber(registerAllocation.
              getStringID("DivideByZeroError: divide or modulo by zero\\n\\0"));
      instructionList.add(divByZero);
      registerAllocation.addString("%.*s\\0");
      InstructionPrintBlocksString instructionPrintString = new InstructionPrintBlocksString(registerAllocation.getStringID("%.*s\\0"));
      instructionList.add(instructionPrintString);

      instructionList.add(new InstructionErrorRuntime());
    }
  }

  public AST_Expr getExprLeftAST() {
    return exprLeftAST;
  }

  public AST_Expr getExprRightAST() {
    return exprRightAST;
  }

  public int constantEvaluation() {

    //left to right

    System.out.println("+++++++++++++++++++++++++++++++++");
    System.out.println("Start evaluating constant");
    SymbolTable ST = this.symbolTable;
    int result = 0;
    String exprLeft = "0";
    String exprRight = "0";

    System.out.println(exprLeftAST.getClass().getSimpleName());
    System.out.println(exprRightAST.getClass().getSimpleName());

    if (exprLeftAST instanceof AST_ExprLiter) {
      System.out.println("exprLeftAST is instance of AST_ExprLiter");
      exprLeft = ((AST_ExprLiter) exprLeftAST).getConstant();
      System.out.println("exprLeft is: " + exprLeft);
    }

    if (exprRightAST instanceof AST_ExprLiter) {
      System.out.println("exprRightAST is instance of AST_ExprLiter");
      exprRight = ((AST_ExprLiter) exprRightAST).getConstant();
      System.out.println("exprRight is: " + exprRight);
    }

    if (exprLeftAST instanceof AST_ExprIdent) {
      System.out.println("exprLeftAST is instance of AST_ExprIdent");
      System.out.println("Not evaluating");
    }

    if (exprRightAST instanceof AST_ExprIdent) {
      System.out.println("exprRightAST is instance of AST_ExprIdent");
      System.out.println("Not evaluating");
    }

    //TODO maybe needs to check the type first
    //what to do if it's nested?
    //it is iterating from right ot left and left is instance of AST_ExprBinary
    //loop until instance of ExprLiter
    //don't forget to clear when both sides are AST_ExprIdent
    //needs to think of precedences as well


    //if both are instance of exprLiter, we can calculate the result immediately
    if (exprLeftAST instanceof AST_ExprLiter && exprRightAST instanceof AST_ExprLiter) {
      System.out.println("Both exprLeftAST and exprRightAST are instance of AST_ExprLiter");
      //if listInt and listOp are empty, we can immediately calculate the value
      if (program.getListInt().isEmpty() && program.getListOp().isEmpty()) {
        if (opName.equals("*")) {
          System.out.println("doing multiplication");
          result = Integer.parseInt(exprLeft) * Integer.parseInt(exprRight);
        } else if (opName.equals("/")) {
          System.out.println("doing division");
          result = Integer.parseInt(exprLeft) / Integer.parseInt(exprRight);
        } else if (opName.equals("%")) {
          System.out.println("doing mod");
          result = Integer.parseInt(exprLeft) % Integer.parseInt(exprRight);
        } else if (opName.equals("+")) {
          System.out.println("doing addition");
          result = Integer.parseInt(exprLeft) + Integer.parseInt(exprRight);
        } else if (opName.equals("-")) {
          System.out.println("doing subtraction");
          result = Integer.parseInt(exprLeft) - Integer.parseInt(exprRight);
        } else if (opName.equals(">") || opName.equals(">=") || opName.equals("<") || opName.equals("<=")
                || opName.equals("==") || opName.equals("!=")){
          System.out.println("compare");
          //return 1 for true, return 0 for false
          int exprLeftInt = Integer.parseInt(exprLeft);
          int exprRightInt= Integer.parseInt(exprRight);
          if (opName.equals(">")) {
            if (exprLeftInt > exprRightInt) {
              result = 1;
            }
          } else if (opName.equals(">=")) {
            if (exprLeftInt >= exprRightInt) {
              result = 1;
            }
          } else if (opName.equals("<")) {
            if (exprLeftInt < exprRightInt) {
              result = 1;
            }
          } else if (opName.equals("<=")) {
            if (exprLeftInt <= exprRightInt) {
              result = 1;
            }
          } else if (opName.equals("==")) {
            if (exprLeftInt == exprRightInt) {
              result = 1;
            }
          } else if (opName.equals("!=")) {
            if (exprLeftInt != exprRightInt) {
              result = 1;
            }
          }
        } else if (opName.equals("&&") || opName.equals("||")) {
          System.out.println("&& ||");
          //check true or false
          if (opName.equals("&&")) {
            //only case that is true must be when both sides are true
            if (exprLeft.equals("true") && exprRight.equals("true")) {
              result = 1;
            }
          } else if (opName.equals("||")) {
            //only false case is when both are false
            if (!(exprLeft.equals("false") && exprRight.equals("false"))) {
              result = 1;
            }
          }
        }
      } else {
        //this is the case when everything terminates and we are ready to calculate
        //or maybe it's the case that the two are the most left
        //needs to consider the precedence
        //add LHS to the list when RHS is exprEnclosed
        //TODO maybe needs to separate if add from right or left first
        //how to differentiate
        int immediateResult = 0;

        System.out.println("Both are");

        String lastElem = program.getListInt().get(program.getListInt().size() - 1);
        String firstElem = program.getListInt().get(0);

        if (lastElem.equals("+") || lastElem.equals("-") || lastElem.equals("*") || lastElem.equals("/")) {
          if (opName.equals("*")) {
            immediateResult = Integer.parseInt(exprLeft) * Integer.parseInt(exprRight);
            String immString = String.valueOf(immediateResult);
            program.addLastListInt(immString);
          } else if (opName.equals("/")) {
            immediateResult = Integer.parseInt(exprLeft) / Integer.parseInt(exprRight);
            String immString = String.valueOf(immediateResult);
            program.addLastListInt(immString);
          } else if (opName.equals("+")) {
            immediateResult = Integer.parseInt(exprLeft) + Integer.parseInt(exprRight);
            String immString = String.valueOf(immediateResult);
            program.addLastListInt(immString);
          } else if (opName.equals("-")) {
            immediateResult = Integer.parseInt(exprLeft) - Integer.parseInt(exprRight);
            String immString = String.valueOf(immediateResult);
            program.addLastListInt(immString);
          }
        } else if (firstElem.equals("+") || firstElem.equals("-") || firstElem.equals("*") || firstElem.equals("/")) {
          System.out.println("first elem");
          if (opName.equals("*")) {
            immediateResult = Integer.parseInt(exprLeft) * Integer.parseInt(exprRight);
            String immString = String.valueOf(immediateResult);
            program.addListInt(immString);
          } else if (opName.equals("/")) {
            immediateResult = Integer.parseInt(exprLeft) / Integer.parseInt(exprRight);
            String immString = String.valueOf(immediateResult);
            program.addListInt(immString);
          } else if (opName.equals("+")) {
            immediateResult = Integer.parseInt(exprLeft) + Integer.parseInt(exprRight);
            String immString = String.valueOf(immediateResult);
            program.addListInt(immString);
          } else if (opName.equals("-")) {
            immediateResult = Integer.parseInt(exprLeft) - Integer.parseInt(exprRight);
            String immString = String.valueOf(immediateResult);
            program.addListInt(immString);
          }
        }


        System.out.println("current list is: " + program.getListInt());
        //the general case
        //search for *, / first
        //this loop should start when everything else is in the loop already
        int listSize = program.getListInt().size();

        while (program.getListInt().contains("*") || program.getListInt().contains("/")) {
          for (int i = 0; i < listSize - 1; i++) {
            System.out.println("evaluate 1 time");
            if (program.getListInt().get(i).equals("*") || program.getListInt().get(i).equals("/")) {
              String intLeft = program.getListInt().get(i - 1);
              String intRight = program.getListInt().get(i + 1);
              System.out.println("intLeft is: " + intLeft);
              System.out.println("intRight is; " + intRight);

              //evaluate
              int immEval = 0;
              if (program.getListInt().get(i).equals("*")) {
                immEval = Integer.parseInt(intLeft) * Integer.parseInt(intRight);
              } else if (program.getListInt().get(i).equals("/")) {
                immEval = Integer.parseInt(intLeft) / Integer.parseInt(intRight);
              }

              System.out.println("immEval is: " + immEval);
              //delete the integer and replace it with the calculated one
              program.changeListElem(i - 1, String.valueOf(immEval));
              System.out.println("pass changeListElem");
              program.delListElem(i);
              System.out.println("pass remove first elem");
              program.delListElem(i);
              System.out.println("current list is: " + program.getListInt());

            }
          }
        }


        //loop until 1 elem left

        while (program.getListInt().size() != 1) {
          for (int i = 0; i < program.getListInt().size(); i++) {
            if (program.getListInt().get(i).equals("+") || program.getListInt().get(i).equals("-")) {
              String intLeft = program.getListInt().get(i - 1);
              String intRight = program.getListInt().get(i + 1);

              int immEval = 0;
              if (program.getListInt().get(i).equals("+")) {
                immEval = Integer.parseInt(intLeft) + Integer.parseInt(intRight);
              } else if (program.getListInt().get(i).equals("-")) {
                immEval = Integer.parseInt(intLeft) - Integer.parseInt(intRight);
              }

              program.changeListElem(i - 1, String.valueOf(immEval));
              program.delListElem(i);
              program.delListElem(i);
              System.out.println("current list is: " + program.getListInt());
            }
          }
        }

        //when the list is equal to 1
        //clear all list
        if (program.getListInt().size() == 1) {
          result = Integer.parseInt(program.getListInt().get(0));
          //program.clearAllList();
        }

      }

    } else if (exprLeftAST instanceof AST_ExprLiter || exprRightAST instanceof AST_ExprLiter){
      //only add to list if it's +, -, *, /
      System.out.println("Reach the else statement where not both types are of type AST_ExprIdnet");

      if (exprRightAST instanceof AST_ExprLiter) {

        if (opName.equals("+") || opName.equals("-") || opName.equals("*") || opName.equals("/")) {
          System.out.println("exprRight is: " + exprRight);
          program.addListInt(exprRight);
          if (opName != null) {
            program.addListInt(opName);
          }

          System.out.println("current list is: ");
          System.out.println(program.getListInt());
          System.out.println(program.getListOp());
        }
      }

      //TODO is the only cast when LestAST is instance of AST_ExprLiter only when RHS is Enclosed?
      if (exprLeftAST instanceof AST_ExprLiter && exprRightAST instanceof AST_ExprEnclosed) {

        if (opName.equals("+") || opName.equals("-") || opName.equals("*") || opName.equals("/")) {
          program.addLastListInt(exprLeft);
          if (opName != null) {
            program.addLastListInt(opName);
          }

          System.out.println("current list is: ");
          System.out.println(program.getListInt());
        }
      }
    }


    //TODO have to create new list for each exprEnclosed
    //ignore all expr ident cases

    if (exprLeftAST instanceof AST_ExprLiter) {
      System.out.println("exprLeftAST is instance of AST_ExprLiter");
      exprLeft = ((AST_ExprLiter) exprLeftAST).getConstant();
      System.out.println("exprLeft is: " + exprLeft);
    }

    if (exprRightAST instanceof AST_ExprLiter) {
      System.out.println("exprRightAST is instance of AST_ExprLiter");
      exprRight = ((AST_ExprLiter) exprRightAST).getConstant();
      System.out.println("exprRight is: " + exprRight);
    }

    if (exprLeftAST instanceof AST_ExprIdent) {
      System.out.println("exprLeftAST is instance of AST_ExprIdent");
      System.out.println("Not evaluating");
    }

    if (exprRightAST instanceof AST_ExprIdent) {
      System.out.println("exprRightAST is instance of AST_ExprIdent");
      System.out.println("Not evaluating");
    }

    //TODO search for * and / first

    //assume these in the bracket already

    /*while (program.getListInt().contains())


      while (program.getListInt().contains("*") || program.getListInt().contains("/")) {
        for (int i = 0; i < listSize - 1; i++) {
          System.out.println("evaluate 1 time");
          if (program.getListInt().get(i).equals("*") || program.getListInt().get(i).equals("/")) {
            String intLeft = program.getListInt().get(i - 1);
            String intRight = program.getListInt().get(i + 1);
            System.out.println("intLeft is: " + intLeft);
            System.out.println("intRight is; " + intRight);

            //evaluate
            int immEval = 0;
            if (program.getListInt().get(i).equals("*")) {
              immEval = Integer.parseInt(intLeft) * Integer.parseInt(intRight);
            } else if (program.getListInt().get(i).equals("/")) {
              immEval = Integer.parseInt(intLeft) / Integer.parseInt(intRight);
            }

            System.out.println("immEval is: " + immEval);
            //delete the integer and replace it with the calculated one
            program.changeListElem(i - 1, String.valueOf(immEval));
            System.out.println("pass changeListElem");
            program.delListElem(i);
            System.out.println("pass remove first elem");
            program.delListElem(i);
            System.out.println("current list is: " + program.getListInt());

          }
        }
      }*/



    System.out.println("current list is: " + program.getListInt());
    System.out.println("result is: " + result);

    System.out.println("+++++++++++++++++++++++++++++++++");
    return result;
  }
}

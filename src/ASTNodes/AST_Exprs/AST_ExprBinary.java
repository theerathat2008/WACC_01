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
import InstructionSet.InstructionBlocks.InstructionPrintBlocks.InstructionPrintBlocksString;
import org.antlr.v4.runtime.ParserRuleContext;
import InstructionSet.InstructionArithmetic;
import InstructionSet.InstructionComparison;
import Registers.RegisterARM;
import Registers.RegisterAllocation;
import SymbolTable.SymbolTable;
import java.util.ArrayDeque;
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

  /**
   * Used to flag special cases where the register needs a stack implementation before the backend parse
   * @param regAlloc
   */
  @Override
  public void acceptPreProcess(RegisterAllocation regAlloc) {
    exprLeftAST.acceptPreProcess(regAlloc);
    exprRightAST.acceptPreProcess(regAlloc);
  }

  /**
   * Part of the visitor code gen pattern, used to generate the instruction classes
   * which are added to the instruction list
   * @param visitor
   */
  public void accept(AST_NodeVisitor visitor) {
    visitor.visit(this);
    exprLeftAST.accept(visitor);
    exprRightAST.accept(visitor);
  }

  /**
   * @param visitor
   * @return Return the result of evaluating constant expressions at compile-time
   */
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

    //System.out.println(result);
    return result;
  }

  /**
   * Function that is iterates through the ast_nodes and adds the instruction blocks
   * in the right order to the assembly code list
   * @param assemblyCode
   */
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
   */

  /**
   * takes the embeded information corresponding to the specific instruction class and generates blocks
   * of assembly code for that instruction class
   * The embeded information is mainly the registers which is allocated using registerAllocation.
   * @param instructionList
   * @param registerAllocation
   * @throws Exception
   */
  public void genInstruction(List<Instruction> instructionList, RegisterAllocation registerAllocation) throws Exception {

    if (opName.equals("*") || opName.equals("/") || opName.equals("%") || opName.equals("+") || opName.equals("-")) {
      InstructionArithmetic instructionArithmetic = new InstructionArithmetic(opName);

      instructionList.add(instructionArithmetic);
      instrA = instructionArithmetic;
    } else {


      InstructionComparison instructionCompare = new InstructionComparison(opName);

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

  /**
   * @return Return exprLeftAST attributes
   */
  public AST_Expr getExprLeftAST() {
    return exprLeftAST;
  }

  /**
   * @return Return exprRightAST attributes
   */
  public AST_Expr getExprRightAST() {
    return exprRightAST;
  }
}

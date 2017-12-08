package ASTNodes.AST_Exprs;

import InstructionSet.Instruction;
import InstructionSet.InstructionBlocks.InstructionError.InstructionErrorOverflow;
import InstructionSet.InstructionBlocks.InstructionError.InstructionErrorRuntime;
import InstructionSet.InstructionBlocks.InstructionPrintBlocks.InstructionPrintBlocksString;
import InstructionSet.InstructionUnary;
import Registers.RegisterARM;
import Registers.RegisterAllocation;
import Registers.RegisterUsage;
import org.antlr.v4.runtime.ParserRuleContext;
import ASTNodes.AST_Node;
import ErrorMessages.TypeError;
import ErrorMessages.TypeMismatchError;
import ErrorMessages.FilePosition;
import SymbolTable.SymbolTable;
import VisitorClass.AST_NodeVisitor;
import java.util.ArrayDeque;
import java.util.List;
import IdentifierObjects.*;
import static Registers.RegisterUsageBuilder.*;

/**
 * Class representing node in AST tree for UNARY EXPRESSIONS
 */
public class AST_ExprUnary extends AST_Expr {

  //Syntactic attributes
  String opName;
  AST_Expr astExpr;
  ParserRuleContext ctx;
  SymbolTable symbolTable;
  InstructionUnary instr;

  /**
   * Constructor for class - initialises class variables to NULL
   */
  public AST_ExprUnary(ParserRuleContext ctx, SymbolTable symbolTable) {
    this.opName = null;
    this.astExpr = null;
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
    returnList.addLast(astExpr);
    return returnList;
  }

  /**
   * Returns true if the embedded Nodes have value
   */
  @Override
  public boolean isEmbeddedNodesFull() {
    return astExpr != null;
  }

  /**
   * Sets syntactic attributes of class variables by assigning it a value
   * @param value - Value to be assigned to class variable
   */
  @Override
  public void setSyntacticAttributes(String value) {
    if (opName == null) {
      this.opName = value;
      if (opName.equals("!")) {
        identifier = new BaseTypeObj(null, "bool");
      } else if (opName.equals("-")) {
        identifier = new BaseTypeObj(null, "int");
      } else if (opName.equals("len")) {
        identifier = new BaseTypeObj(null, "int");
      } else if (opName.equals("ord")) {
        identifier = new BaseTypeObj(null, "int");
      } else if (opName.equals("chr")) {
        identifier = new BaseTypeObj(null, "char");
      } else {
        identifier = null;
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
   * @param astToGet Shows which child to get from current node
   * @param counter  Shows which child of child to get from current node
   * @return Returns the required child AST Node (determined by the astToGet parameter)
   */
  @Override
  public AST_Node getEmbeddedAST(String astToGet, int counter) {
    if (astToGet.equals("astExpr")) {
      return astExpr;
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
      astExpr = (AST_Expr) nodeToSet;
    } else {
      System.out.println("Unrecognised AST Node at class: " + this.getClass().getSimpleName());
    }
  }

  /**
   * Semantic Analysis and print error message if needed
   */
  @Override
  public boolean CheckSemantics() {
    if (opName.equals("!")) {
      setType("bool");
    } else if (opName.equals("-")) {
      setType("int");
    } else if (opName.equals("len")) {
      setType("int");
    } else if (opName.equals("ord")) {
      setType("int");
    } else if (opName.equals("chr")) {
      setType("char");
    } else {
      setType("null");
    }


    SymbolTable ST = this.symbolTable;

    if (opName.equals("!")) {
      if (astExpr instanceof AST_ExprEnclosed) {
        return true;
      } else if (astExpr instanceof AST_ExprIdent) {

        String varName = ((AST_ExprIdent) astExpr).getVarName();
        SymbolTable tempST = this.symbolTable;
        IDENTIFIER type = tempST.lookup(varName);

        AST_Node parent = getParentNode();
        //if parent is instance of AST_FuncDecl, search in encSymTable instead
        while (type == null) {
          tempST = tempST.encSymTable;
          type = tempST.lookup(varName);
        }

        if (type.toString().equals("bool")) {
          return true;
        } else {
          System.out.println("Unary operator '!' can only be used with statement of type 'bool'.");
          new TypeMismatchError(new FilePosition(ctx)).printAll();
          return false;
        }
      } else {
        new TypeError(new FilePosition(ctx)).printAll();
        return false;
      }
    }

    //if unaryOp = '-', expression must be of type int
    if (opName.equals("-")) {
      if (astExpr instanceof AST_ExprEnclosed) {
        return true;
      } else if (astExpr instanceof AST_ExprIdent) {

        String varName = ((AST_ExprIdent) astExpr).getVarName();

        SymbolTable tempST = this.symbolTable;
        IDENTIFIER type = tempST.lookup(varName);

        AST_Node parent = getParentNode();
        //if parent is instance of AST_FuncDecl, search in encSymTable instead
        while (type == null) {
          tempST = tempST.encSymTable;
          type = tempST.lookup(varName);
        }

        if (type.toString().equals("int")) {
          return true;
        } else {
          System.out.println("Unary operator '-' can only be used with statement of type 'int'.");
          new TypeMismatchError(new FilePosition(ctx)).printAll();
          return false;
        }
      }
    }

    //if unaryOp = 'len', array must be of valid type
    if (opName.equals("len")) {

      if (astExpr instanceof AST_ExprEnclosed) {
        return true;
      } else if (astExpr instanceof AST_ExprIdent) {
        System.out.println(astExpr);
        astExpr.printContents();
        String varName = ((AST_ExprIdent) astExpr).getVarName();

        SymbolTable tempST = this.symbolTable;
        IDENTIFIER type = tempST.lookup(varName);

        AST_Node parent = getParentNode();
        //if parent is instance of AST_FuncDecl, search in encSymTable instead
        while (type == null) {
          tempST = tempST.encSymTable;
          type = tempST.lookup(varName);
        }

        if (type.toString().equals("char") || type.toString().equals("bool") || type.toString().equals("string")
            || type.toString().contains("[]") || type.toString().contains("pair")) {
          return true;
        } else {
          System.out.println("Unary operator 'len' can only be used with statement of type 'char' 'bool'" +
              "'string' 'array' 'pair'.");
          new TypeError(new FilePosition(ctx)).printAll();
          return false;
        }
      } else {
        new TypeError(new FilePosition(ctx)).printAll();
        return false;
      }
    }

    //if unaryOp = 'ord', statement must be of type char
    if (opName.equals("ord")) {

      if (astExpr instanceof AST_ExprEnclosed) {
        return true;
      } else if (astExpr instanceof AST_ExprIdent) {

        String varName = ((AST_ExprIdent) astExpr).getVarName();

        SymbolTable tempST = this.symbolTable;
        IDENTIFIER type = tempST.lookup(varName);

        AST_Node parent = getParentNode();
        //if parent is instance of AST_FuncDecl, search in encSymTable instead
        while (type == null) {
          tempST = tempST.encSymTable;
          type = tempST.lookup(varName);
        }

        if (type.toString().equals("char")) {
          return true;
        } else {
          System.out.println("Unary operator 'ord' can only be used with statement of type 'char'.");
          new TypeError(new FilePosition(ctx)).printAll();
          return false;
        }
      } else if (astExpr.getIdentifier().toString().equals("char")) {
        return true;
      } else {
        new TypeError(new FilePosition(ctx)).printAll();
        return false;
      }
    }

    if (opName.equals("chr")) {

      if (astExpr instanceof AST_ExprEnclosed) {
        return true;
      } else if (astExpr instanceof AST_ExprIdent) {
        String varName = ((AST_ExprIdent) astExpr).getVarName();

        SymbolTable tempST = this.symbolTable;
        IDENTIFIER type = tempST.lookup(varName);

        AST_Node parent = getParentNode();
        //if parent is instance of AST_FuncDecl, search in encSymTable instead

        while (type == null) {
          tempST = tempST.encSymTable;
          type = tempST.lookup(varName);
        }

        if (type.toString().equals("int")) {
          return true;
        } else {
          System.out.println("Unary operator 'chr' can only be used with statement of type 'int'.");
          new TypeMismatchError(new FilePosition(ctx)).printAll();
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
    if (astExpr == null) {
      System.out.println("astExpr: null");
    } else {
      System.out.println("astExpr: has content");
      //Debug statement
      System.out.println(astExpr);
    }
  }

  /**
   * Used to flag special cases where the register needs a stack implementation before the backend parse
   * @param regAlloc
   */
  @Override
  public void acceptPreProcess(RegisterAllocation regAlloc) {
    astExpr.acceptPreProcess(regAlloc);
  }

  /**
   * Part of the visitor code gen pattern, used to generate the instruction classes
   * which are added to the instruction list
   * @param visitor
   */
  public void accept(AST_NodeVisitor visitor) {
    visitor.visit(this);
    astExpr.accept(visitor);
  }

  /**
   * @param visitor
   * @return Return the result of evaluating constant expressions at compile-time
   */
  public int acceptNode(AST_NodeVisitor visitor) {
    visitor.visit(this);

    System.out.println("+++++++++++++++++++++++++++++++++");
    System.out.println("Start evaluating constant");

    if (astExpr instanceof AST_ExprIdent) {
      System.out.println("exprLeftAST is instance of AST_ExprIdent");
      System.out.println("Not evaluating");
    }

    int result = 0;

    if (astExpr instanceof AST_ExprLiter) {
      int result1 = ((AST_ExprLiter) astExpr).acceptNode(visitor);

      if (opName.equals("chr")) {
        //return the integer input
        String constant = ((AST_ExprLiter) astExpr).getConstant();
        result = Integer.parseInt(constant);
      } else if (opName.equals("ord")) {
        //return the integer output
        String charConstant = ((AST_ExprLiter) astExpr).getConstant();
        if (charConstant != null) {
          result = (int) charConstant.charAt(0);
        }
      } else if (opName.equals("len")) {

        if (astExpr instanceof AST_ExprArrayElem) {
          int numOfExpr = ((AST_ExprArrayElem) astExpr).numOfExpr;
          result = numOfExpr;
        }
      } else if (opName.equals("-")) {
        result = -result1;
      } else if (opName.equals("!")) {
        if (((AST_ExprLiter) astExpr).getConstant().equals("true")) {
          result = 0;
        } else if (((AST_ExprLiter) astExpr).getConstant().equals("false")) {
          result = 1;
        }
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
    astExpr.acceptInstr(assemblyCode);
    assemblyCode.add(instr.block1);
  }

  /**
   * Want to store the evaluation of the two registers result of the binary expression
   * Format is expr BinOp expr
   * Store the returned result of the two expr into a result reg
   * Free the two registers after having got the evaluation of the two stores in the regs
   */
  @Override
  public RegisterARM acceptRegister(RegisterAllocation registerAllocation) throws Exception {

    RegisterARM regUnary = astExpr.acceptRegister(registerAllocation);
    registerAllocation.freeRegister(regUnary);

    RegisterUsage usage = aRegisterUsageBuilder()
        .withScope(registerAllocation.getCurrentScope())
        .withUsageType("exprType")
        .withSubType("resultType")
        .withOperationType(opName)
        .build();

    RegisterARM dst = registerAllocation.useRegister(usage);

    instr.allocateRegisters(dst, regUnary);
    if (opName.equals("-")) {
      RegisterARM freeReg = registerAllocation.getNextFreeRegister();
      instr.extraRegister(freeReg);
      registerAllocation.freeRegister(freeReg);
    }

    return dst;
  }

  /**
   * Generates assembly code
   * opName:  CHR   *   Needs registers to be allocated  InstructionUnary
   * ORD    /  Needs registers to be allocated  InstructionUnary
   * LEN    %  Needs registers to be allocated  InstructionUnary
   * EXCL   +  Needs registers to be allocated  InstructionUnary
   * MINUS  -  Needs registers to be allocated  InstructionUnary
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
    InstructionUnary instructionUnary = new InstructionUnary(opName);

    instructionList.add(instructionUnary);
    instr = instructionUnary;

    if (opName.equals("-")) {
      registerAllocation.addString("OverflowError: the result is too small/large to store in a 4-byte signed-integer.\\n");
      InstructionErrorOverflow errorOverflow = new InstructionErrorOverflow(registerAllocation.
              getStringID("OverflowError: the result is too small/large to store in a 4-byte signed-integer.\\n"));
      instructionList.add(errorOverflow);
      registerAllocation.addString("%.*s\\0");
      InstructionPrintBlocksString instructionPrintString = new InstructionPrintBlocksString(registerAllocation.getStringID("%.*s\\0"));
      instructionList.add(instructionPrintString);

      instructionList.add(new InstructionErrorRuntime());
    }

  }
}

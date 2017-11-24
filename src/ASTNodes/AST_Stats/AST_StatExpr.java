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

import src.FilePosition;
import org.antlr.v4.runtime.ParserRuleContext;
import VisitorClass.AST_NodeVisitor;

import java.util.ArrayDeque;
import java.util.List;

public class AST_StatExpr extends AST_Stat {

  //Syntactic attributes
  AST_Expr expr;
  ParserRuleContext ctx;
  SymbolTable symbolTable;
  String instr = "undefined block in AST_StatExpr\n";

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
          System.out.println("typeExpr is null");
          tempST = tempST.encSymTable;
          typeExpr = tempST.lookup(varName);
        }

        System.out.println("The typeExpr is: ");
        System.out.println(typeExpr);
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

        System.out.println("Going to AST parent, looking for function");
      }

      //check if the return type is the same type as function type
      AST_FuncDecl temp = (AST_FuncDecl) parent;

      if (expr instanceof AST_ExprIdent) {
        System.out.println("Hey I'm instance of AST_ExprIdent");
        String varName = ((AST_ExprIdent) expr).getVarName();
        AST_Node tempNode = this.getParentNode();
        SymbolTable tempST = this.symbolTable;
        IDENTIFIER typeExpr = tempST.lookup(varName);

        while (typeExpr == null) {
          System.out.println("typeExpr is null");
          tempST = tempST.encSymTable;
          typeExpr = tempST.lookup(varName);
        }
        System.out.println("type expr is: ");
        System.out.println(typeExpr);
        if (temp.ast_type.getIdentifier().equals(typeExpr)) {
          return true;
        } else {
          new TypeMismatchError(new FilePosition(ctx)).printAll();
          return false;
        }
      }

      //debug message
      System.out.println(temp.ast_type.getIdentifier().toString());
      if (expr.getIdentifier() == null) {
        System.out.println("null");
        System.out.println(expr.getType());
      }

      /* TODO expr has null value */
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
      //Debug statement
      System.out.println(expr);
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
        //Debug statement
        System.out.println(type);
        if (type.toString().equals("int")) {
          return true;
        } else {
          new TypeMismatchError(new FilePosition(ctx)).printAll();
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
    assemblyCode.add(instr);
  }

  @Override
  public void acceptRegister(RegisterAllocation registerAllocation) throws Exception {

    registerAllocation.useRegister("expr");
    expr.acceptRegister(registerAllocation);

    RegisterARM reg1 = registerAllocation.searchByValue("expr");
    registerAllocation.freeRegister(reg1);


    switch (statName) {
      case ("free"):

        break;

      case ("return"):

        break;

      case ("exit"):

        break;

      case ("println"):

      case ("print"):
        String type = expr.getType();

        switch (type) {
          case ("int"):

            break;
          case ("string"):

            break;
          case ("char"):
            break;
          case ("pair"):
            //No break since pair and array are the same
          case ("array"):

            break;

          case ("bool"):

          default:
            break;
        }

        break;
      default:
        System.out.println("Unrecognised statement type in AST_StatExpr");
    }
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
    System.out.println("Statement type is: "+statName);

    switch (statName) {
      case ("free"):
        registerAllocation.addString("NullReferenceError: dereference a null reference\\n\\0");
        InstructionFreePair instructionFreePair = new InstructionFreePair();
        instructionList.add(instructionFreePair);

        InstructionFreePairBlock instructionFreePairBlock = new InstructionFreePairBlock(registerAllocation.getStringID("NullReferenceError: dereference a null reference\\n\\0"));
        InstructionErrorRuntime instructionErrorRuntime = new InstructionErrorRuntime();
        if (!instructionList.contains(instructionFreePairBlock)){
          instructionList.add(instructionFreePairBlock);
          //TODO put this at special position of list dedicated to end of file instructions.
        }
        if (!instructionList.contains(instructionErrorRuntime)){
          instructionList.add(instructionErrorRuntime);
        }
        break;

      case ("return"):
        InstructionReturn instructionReturn = new InstructionReturn(expr.getType());
        instructionList.add(instructionReturn);
        instr = instructionReturn.resultBlock;
        break;

      case ("exit"):
        InstructionExit instructionExit = new InstructionExit("0");//EXITCODE); //TODO put exit code in - can be found after <statname> <expr = EXITCODE>
        instructionList.add(instructionExit);
        instr = instructionExit.resultBlock;
        break;

      case ("println"):
        //No break so it executes print too
        registerAllocation.addString("\\0");
        InstructionPrintBlocksLn instructionPrintLn = new InstructionPrintBlocksLn(registerAllocation.getStringID("\\0"));
        if (!instructionList.contains(instructionPrintLn)) {
          instructionList.add(instructionPrintLn);
        }
        instructionList.add(new InstructionPrintln());
      case ("print"):
        System.out.println(expr.getType());
        String type = expr.getType();

        switch (type) {
          case ("int"):
            registerAllocation.addString("%d\\0");
            InstructionPrintBlocksInt instructionPrintInt = new InstructionPrintBlocksInt(registerAllocation.getStringID("%d\\0"));
            if (!instructionList.contains(instructionPrintInt)) {
              instructionList.add(instructionPrintInt);
            }
            break;
          case ("string"):
            registerAllocation.addString("%.*s\\0");
            InstructionPrintBlocksString instructionPrintString = new InstructionPrintBlocksString(registerAllocation.getStringID("%.*s\\0"));
            if (!instructionList.contains(instructionPrintString)) {
              instructionList.add(instructionPrintString);
            }
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
            break;

          case ("bool"):
            registerAllocation.addString("true");
            registerAllocation.addString("false");
            InstructionPrintBlocksBool instructionPrintBool = new InstructionPrintBlocksBool(registerAllocation.getStringID("true"), registerAllocation.getStringID("false"));
            if (!instructionList.contains(instructionPrintBool)) {
              instructionList.add(instructionPrintBool);
            }
          default:
            break;
        }
        InstructionPrint instructionPrint = new InstructionPrint(type);
        instructionList.add(instructionPrint);
        break;
      default:
        System.out.println("Unrecognised statement type in AST_StatExpr");
    }

  }

}

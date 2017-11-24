package ASTNodes.AST_Stats;

import ASTNodes.AST_Exprs.AST_Expr;
import ASTNodes.AST_Exprs.AST_ExprIdent;
import ASTNodes.AST_FuncDecl;
import ASTNodes.AST_Node;
import ASTNodes.AST_Program;
import ASTNodes.AST_Stats.AST_StatIfs.AST_StatIfElse;
import ASTNodes.AST_Stats.AST_StatIfs.AST_StatIfThen;
import IdentifierObjects.IDENTIFIER;
import InstructionSet.Instruction;
import InstructionSet.InstructionIf;
import Registers.RegisterAllocation;
import SymbolTable.SymbolTable;
import ErrorMessages.*;
import src.FilePosition;
import VisitorClass.AST_NodeVisitor;
import java.util.ArrayDeque;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

public class AST_StatIf extends AST_Stat {

  //Syntactic attributes
  AST_Expr expr;
  AST_StatIfThen thenStat;
  AST_StatIfElse elseStat;
  //Semantic attribute
  ParserRuleContext ctx;

  InstructionIf instr;

  SymbolTable symbolTable;


  /**
   * Assign the class variables when called
   */
  public AST_StatIf(ParserRuleContext ctx, SymbolTable symbolTable) {
    this.expr = null;
    this.thenStat = null;
    this.elseStat = null;
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
    returnList.addLast(thenStat);
    returnList.addLast(elseStat);
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
    return expr != null && thenStat != null && elseStat != null;
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
    } else if (astToGet.equals("thenStat")) {
      return thenStat;
    } else if (astToGet.equals("elseStat")) {
      return elseStat;
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
    } else if (astToSet.equals("statement")) {

      if (thenStat == null) {
        thenStat = (AST_StatIfThen) nodeToSet;
      } else if (elseStat == null) {
        elseStat = (AST_StatIfElse) nodeToSet;
      } else {
        System.out.println("If and then in AST_StatIf have already been assigned.");
      }

    } else {
      System.out.println("Unrecognised AST Node at class: " + this.getClass().getSimpleName());
    }
  }

  /**
   * Semantic Analysis and print error message if needed
   *
   */
  @Override
  public boolean CheckSemantics() {
    //TODO inside an if stat if it's AST_ExprIdent

    //get type of the expr of the context to see whether it is equal to type bool
    SymbolTable ST = this.symbolTable;
    IDENTIFIER typeExpr = expr.getIdentifier();
    System.out.println(typeExpr);

    //
    if (expr instanceof AST_ExprIdent) {
      System.out.println("Hey, I'm an instance of AST_ExprIdent");
      String varName = ((AST_ExprIdent) expr).getVarName();
      System.out.println("varName is: ");
      System.out.println(varName);
      //IDENTIFIER typeName = ST.encSymTable.lookup(varName);
      IDENTIFIER typeName = ST.lookup(varName);
      System.out.println(typeName);
      System.out.println(ST.lookup(varName));
      System.out.println(ST.encSymTable.encSymTable.lookup(varName));

      AST_Node tempNode = this.getParentNode();

      /*if (ST.encSymTable.lookup(varName) == null) {
        typeName = ST.lookup(varName);
      }*/

      while (typeName == null) {
        System.out.println("type name is null");
        ST = ST.encSymTable;
        typeName = ST.lookup(varName);
      }

      System.out.println("This is the most recent typeName");
      System.out.println(typeName);

      System.out.println("This is typeExpr: ");
      System.out.println(typeExpr);

      if (typeName.toString().contains("bool")) {
        return true;
      } else {
        new TypeError(new FilePosition(ctx)).printAll();
        return false;
      }
    }


    if (typeExpr != null) {
      if (typeExpr.toString().contains("bool")) {
        return true;
      } else {
        new TypeError(new FilePosition(ctx)).printAll();
        return false;
      }
    } else {
      return true;
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
      //Do symbol table stuff
    }
  }

  /**
   * Used for testing - Prints out contents of current AST node
   */
  @Override
  public void printContents() {
    System.out.println(this.getClass().getSimpleName() + ": ");
    if (expr == null) {
      System.out.println("expr: null");
    } else {
      System.out.println("expr: has content");
    }
    if (thenStat == null) {
      System.out.println("thenStat: null");
    } else {
      System.out.println("thenStat: has content");
    }
    if (elseStat == null) {
      System.out.println("elseStat: null");
    } else {
      System.out.println("elseStat: has content");
    }
  }

  public void accept(AST_NodeVisitor visitor) {
    visitor.visit(this);
    expr.accept(visitor);
    thenStat.accept(visitor);
    elseStat.accept(visitor);
  }

  public void acceptInstr(List<String> assemblyList) {
    expr.acceptInstr(assemblyList);
    assemblyList.add(instr.blockIf);
    thenStat.acceptInstr(assemblyList);
    assemblyList.add(instr.blockElse);
    elseStat.acceptInstr(assemblyList);
    assemblyList.add(instr.blockContinue);
  }

  @Override
  public void acceptRegister(RegisterAllocation registerAllocation) throws Exception {
    expr.acceptRegister(registerAllocation);
    thenStat.acceptRegister(registerAllocation);
    elseStat.acceptRegister(registerAllocation);

  }

  /**
   * Creates an InstructionIf
   * Uses registers one of which is taken from InstructionExpr
   */

  @Override
  public void genInstruction(List<Instruction> instructionList, RegisterAllocation registerAllocation) throws Exception {
    InstructionIf instructionIf = new InstructionIf();

    //Allocate registers for exprReg

    instructionIf.setLabels(registerAllocation.generateLabel(), registerAllocation.generateLabel());

    instructionList.add(instructionIf);
    instr = instructionIf;
  }
}

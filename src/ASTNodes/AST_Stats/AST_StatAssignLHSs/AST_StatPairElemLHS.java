package ASTNodes.AST_Stats.AST_StatAssignLHSs;

import ASTNodes.AST_Exprs.AST_ExprIdent;
import IdentifierObjects.IDENTIFIER;
import InstructionSet.Instruction;
import Registers.RegisterARM;
import Registers.RegisterAllocation;
import org.antlr.v4.runtime.ParserRuleContext;
import ASTNodes.AST_Exprs.AST_Expr;
import ASTNodes.AST_Node;
import ErrorMessages.TypeError;
import ErrorMessages.FilePosition;
import SymbolTable.SymbolTable;
import VisitorClass.AST_NodeVisitor;

import java.util.ArrayDeque;
import java.util.List;

/**
 * Class representing node in AST tree for PAIR VARIABLES
 */
public class AST_StatPairElemLHS extends AST_StatAssignLHS {

  //Syntactic attributes
  String typeName;
  AST_Expr ast_expr;

  ParserRuleContext ctx;
  SymbolTable symboltable;

  /**
   * Constructor for class - initialises class variables to NULL
   */
  public AST_StatPairElemLHS(ParserRuleContext ctx, SymbolTable symbolTable) {
    this.typeName = null;
    this.ast_expr = null;
    this.ctx = ctx;
    this.symboltable = symbolTable;
  }

  public String getTypeName() {
    return typeName;
  }

  /**
   * Gets all children nodes of current node
   *
   * @return list of AST nodes that are the children of the current node
   */
  @Override
  public ArrayDeque<AST_Node> getNodes() {
    ArrayDeque<AST_Node> returnList = new ArrayDeque<>();
    returnList.addLast(ast_expr);
    return returnList;
  }

  /**
   * Sets syntactic attributes of class variables by assigning it a value
   *
   * @param value - Value to be assigned to class variable
   */
  @Override
  public void setSyntacticAttributes(String value) {
    if (typeName == null) {
      this.typeName = value;
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
    if (strToGet.equals("typeName")) {
      return typeName;
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
    return ast_expr != null;
  }

  /**
   * @param astToGet Shows which child to get from current node
   * @param counter  Shows which child of child to get from current node
   * @return Returns the required child AST Node (determined by the astToGet parameter)
   */
  @Override
  public AST_Node getEmbeddedAST(String astToGet, int counter) {
    if (astToGet.equals("ast_expr")) {
      return ast_expr;
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
      ast_expr = (AST_Expr) nodeToSet;
    } else {
      System.out.println("Unrecognised AST Node at class: " + this.getClass().getSimpleName());
    }
  }

  /**
   * Semantic Analysis and print error message if needed
   */
  @Override
  public boolean CheckSemantics() {

    IDENTIFIER type;
    SymbolTable ST = this.symboltable;

    if (typeName.equals("fst")) {
      if (ast_expr instanceof AST_ExprIdent) {
        String varName = ((AST_ExprIdent) ast_expr).getVarName();

        SymbolTable tempST = ST;
        type = tempST.lookup(varName);

        AST_Node tempNode = this.getParentNode();

        while (type == null) {
          tempST = tempST.encSymTable;
          type = tempST.lookup(varName);
        }

        String typeString = type.toString();

        if (typeString.contains("int") || typeString.contains("bool") || typeString.contains("char")
            || typeString.contains("PAIR") || typeString.contains("str")) {
          return true;
        } else {
          new TypeError(new FilePosition(ctx)).printAll();
          return false;
        }
      } else {
        if (typeName.equals("int") || typeName.equals("bool") || typeName.equals("char") ||
            typeName.contains("PAIR") || typeName.contains("str")) {
          return true;
        } else {
          System.out.println("Invalid type for pair elem.");
          new TypeError(new FilePosition(ctx)).printAll();
          return false;
        }
      }
    } else if (typeName.equals("snd")) {
      if (ast_expr instanceof AST_ExprIdent) {
        String varName = ((AST_ExprIdent) ast_expr).getVarName();

        SymbolTable tempST = ST;
        type = tempST.lookup(varName);

        AST_Node tempNode = this.getParentNode();

        while (type == null) {
          tempST = tempST.encSymTable;
          type = tempST.lookup(varName);
        }

        String typeString = type.toString();

        if (typeString.contains("int") || typeString.contains("bool") || typeString.contains("char")
            || typeString.contains("PAIR") || typeString.contains("str")) {
          return true;
        } else {
          new TypeError(new FilePosition(ctx)).printAll();
          return false;
        }
      } else {
        if (typeName.equals("int") || typeName.equals("bool") || typeName.equals("char") ||
            typeName.contains("PAIR") || typeName.contains("str")) {
          return true;
        } else {
          System.out.println("Invalid type for pair elem.");
          new TypeError(new FilePosition(ctx)).printAll();
          return false;
        }
      }


    } else {
      if (!(typeName.equals("int") || typeName.equals("bool") || typeName.equals("char") ||
          typeName.contains("PAIR") || typeName.contains("str"))) {
        System.out.println("Invalid type for pair elem.");
        new TypeError(new FilePosition(ctx)).printAll();
        return false;
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
      setType(ast_expr.getType());
    }
  }

  /**
   * Used for testing - Prints out contents of current AST node
   */
  @Override
  public void printContents() {
    System.out.println(this.getClass().getSimpleName() + ": ");
    System.out.println("typeName: " + typeName);
    if (ast_expr == null) {
      System.out.println("ast_expr: null");
    } else {
      System.out.println("ast_expr: has content");
    }
  }

  public void accept(AST_NodeVisitor visitor) {
    visitor.visit(this);
    ast_expr.accept(visitor);
  }

  @Override
  public void acceptInstr(List<String> assemblyCode) {
    ast_expr.acceptInstr(assemblyCode);
  }

  @Override
  public RegisterARM acceptRegister(RegisterAllocation registerAllocation) throws Exception {
    return ast_expr.acceptRegister(registerAllocation);
  }

  public void genInstruction(List<Instruction> instructionList, RegisterAllocation registerAllocation) throws Exception {

  }

  public AST_Expr getAst_expr() {
    return ast_expr;
  }
}

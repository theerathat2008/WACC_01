package src.ASTNodes.AST_Stats;

import src.ASTNodes.AST_FuncDecl;
import src.ASTNodes.AST_Node;
import src.ASTNodes.AST_Program;
import src.ASTNodes.AST_Stats.AST_StatAssignRHSs.AST_StatAssignRHS;

import src.IdentifierObjects.IDENTIFIER;
import src.SymbolTable.SymbolTable;

import src.ASTNodes.AST_TYPES.AST_Type;
import src.ErrorMessages.TypeMismatchError;
import src.ErrorMessages.VariableRedeclarationError;
import src.FilePosition;
import org.antlr.v4.runtime.ParserRuleContext;
import src.VisitorClass.AST_NodeVisitor;

import java.util.ArrayDeque;


public class AST_StatVarDecl extends AST_Stat {

  //Syntactic attributes
  AST_Type ast_type;
  String identName;
  AST_StatAssignRHS ast_assignRHS;
  ParserRuleContext ctx;
  SymbolTable symbolTable;

  /**
   * Assign the class variables when called
   *
   * @param ctx
   */
  public AST_StatVarDecl(ParserRuleContext ctx, SymbolTable symbolTable) {
    this.ast_assignRHS = null;
    this.statName = null;
    this.identName = null;
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
    returnList.addLast(ast_type);
    returnList.addLast(ast_assignRHS);
    return returnList;
  }

  /**
   * Sets syntactic attributes of class variables by assigning it a value
   *
   * @param value - Value to be assigned to class variable
   */
  @Override
  public void setSyntacticAttributes(String value) {
    if (identName == null) {
      this.identName = value;
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
    if (identName == null) {
      return identName;
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
    return ast_assignRHS != null;
  }

  /**
   * @param astToGet Shows which child to get from current node
   * @param counter  Shows which child of child to get from current node
   * @return Returns the required child AST Node (determined by the astToGet parameter)
   */
  @Override
  public AST_Node getEmbeddedAST(String astToGet, int counter) {
    if (astToGet.equals("ast_assignRHS")) {
      return ast_assignRHS;
    } else if (astToGet.equals("ast_type")) {
      return ast_type;
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
    if (astToSet.equals("statAssignRHS")) {
      ast_assignRHS = (AST_StatAssignRHS) nodeToSet;
    } else if (astToSet.equals("ast_type")) {
      ast_type = (AST_Type) nodeToSet;
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

    //Debug statement

    //Maybe ST has content but ast_assignRHS is null so it cannot find type
    SymbolTable ST = symbolTable;
    System.out.println("printing contents");
    System.out.println(ast_type.getIdentifier().toString());
    System.out.println(ST.getScope());
    System.out.println(identName);
    System.out.println(ST.lookup(identName));
    System.out.println(ST.lookupAll(identName));
    System.out.println(ST.encSymTable.lookup("s2"));
    System.out.println(ast_type.getIdentifier());
    System.out.println(ast_assignRHS.getIdentifier());
    System.out.println(ast_assignRHS);

    AST_Node parent = getParentNode();

    IDENTIFIER type = ST.encSymTable.lookup(identName);
    System.out.println(type);

    while (!(parent instanceof AST_FuncDecl)) {
      if (parent instanceof AST_Program) {
        System.out.println("Hey, I'm inside the if statement");
        type = ST.lookup(identName);
        break;
      }
      parent = parent.getParentNode();
    }
    System.out.println(type);
    System.out.println(ast_type);

    //TODO find out why it is already assigned
    //find other way to check
    //maybe use not equal to the already assigned type?
    if (!type.equals(ast_type.getIdentifier())) {
      new VariableRedeclarationError(new FilePosition(ctx)).printAll();
      return false;
    }

    if (ast_assignRHS.getIdentifier() == null) {
      return true;
    }

    //ast_type.getIdentifier() returns "str" so it's the problem
    if (!(ast_type.getIdentifier().toString().contains(ast_assignRHS.getIdentifier().toString())
            || ast_assignRHS.getIdentifier().toString().contains(ast_type.getIdentifier().toString()))) {
      new TypeMismatchError(new FilePosition(ctx)).printAll();
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
    //CheckSemantics(ST);
    ST.add(identName, ST.stringToIdent(identName, ast_type.toString()));
  }

  public void Assign(SymbolTable ST) {
    if (ast_type == null) {
      System.out.println("Variable " + identName + "'s AST_Type not set yet");
    }
    ST.add(identName, ast_type.getIdentifier());
  }

  /**
   * Used for testing - Prints out contents of current AST node
   */
  @Override
  public void printContents() {
    System.out.println(this.getClass().getSimpleName() + ": ");
    System.out.println("identName: " + identName);
    if (ast_assignRHS == null) {
      System.out.println("ast_assignRHS: null");
    } else {
      System.out.println("ast_assignRHS: has content");
    }
    if (ast_type == null) {
      System.out.println("ast_type: null");
    } else {
      System.out.println("ast_type: has content");
      System.out.println(ast_type.getIdentifier().toString());
    }
  }

  public void accept(AST_NodeVisitor visitor) {
    visitor.visit(this);
    ast_type.accept(visitor);
    ast_assignRHS.accept(visitor);
  }
}

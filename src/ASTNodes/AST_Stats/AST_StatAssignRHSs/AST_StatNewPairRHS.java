package ASTNodes.AST_Stats.AST_StatAssignRHSs;

import ASTNodes.AST_Exprs.AST_Expr;
import ASTNodes.AST_Node;
import SymbolTable.SymbolTable;

import java.util.ArrayDeque;

public class AST_StatNewPairRHS extends AST_StatAssignRHS{
  //Syntactic attributes
  AST_Expr ast_expr_first;
  AST_Expr ast_expr_second;
  //Semantic attribute


  // Assign the class variables when called
  public AST_StatNewPairRHS(){
    this.ast_expr_first = null;
    this.ast_expr_second = null;
  }

  @Override
  public ArrayDeque<AST_Node> getNodes(){
    ArrayDeque<AST_Node> returnList = new ArrayDeque<>();
    returnList.addLast(ast_expr_first);
    returnList.addLast(ast_expr_second);
    return returnList;
  }

  @Override
  public void setSyntacticAttributes(String value){
    System.out.println("No String Syntactic Attributes in class: " + this.getClass().getSimpleName());
  }

  @Override
  public String getSyntacticAttributes(String strToGet){
    System.out.println("No String Syntactic Attributes in class: " + this.getClass().getSimpleName());
    return null;
  }

  @Override
  public boolean isEmbeddedNodesFull(){
    return ast_expr_first != null && ast_expr_second != null;
  }

  @Override
  public AST_Node getEmbeddedAST(String astToGet, int counter){
    if(astToGet.equals("ast_expr_first")){
      return ast_expr_first;
    } else if (astToGet.equals("ast_expr_second")){
      return ast_expr_second;
    }
    System.out.println("Unrecognised AST Node at class: " + this.getClass().getSimpleName());
    return null;
  }

  @Override
  public void setEmbeddedAST(String astToSet, AST_Node nodeToSet){
    if(astToSet.equals("expr")){
      if(ast_expr_first == null){
        ast_expr_first = (AST_Expr) nodeToSet;
      } else if (ast_expr_second == null){
        ast_expr_second = (AST_Expr) nodeToSet;
      } else {
        System.out.println("If and then in AST_StatIf have already been assigned.");
      }
    } else if (astToSet.equals("ast_expr_second")){
      ast_expr_second = (AST_Expr) nodeToSet;
    } else {
      System.out.println("Unrecognised AST Node at class: " + this.getClass().getSimpleName());
    }
  }

  public String getType(SymbolTable ST) {
    return "PAIR(" + ast_expr_first.toString() + "," + ast_expr_second + ")";
  }

  //Semantic Analysis and print error message if needed
  protected boolean CheckSemantics(SymbolTable ST){
    return true;
  }

  // Called from visitor
  public void Check(SymbolTable ST){
    if(CheckSemantics(ST)){
      //Do symbol table stuff
    }
  }

  @Override
  public void printContents(){
    System.out.println(this.getClass().getSimpleName() + ": ");
    if(ast_expr_first == null){
      System.out.println("ast_expr_first: null");
    } else {
      System.out.println("ast_expr_first: has content");
    }
    if(ast_expr_second == null){
      System.out.println("ast_expr_second: null");
    } else {
      System.out.println("ast_expr_second: has content");
    }
  }
}

package ASTNodes.AST_Stats.AST_StatAssignLHSs;

import ASTNodes.AST_Exprs.AST_Expr;
import ASTNodes.AST_Node;
import SymbolTable.SymbolTable;

import java.util.ArrayDeque;

public class AST_StatPairElemLHS extends AST_StatAssignLHS{
  //Syntactic attributes
  String typeName;
  AST_Expr ast_expr;
  //Semantic attribute


  // Assign the class variables when called
  public AST_StatPairElemLHS(){
    this.typeName = null;
    this.ast_expr = null;
  }

  @Override
  public ArrayDeque<AST_Node> getNodes(){
    ArrayDeque<AST_Node> returnList = new ArrayDeque<>();
    returnList.addLast(ast_expr);
    return returnList;
  }

  @Override
  public void setSyntacticAttributes(String value){
    if(typeName == null){
      this.typeName = value;
    } else {
      System.out.println("Unrecognised String Attribute" + this.getClass().getSimpleName());
    }
  }

  @Override
  public String getSyntacticAttributes(String strToGet){
    if(strToGet.equals("typeName")){
      return typeName;
    } else {
      System.out.println("Unrecognised String Attribute" + this.getClass().getSimpleName());
      return null;
    }
  }

  @Override
  public boolean isEmbeddedNodesFull(){
    return ast_expr != null;
  }

  @Override
  public AST_Node getEmbeddedAST(String astToGet, int counter){
    if(astToGet.equals("ast_expr")){
      return ast_expr;
    }
    System.out.println("Unrecognised AST Node at class: " + this.getClass().getSimpleName());
    return null;
  }

  @Override
  public void setEmbeddedAST(String astToSet, AST_Node nodeToSet){
    if(astToSet.equals("expr")){
      ast_expr = (AST_Expr) nodeToSet;
    } else {
      System.out.println("Unrecognised AST Node at class: " + this.getClass().getSimpleName());
    }
  }


  @Override
  //Semantic Analysis and print error message if needed
  protected boolean CheckSemantics(SymbolTable ST){
    return true;
  }

  @Override
  // Called from visitor
  public void Check(SymbolTable ST){
    if(CheckSemantics(ST)){
      setType(ast_expr.getType());
    }
  }

  @Override
  public void printContents(){
    System.out.println(this.getClass().getSimpleName() + ": ");
    System.out.println("typeName: " + typeName);
    if(ast_expr == null){
      System.out.println("ast_expr: null");
    } else {
      System.out.println("ast_expr: has content");
    }
  }
}

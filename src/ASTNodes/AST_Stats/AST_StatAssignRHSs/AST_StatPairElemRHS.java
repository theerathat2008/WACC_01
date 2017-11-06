package ASTNodes.AST_Stats.AST_StatAssignRHSs;

import ASTNodes.AST_Exprs.AST_Expr;
import ASTNodes.AST_Node;

public class AST_StatPairElemRHS extends AST_StatAssignRHS {
  //Syntactic attributes
  String typeName;
  AST_Expr ast_expr;
  //Semantic attribute


  // Assign the class variables when called
  public AST_StatPairElemRHS(){
    this.ast_expr = null;
    this.typeName = null;
  }

  @Override
  public void setSyntacticAttributes(String value){
    if(typeName == null){
      this.typeName = value;
    } else {
      System.out.println("Unrecognised String Attribute");
    }
  }

  @Override
  public String getSyntacticAttributes(String strToGet){
    if(strToGet.equals("typeName")){
      return typeName;
    } else {
      System.out.println("Unrecognised String Attribute");
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
    System.out.println("Unrecognised AST Node.");
    return null;
  }

  @Override
  public void setEmbeddedAST(String astToSet, AST_Node nodeToSet){
    if(astToSet.equals("expr")){
      ast_expr = (AST_Expr) nodeToSet;
    }
    System.out.println("Unrecognised AST Node.");
  }



  //Semantic Analysis and print error message if needed
  @Override
  protected boolean CheckSemantics(){
    return true;
  }

  // Called from visitor
  @Override
  public void Check(){
    if(CheckSemantics()){
      //Do symbol table stuff
    }
  }

  @Override
  public void printContents(){
    System.out.println("typeName: " + typeName);
    if(ast_expr == null){
      System.out.println("ast_expr: null");
    } else {
      System.out.println("ast_expr: has content");
    }
  }

}

package ASTNodes.AST_Exprs;

import ASTNodes.AST_Node;

public class AST_ExprUnary extends AST_Expr{
  //Syntactic attributes
  String opName;
  AST_Expr astExpr;
  //Semantic attribute

  // Assign the class variables when called
  public AST_ExprUnary(){
    this.astExpr = null;
  }

  public boolean isEmbeddedNodesFull(){
    return astExpr != null;
  }

  public AST_Node getEmbeddedAST(String astToGet, int counter){
    if(astToGet.equals("astExpr")){
      return astExpr;
    }
    System.out.println("Unrecognised AST Node.");
    return null;
  }

  public void setEmbeddedAST(String astToSet, AST_Node nodeToSet){
    if(astToSet.equals("expr")){
      astExpr = (AST_Expr) nodeToSet;
    } else {
      System.out.println("Unrecognised AST Node.");
    }
  }


  //Semantic Analysis and print error message if needed
  protected boolean CheckSemantics(){
    return true;
  }

  // Called from visitor
  public void Check(){
    if(CheckSemantics()){
      //Do symbol table stuff
    }
  }
}

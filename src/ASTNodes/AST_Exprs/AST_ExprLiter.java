package ASTNodes.AST_Exprs;

import ASTNodes.AST_Node;

public class AST_ExprLiter extends AST_Expr{
  //Syntactic attributes
  String constant;
  String literal;
  //Semantic attribute

  // Assign the class variables when called
  public AST_ExprLiter(){

  }

  public boolean isEmbeddedNodesFull(){
    return true;
  }

  public AST_Node getEmbeddedAST(String astToGet, int counter){
    System.out.println("Terminal AST Node.");
    return null;
  }

  public void setEmbeddedAST(String astToSet, AST_Node nodeToSet){
    System.out.println("Terminal AST Node.");
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

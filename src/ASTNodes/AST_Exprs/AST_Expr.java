package ASTNodes.AST_Exprs;

import ASTNodes.AST_Node;

public class AST_Expr extends AST_Node{
  //Syntactic attributes

  //Semantic attribute

  // Assign the class variables when called

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

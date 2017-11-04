package ASTNodes.AST_Exprs;

import ASTNodes.AST_Separator;

public class AST_ExprEnclosed extends AST_Expr{
  //Syntactic attributes
  AST_Separator leftSepAST;
  AST_Expr exprAST;
  AST_Separator rightSepAST;
  //Semantic attribute

  // Assign the class variables when called
  public AST_ExprEnclosed(){

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

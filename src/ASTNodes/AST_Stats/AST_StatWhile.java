package ASTNodes.AST_Stats;


import ASTNodes.AST_Exprs.AST_Expr;

public class AST_StatWhile extends AST_Stat{
  //Syntactic attributes
  AST_Expr exprAST;
  AST_Stat statAST;
  //Semantic attribute


  // Assign the class variables when called
  public AST_StatWhile(){

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

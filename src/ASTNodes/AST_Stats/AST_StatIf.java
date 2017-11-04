package ASTNodes.AST_Stats;

import ASTNodes.AST_Exprs.AST_Expr;

public class AST_StatIf extends AST_Stat{
  //Syntactic attributes
  AST_Expr expr;
  AST_Stat thenStat;
  AST_Stat elseStat;
  //Semantic attribute


  // Assign the class variables when called
  public AST_StatIf(){

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

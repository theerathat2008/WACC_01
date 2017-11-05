package ASTNodes.AST_Stats.AST_StatAssignLHSs;

import ASTNodes.AST_Exprs.AST_Expr;

public class AST_StatPairElemLHS extends AST_StatAssignLHS{
  //Syntactic attributes
  String typeName;
  AST_Expr ast_expr;
  //Semantic attribute


  // Assign the class variables when called
  public AST_StatPairElemLHS(){

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

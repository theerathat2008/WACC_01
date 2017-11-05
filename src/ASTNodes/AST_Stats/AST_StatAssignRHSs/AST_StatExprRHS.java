package ASTNodes.AST_Stats.AST_StatAssignRHSs;

import ASTNodes.AST_Exprs.AST_Expr;

public class AST_StatExprRHS extends AST_StatAssignRHS {
  //Syntactic attributes
  AST_Expr ast_expr;
  //Semantic attribute


  // Assign the class variables when called
  public AST_StatExprRHS(){

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

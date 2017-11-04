package ASTNodes.AST_Stats.AST_StatAssignRHSs;

import ASTNodes.AST_Exprs.AST_Expr;

import java.util.List;

public class AST_StatCallRHS extends AST_StatAssignRHS{
  //Syntactic attributes
  String funcName;
  List<AST_Expr> ast_exprList;
  //Semantic attribute


  // Assign the class variables when called
  public AST_StatCallRHS(){

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

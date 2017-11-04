package ASTNodes.AST_Stats;

import ASTNodes.AST_Exprs.AST_Expr;
import IdentifierObjects.StatObjs.StatExprObj;

public class AST_StatExpr extends AST_Stat{
  //Syntactic attributes
  AST_Expr expr;
  //Semantic attribute
  StatExprObj statExprObj;

  // Assign the class variables when called
  public AST_StatExpr(){

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

}

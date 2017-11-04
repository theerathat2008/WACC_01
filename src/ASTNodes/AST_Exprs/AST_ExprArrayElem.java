package ASTNodes.AST_Exprs;

import java.util.List;

public class AST_ExprArrayElem extends AST_Expr{
  //Syntactic attributes
  String arrayName;
  List<AST_Expr> ast_exprList;
  //Semantic attribute

  // Assign the class variables when called
  public AST_ExprArrayElem(){

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

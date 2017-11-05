package ASTNodes.AST_Exprs;

public class AST_ExprUnary extends AST_Expr{
  //Syntactic attributes
  String opName;
  AST_Expr astExpr;
  //Semantic attribute

  // Assign the class variables when called
  public AST_ExprUnary(){

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

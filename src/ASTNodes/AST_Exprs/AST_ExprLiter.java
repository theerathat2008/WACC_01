package ASTNodes.AST_Exprs;

public class AST_ExprLiter extends AST_Expr{
  //Syntactic attributes
  String constant;
  String literal;
  //Semantic attribute

  // Assign the class variables when called
  public AST_ExprLiter(){

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

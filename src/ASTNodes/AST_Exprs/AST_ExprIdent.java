package ASTNodes.AST_Exprs;

public class AST_ExprIdent extends AST_Expr{
  //Syntactic attributes
  String varName;
  //Semantic attribute

  // Assign the class variables when called
  public AST_ExprIdent(){

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

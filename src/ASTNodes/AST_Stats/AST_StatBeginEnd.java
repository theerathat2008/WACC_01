package ASTNodes.AST_Stats;

public class AST_StatBeginEnd extends AST_Stat {
  //Syntactic attributes
  AST_Stat statAST;
  //Semantic attribute


  // Assign the class variables when called
  public AST_StatBeginEnd(){

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

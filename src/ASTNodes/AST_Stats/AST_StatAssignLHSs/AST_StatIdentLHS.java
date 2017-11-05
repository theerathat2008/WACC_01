package ASTNodes.AST_Stats.AST_StatAssignLHSs;

public class AST_StatIdentLHS extends AST_StatAssignLHS{
  //Syntactic attributes
  String identName;

  //Semantic attribute


  // Assign the class variables when called
  public AST_StatIdentLHS(){

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

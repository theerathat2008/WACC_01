package ASTNodes.AST_Stats.AST_StatAssignLHSs;

import ASTNodes.AST_Node;

public class AST_StatIdentLHS extends AST_StatAssignLHS{
  //Syntactic attributes
  String identName;

  //Semantic attribute


  // Assign the class variables when called
  public AST_StatIdentLHS(){

  }


  public AST_Node getEmbeddedAST(String astToGet, int counter){
    System.out.println("Terminal AST Node.");
    return null;
  }

  public void setEmbeddedAST(String astToSet, AST_Node nodeToSet){
    System.out.println("Terminal AST Node.");
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

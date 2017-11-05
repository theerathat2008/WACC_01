package ASTNodes.AST_Stats.AST_StatAssignRHSs;

import ASTNodes.AST_Node;
import ASTNodes.AST_Stats.AST_Stat;
import IdentifierObjects.StatObjs.StatObj;

public class AST_StatAssignRHS extends AST_Stat {
  //Syntactic attributes
  String statName;
  //Semantic attribute
  StatObj statObj;

  // Assign the class variables when called
  public AST_StatAssignRHS(){

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

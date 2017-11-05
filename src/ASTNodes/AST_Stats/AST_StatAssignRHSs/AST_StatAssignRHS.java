package ASTNodes.AST_Stats.AST_StatAssignRHSs;

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

package ASTNodes.AST_Stats;

import IdentifierObjects.StatObjs.StatObj;

public class AST_StatMult extends AST_Stat{
  //Syntactic attributes
  AST_Stat stat1;
  AST_Stat stat2;
  //Semantic attribute

  // Assign the class variables when called
  public AST_StatMult(){

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

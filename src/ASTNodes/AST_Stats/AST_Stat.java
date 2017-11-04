package ASTNodes.AST_Stats;

import ASTNodes.AST_Node;
import IdentifierObjects.StatObjs.StatObj;

public class AST_Stat extends AST_Node {
  //Syntactic attributes
  String statName;
  //Semantic attribute
  StatObj statObj;

  // Assign the class variables when called
  public AST_Stat(){

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

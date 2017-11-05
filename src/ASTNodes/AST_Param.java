package ASTNodes;

import IdentifierObjects.ParamObj;

public class AST_Param extends AST_Node {
  //Syntactic attributes
  String paramType;
  String paramName;
  //Semantic attribute
  ParamObj paramObj;

  // Assign the class variables when called
  public AST_Param(){

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

package ASTNodes;

import IdentifierObjects.ParamListObj;

import java.util.List;

public class AST_ParamList extends AST_Node{
  //Syntactic attributes
  List<AST_Param> paramList;
  //Semantic attribute
  ParamListObj paramListObj;

  // Assign the class variables when called
  public AST_ParamList(){

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

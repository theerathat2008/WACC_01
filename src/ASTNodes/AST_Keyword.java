package ASTNodes;

import IdentifierObjects.KeywordObj;

public class AST_Keyword extends AST_Node {
  //Syntactic attributes
  String keyword_name;
  //Semantic attribute
  KeywordObj keywordObj;

  // Assign the class variables when called
  public AST_Keyword(){

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

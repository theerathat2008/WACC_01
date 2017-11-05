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

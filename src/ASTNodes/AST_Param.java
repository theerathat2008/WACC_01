package ASTNodes;

import ASTNodes.AST_TYPES.AST_Type;

public class AST_Param extends AST_Node {
  //Syntactic attributes
  AST_Type ast_type;
  String paramName;
  //Semantic attribute

  // Assign the class variables when called
  public AST_Param(){
    this.paramName = null;
    this.ast_type = null;
  }



  @Override
  public void setSyntacticAttributes(String value){
    if (paramName == null){
      this.paramName = value;
    } else {
      System.out.println("Unrecognised String Attribute");
    }
  }


  @Override
  public String getSyntacticAttributes(String strToGet){
    if (strToGet.equals("paramName")){
      return paramName;
    } else {
      System.out.println("Unrecognised String Attribute");
      return null;
    }
  }

  /**
   * Returns true if the embedded Nodes have value
   */
  @Override
  public boolean isEmbeddedNodesFull(){
    return ast_type != null;
  }

  @Override
  public AST_Node getEmbeddedAST(String astToGet, int counter){
    if (astToGet.equals("ast_type")){
      return ast_type;
    }
    System.out.println("Unrecognised AST Node.");
    return null;
  }

  @Override
  public void setEmbeddedAST(String astToSet, AST_Node nodeToSet){
    if(astToSet.equals("ast_type")){
      ast_type = (AST_Type) nodeToSet;
    } else {
      System.out.println("Unrecognised AST Node.");
    }
  }

  //Semantic Analysis and print error message if needed
  @Override
  protected boolean CheckSemantics(){
    return true;
  }

  // Called from visitor
  @Override
  public void Check(){
    if(CheckSemantics()){
      //Do symbol table stuff
    }
  }

  @Override
  public void printContents(){
    if(ast_type == null){
      System.out.println("ast_type: null");
    } else {
      System.out.println("ast_type: has content");
    }
    System.out.println("paramName: " + paramName);
  }
}

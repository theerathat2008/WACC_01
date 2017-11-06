package ASTNodes.AST_TYPES;

import ASTNodes.AST_Node;

public class AST_BaseType extends AST_Type {
  //Syntactic attributes
  String baseTypeName;
  //Semantic attribute

  // Assign the class variables when called
  public AST_BaseType(){
    this.baseTypeName = null;
  }

  @Override
  public boolean isEmbeddedNodesFull(){
    return true;
  }

  @Override
  public void setSyntacticAttributes(String value){
    if(baseTypeName == null){
      this.baseTypeName = value;
    } else {
      System.out.println("Unrecognised String Attribute");
    }
  }


  @Override
  public String getSyntacticAttributes(String strToGet){
    if(strToGet.equals("baseTypeName")){
      return baseTypeName;
    } else {
      System.out.println("Unrecognised String Attribute");
      return null;
    }
  }

  @Override
  public AST_Node getEmbeddedAST(String astToGet, int counter){
    System.out.println("Terminal AST Node at: " + this.getClass().getSimpleName());
    return null;
  }

  @Override
  public void setEmbeddedAST(String astToSet, AST_Node nodeToSet){
    System.out.println("Terminal AST Node at: " + this.getClass().getSimpleName());
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
    System.out.println("baseTypeName: " + baseTypeName);
  }
}

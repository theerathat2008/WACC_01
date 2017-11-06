package ASTNodes.AST_Exprs;

import ASTNodes.AST_Node;

public class AST_Expr extends AST_Node{
  //Syntactic attributes

  //Semantic attribute

  // Assign the class variables when called

  @Override
  public boolean isEmbeddedNodesFull(){
    return true;
  }

  @Override
  public void setSyntacticAttributes(String value){
    System.out.println("Base AST Node");
  }


  @Override
  public String getSyntacticAttributes(String strToGet){
    System.out.println("Base AST Node");
    return null;
  }

  @Override
  public AST_Node getEmbeddedAST(String astToGet, int counter){
    System.out.println("Base AST Node.");
    return null;
  }

  @Override
  public void setEmbeddedAST(String astToSet, AST_Node nodeToSet){
    System.out.println("Base AST Node.");
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
    System.out.println("BASE TYPE");

  }
}

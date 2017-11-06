package ASTNodes.AST_TYPES.AST_PairElemTypes;

import ASTNodes.AST_Node;
import ASTNodes.AST_TYPES.AST_Type;

public class AST_ArrayTypePair extends  AST_PairElemType{
  //Syntactic attributes
  AST_Type ast_type;
  //Semantic attribute

  // Assign the class variables when called
  public AST_ArrayTypePair(){
    this.ast_type = null;
  }

  @Override
  public boolean isEmbeddedNodesFull(){
    return ast_type != null;
  }

  @Override
  public void setSyntacticAttributes(String value){
    System.out.println("No Syntactic Attribute");
  }


  @Override
  public String getSyntacticAttributes(String strToGet){
    System.out.println("No Syntactic Attribute");
    return null;
  }

  @Override
  public AST_Node getEmbeddedAST(String astToGet, int counter){
    if(astToGet.equals("ast_type")){
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
  }
}

package ASTNodes.AST_TYPES;

import ASTNodes.AST_Node;

import java.util.ArrayDeque;

public class AST_ArrayType extends AST_Type{
  //Syntactic attributes
  AST_Type ast_type;
  //Semantic attribute

  // Assign the class variables when called
  public AST_ArrayType(){
    this.ast_type = null;
  }

  @Override
  public ArrayDeque<AST_Node> getNodes(){
    ArrayDeque<AST_Node> returnList = new ArrayDeque<>();
    returnList.addLast(ast_type);
    return returnList;
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
    System.out.println("Unrecognised AST Node at class: " + this.getClass().getSimpleName());
    return null;
  }

  @Override
  public void setEmbeddedAST(String astToSet, AST_Node nodeToSet){
    if(astToSet.equals("ast_type")){
      ast_type = (AST_Type) nodeToSet;
    } else {
      System.out.println("Unrecognised AST Node at class: " + this.getClass().getSimpleName());
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
    System.out.println(this.getClass().getSimpleName() + ": ");
    if(ast_type == null){
      System.out.println("ast_type: null");
    } else {
      System.out.println("ast_type: has content");
    }
  }
}

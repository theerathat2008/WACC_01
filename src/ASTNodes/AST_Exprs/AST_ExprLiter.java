package ASTNodes.AST_Exprs;

import ASTNodes.AST_Node;

import java.util.ArrayDeque;

public class AST_ExprLiter extends AST_Expr{
  //Syntactic attributes
  String constant;
  String literal;
  //Semantic attribute

  // Assign the class variables when called
  public AST_ExprLiter(){
    this.constant = null;
    this.literal = null;

  }

  @Override
  public ArrayDeque<AST_Node> getNodes(){
    System.out.println("Terminal AST Node at: " + this.getClass().getSimpleName());
    return null;
  }


  @Override
  public void setSyntacticAttributes(String value){
    if(constant == null){
      this.constant = value;
    } else if(literal == null){
      this.literal = value;
    } else {
      System.out.println("Unrecognised String Attribute");
    }
  }


  @Override
  public String getSyntacticAttributes(String strToGet){
    if(strToGet.equals("constant")){
      return constant;
    } else if(strToGet.equals("literal")){
      return literal;
    } else {
      System.out.println("Unrecognised String Attribute");
      return null;
    }
  }

  @Override
  public boolean isEmbeddedNodesFull(){
    return true;
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
    System.out.println(this.getClass().getSimpleName() + ": ");
    System.out.println("constant: " + constant);
    System.out.println("literal: " + literal);

  }
}

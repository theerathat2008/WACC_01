package ASTNodes.AST_Exprs;

import ASTNodes.AST_Node;

import java.util.ArrayDeque;

public class AST_ExprUnary extends AST_Expr{
  //Syntactic attributes
  String opName;
  AST_Expr astExpr;
  //Semantic attribute

  // Assign the class variables when called
  public AST_ExprUnary(){
    this.opName = null;
    this.astExpr = null;
  }


  @Override
  public ArrayDeque<AST_Node> getNodes(){
    ArrayDeque<AST_Node> returnList = new ArrayDeque<>();
    returnList.addLast(astExpr);
    return returnList;
  }

  @Override
  public boolean isEmbeddedNodesFull(){
    return astExpr != null;
  }

  @Override
  public void setSyntacticAttributes(String value){
    if(opName == null){
      this.opName = value;
    } else {
      System.out.println("Unrecognised String Attribute");
    }
  }


  @Override
  public String getSyntacticAttributes(String strToGet){
    if(strToGet.equals("opName")){
      return opName;
    } else {
      System.out.println("Unrecognised String Attribute");
      return null;
    }
  }

  @Override
  public AST_Node getEmbeddedAST(String astToGet, int counter){
    if(astToGet.equals("astExpr")){
      return astExpr;
    }
    System.out.println("Unrecognised AST Node.");
    return null;
  }

  @Override
  public void setEmbeddedAST(String astToSet, AST_Node nodeToSet){
    if(astToSet.equals("expr")){
      astExpr = (AST_Expr) nodeToSet;
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
    System.out.println(this.getClass().getSimpleName() + ": ");
    System.out.println("opName: " + opName);
    if(astExpr == null){
      System.out.println("astExpr: null");
    } else {
      System.out.println("astExpr: has content");
    }
  }
}

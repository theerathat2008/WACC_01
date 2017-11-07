package ASTNodes.AST_Stats;


import ASTNodes.AST_Exprs.AST_Expr;
import ASTNodes.AST_Node;

import java.util.ArrayDeque;

public class AST_StatWhile extends AST_Stat{
  //Syntactic attributes
  AST_Expr exprAST;
  AST_Stat statAST;
  //Semantic attribute


  // Assign the class variables when called
  public AST_StatWhile(){
    this.exprAST = null;
    this.statAST = null;
  }

  @Override
  public ArrayDeque<AST_Node> getNodes(){
    ArrayDeque<AST_Node> returnList = new ArrayDeque<>();
    returnList.addLast(exprAST);
    returnList.addLast(statAST);
    return returnList;
  }


  @Override
  public boolean isEmbeddedNodesFull(){
    return exprAST != null && statAST != null;
  }

  @Override
  public void setSyntacticAttributes(String value){
    System.out.println("No String Syntactic Attributes in class: " + this.getClass().getSimpleName());
  }


  @Override
  public String getSyntacticAttributes(String strToGet){
    System.out.println("No String Syntactic Attributes in class: " + this.getClass().getSimpleName());
    return null;
  }


  @Override
  public AST_Node getEmbeddedAST(String astToGet, int counter){
    if(astToGet.equals("expr")){
      return exprAST;
    } else if (astToGet.equals("statAST")){
      return statAST;
    }
    System.out.println("Unrecognised AST Node at class: " + this.getClass().getSimpleName());
    return null;
  }

  @Override
  public void setEmbeddedAST(String astToSet, AST_Node nodeToSet){
    if(astToSet.equals("expr")){
      exprAST = (AST_Expr) nodeToSet;
    } else if (astToSet.equals("statement")){
      statAST = (AST_Stat) nodeToSet;
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
    if(exprAST == null){
      System.out.println("exprAST: null");
    } else {
      System.out.println("exprAST: has content");
    }
    if(statAST == null){
      System.out.println("statAST: null");
    } else {
      System.out.println("statAST: has content");
    }
  }
}

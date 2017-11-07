package ASTNodes.AST_Exprs;

import ASTNodes.AST_Node;
import SymbolTable.SymbolTable;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class AST_ExprArrayElem extends AST_Expr{
  //Syntactic attributes
  String arrayName;
  int numOfExpr;
  List<AST_Expr> ast_exprList;
  //Semantic attribute

  // Assign the class variables when called
  public AST_ExprArrayElem(int numberOfChildren){
    ast_exprList = new ArrayList<>();
    this.numOfExpr = (numberOfChildren - 1) / 3;
    this.arrayName = null;
  }

  @Override
  public ArrayDeque<AST_Node> getNodes(){
    ArrayDeque<AST_Node> returnList = new ArrayDeque<>();
    for(AST_Expr expr : ast_exprList){
      returnList.addLast(expr);
    }
    return returnList;
  }

  @Override
  public void setSyntacticAttributes(String value){
    if(arrayName == null){
      this.arrayName = value;
    } else {
      System.out.println("Unrecognised String Attribute" + this.getClass().getSimpleName());
    }
  }


  @Override
  public String getSyntacticAttributes(String strToGet){
    if(strToGet.equals("arrayName")){
      return arrayName;
    } else {
      System.out.println("Unrecognised String Attribute" + this.getClass().getSimpleName());
      return null;
    }
  }


  @Override
  public boolean isEmbeddedNodesFull(){
    return ast_exprList.size() == numOfExpr;
  }

  @Override
  public AST_Node getEmbeddedAST(String astToGet, int counter){
    if(astToGet.equals("ast_exprList")){
      return ast_exprList.get(counter);
    }
    System.out.println("Unrecognised AST Node at class: " + this.getClass().getSimpleName());
    return null;
  }

  @Override
  public void setEmbeddedAST(String astToSet, AST_Node nodeToSet){
    if(astToSet.equals("expr")){
      ast_exprList.add((AST_Expr)nodeToSet);
    } else {
      System.out.println("Unrecognised AST Node at class: " + this.getClass().getSimpleName());
    }
  }



  //Semantic Analysis and print error message if needed
  protected boolean CheckSemantics(SymbolTable ST){
    return true;
  }

  // Called from visitor
  public void Check(SymbolTable ST){
    if(CheckSemantics(ST)){
      setType(ast_exprList.get(0).type + "[]");
    }
  }

  @Override
  public void printContents(){
    System.out.println(this.getClass().getSimpleName() + ": ");
    System.out.println("arrayName: " + arrayName);
    System.out.println("numOfExpr: " + numOfExpr);
    if(ast_exprList.size() == numOfExpr){
      System.out.println("ast_exprList: list full");
    } else {
      System.out.println("ast_exprList has size: " + ast_exprList.size());
    }
  }
}

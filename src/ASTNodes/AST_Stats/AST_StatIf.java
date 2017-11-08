package ASTNodes.AST_Stats;

import ASTNodes.AST_Exprs.AST_Expr;
import ASTNodes.AST_Node;
import SymbolTable.SymbolTable;

import java.util.ArrayDeque;

public class AST_StatIf extends AST_Stat{
  //Syntactic attributes
  AST_Expr expr;
  AST_Stat thenStat;
  AST_Stat elseStat;
  //Semantic attribute


  // Assign the class variables when called
  public AST_StatIf(){
    this.expr = null;
    this.thenStat = null;
    this.elseStat = null;
  }

  @Override
  public ArrayDeque<AST_Node> getNodes(){
    ArrayDeque<AST_Node> returnList = new ArrayDeque<>();
    returnList.addLast(expr);
    returnList.addLast(thenStat);
    returnList.addLast(elseStat);
    return returnList;
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
  public boolean isEmbeddedNodesFull(){
    return expr != null && thenStat != null && elseStat != null;
  }


  @Override
  public AST_Node getEmbeddedAST(String astToGet, int counter){
    if(astToGet.equals("expr")){
      return expr;
    } else if (astToGet.equals("thenStat")){
      return thenStat;
    } else if (astToGet.equals("elseStat")){
      return elseStat;
    }
    System.out.println("Unrecognised AST Node at class: " + this.getClass().getSimpleName());
    return null;
  }

  @Override
  public void setEmbeddedAST(String astToSet, AST_Node nodeToSet){
    if(astToSet.equals("expr")){
      expr = (AST_Expr) nodeToSet;
    } else if (astToSet.equals("statement")){

      if(thenStat == null){
        thenStat = (AST_Stat) nodeToSet;
      } else if (elseStat == null){
        elseStat = (AST_Stat) nodeToSet;
      } else {
        System.out.println("If and then in AST_StatIf have already been assigned.");
      }

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
      //Do symbol table stuff
    }
  }

  @Override
  public void printContents(){
    System.out.println(this.getClass().getSimpleName() + ": ");
    if(expr == null){
      System.out.println("expr: null");
    } else {
      System.out.println("expr: has content");
    }
    if(thenStat == null){
      System.out.println("thenStat: null");
    } else {
      System.out.println("thenStat: has content");
    }
    if(elseStat == null){
      System.out.println("elseStat: null");
    } else {
      System.out.println("elseStat: has content");
    }
  }
}

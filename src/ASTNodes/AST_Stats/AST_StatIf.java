package ASTNodes.AST_Stats;

import ASTNodes.AST_Exprs.AST_Expr;
import ASTNodes.AST_Node;

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

  public boolean isEmbeddedNodesFull(){
    return expr != null && thenStat != null && elseStat != null;
  }


  public AST_Node getEmbeddedAST(String astToGet, int counter){
    if(astToGet.equals("expr")){
      return expr;
    } else if (astToGet.equals("thenStat")){
      return thenStat;
    } else if (astToGet.equals("elseStat")){
      return elseStat;
    }
    System.out.println("Unrecognised AST Node.");
    return null;
  }

  public void setEmbeddedAST(String astToSet, AST_Node nodeToSet){
    if(astToSet.equals("expr")){
      expr = (AST_Expr) nodeToSet;
    } else if (astToSet.equals("thenStat")){
      thenStat = (AST_Stat) nodeToSet;
    } else if (astToSet.equals("elseStat")){
      elseStat = (AST_Stat) nodeToSet;
    } else {
      System.out.println("Unrecognised AST Node.");
    }
  }


  //Semantic Analysis and print error message if needed
  protected boolean CheckSemantics(){
    return true;
  }

  // Called from visitor
  public void Check(){
    if(CheckSemantics()){
      //Do symbol table stuff
    }
  }
}

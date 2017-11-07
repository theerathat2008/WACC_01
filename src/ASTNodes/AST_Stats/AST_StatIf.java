package ASTNodes.AST_Stats;

import ASTNodes.AST_Exprs.AST_Expr;
import ASTNodes.AST_Node;
import SymbolTable.SymbolTable;

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

  public void setSyntacticAttributes(String value){
    System.out.println("No String Syntactic Attributes");
  }


  public String getSyntacticAttributes(String strToGet){
    System.out.println("No String Syntactic Attributes");
    return null;
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
    } else if (astToSet.equals("statement")){

      if(thenStat == null){
        thenStat = (AST_Stat) nodeToSet;
      } else if (elseStat == null){
        elseStat = (AST_Stat) nodeToSet;
      } else {
        System.out.println("If and then in AST_StatIf have already been assigned.");
      }

    } else {
      System.out.println("Unrecognised AST Node.");
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
}

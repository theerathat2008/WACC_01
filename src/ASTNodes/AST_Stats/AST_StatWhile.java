package ASTNodes.AST_Stats;


import ASTNodes.AST_Exprs.AST_Expr;
import ASTNodes.AST_Node;

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

  public boolean isEmbeddedNodesFull(){
    return exprAST != null && statAST != null;
  }

  public AST_Node getEmbeddedAST(String astToGet, int counter){
    if(astToGet.equals("expr")){
      return exprAST;
    } else if (astToGet.equals("statAST")){
      return statAST;
    }
    System.out.println("Unrecognised AST Node.");
    return null;
  }

  public void setEmbeddedAST(String astToSet, AST_Node nodeToSet){
    if(astToSet.equals("expr")){
      exprAST = (AST_Expr) nodeToSet;
    } else if (astToSet.equals("statement")){
      statAST = (AST_Stat) nodeToSet;
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

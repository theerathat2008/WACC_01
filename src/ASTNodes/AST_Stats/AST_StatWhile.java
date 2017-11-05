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

  }

  public AST_Node getEmbeddedAST(String astToGet, int counter){
    if(astToGet.equals("paramList")){
      return exprAST;
    } else if (astToGet.equals("statement")){
      return statAST;
    }
    System.out.println("Unrecognised AST Node.");
    return null;
  }

  public void setEmbeddedAST(String astToSet, AST_Node nodeToSet){
    if(astToSet.equals("paramList")){
      exprAST = (AST_Expr) nodeToSet;
    } else if (astToSet.equals("statement")){
      statAST = (AST_Stat) nodeToSet;
    }
    System.out.println("Unrecognised AST Node.");
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

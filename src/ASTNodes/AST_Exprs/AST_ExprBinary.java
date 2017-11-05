package ASTNodes.AST_Exprs;

import ASTNodes.AST_Node;

public class AST_ExprBinary extends AST_Expr{
  //Syntactic attributes
  String opName;
  AST_Expr exprLeftAST;
  AST_Expr exprRightAST;
  //Semantic attribute

  // Assign the class variables when called
  public AST_ExprBinary(){

  }

  public AST_Node getEmbeddedAST(String astToGet, int counter){
    if(astToGet.equals("paramList")){
      return exprLeftAST;
    } else if (astToGet.equals("statement")){
      return exprRightAST;
    }
    System.out.println("Unrecognised AST Node.");
    return null;
  }

  public void setEmbeddedAST(String astToSet, AST_Node nodeToSet){
    if(astToSet.equals("paramList")){
      exprLeftAST = (AST_Expr) nodeToSet;
    } else if (astToSet.equals("statement")){
      exprRightAST = (AST_Expr) nodeToSet;
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

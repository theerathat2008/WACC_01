package ASTNodes.AST_Exprs;

import ASTNodes.AST_Node;
import ASTNodes.AST_Separator;

public class AST_ExprEnclosed extends AST_Expr{
  //Syntactic attributes
  AST_Separator leftSepAST;
  AST_Expr exprAST;
  AST_Separator rightSepAST;
  //Semantic attribute

  // Assign the class variables when called
  public AST_ExprEnclosed(){

  }

  public AST_Node getEmbeddedAST(String astToGet, int counter){
    if(astToGet.equals("paramList")){
      return leftSepAST;
    } else if (astToGet.equals("statement")){
      return exprAST;
    } else if (astToGet.equals("statement")){
      return rightSepAST;
    }
    System.out.println("Unrecognised AST Node.");
    return null;
  }

  public void setEmbeddedAST(String astToSet, AST_Node nodeToSet){
    if(astToSet.equals("paramList")){
      leftSepAST = (AST_Separator) nodeToSet;
    } else if (astToSet.equals("statement")){
      exprAST = (AST_Expr) nodeToSet;
    } else if (astToSet.equals("statement")){
      rightSepAST = (AST_Separator) nodeToSet;
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

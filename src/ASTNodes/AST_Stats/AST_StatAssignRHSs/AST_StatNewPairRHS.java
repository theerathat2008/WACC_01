package ASTNodes.AST_Stats.AST_StatAssignRHSs;

import ASTNodes.AST_Exprs.AST_Expr;
import ASTNodes.AST_Node;

public class AST_StatNewPairRHS extends AST_StatAssignRHS{
  //Syntactic attributes
  AST_Expr ast_expr_first;
  AST_Expr ast_expr_second;
  //Semantic attribute


  // Assign the class variables when called
  public AST_StatNewPairRHS(){

  }

  public AST_Node getEmbeddedAST(String astToGet, int counter){
    if(astToGet.equals("paramList")){
      return ast_expr_first;
    } else if (astToGet.equals("statement")){
      return ast_expr_second;
    }
    System.out.println("Unrecognised AST Node.");
    return null;
  }

  public void setEmbeddedAST(String astToSet, AST_Node nodeToSet){
    if(astToSet.equals("paramList")){
      ast_expr_first = (AST_Expr) nodeToSet;
    } else if (astToSet.equals("statement")){
      ast_expr_second = (AST_Expr) nodeToSet;
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

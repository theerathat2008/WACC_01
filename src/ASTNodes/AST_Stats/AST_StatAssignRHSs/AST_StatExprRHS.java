package ASTNodes.AST_Stats.AST_StatAssignRHSs;

import ASTNodes.AST_Exprs.AST_Expr;
import ASTNodes.AST_Node;
import SymbolTable.SymbolTable;

public class AST_StatExprRHS extends AST_StatAssignRHS {
  //Syntactic attributes
  AST_Expr ast_expr;
  //Semantic attribute


  // Assign the class variables when called
  public AST_StatExprRHS(){
    this.ast_expr = null;

  }


  public void setSyntacticAttributes(String value){
    System.out.println("No String Syntactic Attributes");
  }


  public String getSyntacticAttributes(String strToGet){
    System.out.println("No String Syntactic Attributes");
    return null;
  }


  public boolean isEmbeddedNodesFull(){
    return ast_expr != null;
  }


  public AST_Node getEmbeddedAST(String astToGet, int counter){
    if(astToGet.equals("ast_expr")){
      return ast_expr;
    }
    System.out.println("Unrecognised AST Node.");
    return null;
  }

  public void setEmbeddedAST(String astToSet, AST_Node nodeToSet){
    if(astToSet.equals("expr")){
      ast_expr = (AST_Expr)nodeToSet;
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

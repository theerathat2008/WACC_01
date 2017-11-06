package ASTNodes.AST_Stats.AST_StatAssignRHSs;

import ASTNodes.AST_Exprs.AST_Expr;
import ASTNodes.AST_Node;

import java.util.ArrayList;
import java.util.List;

public class AST_StatArrayLitRHS extends AST_StatAssignRHS{
  //Syntactic attributes
  List<AST_Expr> ast_exprList;
  int numOfExpr;
  //Semantic attribute


  // Assign the class variables when called
  public AST_StatArrayLitRHS(int numberOfChildren){
    ast_exprList = new ArrayList<>();
    if(numberOfChildren == 2){
      this.numOfExpr = 0;
    } else {
      this.numOfExpr = (numberOfChildren - 1) / 2;
    }
  }

  public void setSyntacticAttributes(String value){
    System.out.println("No String Syntactic Attributes");
  }


  public String getSyntacticAttributes(String strToGet){
    System.out.println("No String Syntactic Attributes");
    return null;
  }



  public boolean isEmbeddedNodesFull(){
    return ast_exprList.size() == numOfExpr;
  }


  public AST_Node getEmbeddedAST(String astToGet, int counter){
    if(astToGet.equals("ast_exprList")){
      return ast_exprList.get(counter);
    }
    System.out.println("Unrecognised AST Node.");
    return null;
  }

  public void setEmbeddedAST(String astToSet, AST_Node nodeToSet){
    if(astToSet.equals("ast_exprList")){
      ast_exprList.add((AST_Expr)nodeToSet);
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

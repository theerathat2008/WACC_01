package ASTNodes.AST_Stats.AST_StatAssignLHSs;

import ASTNodes.AST_Exprs.AST_Expr;
import ASTNodes.AST_Node;
import SymbolTable.SymbolTable;

import java.util.ArrayList;
import java.util.List;


//TODO ------------------------
//TODO Calculate the num of expression properly
//TODO -------------------------


public class AST_StatArrayElemLHS extends AST_StatAssignLHS{
  //Syntactic attributes
  String identName;
  List<AST_Expr> ast_exprList;
  int numOfExpr;
  //Semantic attribute


  // Assign the class variables when called
  public AST_StatArrayElemLHS(int numberOfChildren){
    ast_exprList = new ArrayList<>();
    this.numOfExpr = (numberOfChildren - 1) / 3;
    this.identName = null;
  }

  public void setSyntacticAttributes(String value){
    if(identName == null){
      this.identName = value;
    } else {
      System.out.println("Unrecognised String Attribute");
    }
  }


  public String getSyntacticAttributes(String strToGet){
    if(strToGet.equals("identName")){
      return identName;
    } else {
      System.out.println("Unrecognised String Attribute");
      return null;
    }
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
  protected boolean CheckSemantics(SymbolTable ST){
    return true;
  }

  // Called from visitor
  public void Check(SymbolTable ST){
    if(CheckSemantics(ST)){
      setType(ast_exprList.get(0).getType());
    }
  }

  public String getType(SymbolTable ST) {
    return null;
  }

}

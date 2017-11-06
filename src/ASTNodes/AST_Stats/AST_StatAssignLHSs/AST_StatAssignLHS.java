package ASTNodes.AST_Stats.AST_StatAssignLHSs;

import ASTNodes.AST_Node;
import ASTNodes.AST_Stats.AST_Stat;

public class AST_StatAssignLHS extends AST_Stat {

  @Override
  public void setSyntacticAttributes(String value){
    System.out.println("Base AST Node");
  }

  @Override
  public String getSyntacticAttributes(String strToGet){
    System.out.println("Base AST Node");
    return null;
  }


  @Override
  public AST_Node getEmbeddedAST(String astToGet, int counter){
    System.out.println("Base AST Node.");
    return null;
  }

  @Override
  public boolean isEmbeddedNodesFull(){
    return true;
  }

  @Override
  public void setEmbeddedAST(String astToSet, AST_Node nodeToSet){
    System.out.println("Base AST Node.");
  }

  @Override
  //Semantic Analysis and print error message if needed
  protected boolean CheckSemantics(){
    return true;

  }

  @Override
  // Called from visitor
  public void Check(){

  }

  @Override
  public void printContents() {
    System.out.println("BASE CLASS");
  }
}

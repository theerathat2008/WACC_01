package ASTNodes.AST_Stats.AST_StatAssignLHSs;

import ASTNodes.AST_Node;
import ASTNodes.AST_Stats.AST_Stat;

public class AST_StatAssignLHS extends AST_Stat {

  public void setSyntacticAttributes(String value){
    System.out.println("Base AST Node");
  }


  public String getSyntacticAttributes(String strToGet){
    System.out.println("Base AST Node");
    return null;
  }



  public AST_Node getEmbeddedAST(String astToGet, int counter){
    System.out.println("Base AST Node.");
    return null;
  }

  public boolean isEmbeddedNodesFull(){
    return true;
  }

  public void setEmbeddedAST(String astToSet, AST_Node nodeToSet){
    System.out.println("Base AST Node.");
  }


  //Semantic Analysis and print error message if needed
  protected boolean CheckSemantics(){
    return true;

  }

  // Called from visitor
  public void Check(){

  }

}

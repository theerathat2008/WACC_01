package ASTNodes.AST_Stats.AST_StatAssignRHSs;

import ASTNodes.AST_Node;
import ASTNodes.AST_Stats.AST_Stat;

import java.util.ArrayDeque;

/**
 * TODO DELETE STATNAME
 */

public class AST_StatAssignRHS extends AST_Stat {
  //Syntactic attributes
  String statName;
  //Semantic attribute

  // Assign the class variables when called
  public AST_StatAssignRHS(){
    this.statName = null;
  }

  @Override
  public ArrayDeque<AST_Node> getNodes(){
    System.out.println("Terminal AST Node at: " + this.getClass().getSimpleName());
    return null;
  }


  public void setSyntacticAttributes(String value){
    if(statName == null){
      this.statName = value;
    } else {
      System.out.println("Unrecognised String Attribute");
    }
  }

  @Override
  public String getSyntacticAttributes(String strToGet){
    if(strToGet.equals("statName")){
      return statName;
    } else {
      System.out.println("Unrecognised String Attribute");
      return null;
    }
  }

  @Override
  public boolean isEmbeddedNodesFull(){
    return true;
  }

  @Override
  public AST_Node getEmbeddedAST(String astToGet, int counter){
    System.out.println("Terminal AST Node at: " + this.getClass().getSimpleName());
    return null;
  }

  @Override
  public void setEmbeddedAST(String astToSet, AST_Node nodeToSet){
    System.out.println("Terminal AST Node at: " + this.getClass().getSimpleName());
  }



  //Semantic Analysis and print error message if needed
  @Override
  protected boolean CheckSemantics(){
    return true;
  }

  @Override
  // Called from visitor
  public void Check(){
    if(CheckSemantics()){
      //Do symbol table stuff
    }
  }

  @Override
  public void printContents(){
    System.out.println(this.getClass().getSimpleName() + ": ");
    System.out.println("statName: " + statName);
  }
}

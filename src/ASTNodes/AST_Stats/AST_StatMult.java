package ASTNodes.AST_Stats;

import ASTNodes.AST_Node;


public class AST_StatMult extends AST_Stat{
  //Syntactic attributes
  AST_Stat stat1;
  AST_Stat stat2;
  //Semantic attribute

  // Assign the class variables when called
  public AST_StatMult(){
    this.stat1 = null;
    this.stat2 = null;
  }

  public boolean isEmbeddedNodesFull(){
    return stat1 != null && stat2 != null;
  }

  public AST_Node getEmbeddedAST(String astToGet, int counter){
    if(astToGet.equals("stat1")){
      return stat1;
    } else if (astToGet.equals("stat2")){
      return stat2;
    }
    System.out.println("Unrecognised AST Node.");
    return null;
  }

  public void setEmbeddedAST(String astToSet, AST_Node nodeToSet){
    if(astToSet.equals("statement")){

      if(stat1 == null){
        stat1 = (AST_Stat) nodeToSet;
      } else if (stat2 == null){
        stat2 = (AST_Stat) nodeToSet;
      } else {
        System.out.println("Stat1 and Stat2 in AST_StatMult have already been assigned.");
      }

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

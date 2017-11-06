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

  @Override
  public void setSyntacticAttributes(String value){
    System.out.println("No String Syntactic Attributes");
  }


  @Override
  public String getSyntacticAttributes(String strToGet){
    System.out.println("No String Syntactic Attributes");
    return null;
  }

  @Override
  public boolean isEmbeddedNodesFull(){
    return stat1 != null && stat2 != null;
  }

  @Override
  public AST_Node getEmbeddedAST(String astToGet, int counter){
    if(astToGet.equals("stat1")){
      return stat1;
    } else if (astToGet.equals("stat2")){
      return stat2;
    }
    System.out.println("Unrecognised AST Node.");
    return null;
  }

  @Override
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
  @Override
  protected boolean CheckSemantics(){
    return true;
  }

  // Called from visitor
  @Override
  public void Check(){
    if(CheckSemantics()){
      //Do symbol table stuff
    }
  }

  @Override
  public void printContents(){
    if(stat1 == null){
      System.out.println("stat1: null");
    } else {
      System.out.println("stat1: has content");
    }
    if(stat2 == null){
      System.out.println("stat2: null");
    } else {
      System.out.println("stat2: has content");
    }
  }
}

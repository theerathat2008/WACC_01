package ASTNodes.AST_Stats;

import ASTNodes.AST_Node;

public class AST_Stat extends AST_Node {
  //Syntactic attributes
  String statName;
  //Semantic attribute

  // Assign the class variables when called
  public AST_Stat(){
    this.statName = null;

  }

  @Override
  public boolean isEmbeddedNodesFull(){
    return true;
  }

  @Override
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
  public AST_Node getEmbeddedAST(String astToGet, int counter){
    System.out.println("Base AST Node.");
    return null;
  }

  @Override
  public void setEmbeddedAST(String astToSet, AST_Node nodeToSet){
    System.out.println("Base AST Node.");
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
    System.out.println("statName: " + statName);
  }
}

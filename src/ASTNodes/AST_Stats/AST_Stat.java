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

  public boolean isEmbeddedNodesFull(){
    return true;
  }

  public void setSyntacticAttributes(String value){
    if(statName == null){
      this.statName = value;
    } else {
      System.out.println("Unrecognised String Attribute");
    }
  }


  public String getSyntacticAttributes(String strToGet){
    if(strToGet.equals("statName")){
      return statName;
    } else {
      System.out.println("Unrecognised String Attribute");
      return null;
    }
  }

  public AST_Node getEmbeddedAST(String astToGet, int counter){
    System.out.println("Base AST Node.");
    return null;
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
    if(CheckSemantics()){
      //Do symbol table stuff
    }
  }
}

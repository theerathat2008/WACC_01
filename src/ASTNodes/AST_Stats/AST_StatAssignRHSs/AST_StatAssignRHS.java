package ASTNodes.AST_Stats.AST_StatAssignRHSs;

import ASTNodes.AST_Node;
import ASTNodes.AST_Stats.AST_Stat;
import SymbolTable.SymbolTable;

public class AST_StatAssignRHS extends AST_Stat {
  //Syntactic attributes
  String statName;
  //Semantic attribute

  // Assign the class variables when called
  public AST_StatAssignRHS(){
    this.statName = null;
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

  public String getType(SymbolTable ST) {
    return null;
  }

  public boolean isEmbeddedNodesFull(){
    return true;
  }

  public AST_Node getEmbeddedAST(String astToGet, int counter){
    System.out.println("Terminal AST Node.");
    return null;
  }

  public void setEmbeddedAST(String astToSet, AST_Node nodeToSet){
    System.out.println("Terminal AST Node.");
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

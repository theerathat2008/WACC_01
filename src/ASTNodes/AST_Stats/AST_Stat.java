package ASTNodes.AST_Stats;

import ASTNodes.AST_Node;
import SymbolTable.SymbolTable;

import java.util.ArrayDeque;

public class AST_Stat extends AST_Node {
  //Syntactic attributes
  String statName;
  //Semantic attribute

  // Assign the class variables when called
  public AST_Stat(){
    this.statName = null;

  }


  @Override
  public ArrayDeque<AST_Node> getNodes(){
    System.out.println("BASE AST Node at: " + this.getClass().getSimpleName());
    return null;
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
      System.out.println("Unrecognised String Attribute" + this.getClass().getSimpleName());
    }
  }


  @Override
  public String getSyntacticAttributes(String strToGet){
    if(strToGet.equals("statName")){
      return statName;
    } else {
      System.out.println("Unrecognised String Attribute" + this.getClass().getSimpleName());
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
  protected boolean CheckSemantics(SymbolTable ST){
    return true;
  }

  // Called from visitor
  public void Check(SymbolTable ST){
    if(CheckSemantics(ST)){
      //Do symbol table stuff
    }
  }

  @Override
  public void printContents(){
    System.out.println(this.getClass().getSimpleName() + ": ");
    System.out.println("statName: " + statName);
  }
}

package ASTNodes.AST_TYPES.AST_PairElemTypes;

import ASTNodes.AST_Node;
import SymbolTable.SymbolTable;
import java.util.ArrayDeque;

public class AST_PairString extends AST_PairElemType{
  //Syntactic attributes
  String pairString;
  //Semantic attribute

  // Assign the class variables when called
  public AST_PairString(){
    this.pairString = null;
  }

  @Override
  public ArrayDeque<AST_Node> getNodes(){
    System.out.println("Terminal AST Node at: " + this.getClass().getSimpleName());
    return null;
  }


  @Override
  public boolean isEmbeddedNodesFull(){
    return true;
  }

  @Override
  public void setSyntacticAttributes(String value){
    if(pairString == null){
      this.pairString = value;
    } else {
      System.out.println("Unrecognised String Attribute" + this.getClass().getSimpleName());
    }
  }


  @Override
  public String getSyntacticAttributes(String strToGet){
    if(strToGet.equals("pairString")){
      return pairString;
    } else {
      System.out.println("Unrecognised String Attribute" + this.getClass().getSimpleName());
      return null;
    }
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
  protected boolean CheckSemantics(SymbolTable ST){
    return true;
  }

  // Called from visitor
  @Override
  public void Check(SymbolTable ST){
    if(CheckSemantics(ST)){
      //Do symbol table stuff
    }
  }

  public String toString() {
    return pairString;
  }

  @Override
  public void printContents(){
    System.out.println(this.getClass().getSimpleName() + ": ");
    System.out.println("pairString: " + pairString);
  }
}

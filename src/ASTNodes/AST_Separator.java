package ASTNodes;

import SymbolTable.SymbolTable;
import java.util.ArrayDeque;

public class AST_Separator extends AST_Node {
  //Syntactic attributes
  String separatorType;
  //Semantic attribute

  // Assign the class variables when called
  public AST_Separator(){
    this.separatorType = null;
  }

  @Override
  public ArrayDeque<AST_Node> getNodes(){
    System.out.println("Terminal AST Node at: " + this.getClass().getSimpleName());
    return null;
  }

  @Override
  public void setSyntacticAttributes(String value){
    if(separatorType == null){
      this.separatorType = value;
    } else {
      System.out.println("Unrecognised String Attribute" + this.getClass().getSimpleName());
    }
  }


  @Override
  public String getSyntacticAttributes(String strToGet){
    if(strToGet.equals("separatorType")){
      return separatorType;
    } else {
      System.out.println("Unrecognised String Attribute" + this.getClass().getSimpleName());
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
    System.out.println("separatorType: " + separatorType);
  }
}

package ASTNodes;

import SymbolTable.SymbolTable;

public class AST_Keyword extends AST_Node {
  //Syntactic attributes
  String keyword_name;
  //Semantic attribute

  // Assign the class variables when called
  public AST_Keyword(){
    this.keyword_name = null;

  }

  public void setSyntacticAttributes(String value){
    if(keyword_name == null){
      this.keyword_name = value;
    } else {
      System.out.println("Unrecognised String Attribute");
    }
  }


  public String getSyntacticAttributes(String strToGet){
    if(strToGet.equals("keyword_name")){
      return keyword_name;
    } else {
      System.out.println("Unrecognised String Attribute");
      return null;
    }
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

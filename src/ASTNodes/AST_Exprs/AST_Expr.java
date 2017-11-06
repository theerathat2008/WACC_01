package ASTNodes.AST_Exprs;

import ASTNodes.AST_Node;
import SymbolTable.SymbolTable;

public class AST_Expr extends AST_Node{
  String type;
  //Syntactic attributes

  //Semantic attribute

  // Assign the class variables when called

  public boolean isEmbeddedNodesFull(){
    return true;
  }

  public void setSyntacticAttributes(String value){
    System.out.println("Base AST Node");
  }


  public String getSyntacticAttributes(String strToGet){
    System.out.println("Base AST Node");
    return null;
  }

  public AST_Node getEmbeddedAST(String astToGet, int counter){
    System.out.println("Base AST Node.");
    return null;
  }

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
  public String getType() {
    return type;
  }

  public void setType(String type) {}
}

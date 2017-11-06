package ASTNodes.AST_Exprs;

import ASTNodes.AST_Node;

public class AST_ExprIdent extends AST_Expr{
  //Syntactic attributes
  String varName;
  //Semantic attribute

  // Assign the class variables when called
  public AST_ExprIdent(){
    this.varName = null;
  }

  public void setSyntacticAttributes(String value){
    if(varName == null){
      this.varName = value;
    } else {
      System.out.println("Unrecognised String Attribute");
    }
  }


  public String getSyntacticAttributes(String strToGet){
    if(strToGet.equals("varName")){
      return varName;
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

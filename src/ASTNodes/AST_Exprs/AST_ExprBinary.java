package ASTNodes.AST_Exprs;

import ASTNodes.AST_Node;

public class AST_ExprBinary extends AST_Expr{
  //Syntactic attributes
  String opName;
  AST_Expr exprLeftAST;
  AST_Expr exprRightAST;
  //Semantic attribute

  // Assign the class variables when called
  public AST_ExprBinary(){
    this.exprLeftAST = null;
    this.exprRightAST = null;
    this.opName = null;
  }

  public void setSyntacticAttributes(String value){
    if(opName == null){
      this.opName = value;
    } else {
      System.out.println("Unrecognised String Attribute");
    }
  }


  public String getSyntacticAttributes(String strToGet){
    if(strToGet.equals("opName")){
      return opName;
    } else {
      System.out.println("Unrecognised String Attribute");
      return null;
    }
  }


  public boolean isEmbeddedNodesFull(){
    return exprLeftAST != null && exprRightAST != null;
  }

  public AST_Node getEmbeddedAST(String astToGet, int counter){
    if(astToGet.equals("exprLeftAST")){
      return exprLeftAST;
    } else if (astToGet.equals("exprRightAST")){
      return exprRightAST;
    }
    System.out.println("Unrecognised AST Node.");
    return null;
  }

  public void setEmbeddedAST(String astToSet, AST_Node nodeToSet){
    if(astToSet.equals("exprLeftAST")){
      exprLeftAST = (AST_Expr) nodeToSet;
    } else if (astToSet.equals("exprRightAST")){
      exprRightAST = (AST_Expr) nodeToSet;
    } else {
      System.out.println("Unrecognised AST Node.");
    }
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

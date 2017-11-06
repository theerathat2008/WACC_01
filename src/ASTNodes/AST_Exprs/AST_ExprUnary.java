package ASTNodes.AST_Exprs;

import ASTNodes.AST_Node;
import SymbolTable.SymbolTable;

public class AST_ExprUnary extends AST_Expr{
  //Syntactic attributes
  String opName;
  AST_Expr astExpr;
  //Semantic attribute

  // Assign the class variables when called
  public AST_ExprUnary(){
    this.opName = null;
    this.astExpr = null;
  }

  public boolean isEmbeddedNodesFull(){
    return astExpr != null;
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

  public AST_Node getEmbeddedAST(String astToGet, int counter){
    if(astToGet.equals("astExpr")){
      return astExpr;
    }
    System.out.println("Unrecognised AST Node.");
    return null;
  }

  public void setEmbeddedAST(String astToSet, AST_Node nodeToSet){
    if(astToSet.equals("expr")){
      astExpr = (AST_Expr) nodeToSet;
    } else {
      System.out.println("Unrecognised AST Node.");
    }
  }


  //Semantic Analysis and print error message if needed
  protected boolean CheckSemantics(SymbolTable ST){
    return true;
  }

  // Called from visitor
  public void Check(SymbolTable ST){
    if(CheckSemantics(ST)){
      if (opName.equals("!")) {
        setType("bool");
      } else if (opName.equals("-")) {
        setType("int");
      } else if (opName.equals("len")) {
        setType("int");
      } else if(opName.equals("ord")) {
        setType("int");
      } else if(opName.equals("chr")) {
        setType("char");
      } else {
        setType("null");
      }

    }
  }
}

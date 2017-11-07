package ASTNodes.AST_Exprs;

import ASTNodes.AST_Node;
import ASTNodes.AST_Separator;
import SymbolTable.SymbolTable;

public class AST_ExprEnclosed extends AST_Expr{
  //Syntactic attributes
  AST_Separator leftSepAST;
  AST_Expr exprAST;
  AST_Separator rightSepAST;
  //Semantic attribute

  // Assign the class variables when called
  public AST_ExprEnclosed(){
    this.leftSepAST = null;
    this.exprAST = null;
    this.rightSepAST = null;

  }



  public void setSyntacticAttributes(String value){
    System.out.println("No String Syntactic Attributes");
  }


  public String getSyntacticAttributes(String strToGet){
    System.out.println("No String Syntactic Attributes");
    return null;
  }


  public boolean isEmbeddedNodesFull(){
    return leftSepAST != null && exprAST != null && rightSepAST != null;
  }

  public AST_Node getEmbeddedAST(String astToGet, int counter){
    if(astToGet.equals("leftSepAST")){
      return leftSepAST;
    } else if (astToGet.equals("exprAST")){
      return exprAST;
    } else if (astToGet.equals("rightSepAST")){
      return rightSepAST;
    }
    System.out.println("Unrecognised AST Node.");
    return null;
  }

  public void setEmbeddedAST(String astToSet, AST_Node nodeToSet){
    if(astToSet.equals("leftSepAST")){
      leftSepAST = (AST_Separator) nodeToSet;
    } else if (astToSet.equals("expr")){
      exprAST = (AST_Expr) nodeToSet;
    } else if (astToSet.equals("rightSepAST")){
      rightSepAST = (AST_Separator) nodeToSet;
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
      setType(exprAST.type);
      //Do symbol table stuff
    }
  }
}

package ASTNodes.AST_Exprs;

import ASTNodes.AST_Node;

import java.util.ArrayDeque;

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

  @Override
  public ArrayDeque<AST_Node> getNodes(){
    ArrayDeque<AST_Node> returnList = new ArrayDeque<>();
    returnList.addLast(exprLeftAST);
    returnList.addLast(exprRightAST);
    return returnList;
  }


  @Override
  public void setSyntacticAttributes(String value){
    if(opName == null){
      this.opName = value;
    } else {
      System.out.println("Unrecognised String Attribute");
    }
  }


  @Override
  public String getSyntacticAttributes(String strToGet){
    if(strToGet.equals("opName")){
      return opName;
    } else {
      System.out.println("Unrecognised String Attribute");
      return null;
    }
  }


  @Override
  public boolean isEmbeddedNodesFull(){
    return exprLeftAST != null && exprRightAST != null;
  }

  @Override
  public AST_Node getEmbeddedAST(String astToGet, int counter){
    if(astToGet.equals("exprLeftAST")){
      return exprLeftAST;
    } else if (astToGet.equals("exprRightAST")){
      return exprRightAST;
    }
    System.out.println("Unrecognised AST Node.");
    return null;
  }

  @Override
  public void setEmbeddedAST(String astToSet, AST_Node nodeToSet){
    if(astToSet.equals("expr")){
      if(exprLeftAST == null){
        exprLeftAST = (AST_Expr) nodeToSet;
      } else if (exprRightAST == null){
        exprRightAST = (AST_Expr) nodeToSet;
      } else {
        System.out.println("If and then in AST_StatIf have already been assigned.");
      }
    }  else {
      System.out.println("Unrecognised AST Node.");
    }
  }


  //Semantic Analysis and print error message if needed
  @Override
  protected boolean CheckSemantics(){
    return true;
  }

  // Called from visitor
  @Override
  public void Check(){
    if(CheckSemantics()){
      //Do symbol table stuff
    }
  }

  @Override
  public void printContents(){
    System.out.println(this.getClass().getSimpleName() + ": ");
    System.out.println("opName: " + opName);
    if(exprLeftAST == null){
      System.out.println("exprLeftAST: null");
    } else {
      System.out.println("exprLeftAST: has content");
    }
    if(exprRightAST == null){
      System.out.println("exprRightAST: null");
    } else {
      System.out.println("exprRightAST: has content");
    }
  }
}

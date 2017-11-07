package ASTNodes.AST_TYPES;

import ASTNodes.AST_Node;
import ASTNodes.AST_TYPES.AST_PairElemTypes.AST_PairElemType;
import ASTNodes.AST_TYPES.AST_Type;

import java.util.ArrayDeque;

public class AST_PairType extends AST_Type{
  //Syntactic attributes
  AST_PairElemType pairElemTypeFst;
  AST_PairElemType pairElemTypeSnd;
  //Semantic attribute

  // Assign the class variables when called
  public AST_PairType(){
    this.pairElemTypeFst = null;
    this.pairElemTypeSnd = null;
  }

  @Override
  public ArrayDeque<AST_Node> getNodes(){
    ArrayDeque<AST_Node> returnList = new ArrayDeque<>();
    returnList.addLast(pairElemTypeFst);
    returnList.addLast(pairElemTypeSnd);
    return returnList;
  }

  @Override
  public boolean isEmbeddedNodesFull(){
    return pairElemTypeFst != null && pairElemTypeSnd != null;
  }

  @Override
  public void setSyntacticAttributes(String value){
    System.out.println("No Syntactic Attribute");
  }


  @Override
  public String getSyntacticAttributes(String strToGet){
    System.out.println("No Syntactic Attribute");
    return null;
  }

  @Override
  public AST_Node getEmbeddedAST(String astToGet, int counter){
    if(astToGet.equals("pairElemTypeFst")){
      return pairElemTypeFst;
    } else if (astToGet.equals("pairElemTypeSnd")){
      return pairElemTypeSnd;
    }
    System.out.println("Unrecognised AST Node at class: " + this.getClass().getSimpleName());
    return null;
  }

  @Override
  public void setEmbeddedAST(String astToSet, AST_Node nodeToSet){
    if(astToSet.equals("pairElemType")){
      if (pairElemTypeFst == null){
        pairElemTypeFst = (AST_PairElemType) nodeToSet;
      } else if (pairElemTypeSnd == null){
        pairElemTypeSnd = (AST_PairElemType) nodeToSet;
      } else {
        System.out.println("pairElemTypeFst and pairElemTypeSnd in AST_PairType have already been assigned.");
      }
    } else {
      System.out.println("Unrecognised AST Node at class: " + this.getClass().getSimpleName());
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
    if(pairElemTypeFst == null){
      System.out.println("pairElemTypeFst: null");
    } else {
      System.out.println("pairElemTypeFst: has content");
    }
    if(pairElemTypeSnd == null){
      System.out.println("pairElemTypeSnd: null");
    } else {
      System.out.println("pairElemTypeSnd: has content");
    }
  }
}

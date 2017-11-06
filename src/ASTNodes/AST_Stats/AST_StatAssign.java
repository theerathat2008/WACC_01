package ASTNodes.AST_Stats;

import ASTNodes.AST_Node;
import ASTNodes.AST_Stats.AST_StatAssignLHSs.AST_StatAssignLHS;
import ASTNodes.AST_Stats.AST_StatAssignRHSs.AST_StatAssignRHS;

import java.util.ArrayDeque;

public class AST_StatAssign extends AST_Stat{
  //Syntactic attributes
  AST_StatAssignLHS ast_statAssignLHS;
  AST_StatAssignRHS ast_statAssignRHS;

  //Semantic attribute
 // StatAssignObj statAssignObj;

  // Assign the class variables when called
  public AST_StatAssign(){
    this.ast_statAssignLHS = null;
    this.ast_statAssignRHS = null;

  }

  @Override
  public ArrayDeque<AST_Node> getNodes(){
    ArrayDeque<AST_Node> returnList = new ArrayDeque<>();
    returnList.addLast(ast_statAssignLHS);
    returnList.addLast(ast_statAssignRHS);
    return returnList;
  }

  @Override
  public boolean isEmbeddedNodesFull(){
    return ast_statAssignLHS != null && ast_statAssignRHS != null;
  }

  @Override
  public void setSyntacticAttributes(String value){
    System.out.println("No String Syntactic Attributes in class: " + this.getClass().getSimpleName());
  }

  @Override
  public String getSyntacticAttributes(String strToGet){
    System.out.println("No String Syntactic Attributes in class: " + this.getClass().getSimpleName());
    return null;
  }

  @Override
  public AST_Node getEmbeddedAST(String astToGet, int counter){
    if(astToGet.equals("ast_statAssignLHS")){
      return ast_statAssignLHS;
    } else if (astToGet.equals("ast_statAssignRHS")){
      return ast_statAssignRHS;
    }
    System.out.println("Unrecognised AST Node.");
    return null;
  }

  @Override
  public void setEmbeddedAST(String astToSet, AST_Node nodeToSet){
    if(astToSet.equals("ast_statAssignLHS")){
      ast_statAssignLHS = (AST_StatAssignLHS) nodeToSet;
    } else if (astToSet.equals("statAssignRHS")){
      ast_statAssignRHS = (AST_StatAssignRHS) nodeToSet;
    } else {
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
    if(ast_statAssignLHS == null){
      System.out.println("ast_statAssignLHS: null");
    } else {
      System.out.println("ast_statAssignLHS: has content");
    }
    if(ast_statAssignRHS == null){
      System.out.println("ast_statAssignRHS: null");
    } else {
      System.out.println("ast_statAssignRHS: has content");
    }
  }

}

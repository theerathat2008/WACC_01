package ASTNodes.AST_Stats;

import ASTNodes.AST_Node;
import ASTNodes.AST_Stats.AST_StatAssignLHSs.AST_StatAssignLHS;
import SymbolTable.SymbolTable;

public class AST_StatRead extends AST_Stat{
  //Syntactic attributes
  AST_StatAssignLHS ast_statAssignLHS;
  //Semantic attribute

  // Assign the class variables when called
  public AST_StatRead(){
    this.ast_statAssignLHS = null;
  }

  public void setSyntacticAttributes(String value){
    System.out.println("No String Syntactic Attributes");
  }


  public String getSyntacticAttributes(String strToGet){
    System.out.println("No String Syntactic Attributes");
    return null;
  }

  public boolean isEmbeddedNodesFull(){
    return ast_statAssignLHS != null;
  }

  public AST_Node getEmbeddedAST(String astToGet, int counter){
    if(astToGet.equals("ast_statAssignLHS")){
      return ast_statAssignLHS;
    }
    System.out.println("Unrecognised AST Node.");
    return null;
  }

  public void setEmbeddedAST(String astToSet, AST_Node nodeToSet){
    if(astToSet.equals("ast_statAssignLHS")){
      ast_statAssignLHS = (AST_StatAssignLHS) nodeToSet;
    } else {
      System.out.println("Unrecognised AST Node.");
    }
  }


  //Semantic Analysis and print error message if needed
  @Override
  protected boolean CheckSemantics(SymbolTable ST){
    return true;
  }

  // Called from visitor
  @Override
  public void Check(SymbolTable ST){
    if(CheckSemantics(ST)){
      //Do symbol table stuff
    }
  }

}

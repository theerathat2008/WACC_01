package ASTNodes.AST_Stats;

import ASTNodes.AST_Node;
import ASTNodes.AST_Stats.AST_StatAssignLHSs.AST_StatAssignLHS;
import ASTNodes.AST_Stats.AST_StatAssignRHSs.AST_StatAssignRHS;
import SymbolTable.SymbolTable;

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

  public boolean isEmbeddedNodesFull(){
    return ast_statAssignLHS != null && ast_statAssignRHS != null;
  }

  public void setSyntacticAttributes(String value){
    System.out.println("No String Syntactic Attributes");
  }


  public String getSyntacticAttributes(String strToGet){
    System.out.println("No String Syntactic Attributes");
    return null;
  }

  public AST_Node getEmbeddedAST(String astToGet, int counter){
    if(astToGet.equals("ast_statAssignLHS")){
      return ast_statAssignLHS;
    } else if (astToGet.equals("ast_statAssignRHS")){
      return ast_statAssignRHS;
    }
    System.out.println("Unrecognised AST Node.");
    return null;
  }

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
  protected boolean CheckSemantics(SymbolTable ST){
    return ast_statAssignLHS.getType(ST).equals(ast_statAssignRHS.getType(ST));
  }

  // Called from visitor
  public void Check(SymbolTable ST){
    if(CheckSemantics(ST)){
      //Do symbol table stuff
    }
  }



}

package ASTNodes.AST_Stats;

import ASTNodes.AST_Stats.AST_StatAssignLHSs.AST_StatAssignLHS;
import ASTNodes.AST_Stats.AST_StatAssignRHSs.AST_StatAssignRHS;

public class AST_StatAssign extends AST_Stat{
  //Syntactic attributes
  AST_StatAssignLHS ast_statAssignLHS;
  AST_StatAssignRHS ast_statAssignRHS;

  //Semantic attribute
 // StatAssignObj statAssignObj;

  // Assign the class variables when called
  public AST_StatAssign(){

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

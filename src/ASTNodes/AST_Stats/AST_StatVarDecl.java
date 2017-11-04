package ASTNodes.AST_Stats;

import ASTNodes.AST_Stats.AST_StatAssignRHSs.AST_StatAssignRHS;

public class AST_StatVarDecl extends AST_Stat {
  //Syntactic attributes
  String typeName;
  String identName;
  AST_StatAssignRHS ast_assignRHS;
  //Semantic attribute
  //VariableObj var;

  // Assign the class variables when called
  public AST_StatVarDecl(){

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

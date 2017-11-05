package ASTNodes.AST_Stats;

import ASTNodes.AST_Node;
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
    this.ast_assignRHS = null;
  }

  public boolean isEmbeddedNodesFull(){
    return ast_assignRHS != null;
  }

  public AST_Node getEmbeddedAST(String astToGet, int counter){
    if(astToGet.equals("ast_assignRHS")){
      return ast_assignRHS;
    }
    System.out.println("Unrecognised AST Node.");
    return null;
  }

  public void setEmbeddedAST(String astToSet, AST_Node nodeToSet){
    if(astToSet.equals("statAssignRHS")){
      ast_assignRHS = (AST_StatAssignRHS) nodeToSet;
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

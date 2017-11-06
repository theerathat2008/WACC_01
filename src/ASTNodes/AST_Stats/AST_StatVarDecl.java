package ASTNodes.AST_Stats;

import ASTNodes.AST_Node;
import ASTNodes.AST_Stats.AST_StatAssignRHSs.AST_StatAssignRHS;
import ASTNodes.AST_TYPES.AST_Type;

public class AST_StatVarDecl extends AST_Stat {
  //Syntactic attributes
  AST_Type ast_type;
  String identName;
  AST_StatAssignRHS ast_assignRHS;
  //Semantic attribute
  //VariableObj var;

  // Assign the class variables when called
  public AST_StatVarDecl(){
    this.ast_assignRHS = null;
    this.statName = null;
    this.identName = null;
  }



  @Override
  public void setSyntacticAttributes(String value){
    if(identName == null){
      this.identName = value;
    } else {
      System.out.println("Unrecognised String Attribute");
    }
  }


  @Override
  public String getSyntacticAttributes(String strToGet){
    if(identName == null){
      return identName;
    } else {
      System.out.println("Unrecognised String Attribute");
      return null;
    }
  }

  @Override
  public boolean isEmbeddedNodesFull(){
    return ast_assignRHS != null;
  }

  @Override
  public AST_Node getEmbeddedAST(String astToGet, int counter){
    if(astToGet.equals("ast_assignRHS")){
      return ast_assignRHS;
    } else if (astToGet.equals("ast_type")){
      return ast_type;
    }
    System.out.println("Unrecognised AST Node.");
    return null;
  }

  @Override
  public void setEmbeddedAST(String astToSet, AST_Node nodeToSet){
    if(astToSet.equals("statAssignRHS")){
      ast_assignRHS = (AST_StatAssignRHS) nodeToSet;
    } else if(astToSet.equals("ast_type")){
      ast_type = (AST_Type) nodeToSet;
    }else {
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
    System.out.println("identName: " + identName);
    if(ast_assignRHS == null){
      System.out.println("ast_assignRHS: null");
    } else {
      System.out.println("ast_assignRHS: has content");
    }
    if(ast_type == null){
      System.out.println("ast_type: null");
    } else {
      System.out.println("ast_type: has content");
    }
  }
}

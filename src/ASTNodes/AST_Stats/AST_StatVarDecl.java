package ASTNodes.AST_Stats;

import ASTNodes.AST_Node;
import ASTNodes.AST_Stats.AST_StatAssignRHSs.AST_StatAssignRHS;

import SymbolTable.SymbolTable;

import ASTNodes.AST_TYPES.AST_Type;

import java.util.ArrayDeque;


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
  public ArrayDeque<AST_Node> getNodes(){
    ArrayDeque<AST_Node> returnList = new ArrayDeque<>();
    returnList.addLast(ast_type);
    returnList.addLast(ast_assignRHS);
    return returnList;
  }



  @Override
  public void setSyntacticAttributes(String value){
    if(identName == null){
      this.identName = value;
    } else {
      System.out.println("Unrecognised String Attribute" + this.getClass().getSimpleName());
    }
  }


  @Override
  public String getSyntacticAttributes(String strToGet){
    if(identName == null){
      return identName;
    } else {
      System.out.println("Unrecognised String Attribute" + this.getClass().getSimpleName());
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
    System.out.println("Unrecognised AST Node at class: " + this.getClass().getSimpleName());
    return null;
  }

  @Override
  public void setEmbeddedAST(String astToSet, AST_Node nodeToSet){
    if(astToSet.equals("statAssignRHS")){
      ast_assignRHS = (AST_StatAssignRHS) nodeToSet;
    } else if(astToSet.equals("ast_type")){
      ast_type = (AST_Type) nodeToSet;
    }else {
      System.out.println("Unrecognised AST Node at class: " + this.getClass().getSimpleName());
    }
  }


  //Semantic Analysis and print error message if needed
  protected boolean CheckSemantics(SymbolTable ST) {
    if (ST.lookup(identName) != null) {
      return false;
    } else if (ast_type.toString() != ast_assignRHS.getType(ST)) {
      return true;
    } else {
      return false;
    }
  }

  // Called from visitor
  public void Check(SymbolTable ST){
    if(CheckSemantics(ST)){
      //Do symbol table stuff
    }
  }

  @Override
  public void printContents(){
    System.out.println(this.getClass().getSimpleName() + ": ");
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

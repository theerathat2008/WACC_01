package ASTNodes.AST_Stats.AST_StatAssignRHSs;

import ASTNodes.AST_Node;
import ASTNodes.AST_Stats.AST_Stat;
import SymbolTable.SymbolTable;

import java.util.ArrayDeque;

/**
 * TODO DELETE STATNAME
 */

public class AST_StatAssignRHS extends AST_Stat {

  @Override
  public ArrayDeque<AST_Node> getNodes(){
    System.out.println("BASE AST Node at: " + this.getClass().getSimpleName());
    return null;
  }

  @Override
  public void setSyntacticAttributes(String value){
    System.out.println("Base AST Node");
  }

  @Override
  public String getSyntacticAttributes(String strToGet){
    System.out.println("Base AST Node");
    return null;
  }

  public String getType(SymbolTable ST) {
    return null;
  }

  @Override
  public AST_Node getEmbeddedAST(String astToGet, int counter){
    System.out.println("Base AST Node.");
    return null;
  }

  @Override
  public boolean isEmbeddedNodesFull(){
    return true;
  }

  @Override
  public void setEmbeddedAST(String astToSet, AST_Node nodeToSet){
    System.out.println("Base AST Node.");
  }

  @Override
  //Semantic Analysis and print error message if needed
  protected boolean CheckSemantics(SymbolTable ST){
    return true;

  }

  @Override
  // Called from visitor
  public void Check(SymbolTable ST){
    if(CheckSemantics(ST)){
      //Do symbol table stuff
    }
  }

  @Override
  public void printContents() {
    System.out.println("BASE CLASS");
  }
}


package ASTNodes.AST_Stats.AST_StatAssignLHSs;

import ASTNodes.AST_Node;

import java.util.ArrayDeque;

public class AST_StatIdentLHS extends AST_StatAssignLHS{
  //Syntactic attributes
  String identName;

  //Semantic attribute


  // Assign the class variables when called
  public AST_StatIdentLHS(){
    this.identName = null;

  }


  @Override
  public ArrayDeque<AST_Node> getNodes(){
    System.out.println("Terminal AST Node at: " + this.getClass().getSimpleName());
    return null;
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
    if(strToGet.equals("identName")){
      return identName;
    } else {
      System.out.println("Unrecognised String Attribute");
      return null;
    }
  }

  @Override
  public boolean isEmbeddedNodesFull(){
    return true;
  }

  @Override
  public AST_Node getEmbeddedAST(String astToGet, int counter){
    System.out.println("Terminal AST Node at: " + this.getClass().getSimpleName());
    return null;
  }

  @Override
  public void setEmbeddedAST(String astToSet, AST_Node nodeToSet){
    System.out.println("Terminal AST Node at: " + this.getClass().getSimpleName());
  }


  @Override
  //Semantic Analysis and print error message if needed
  protected boolean CheckSemantics(){
    return true;
  }

  @Override
  // Called from visitor
  public void Check(){
    if(CheckSemantics()){
      //Do symbol table stuff
    }
  }

  @Override
  public void printContents(){
    System.out.println(this.getClass().getSimpleName() + ": ");
    System.out.println("identName: " + identName);
  }
}

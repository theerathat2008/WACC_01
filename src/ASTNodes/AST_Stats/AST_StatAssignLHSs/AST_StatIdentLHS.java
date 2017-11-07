package ASTNodes.AST_Stats.AST_StatAssignLHSs;

import ASTNodes.AST_Node;
import SymbolTable.SymbolTable;

public class AST_StatIdentLHS extends AST_StatAssignLHS{
  //Syntactic attributes
  String identName;

  //Semantic attribute


  // Assign the class variables when called
  public AST_StatIdentLHS(){
    this.identName = null;

  }

  public void setSyntacticAttributes(String value){
    if(identName == null){
      this.identName = value;
    } else {
      System.out.println("Unrecognised String Attribute");
    }
  }


  public String getSyntacticAttributes(String strToGet){
    if(strToGet.equals("identName")){
      return identName;
    } else {
      System.out.println("Unrecognised String Attribute");
      return null;
    }
  }

  public boolean isEmbeddedNodesFull(){
    return true;
  }


  public AST_Node getEmbeddedAST(String astToGet, int counter){
    System.out.println("Terminal AST Node.");
    return null;
  }

  public void setEmbeddedAST(String astToSet, AST_Node nodeToSet){
    System.out.println("Terminal AST Node.");
  }



  //Semantic Analysis and print error message if needed
  protected boolean CheckSemantics(SymbolTable ST){
    return true;
  }

  // Called from visitor
  public void Check(SymbolTable ST){
    if(CheckSemantics(ST)){
      setType(ST.lookupAll(identName).toString());
    }
  }
}

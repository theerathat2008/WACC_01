package ASTNodes.AST_Stats;

import ASTNodes.AST_Node;
import IdentifierObjects.StatObjs.StatObj;

public class AST_StatMult extends AST_Stat{
  //Syntactic attributes
  AST_Stat stat1;
  AST_Stat stat2;
  //Semantic attribute

  // Assign the class variables when called
  public AST_StatMult(){

  }

  public AST_Node getEmbeddedAST(String astToGet, int counter){
    if(astToGet.equals("paramList")){
      return stat1;
    } else if (astToGet.equals("statement")){
      return stat2;
    }
    System.out.println("Unrecognised AST Node.");
    return null;
  }

  public void setEmbeddedAST(String astToSet, AST_Node nodeToSet){
    if(astToSet.equals("paramList")){
      stat1 = (AST_Stat) nodeToSet;
    } else if (astToSet.equals("statement")){
      stat2 = (AST_Stat) nodeToSet;
    }
    System.out.println("Unrecognised AST Node.");
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

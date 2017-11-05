package ASTNodes;

import ASTNodes.AST_Stats.AST_Stat;
import IdentifierObjects.ProgramObj;

import java.util.ArrayList;
import java.util.List;

public class AST_Program extends AST_Node {
  //Syntactic attributes
  List<AST_FuncDecl> funcDeclList;
  int numOfFunc;
  AST_Stat statement;
  //Semantic attribute
  ProgramObj programObj;

  // Assign the class variables when called
  public AST_Program(int listLength){
    this.numOfFunc = listLength;
    this.funcDeclList = new ArrayList<>();
    statement = null;
  }

  /**
   * Returns true if the embedded Nodes have values
   */
  public boolean isEmbeddedNodesFull(){
    return funcDeclList.size() == numOfFunc && statement != null;
  }

  public AST_Node getEmbeddedAST(String astToGet, int counter){
    if(astToGet.equals("functionList")){
      return funcDeclList.get(counter);
    } else if (astToGet.equals("statement")){
      return statement;
    }
    System.out.println("Unrecognised AST Node.");
    return null;
  }

  public void setEmbeddedAST(String astToSet, AST_Node nodeToSet){
    if(astToSet.equals("functionList")){
      funcDeclList.add(((AST_FuncDecl)nodeToSet));
    } else if (astToSet.equals("statement")){
      statement = (AST_Stat) nodeToSet;
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

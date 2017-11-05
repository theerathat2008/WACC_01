package ASTNodes;

import IdentifierObjects.ParamListObj;

import java.util.ArrayList;
import java.util.List;

public class AST_ParamList extends AST_Node{
  //Syntactic attributes
  List<AST_Param> paramList;
  int numOfParam;
  //Semantic attribute
  ParamListObj paramListObj;

  // Assign the class variables when called
  public AST_ParamList(int listLength){
    this.paramList = new ArrayList<>();
    this.numOfParam = listLength;
  }

  /**
   * Returns true if the embedded Nodes have value
   */
  public boolean isEmbeddedNodesFull(){
    return paramList.size() == numOfParam;
  }

  public AST_Node getEmbeddedAST(String astToGet, int counter){
    if(astToGet.equals("paramList")){
      return paramList.get(counter);
    }
    System.out.println("Unrecognised AST Node.");
    return null;
  }

  public void setEmbeddedAST(String astToSet, AST_Node nodeToSet){
    if(astToSet.equals("paramList")){
      paramList.add((AST_Param) nodeToSet);
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

package ASTNodes;


import java.util.ArrayList;
import java.util.List;

public class AST_ParamList extends AST_Node{
  //Syntactic attributes
  List<AST_Param> listParam;
  int numOfParam;
  //Semantic attribute

  // Assign the class variables when called
  public AST_ParamList(int numberOfChildren){
    this.listParam = new ArrayList<>();
    this.numOfParam = numberOfChildren;
  }

  /**
   * Returns true if the embedded Nodes have value
   */
  public boolean isEmbeddedNodesFull(){
    return listParam.size() == numOfParam;
  }

  public AST_Node getEmbeddedAST(String astToGet, int counter){
    if(astToGet.equals("listParam")){
      return listParam.get(counter);
    }
    System.out.println("Unrecognised AST Node.");
    return null;
  }

  public void setEmbeddedAST(String astToSet, AST_Node nodeToSet){
    if(astToSet.equals("listParam")){
      listParam.add((AST_Param) nodeToSet);
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

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

  @Override
  public void setSyntacticAttributes(String value){
    System.out.println("No String Syntactic Attributes");
  }


  @Override
  public String getSyntacticAttributes(String strToGet){
    System.out.println("No String Syntactic Attributes");
    return null;
  }

  /**
   * Returns true if the embedded Nodes have value
   */
  @Override
  public boolean isEmbeddedNodesFull(){
    return listParam.size() == numOfParam;
  }

  @Override
  public AST_Node getEmbeddedAST(String astToGet, int counter){
    if(astToGet.equals("listParam")){
      return listParam.get(counter);
    }
    System.out.println("Unrecognised AST Node.");
    return null;
  }

  @Override
  public void setEmbeddedAST(String astToSet, AST_Node nodeToSet){
    if(astToSet.equals("listParam")){
      listParam.add((AST_Param) nodeToSet);
    } else {
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
    System.out.println("numOfParam: " + numOfParam);
    if(listParam.size() == numOfParam){
      System.out.println("ParamList: List full");
    } else {
      System.out.println("ParamList has size: " + listParam.size());
    }
  }
}

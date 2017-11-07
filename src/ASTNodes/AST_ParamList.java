package ASTNodes;

import SymbolTable.SymbolTable;
import java.util.ArrayDeque;
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
    this.numOfParam = (numberOfChildren + 1) / 2;
  }

  @Override
  public ArrayDeque<AST_Node> getNodes(){
    ArrayDeque<AST_Node> returnList = new ArrayDeque<>();
    if(listParam.size() == 0){
      return null;
    }
    for(AST_Param param : listParam){
      returnList.addLast(param);
    }
    return returnList;
  }
  @Override
  public void setSyntacticAttributes(String value){
    System.out.println("No String Syntactic Attributes in class: " + this.getClass().getSimpleName());
  }


  @Override
  public String getSyntacticAttributes(String strToGet){
    System.out.println("No String Syntactic Attributes in class: " + this.getClass().getSimpleName());
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
    System.out.println("Unrecognised AST Node at class: " + this.getClass().getSimpleName());
    return null;
  }

  @Override
  public void setEmbeddedAST(String astToSet, AST_Node nodeToSet){
    if(astToSet.equals("listParam")){
      listParam.add((AST_Param) nodeToSet);
    } else {
      System.out.println("Unrecognised AST Node at class: " + this.getClass().getSimpleName());
    }
  }


  //Semantic Analysis and print error message if needed
  protected boolean CheckSemantics(SymbolTable ST){
    return true;
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
    System.out.println("numOfParam: " + numOfParam);
    if(listParam.size() == numOfParam){
      System.out.println("ParamList: List full");
    } else {
      System.out.println("ParamList has size: " + listParam.size());
    }
  }
}

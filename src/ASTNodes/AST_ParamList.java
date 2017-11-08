package ASTNodes;

import SymbolTable.SymbolTable;
import java.util.ArrayDeque;
import IdentifierObjects.IDENTIFIER;
import IdentifierObjects.ParamListObj;
import IdentifierObjects.BaseTypeObj;
import java.util.ArrayList;
import java.util.List;

/**
 * Class representing node in AST tree for PARAMLIST
 */
public class AST_ParamList extends AST_Node{
  //Syntactic attributes
  List<AST_Param> listParam;
  int numOfParam;

  /**
   * Constructor for class - initialises class variables
   * @param numberOfChildren - Shows the number of parameters in the parameter list of function
   */
  public AST_ParamList(int numberOfChildren){
    this.listParam = new ArrayList<>();
    this.numOfParam = (numberOfChildren + 1) / 2;
  }

  public List<AST_Param> getListParam() {
    return listParam;
  }

  /**
   * Gets all children nodes of current node
   * @return list of AST nodes that are the children of the current node
   */
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

  /**
   * Sets syntactic attributes of class variables by assigning it a value
   * @param value - Value to be assigned to class variable
   */
  @Override
  public void setSyntacticAttributes(String value){
    System.out.println("No String Syntactic Attributes in class: " + this.getClass().getSimpleName());
  }

  /**
   * Gets syntactic attributes of class variables
   * @param strToGet - Value to be retrieved from class variable
   */
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

  /**
   * @param astToGet Shows which child to get from current node
   * @param counter Shows which child of child to get from current node
   * @return Returns the required child AST Node (determined by the astToGet parameter)
   */
  @Override
  public AST_Node getEmbeddedAST(String astToGet, int counter){
    if(astToGet.equals("listParam")){
      return listParam.get(counter);
    }
    System.out.println("Unrecognised AST Node at class: " + this.getClass().getSimpleName());
    return null;
  }

  /**
   * @param astToSet Shows which child to set from current node
   * @param nodeToSet Shows which child of child to set from current node
   */
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
      List<IDENTIFIER> paramObjList = new ArrayList<>();
      for(AST_Param param : listParam){
        paramObjList.add(new BaseTypeObj(param.getParamName(), (param.getEmbeddedAST("ast_type", 0)).toString()));
      }
      ST.encSymTable.add(((AST_FuncDecl)this.getParentNode()).getFuncName().concat("_paramList"), new ParamListObj(paramObjList));
    }
  }

  /**
   * Used for testing - Prints out contents of current AST node
   */
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

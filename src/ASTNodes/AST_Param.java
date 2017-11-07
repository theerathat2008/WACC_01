package ASTNodes;

import SymbolTable.SymbolTable;

public class AST_Param extends AST_Node {
  //Syntactic attributes
  String paramType;
  String paramName;
  //Semantic attribute

  // Assign the class variables when called
  public AST_Param(){
    this.paramName = null;
    this.paramType = null;

  }

  public void setSyntacticAttributes(String value){
    if(paramType == null){
      this.paramType = value;
    } else if (paramName == null){
      this.paramName = value;
    } else {
      System.out.println("Unrecognised String Attribute");
    }
  }


  public String getSyntacticAttributes(String strToGet){
    if(strToGet.equals("paramType")){
      return paramType;
    } else if (strToGet.equals("paramName")){
      return paramName;
    } else {
      System.out.println("Unrecognised String Attribute");
      return null;
    }
  }

  /**
   * Returns true if the embedded Nodes have value
   */
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
      ST.add(paramName, ST.stringToIdent(paramName, paramType));
    }
  }
}

package ASTNodes;

import ASTNodes.AST_Stats.AST_Stat;
import ASTNodes.AST_TYPES.AST_Type;

import java.util.ArrayDeque;

public class AST_FuncDecl extends AST_Node {
  //Syntactic attributes
  AST_Type ast_type;
  String funcName;  //IDENT
  AST_ParamList paramList;
  AST_Stat statement;
  //Semantic attribute

  public AST_FuncDecl(){
    ast_type = null;
    funcName = null;
    paramList = null;
    statement = null;
  }

  @Override
  public ArrayDeque<AST_Node> getNodes(){
    ArrayDeque<AST_Node> returnList = new ArrayDeque<>();
    returnList.addLast(ast_type);
    returnList.addLast(paramList);
    returnList.addLast(statement);
    return returnList;
  }



  /**
   * Returns true if the embedded Nodes have values
   */
  @Override
  public boolean isEmbeddedNodesFull(){
    return ast_type != null && statement != null && paramList != null;
  }

  @Override
  public void setSyntacticAttributes(String value){
    if (funcName == null){
      this.funcName = value;
    } else {
      System.out.println("Unrecognised String Attribute");
    }
  }

  @Override
  public String getSyntacticAttributes(String strToGet){
    if (strToGet.equals("funcName")){
      return funcName;
    } else {
      System.out.println("Unrecognised String Attribute");
      return null;
    }
  }

  @Override
  public AST_Node getEmbeddedAST(String astToGet, int counter){
    if(astToGet.equals("paramList")){
      return paramList;
    } else if (astToGet.equals("statement")){
      return statement;
    } else if (astToGet.equals("ast_type")){
      return ast_type;
    }
    System.out.println("Unrecognised AST Node.");
    return null;
  }

  @Override
  public void setEmbeddedAST(String astToSet, AST_Node nodeToSet){
    if(astToSet.equals("paramList")){
      paramList = (AST_ParamList) nodeToSet;
    } else if (astToSet.equals("statement")){
      statement = (AST_Stat) nodeToSet;
    } else if (astToSet.equals("ast_type")){
      ast_type = (AST_Type) nodeToSet;
    } else {
      System.out.println("Unrecognised AST Node.");
    }
  }

  @Override
  //Semantic Analysis and print error message if needed
  protected boolean CheckSemantics(){
    //currSymbolTable.add(String name, new FUNCTION());
    return true;
  }

  @Override
  // Called from visitor
  public void Check(){
    if(CheckSemantics()){
      //Create new symbol table and add to list of symbol table
      //Add necessary contents specific to func to symbol table
      //set enclosing symbol table to curr symbol table
      //Set curr symbol table to new symbol table
    }
  }

  @Override
  public void printContents(){
    System.out.println(this.getClass().getSimpleName() + ": ");
    System.out.println("Funcname: " + funcName);
    if(paramList == null){
      System.out.println("ParamList: null");
    } else {
      System.out.println("ParamList: has content");
    }
    if(statement == null){
      System.out.println("statement: null");
    } else {
      System.out.println("statement: has content");
    }
    if(ast_type == null){
      System.out.println("ast_type: null");
    } else {
      System.out.println("ast_type: has content");
    }
  }

}


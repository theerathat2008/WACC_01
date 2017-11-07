package ASTNodes;

import ASTNodes.AST_Stats.AST_Stat;
import IdentifierObjects.FunctionObj;
import SymbolTable.SymbolTable;
import ASTNodes.AST_TYPES.AST_Type;
import java.util.ArrayDeque;


public class AST_FuncDecl extends AST_Node {
  //Syntactic attributes
  AST_Type ast_type;
  String funcName;
  int numOfChildren;
  AST_ParamList paramList;
  AST_Stat statement;
  //Semantic attribute

  public AST_FuncDecl(int numOfChildren){
    this.numOfChildren = numOfChildren;
    this.ast_type = null;
    this.funcName = null;
    this.paramList = null;
    this.statement = null;
  }

  @Override
  public ArrayDeque<AST_Node> getNodes(){
    ArrayDeque<AST_Node> returnList = new ArrayDeque<>();
    returnList.addLast(ast_type);
    if(paramList != null){
      returnList.addLast(paramList);
    }
    returnList.addLast(statement);
    return returnList;
  }

  /**
   * returns true if the function has any parameters
   *
   */

  public boolean checkForParamList(){
    return numOfChildren == 8;
  }


  /**
   * Returns true if the embedded Nodes have values
   */
  @Override
  public boolean isEmbeddedNodesFull(){
    if(numOfChildren == 7){
      return ast_type != null && statement != null;
    }
    return ast_type != null && statement != null && paramList != null;
  }

  @Override
  public void setSyntacticAttributes(String value){
    if (funcName == null){
      this.funcName = value;
    } else {
      System.out.println("Unrecognised String Attribute" + this.getClass().getSimpleName());
    }
  }

  @Override
  public String getSyntacticAttributes(String strToGet){
    if (strToGet.equals("funcName")){
      return funcName;
    } else {
      System.out.println("Unrecognised String Attribute" + this.getClass().getSimpleName());
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
    System.out.println("Unrecognised AST Node at class: " + this.getClass().getSimpleName());
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
      System.out.println("Unrecognised AST Node at class for " + astToSet + " : " + this.getClass().getSimpleName());
    }
  }


  public String getReturnTypeName() {
    return ast_type.toString();
  }

  //Semantic Analysis and print error message if needed
  @Override
  protected boolean CheckSemantics(SymbolTable ST){
    return ST.lookupAll(funcName) == null;
  }

  @Override
  // Called from visitor
  public void Check(SymbolTable ST){
    if(CheckSemantics(ST)){
      System.out.println("Added " + funcName + " to the symbol tree.");
      ST.encSymTable.add(funcName, new FunctionObj(funcName, ST.stringToIdent(funcName,ast_type.toString()), this));
      //System.out.println(ST.encSymTable.lookup(funcName)==null);
      //Create new symbol table   DONE
      //Add necessary contents specific to func to symbol table  DONE
      //set enclosing symbol table to curr symbol table   does this before check
      //Set curr symbol table to new symbol table
    } else {
      //ERROR
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


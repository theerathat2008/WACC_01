package ASTNodes;

import ASTNodes.AST_Stats.AST_Stat;
import IdentifierObjects.FunctionObj;
import SymbolTable.SymbolTable;

public class AST_FuncDecl extends AST_Node {
  //Syntactic attributes
  String returnTypeName; //type
  String funcName;  //IDENT
  AST_ParamList paramList;
  AST_Stat statement;
  //Semantic attribute

  public AST_FuncDecl(){
    returnTypeName = null;
    funcName = null;
    paramList = null;
    statement = null;
  }



  /**
   * Returns true if the embedded Nodes have values
   */
  public boolean isEmbeddedNodesFull(){
    return statement != null && paramList != null;
  }


  public void setSyntacticAttributes(String value){
    if(returnTypeName == null){
      this.returnTypeName = value;
    } else if (funcName == null){
      this.funcName = value;
    } else {
      System.out.println("Unrecognised String Attribute");
    }
  }


  public String getSyntacticAttributes(String strToGet){
    if(strToGet.equals("returnTypeName")){
      return returnTypeName;
    } else if (strToGet.equals("funcName")){
      return funcName;
    } else {
      System.out.println("Unrecognised String Attribute");
      return null;
    }
  }

  public AST_Node getEmbeddedAST(String astToGet, int counter){
    if(astToGet.equals("paramList")){
      return paramList;
    } else if (astToGet.equals("statement")){
      return statement;
    }
    System.out.println("Unrecognised AST Node.");
    return null;
  }

  public void setEmbeddedAST(String astToSet, AST_Node nodeToSet){
    if(astToSet.equals("paramList")){
      paramList = (AST_ParamList) nodeToSet;
    } else if (astToSet.equals("statement")){
      statement = (AST_Stat) nodeToSet;
    } else {
      System.out.println("Unrecognised AST Node.");
    }
  }

  public String getReturnTypeName() {
    return returnTypeName;
  }

  //Semantic Analysis and print error message if needed
  protected boolean CheckSemantics(SymbolTable ST){
    return ST.lookupAll(funcName) == null;
  }

  // Called from visitor
  public void Check(SymbolTable ST){
    if(CheckSemantics(ST)){
      ST.encSymTable.add(funcName, new FunctionObj(funcName, ST.stringToIdent(funcName,returnTypeName)));
      //Create new symbol table   DONE
      //Add necessary contents specific to func to symbol table  DONE
      //set enclosing symbol table to curr symbol table   does this before check
      //Set curr symbol table to new symbol table
    } else {
      //ERROR
    }
  }
}


package ASTNodes;

import ASTNodes.AST_Stats.AST_Stat;
import IdentifierObjects.FunctionObj;

public class AST_FuncDecl extends AST_Node {
  //Syntactic attributes
  String returnTypeName; //type
  String funcName;  //IDENT
  AST_ParamList paramList;
  AST_Stat statement;
  //Semantic attribute
  FunctionObj function;

  public AST_FuncDecl(){

  }


  //Semantic Analysis and print error message if needed
  protected boolean CheckSemantics(){
    //currSymbolTable.add(String name, new FUNCTION());
    return true;
  }

  // Called from visitor
  public void Check(){
    if(CheckSemantics()){
      //Create new symbol table and add to list of symbol table
      //Add necessary contents specific to func to symbol table
      //set enclosing symbol table to curr symbol table
      //Set curr symbol table to new symbol table
    }
  }
}


package SymbolTable;

import IdentifierObjects.IDENTIFIER;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.List;

public class ParamListAST extends IDENTIFIER {

  List<ParseTree> parameters;



  public ParamListAST(ParseTree param_list){
    int n = param_list.getChildCount();

    for(int i = 0; i < n; ++i) {
      ParseTree c = param_list.getChild(i);
      parameters.add(c);
    }
  }




  //Semantic Analysis and print error message if needed
  public boolean CheckValidity(){
    //currSymbolTable.add(String name, new FUNCTION());
    return true;
  }

  // Called from visitor
  public void check(){
    if(CheckValidity()){
      //Create new symbol table and add to list of symbol table
      //Add necessary contents specific to func to symbol table
      //set enclosing symbol table to curr symbol table
      //Set curr symbol table to new symbol table
    }
  }
}
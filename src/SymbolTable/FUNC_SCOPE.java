package SymbolTable;

public class FUNC_SCOPE extends IDENTIFIER {
  String returntypename; //type
  String funcname;  //IDENT
  PARAM_LIST_SCOPE parameters; // param_list
  STAT_OBJ function; //stat


  //Semantic Analysis and print error message if needed
  public boolean CheckValidity(){
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

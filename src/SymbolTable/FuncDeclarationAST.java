package SymbolTable;

public class FuncDeclarationAST extends IDENTIFIER {
  String returntypename; //type
  String funcname;  //IDENT
  //FUNCTION function; //stat Semantic

  public FuncDeclarationAST(String returntypename, String funcname){
    this.returntypename = returntypename;
    this.funcname = funcname;
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

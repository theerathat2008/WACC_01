package ASTNodes;

public class AST_Separator extends AST_Node {
  //Syntactic attributes
  String separatorType;
  //Semantic attribute
  SeparatorObj separatorObj;

  // Assign the class variables when called
  public AST_Separator(){

  }


  //Semantic Analysis and print error message if needed
  protected boolean CheckSemantics(){
    return true;
  }

  // Called from visitor
  public void Check(){
    if(CheckSemantics()){
      //Do symbol table stuff
    }
  }
}

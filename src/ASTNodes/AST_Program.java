package ASTNodes;

import ASTNodes.AST_Stats.AST_Stat;
import IdentifierObjects.ProgramObj;

import java.util.List;

public class AST_Program extends AST_Node {
  //Syntactic attributes
  List<AST_FuncDecl> funcDeclList;
  AST_Stat statement;
  //Semantic attribute
  ProgramObj programObj;

  // Assign the class variables when called
  public AST_Program(){

  }

  public AST_Node getEmbededAST(String astToGet){
    if(astToGet == "functionList"){
      return funcDeclList;
    } else if (astToGet == "statement"){
      return statement;
    }
    System.out.println("Unrecognised AST Node.");
    return null;
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

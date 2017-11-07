package ASTNodes.AST_Stats.AST_StatAssignRHSs;

import ASTNodes.AST_Exprs.AST_Expr;
import ASTNodes.AST_Node;
import IdentifierObjects.FunctionObj;
import IdentifierObjects.IDENTIFIER;
import SymbolTable.SymbolTable;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.exit;


public class AST_StatCallRHS extends AST_StatAssignRHS{
  //Syntactic attributes
  String funcName;
  int numOfExpr;
  List<AST_Expr> ast_exprList;
  //Semantic attribute


  // Assign the class variables when called
  public AST_StatCallRHS(int numberOfChildren){
    ast_exprList = new ArrayList<>();
    if(numberOfChildren == 4){
      this.numOfExpr = 0;
    } else {
      this.numOfExpr = (numberOfChildren - 3) / 2;
    }
    this.funcName = null;
  }

  @Override
  public ArrayDeque<AST_Node> getNodes(){
    ArrayDeque<AST_Node> returnList = new ArrayDeque<>();
    if(ast_exprList.size() == 0){
      return null;
    }
    for(AST_Expr expr : ast_exprList){
      returnList.addLast(expr);
    }
    return returnList;
  }


  @Override
  public void setSyntacticAttributes(String value){
    if(funcName == null){
      this.funcName = value;
    } else {
      System.out.println("Unrecognised String Attribute" + this.getClass().getSimpleName());
    }
  }

  @Override
  public String getSyntacticAttributes(String strToGet){
    if(strToGet.equals("funcName")){
      return funcName;
    } else {
      System.out.println("Unrecognised String Attribute" + this.getClass().getSimpleName());
      return null;
    }
  }

  @Override
  public String getType(SymbolTable ST) {
    FunctionObj type = (FunctionObj)ST.lookupAll(funcName);
    return type.getReturnTypeName();
  }

  public boolean isEmbeddedNodesFull(){
    return ast_exprList.size() == numOfExpr;
  }

  @Override
  public AST_Node getEmbeddedAST(String astToGet, int counter){
    if(astToGet.equals("ast_exprList")){
      return ast_exprList.get(counter);
    }
    System.out.println("Unrecognised AST Node at class: " + this.getClass().getSimpleName());
    return null;
  }

  @Override
  public void setEmbeddedAST(String astToSet, AST_Node nodeToSet){
    if(astToSet.equals("expr")){
      ast_exprList.add((AST_Expr)nodeToSet);
    } else {
      System.out.println("Unrecognised AST Node at class: " + this.getClass().getSimpleName());
    }
  }


  //Semantic Analysis and print error message if needed
  protected boolean CheckSemantics(SymbolTable ST){
    IDENTIFIER type =  ST.lookupAll(funcName);
    if (type != null) {
      if (type instanceof FunctionObj) {
        if (((FunctionObj) type).getparamListObj().toString() == "PARAM_LIST") { //TODO check parameters are same in function call and function declaration
          return true;
        }
      }
    }
    return false;
  }

  // Called from visitor
  public void Check(SymbolTable ST){
    if(CheckSemantics(ST)){
      //Do symbol table stuff
    } else {
      System.out.println("#semantic_error#");
      System.out.println("Insert Error message here");
      exit(200);
    }
  }

  @Override
  public void printContents(){
    System.out.println(this.getClass().getSimpleName() + ": ");
    System.out.println("funcName: " + funcName);
    System.out.println("numOfExpr: " + numOfExpr);
    if(ast_exprList.size() == numOfExpr){
      System.out.println("ast_exprList: List full");
    } else {
      System.out.println("ast_exprList has size: " + ast_exprList.size());
    }
  }
}

package ASTNodes.AST_Stats;

import ASTNodes.AST_Exprs.AST_Expr;
import ASTNodes.AST_FuncDecl;
import ASTNodes.AST_Node;
import ASTNodes.AST_Program;
import SymbolTable.SymbolTable;

public class AST_StatExpr extends AST_Stat{
  //Syntactic attributes
  AST_Expr expr;
  //Semantic attribute

  // Assign the class variables when called
  public AST_StatExpr(){
    this.expr = null;
  }

  public boolean isEmbeddedNodesFull(){
    return expr != null;
  }

  public void setSyntacticAttributes(String value){
    System.out.println("No String Syntactic Attributes");
  }


  public String getSyntacticAttributes(String strToGet){
    System.out.println("No String Syntactic Attributes");
    return null;
  }

  public AST_Node getEmbeddedAST(String astToGet, int counter){
    if(astToGet.equals("expr")){
      return expr;
    }
    System.out.println("Unrecognised AST Node.");
    return null;
  }

  public void setEmbeddedAST(String astToSet, AST_Node nodeToSet){
    if(astToSet.equals("expr")){
      expr = (AST_Expr) nodeToSet;
    } else {
      System.out.println("Unrecognised AST Node.");
    }
  }


  //Semantic Analysis and print error message if needed
  @Override
  protected boolean CheckSemantics(SymbolTable ST){
    if (statName.equals("FREE")) {
      return expr.getType().contains("[]") || expr.getType().startsWith("PAIR(");
    } else if (statName.equals("RETURN")) {
      AST_Node parent = getParentNode();
      while (!(parent instanceof AST_FuncDecl)) {
        if (parent instanceof AST_Program) {
          System.out.println("Return statement not inside of a function.");
          return false;
        }
        parent = getParentNode();
        System.out.println("Going to AST parent, looking for function");
      }
      AST_FuncDecl temp = (AST_FuncDecl) parent;
      if (temp.getReturnTypeName().equals(expr.getType())) {
        return true;
      }
    } else if (statName.equals("EXIT")) {
      return expr.getType().equals("int");
    } else if (statName.equals("PRINT")) {
      return true;
    } else if (statName.equals("PRINTLN")) {
      return true;
    }
    return false;
  }

  // Called from visitor
  @Override
  public void Check(SymbolTable ST){
    if(CheckSemantics(ST)){
      //Do symbol table stuff
    }
  }

}

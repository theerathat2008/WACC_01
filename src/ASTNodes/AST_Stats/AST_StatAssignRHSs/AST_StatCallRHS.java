package ASTNodes.AST_Stats.AST_StatAssignRHSs;

import ASTNodes.AST_Exprs.AST_Expr;
import ASTNodes.AST_Node;
import IdentifierObjects.*;
import SymbolTable.SymbolTable;
import src.ErrorMessages.UndefinedFunctionError;
import src.FilePosition;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import static java.lang.System.exit;

/**
 * Class representing node in AST tree for CALL ASSIGNMENT
 */
public class AST_StatCallRHS extends AST_StatAssignRHS{
  //Syntactic attributes
  String funcName;
  int numOfExpr;
  List<AST_Expr> ast_exprList;
  ParserRuleContext ctx;

  /**
   * Constructor for class - initialises class variables
   * @param numberOfChildren - Shows the number of parameters in the parameter list of function
   */
  public AST_StatCallRHS(int numberOfChildren, ParserRuleContext ctx){
    ast_exprList = new ArrayList<>();
    if(numberOfChildren == 4){
      this.numOfExpr = 0;
    } else {
      this.numOfExpr = (numberOfChildren - 3) / 2;
    }
    this.funcName = null;
    this.ctx = ctx;
  }

  /**
   * Gets all children nodes of current node
   * @return list of AST nodes that are the children of the current node
   */
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


  /**
   * Sets syntactic attributes of class variables by assigning it a value
   * @param value - Value to be assigned to class variable
   */

  public void setSyntacticAttributes(String value, SymbolTable ST){
    if(funcName == null){
      this.funcName = value;
      identifier = ST.lookupAll(funcName);
      System.out.println("Checking if " + funcName + " is in the symbol tree.");
    } else {
      System.out.println("Unrecognised String Attribute" + this.getClass().getSimpleName());
    }
  }

  /**
   * Gets syntactic attributes of class variables
   * @param strToGet - Value to be retrieved from class variable
   */
  public String getSyntacticAttributes(String strToGet){
    if(strToGet.equals("funcName")){
      return funcName;
    } else {
      System.out.println("Unrecognised String Attribute" + this.getClass().getSimpleName());
      return null;
    }
  }

  /**
   * @param ST - Parameter of current symbol table in scope
   * @return - Returns the type of the identifier variable
   */
  @Override
  public String getType(SymbolTable ST) {
    //FunctionObj type = (FunctionObj)ST.lookupAll(funcName);
    System.out.println(ST.symMap.containsKey("f"));
    return "int"; //((FunctionObj)ST.lookupAll(funcName)).getReturnTypeName();
  }

  /**
   * Returns true if the embedded Nodes have value
   */
  public boolean isEmbeddedNodesFull(){
    return ast_exprList.size() == numOfExpr;
  }

  /**
   * @param astToGet Shows which child to get from current node
   * @param counter Shows which child of child to get from current node
   * @return Returns the required child AST Node (determined by the astToGet parameter)
   */
  @Override
  public AST_Node getEmbeddedAST(String astToGet, int counter){
    if(astToGet.equals("ast_exprList")){
      return ast_exprList.get(counter);
    }
    System.out.println("Unrecognised AST Node at class: " + this.getClass().getSimpleName());
    return null;
  }

  /**
   * @param astToSet Shows which child to set from current node
   * @param nodeToSet Shows which child of child to set from current node
   */
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

    FunctionObj thisType = (FunctionObj) identifier;
    IDENTIFIER tableType = ST.lookupAll(funcName);
    if (tableType != null) {
      if (tableType instanceof FunctionObj) {
        if (((FunctionObj) tableType).equals(thisType)) { //TODO check parameters are same in function call and function declaration
          identifier = ((FunctionObj) identifier).returnType;
          return true;
        }
      }
    }
    new UndefinedFunctionError(new FilePosition(ctx)).printAll();
    return false;
  }

  private String paramsToString() {
    String res = "(";
    for (int i = 0; i< ast_exprList.size(); i++ ) {
      res += (ast_exprList.get(i).toString() + ",");
    }
    return res + ")";
  }

  // Called from visitor
  public void Check(SymbolTable ST){
    if (CheckSemantics(ST)) {

    }
      //Do symbol table stuff
  }

  /**
   * Used for testing - Prints out contents of current AST node
   */
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

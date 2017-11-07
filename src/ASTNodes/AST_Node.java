package ASTNodes;


import SymbolTable.SymbolTable;
import org.antlr.v4.runtime.ParserRuleContext;
import src.FilePosition;

import java.util.ArrayDeque;


/**
 * Empty Base class for the AST Nodes that is generated for the parse tree
 */
public abstract class AST_Node {
  ParserRuleContext ctx;

  protected AST_Node parentNode;

  public AST_Node(ParserRuleContext ctx){
    this.ctx = ctx;

  }



  public AST_Node getParentNode(){
    return parentNode;
  }

  public void setParentNode(AST_Node nodeToSet){
    parentNode = nodeToSet;
  }

  @Override
  public String toString(){
    return this.getClass().getSimpleName();
  }

  public abstract ArrayDeque<AST_Node> getNodes();

  public abstract void setSyntacticAttributes(String value);

  public abstract String getSyntacticAttributes(String strToGet);

  // Returns true if the embedded nodes have values
  public abstract boolean isEmbeddedNodesFull();

  //Return embeded AST nodes if they exist
  public abstract AST_Node getEmbeddedAST(String astToGet, int counter);

  //Set embeded AST nodes if they exist
  public abstract void setEmbeddedAST(String astToSet, AST_Node nodeToSet);

  //Semantic Analysis and print error message if needed
  protected abstract boolean CheckSemantics(SymbolTable ST);

  // Called from visitor
  public abstract void Check(SymbolTable ST);

  public abstract void printContents();

}

package ASTNodes;

/**
 * Empty Base class for the AST Tree that is generated from the parse tree
 */
public abstract class AST_Node {

  public AST_Node parentNode;

  // Returns true if the embedded nodes have values
  public abstract boolean isEmbeddedNodesFull();

  //Return embeded AST nodes if they exist
  public abstract AST_Node getEmbeddedAST(String astToGet, int counter);

  //Set embeded AST nodes if they exist
  public abstract void setEmbeddedAST(String astToSet, AST_Node nodeToSet);

  //Semantic Analysis and print error message if needed
  protected abstract boolean CheckSemantics();

  // Called from visitor
  public abstract void Check();
}

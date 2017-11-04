package ASTNodes;

/**
 * Empty Base class for the AST Tree that is generated from the parse tree
 */
public abstract class AST_Node {

  //Return embeded AST nodes if they exist
  public abstract AST_Node getEmbededAST(String astToGet);

  //Semantic Analysis and print error message if needed
  protected abstract boolean CheckSemantics();

  // Called from visitor
  public abstract void Check();
}

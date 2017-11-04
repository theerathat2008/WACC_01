package src;

import java.util.*;

import ASTNodes.AST_Program;
import antlr.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * Go thorugh all the nodes in parse tree
 * Generate AST tree
 */


public class waccVisitor extends WaccParserBaseVisitor<Void> {

  @Override
  public Void visitProgram(WaccParser.ProgramContext ctx) {
    //Create new ProgramAST class
    return visitChildren(ctx);
  }

}
/**

1. Override all the Base Visitor functions
   - Add the node to the AST node to the symbol table
   - Depending on the function do semantic analysis on it by calling check function of the AST Node class
2. Override all the Base Visitor functions
  - Create an AST Class which corresponds to the Visitor function
**/

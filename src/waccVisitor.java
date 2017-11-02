
import java.util.*;
import antlr.*;

public class waccVisitor extends WaccParserBaseVisitor<Void> {

  @Override
  public Void visitProgram(WaccParser.ProgramContext ctx) {
    System.out.println("Hi, who's awake");
    return visitChildren(ctx);
  }
  @Override
  public Void visitParam(WaccParser.ParamContext ctx) {
    System.out.println("Visited a parameter.");
    return visitChildren(ctx);
  }

  @Override public Void visitStat(WaccParser.StatContext ctx) {
    ctx.
    return visitChildren(ctx);
  }
}

/**

1. Override all the Base Visitor functions
   - Add the node to the AST node to the symbol table
   - Depending on the function do semantic analysis on it by calling check function of the AST Node class

**/

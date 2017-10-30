package src;

import java.util.*;
import antlr.*;

public class waccVisitor extends WaccParserBaseVisitor<Void> {

  public Void visitProgram(WaccParser.ProgramContext ctx) {
    System.out.println("Hi, who's awake");
    return visitChildren(ctx);
  }
}

/**

1. Override all the Base Visitor functions
   - Add the node to the AST node to the symbol table
   - Depending on the function do semantic anaylisis on it by calling check function of the AST Node class 

**/

package src;

import java.util.*;
import antlr.*;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * Go thorugh all the nodes in parse tree
 * Generate AST tree
 */


public class waccVisitor extends WaccParserBaseVisitor<Void> {
  
  @Override 
  public Void visitPRINT(WaccParser.PRINTContext ctx) {
    return visitChildren(ctx);
  }
  
  @Override 
  public Void visitCALL(WaccParser.CALLContext ctx) {
    return visitChildren(ctx);
  }
  
  @Override 
  public Void visitArray_elem(WaccParser.Array_elemContext ctx) { 
    return visitChildren(ctx); 
  }
  
  @Override 
  public Void visitPRINTLN(WaccParser.PRINTLNContext ctx) { 
    return visitChildren(ctx); 
  }
  
  @Override 
  public Void visitBINARY_OP(WaccParser.BINARY_OPContext ctx) { 
    return visitChildren(ctx); 
  }
  
  @Override 
  public Void visitSEMI(WaccParser.SEMIContext ctx) { 
    return visitChildren(ctx); 
  }
  
  @Override 
  public Void visitNEWPAIR(WaccParser.NEWPAIRContext ctx) { 
    return visitChildren(ctx); 
  }
  
  @Override 
  public Void visitSTR_LITER(WaccParser.STR_LITERContext ctx) { 
    return visitChildren(ctx); 
  }
  
  @Override 
  public Void visitPAIR_LITER(WaccParser.PAIR_LITERContext ctx) { 
    return visitChildren(ctx); 
  }

  @Override 
  public Void visitProgram(WaccParser.ProgramContext ctx) {
    System.out.println("Running program");
    return visitChildren(ctx);
  }

  @Override 
  public Void visitASSIGN(WaccParser.ASSIGNContext ctx) { 
    return visitChildren(ctx); 
  }
  
  @Override 
  public Void visitFREE(WaccParser.FREEContext ctx) { 
    return visitChildren(ctx); 
  }
  
  @Override 
  public Void visitARRAY_ELEM_LHS(WaccParser.ARRAY_ELEM_LHSContext ctx) { 
    return visitChildren(ctx); 
  }
  
  @Override 
  public Void visitPAIR_ELEM_LHS(WaccParser.PAIR_ELEM_LHSContext ctx) { 
    return visitChildren(ctx); 
  }

  @Override 
  public Void visitPAIR_STRING(WaccParser.PAIR_STRINGContext ctx) { 
    return visitChildren(ctx); 
  }
  
  @Override 
  public Void visitRETURN(WaccParser.RETURNContext ctx) { 
    return visitChildren(ctx); 
  }
  
  @Override 
  public Void visitPAIR_ELEM_RHS(WaccParser.PAIR_ELEM_RHSContext ctx) { 
    return visitChildren(ctx); 
  }
  
  @Override 
  public Void visitUNARY_OP(WaccParser.UNARY_OPContext ctx) { 
    return visitChildren(ctx); 
  }
  
  @Override 
  public Void visitCLOSED_EXPR(WaccParser.CLOSED_EXPRContext ctx) { 
    return visitChildren(ctx); 
  }

  @Override
  public Void visitParam(WaccParser.ParamContext ctx) {
    System.out.println("Visited a parameter.");
    return visitChildren(ctx);
  }
  
  @Override 
  public Void visitEXPR(WaccParser.EXPRContext ctx) { 
    return visitChildren(ctx); 
  }
  
  @Override 
  public Void visitPair_type(WaccParser.Pair_typeContext ctx) { 
    return visitChildren(ctx); 
  }
  
  @Override 
  public Void visitPAIR_FST(WaccParser.PAIR_FSTContext ctx) { 
    return visitChildren(ctx); 
  }
  
  @Override 
  public Void visitSKIP(WaccParser.SKIPContext ctx) { 
    return visitChildren(ctx); 
  }

  @Override
  public Void visitIF(WaccParser.IFContext ctx) {
    System.out.println("Visited an if.");
    return visitChildren(ctx);
  }
  
  @Override 
  public Void visitARRAY_TYPE_PAIR(WaccParser.ARRAY_TYPE_PAIRContext ctx) { 
    return visitChildren(ctx); 
  }
  
  @Override 
  public Void visitBOOL_LITER(WaccParser.BOOL_LITERContext ctx) { 
    return visitChildren(ctx); 
  }
  
  @Override 
  public Void visitEQUALS(WaccParser.EQUALSContext ctx) { 
    return visitChildren(ctx); 
  }
  
  @Override 
  public Void visitArray_liter(WaccParser.Array_literContext ctx) { 
    return visitChildren(ctx); 
  }
  
  @Override 
  public Void visitARRAY_TYPE(WaccParser.ARRAY_TYPEContext ctx) { 
    return visitChildren(ctx); 
  }
  
  @Override 
  public Void visitCHAR_LITER(WaccParser.CHAR_LITERContext ctx) { 
    return visitChildren(ctx); 
  }
  
  @Override 
  public Void visitINT_LITER(WaccParser.INT_LITERContext ctx) { 
    return visitChildren(ctx); 
  }
  
  @Override 
  public Void visitIDENT_EXPR(WaccParser.IDENT_EXPRContext ctx) { 
    return visitChildren(ctx); 
  }
  
  @Override 
  public Void visitParam_list(WaccParser.Param_listContext ctx) { 
    return visitChildren(ctx); 
  }
  
  @Override 
  public Void visitArg_list(WaccParser.Arg_listContext ctx) { 
    return visitChildren(ctx); 
  }
  
  @Override 
  public Void visitBASE_TYPE_PAIR(WaccParser.BASE_TYPE_PAIRContext ctx) { 
    return visitChildren(ctx); 
  }
  
  @Override 
  public Void visitREAD(WaccParser.READContext ctx) { 
    return visitChildren(ctx); 
  }
  
  @Override 
  public Void visitPAIR_SND(WaccParser.PAIR_SNDContext ctx) { 
    return visitChildren(ctx); 
  }

  /**
   * Called from the traversal PARSE tree when it encounters a func token
   * Adds func symbol to current symbol table
   * Create a new symbol table from the funcDeclarationAST
   * Work out how to get info from context
  **/
  @Override
  public Void visitFunc(WaccParser.FuncContext ctx) {
    /**
     * SymbolTable currSymbolTable;
     * new FuncDeclarationAST(String returntypename, String funcname ,PARAM_LIST_SCOPE parameters);
     *
     */

    ;

      ParseTree type = ctx.getChild(0);
      ParseTree name = ctx.getChild(1);
      ParseTree params = ctx.getChild(3);
      if (ctx.getRuleIndex() == 2){ // 2 represents RULE_paramList

      }

    }

    return result;
    System.out.println("Visited a func");



    return visitChildren(ctx);
  }

  @Override 
  public Void visitIDENT(WaccParser.IDENTContext ctx) { 
    return visitChildren(ctx); 
  }
  
  @Override 
  public Void visitARRAY_ELEM(WaccParser.ARRAY_ELEMContext ctx) { 
    return visitChildren(ctx); 
  }
  
  @Override 
  public Void visitARRAY_LITER(WaccParser.ARRAY_LITERContext ctx) { 
    return visitChildren(ctx); 
  }
  
  @Override 
  public Void visitWHILE(WaccParser.WHILEContext ctx) { 
    return visitChildren(ctx); 
  }
  
  @Override 
  public Void visitPAIR_TYPE(WaccParser.PAIR_TYPEContext ctx) { 
    return visitChildren(ctx); 
  }
  
  @Override 
  public Void visitBEGIN_END(WaccParser.BEGIN_ENDContext ctx) { 
    return visitChildren(ctx); 
  }
  
  @Override 
  public Void visitEXIT(WaccParser.EXITContext ctx) { 
    return visitChildren(ctx); 
  }
  
  @Override 
  public Void visitBASE_TYPE(WaccParser.BASE_TYPEContext ctx) { 
    return visitChildren(ctx); 
  }
}
/**

1. Override all the Base Visitor functions
   - Add the node to the AST node to the symbol table
   - Depending on the function do semantic analysis on it by calling check function of the AST Node class

**/

package src;

import java.util.*;

import ASTNodes.*;
import ASTNodes.AST_Exprs.*;
import ASTNodes.AST_Stats.*;
import ASTNodes.AST_Stats.AST_StatAssignLHSs.AST_StatArrayElemLHS;
import ASTNodes.AST_Stats.AST_StatAssignLHSs.AST_StatIdentLHS;
import ASTNodes.AST_Stats.AST_StatAssignLHSs.AST_StatPairElemLHS;
import ASTNodes.AST_Stats.AST_StatAssignRHSs.*;
import antlr.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * Go through all the nodes in parse tree
 * Generate AST tree
 */


public class waccVisitor extends WaccParserBaseVisitor<Void> {

  private AST_Program progBase;
  private AST_Node parentVisitorNode;

  /**
   * General layout of visitor functions
   * Set the current visitor Node
   * Assign new visitor Node to its embedded ast value through accessing its parent
   * Set the Curr Node
   * Semantic analysis on the currnode
   * Debug message
   * Iterate through the rest of the tree
   */

  @Override
  public Void visitProgram(WaccParser.ProgramContext ctx) {

    //Create the node for the current visitor function
    progBase = new AST_Program(ctx.getChildCount());

    //Set parentNode of AST class and global visitor class
    progBase.setParentNode(null);
    parentVisitorNode = progBase;

    //Do semantic analysis
    progBase.Check();

    //Debug statement
    System.out.println("Prog");

    //Iterate through rest of the tree

    return visitChildren(ctx);
  }

  @Override
  public Void visitFunc(WaccParser.FuncContext ctx) {


    //Create the node for the current visitor function
    AST_FuncDecl funcNode = new AST_FuncDecl();

    //For returnTypeName
    //Visit type and get the corresponding visitor function to set the type in func AST Node
    visitChildren(ctx.type());

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("functionList", funcNode);

    //Set parentNode of AST class and global visitor class
    funcNode.setParentNode(parentVisitorNode);
    parentVisitorNode = funcNode;

    //Do semantic analysis
    funcNode.Check();

    //Debug statement
    System.out.println("Func");

    //Iterate through rest of the tree
    return visitChildren(ctx);
  }

  @Override
  public Void visitParam_list(WaccParser.Param_listContext ctx) {

    //Create the node for the current visitor function
    AST_ParamList paramListNode = new AST_ParamList(ctx.getChildCount());

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("paramList", paramListNode);

    //Set parentNode of AST class and global visitor class
    paramListNode.setParentNode(parentVisitorNode);
    parentVisitorNode = paramListNode;

    //Do semantic analysis
    paramListNode.Check();

    //Debug statement
    System.out.println("ParamList");

    //Iterate through rest of the tree
    return visitChildren(ctx);
  }


  //TERMINAL NODE
  @Override
  public Void visitParam(WaccParser.ParamContext ctx) {

    //Create the node for the current visitor function
    AST_Param paramNode = new AST_Param();

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("listParam", paramNode);

    //Set parentNode of AST class and global visitor class
    paramNode.setParentNode(parentVisitorNode);
    parentVisitorNode = paramNode;

    //Do semantic analysis
    paramNode.Check();

    //Debug statement
    System.out.println("Param");

    //Set the parent node for terminal node
    while(parentVisitorNode.isEmbeddedNodesFull()){
      parentVisitorNode = parentVisitorNode.getParentNode();
    }
    //Iterate through rest of the tree
    return visitChildren(ctx);
  }


  @Override
  public Void visitEXPR_ASSIGN(WaccParser.EXPR_ASSIGNContext ctx) {

    //Create the node for the current visitor function
    AST_StatExprRHS statExprRHSNode = new AST_StatExprRHS();

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("statAssignRHS", statExprRHSNode);

    //Set parentNode of AST class and global visitor class
    statExprRHSNode.setParentNode(parentVisitorNode);
    parentVisitorNode = statExprRHSNode;

    //Do semantic analysis
    statExprRHSNode.Check();

    //Debug statement
    System.out.println("StatExprAssign");

    //Iterate through rest of the tree
    return visitChildren(ctx);
  }

  //TODO ------------------------
  //TODO Check if we need visit ArrayELEM : PROBABLY NOT, Embedded in StatArrayELemLHs and ExprArrayElem
  //TODO -------------------------
  @Override
  public Void visitArray_elem(WaccParser.Array_elemContext ctx) {
    return visitChildren(ctx);
  }



  @Override
  public Void visitPRINTLN_STAT(WaccParser.PRINTLN_STATContext ctx) {

    //Create the node for the current visitor function
    AST_StatExpr statExprNode = new AST_StatExpr();

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("statement", statExprNode);

    //Set parentNode of AST class and global visitor class
    statExprNode.setParentNode(parentVisitorNode);
    parentVisitorNode = statExprNode;

    //Do semantic analysis
    statExprNode.Check();

    //Debug statement
    System.out.println("printlnStat");

    //Iterate through rest of the tree
    return visitChildren(ctx);
  }


  @Override
  public Void visitARRAY_ELEM_LHS(WaccParser.ARRAY_ELEM_LHSContext ctx) {

    //Create the node for the current visitor function
    AST_StatArrayElemLHS statArrayElemLHSNode = new AST_StatArrayElemLHS(ctx.getChildCount());

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("ast_statAssignLHS", statArrayElemLHSNode);

    //Set parentNode of AST class and global visitor class
    statArrayElemLHSNode.setParentNode(parentVisitorNode);
    parentVisitorNode = statArrayElemLHSNode;

    //Do semantic analysis
    statArrayElemLHSNode.Check();

    //Debug statement
    System.out.println("statArrayElemLHS");

    //Iterate through rest of the tree
    return visitChildren(ctx);
  }

  @Override
  public Void visitPAIR_ELEM_LHS(WaccParser.PAIR_ELEM_LHSContext ctx) {
    //Create the node for the current visitor function
    AST_StatPairElemLHS statPairElemLHSNode = new AST_StatPairElemLHS();

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("ast_statAssignLHS", statPairElemLHSNode);

    //Set parentNode of AST class and global visitor class
    statPairElemLHSNode.setParentNode(parentVisitorNode);
    parentVisitorNode = statPairElemLHSNode;

    //Do semantic analysis
    statPairElemLHSNode.Check();

    //Debug statement
    System.out.println("statPairElemLHS");

    //Iterate through rest of the tree
    return visitChildren(ctx);
  }

  //TODO ------------------------
  //TODO Check if we need visit PAIR STRING : Probably not, embedded as string info in VarDecl Param and FuncDecl
  //TODO -------------------------
  @Override
  public Void visitPAIR_STRING(WaccParser.PAIR_STRINGContext ctx) {
    return visitChildren(ctx);
  }

  @Override
  public Void visitPAIR_ELEM_RHS(WaccParser.PAIR_ELEM_RHSContext ctx) {
    //Create the node for the current visitor function
    AST_StatPairElemRHS statPairElemRHSNode = new AST_StatPairElemRHS();

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("statAssignRHS", statPairElemRHSNode);

    //Set parentNode of AST class and global visitor class
    statPairElemRHSNode.setParentNode(parentVisitorNode);
    parentVisitorNode = statPairElemRHSNode;

    //Do semantic analysis
    statPairElemRHSNode.Check();

    //Debug statement
    System.out.println("statPairElemRHS");

    //Iterate through rest of the tree
    return visitChildren(ctx);
  }

  //Terminal Node
  @Override
  public Void visitCHAR_LITER_EXPR(WaccParser.CHAR_LITER_EXPRContext ctx) {
    //Create the node for the current visitor function
    AST_ExprLiter exprLiterNode = new AST_ExprLiter();

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("expr", exprLiterNode);

    //Set parentNode of AST class and global visitor class
    exprLiterNode.setParentNode(parentVisitorNode);
    parentVisitorNode = exprLiterNode;

    //Do semantic analysis
    exprLiterNode.Check();

    //Debug statement
    System.out.println("exprCharLiter");

    //Set the parent node for terminal node
    while(parentVisitorNode.isEmbeddedNodesFull()){
      parentVisitorNode = parentVisitorNode.getParentNode();
    }
    //Iterate through rest of the tree
    return visitChildren(ctx);
  }

  @Override
  public Void visitUNARY_OP_EXPR(WaccParser.UNARY_OP_EXPRContext ctx) {
    //Create the node for the current visitor function
    AST_ExprUnary exprUnaryNode = new AST_ExprUnary();

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("expr", exprUnaryNode);

    //Set parentNode of AST class and global visitor class
    exprUnaryNode.setParentNode(parentVisitorNode);
    parentVisitorNode = exprUnaryNode;

    //Do semantic analysis
    exprUnaryNode.Check();

    //Debug statement
    System.out.println("exprUnary");

    //Iterate through rest of the tree
    return visitChildren(ctx);
  }

  //Terminal TODO
  @Override
  public Void visitSKIP_STAT(WaccParser.SKIP_STATContext ctx) {
    //Create the node for the current visitor function
    AST_Stat skipNode = new AST_Stat();

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("statement", skipNode);

    //Set parentNode of AST class and global visitor class
    skipNode.setParentNode(parentVisitorNode);
    parentVisitorNode = skipNode;

    //Do semantic analysis
    skipNode.Check();

    //Debug statement
    System.out.println("Skip");

    //Iterate through rest of the tree
    return visitChildren(ctx);
  }

  @Override 
  public Void visitREAD_STAT(WaccParser.READ_STATContext ctx) {
    //Create the node for the current visitor function
    AST_StatRead statReadNode = new AST_StatRead();

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("statement", statReadNode);

    //Set parentNode of AST class and global visitor class
    statReadNode.setParentNode(parentVisitorNode);
    parentVisitorNode = statReadNode;

    //Do semantic analysis
    statReadNode.Check();

    //Debug statement
    System.out.println("statRead");

    //Iterate through rest of the tree
    return visitChildren(ctx);
  }

  @Override
  public Void visitWHILE_STAT(WaccParser.WHILE_STATContext ctx) {
    //Create the node for the current visitor function
    AST_StatWhile statWhileNode = new AST_StatWhile();

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("statement", statWhileNode);

    //Set parentNode of AST class and global visitor class
    statWhileNode.setParentNode(parentVisitorNode);
    parentVisitorNode = statWhileNode;

    //Do semantic analysis
    statWhileNode.Check();

    //Debug statement
    System.out.println("statWhile");

    //Iterate through rest of the tree
    return visitChildren(ctx);
  }


  @Override
  public Void visitNEWPAIR_RHS(WaccParser.NEWPAIR_RHSContext ctx) {
    //Create the node for the current visitor function
    AST_StatNewPairRHS statNewPairRHSNode = new AST_StatNewPairRHS();

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("statAssignRHS", statNewPairRHSNode);

    //Set parentNode of AST class and global visitor class
    statNewPairRHSNode.setParentNode(parentVisitorNode);
    parentVisitorNode = statNewPairRHSNode;

    //Do semantic analysis
    statNewPairRHSNode.Check();

    //Debug statement
    System.out.println("statNewPairRHS");

    //Iterate through rest of the tree
    return visitChildren(ctx);
  }

  @Override
  public Void visitIDENT_EXPR(WaccParser.IDENT_EXPRContext ctx) {
    //Create the node for the current visitor function
    AST_ExprIdent exprIdentNode = new AST_ExprIdent();

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("expr", exprIdentNode);

    //Set parentNode of AST class and global visitor class
    exprIdentNode.setParentNode(parentVisitorNode);
    parentVisitorNode = exprIdentNode;

    //Do semantic analysis
    exprIdentNode.Check();

    //Debug statement
    System.out.println("exprIdent");

    //Iterate through rest of the tree
    return visitChildren(ctx);
  }

  @Override
  public Void visitARRAY_ELEM_EXPR(WaccParser.ARRAY_ELEM_EXPRContext ctx) {
    //Create the node for the current visitor function
    AST_ExprArrayElem exprArrayElemNode = new AST_ExprArrayElem(ctx.getChildCount());

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("expr", exprArrayElemNode);

    //Set parentNode of AST class and global visitor class
    exprArrayElemNode.setParentNode(parentVisitorNode);
    parentVisitorNode = exprArrayElemNode;

    //Do semantic analysis
    exprArrayElemNode.Check();

    //Debug statement
    System.out.println("exprArrayElem");

    //Iterate through rest of the tree
    return visitChildren(ctx);
  }

  @Override
  public Void visitENCLOSED_EXPR(WaccParser.ENCLOSED_EXPRContext ctx) {
    //Create the node for the current visitor function
    AST_ExprEnclosed exprEnclosedNode = new AST_ExprEnclosed();

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("expr", exprEnclosedNode);

    //Set parentNode of AST class and global visitor class
    exprEnclosedNode.setParentNode(parentVisitorNode);
    parentVisitorNode = exprEnclosedNode;

    //Do semantic analysis
    exprEnclosedNode.Check();

    //Debug statement
    System.out.println("exprEnclosed");

    //Iterate through rest of the tree
    return visitChildren(ctx);
  }

  @Override
  public Void visitPRINT_STAT(WaccParser.PRINT_STATContext ctx) {
    //Create the node for the current visitor function
    AST_StatExpr statExprNode = new AST_StatExpr();

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("statement", statExprNode);

    //Set parentNode of AST class and global visitor class
    statExprNode.setParentNode(parentVisitorNode);
    parentVisitorNode = statExprNode;

    //Do semantic analysis
    statExprNode.Check();

    //Debug statement
    System.out.println("statExprNode");

    //Iterate through rest of the tree
    return visitChildren(ctx);
  }

  @Override
  public Void visitASSIGN_STAT(WaccParser.ASSIGN_STATContext ctx) {
    //Create the node for the current visitor function
    AST_StatAssign statAssignNode = new AST_StatAssign();

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("statement", statAssignNode);

    //Set parentNode of AST class and global visitor class
    statAssignNode.setParentNode(parentVisitorNode);
    parentVisitorNode = statAssignNode;

    //Do semantic analysis
    statAssignNode.Check();

    //Debug statement
    System.out.println("statAssign");

    //Iterate through rest of the tree
    return visitChildren(ctx);
  }

  @Override
  public Void visitIDENT_ASSIGN(WaccParser.IDENT_ASSIGNContext ctx) {
    //Create the node for the current visitor function
    AST_StatIdentLHS statIdentLHSNode = new AST_StatIdentLHS();

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("ast_statAssignLHS", statIdentLHSNode);

    //Set parentNode of AST class and global visitor class
    statIdentLHSNode.setParentNode(parentVisitorNode);
    parentVisitorNode = statIdentLHSNode;

    //Do semantic analysis
    statIdentLHSNode.Check();

    //Debug statement
    System.out.println("statIdentLHS");

    //Iterate through rest of the tree
    return visitChildren(ctx);
  }

  @Override
  public Void visitINT_LITER_EXPR(WaccParser.INT_LITER_EXPRContext ctx) {
    //Create the node for the current visitor function
    AST_ExprLiter exprLiterNode = new AST_ExprLiter();

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("expr", exprLiterNode);

    //Set parentNode of AST class and global visitor class
    exprLiterNode.setParentNode(parentVisitorNode);
    parentVisitorNode = exprLiterNode;

    //Do semantic analysis
    exprLiterNode.Check();

    //Debug statement
    System.out.println("exprIntLiter");

    //Iterate through rest of the tree
    return visitChildren(ctx);
  }

  @Override
  public Void visitVAR_DECL_STAT(WaccParser.VAR_DECL_STATContext ctx) {
    //Create the node for the current visitor function
    AST_StatVarDecl statVarDeclNode = new AST_StatVarDecl();

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("statement", statVarDeclNode);

    //Set parentNode of AST class and global visitor class
    statVarDeclNode.setParentNode(parentVisitorNode);
    parentVisitorNode = statVarDeclNode;

    //Do semantic analysis
    statVarDeclNode.Check();

    //Debug statement
    System.out.println("statVarDecl");

    //Iterate through rest of the tree
    return visitChildren(ctx);
  }

  @Override
  public Void visitFREE_STAT(WaccParser.FREE_STATContext ctx) {
    //Create the node for the current visitor function
    AST_StatExpr statExprNode = new AST_StatExpr();

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("statement", statExprNode);

    //Set parentNode of AST class and global visitor class
    statExprNode.setParentNode(parentVisitorNode);
    parentVisitorNode = statExprNode;

    //Do semantic analysis
    statExprNode.Check();

    //Debug statement
    System.out.println("statExpr");

    //Iterate through rest of the tree
    return visitChildren(ctx);
  }

  @Override
  public Void visitBEGIN_END_STAT(WaccParser.BEGIN_END_STATContext ctx) {
    //Create the node for the current visitor function
    AST_StatBeginEnd statBeginEndNode = new AST_StatBeginEnd();

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("statement", statBeginEndNode);

    //Set parentNode of AST class and global visitor class
    statBeginEndNode.setParentNode(parentVisitorNode);
    parentVisitorNode = statBeginEndNode;

    //Do semantic analysis
    statBeginEndNode.Check();

    //Debug statement
    System.out.println("statBeginEnd");

    //Iterate through rest of the tree
    return visitChildren(ctx);
  }

  @Override
  public Void visitIF_STAT(WaccParser.IF_STATContext ctx) {
    //Create the node for the current visitor function
    AST_StatIf statIfNode = new AST_StatIf();

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("statement", statIfNode);

    //Set parentNode of AST class and global visitor class
    statIfNode.setParentNode(parentVisitorNode);
    parentVisitorNode = statIfNode;

    //Do semantic analysis
    statIfNode.Check();

    //Debug statement
    System.out.println("statIf");

    //Iterate through rest of the tree
    return visitChildren(ctx);
  }

  @Override
  public Void visitCALL_ASSIGN(WaccParser.CALL_ASSIGNContext ctx) {
    //Create the node for the current visitor function
    AST_StatCallRHS statCallRHSNode = new AST_StatCallRHS(ctx.getChildCount());

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("statAssignRHS", statCallRHSNode);

    //Set parentNode of AST class and global visitor class
    statCallRHSNode.setParentNode(parentVisitorNode);
    parentVisitorNode = statCallRHSNode;

    //Do semantic analysis
    statCallRHSNode.Check();

    //Debug statement
    System.out.println("statCallRHS");

    //Iterate through rest of the tree
    return visitChildren(ctx);
  }

/**
 * TODO SHOULDNT EXIST ANYMORE
  @Override
  public Void visitOpen_paren(WaccParser.Open_parenContext ctx) {
    //Create the node for the current visitor function
    AST_Separator separatorNode = new AST_Separator();

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("exprAST", separatorNode);

    //Set parentNode of AST class and global visitor class
    separatorNode.setParentNode(parentVisitorNode);
    parentVisitorNode = separatorNode;

    //Do semantic analysis
    separatorNode.Check();

    //Debug statement
    System.out.println("separator");

    //Iterate through rest of the tree
    return visitChildren(ctx);
  }
**/


  //TODO ------------------------
  //TODO Check Whether to visit Pair FST : Probably not, value stored in pair elem rhs and pair elem lhs, ASTs
  //TODO -------------------------

  @Override
  public Void visitPAIR_FST(WaccParser.PAIR_FSTContext ctx) {
    return visitChildren(ctx);
  }


  //TODO ------------------------
  //TODO Check Whether to visit ARRAY_TYPE_PAIR: Probably not, value store in type
  //TODO -------------------------

  @Override
  public Void visitARRAY_TYPE_PAIR(WaccParser.ARRAY_TYPE_PAIRContext ctx) {
    return visitChildren(ctx);
  }


  @Override
  public Void visitBINARY_OP_EXPR(WaccParser.BINARY_OP_EXPRContext ctx) {
    //Create the node for the current visitor function
    AST_ExprBinary exprBinaryNode = new AST_ExprBinary();

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("expr", exprBinaryNode);

    //Set parentNode of AST class and global visitor class
    exprBinaryNode.setParentNode(parentVisitorNode);
    parentVisitorNode = exprBinaryNode;

    //Do semantic analysis
    exprBinaryNode.Check();

    //Debug statement
    System.out.println("exprBinary");

    //Iterate through rest of the tree
    return visitChildren(ctx);
  }

  @Override
  public Void visitMULT_STAT(WaccParser.MULT_STATContext ctx) {
    //Create the node for the current visitor function
    AST_StatMult statMultNode = new AST_StatMult();

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("statement", statMultNode);

    //Set parentNode of AST class and global visitor class
    statMultNode.setParentNode(parentVisitorNode);
    parentVisitorNode = statMultNode;

    //Do semantic analysis
    statMultNode.Check();

    //Debug statement
    System.out.println("statMult");

    //Iterate through rest of the tree
    return visitChildren(ctx);
  }

/**
  //TODO ------------------------
  //TODO Got rid of array type
  //TODO -------------------------

  @Override
  public Void visitARRAY_TYPE(WaccParser.ARRAY_TYPEContext ctx) {
    return visitChildren(ctx);
  }
**/

  @Override
  public Void visitSTR_LITER_EXPR(WaccParser.STR_LITER_EXPRContext ctx) {
    //Create the node for the current visitor function
    AST_ExprLiter exprLiterNode = new AST_ExprLiter();

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("expr", exprLiterNode);

    //Set parentNode of AST class and global visitor class
    exprLiterNode.setParentNode(parentVisitorNode);
    parentVisitorNode = exprLiterNode;

    //Do semantic analysis
    exprLiterNode.Check();

    //Debug statement
    System.out.println("exprStringLiter");

    //Iterate through rest of the tree
    return visitChildren(ctx);
  }

  @Override
  public Void visitARRAY_LITER_RHS(WaccParser.ARRAY_LITER_RHSContext ctx) {
    //Create the node for the current visitor function
    AST_StatArrayLitRHS statArrayLitRHSNode = new AST_StatArrayLitRHS(ctx.getChildCount());

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("statAssignRHS", statArrayLitRHSNode);

    //Set parentNode of AST class and global visitor class
    statArrayLitRHSNode.setParentNode(parentVisitorNode);
    parentVisitorNode = statArrayLitRHSNode;

    //Do semantic analysis
    statArrayLitRHSNode.Check();

    //Debug statement
    System.out.println("statArrayLitRHS");

    //Iterate through rest of the tree
    return visitChildren(ctx);
  }

  @Override
  public Void visitEXIT_STAT(WaccParser.EXIT_STATContext ctx) {
    //Create the node for the current visitor function
    AST_StatExpr exitNode = new AST_StatExpr();

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("statement", exitNode);

    //Set parentNode of AST class and global visitor class
    exitNode.setParentNode(parentVisitorNode);
    parentVisitorNode = exitNode;

    //Do semantic analysis
    exitNode.Check();

    //Debug statement
    System.out.println("exit");

    //Iterate through rest of the tree
    return visitChildren(ctx);
  }

  //TODO ------------------------
  //TODO Check Whether to visit ARG_LIST : Probably not, stored in AST_CallRHS
  //TODO -------------------------

  @Override
  public Void visitArg_list(WaccParser.Arg_listContext ctx) {
    return visitChildren(ctx);
  }

  //TODO ------------------------
  //TODO Check Whether to visit BASE_TYPR_PAIR : Probably not, stored in pair_type
  //TODO -------------------------

  @Override
  public Void visitBASE_TYPE_PAIR(WaccParser.BASE_TYPE_PAIRContext ctx) {
    return visitChildren(ctx);
  }

  //TODO ------------------------
  //TODO Check Whether to visit PAIR_SND :  Probably not, value stored in pair elem rhs and pair elem lhs, ASTs
  //TODO -------------------------

  @Override
  public Void visitPAIR_SND(WaccParser.PAIR_SNDContext ctx) {
    return visitChildren(ctx);
  }

  @Override
  public Void visitBOOL_LITER_EXPR(WaccParser.BOOL_LITER_EXPRContext ctx) {
    //Create the node for the current visitor function
    AST_ExprLiter boolLiterNode = new AST_ExprLiter();

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("expr", boolLiterNode);

    //Set parentNode of AST class and global visitor class
    boolLiterNode.setParentNode(parentVisitorNode);
    parentVisitorNode = boolLiterNode;

    //Do semantic analysis
    boolLiterNode.Check();

    //Debug statement
    System.out.println("boolLiter");

    //Iterate through rest of the tree
    return visitChildren(ctx);
  }

  //TODO ------------------------
  //TODO Check Whether to visit PAIR_TYPE : NO
  //TODO -------------------------

  @Override
  public Void visitPAIR_TYPE(WaccParser.PAIR_TYPEContext ctx) {
    return visitChildren(ctx);
  }

  @Override
  public Void visitPAIR_LITER_EXPR(WaccParser.PAIR_LITER_EXPRContext ctx) {
    //Create the node for the current visitor function
    AST_ExprLiter pairLiterNode = new AST_ExprLiter();

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("expr", pairLiterNode);

    //Set parentNode of AST class and global visitor class
    pairLiterNode.setParentNode(parentVisitorNode);
    parentVisitorNode = pairLiterNode;

    //Do semantic analysis
    pairLiterNode.Check();

    //Debug statement
    System.out.println("pairLiter");

    //Iterate through rest of the tree
    return visitChildren(ctx);
  }


  @Override
  public Void visitRETURN_STAT(WaccParser.RETURN_STATContext ctx) {
    //Create the node for the current visitor function
    AST_StatExpr returnStatNode = new AST_StatExpr();

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("statement", returnStatNode);

    //Set parentNode of AST class and global visitor class
    returnStatNode.setParentNode(parentVisitorNode);
    parentVisitorNode = returnStatNode;

    //Do semantic analysis
    returnStatNode.Check();

    //Debug statement
    System.out.println("returnStat");

    //Iterate through rest of the tree
    return visitChildren(ctx);
  }


  //TODO ------------------------
  //TODO Check Whether to visit BASE_TYPE : NOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
  //TODO -------------------------


  @Override
  public Void visitBASE_TYPE(WaccParser.BASE_TYPEContext ctx) {

    //set the parent node of basetype to have the approriate member variable to be the base type
    System.out.println("This is the base type: ");
    parentVisitorNode.setSyntacticAttributes(ctx.getText());
    System.out.println(ctx.getText());

    return null;
  }




}
/**

1. Override all the Base Visitor functions
   - Add the node to the AST node to the symbol table
   - Depending on the function do semantic analysis on it by calling check function of the AST Node class
2. Override all the Base Visitor functions
  - Create an AST Class which corresponds to the Visitor function

**/

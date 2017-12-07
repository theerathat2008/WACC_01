package VisitorClass;

import ASTNodes.*;
import ASTNodes.AST_Exprs.*;
import ASTNodes.AST_SideEffect.AST_SideEffectBinary;
import ASTNodes.AST_SideEffect.AST_SideEffectPreInc;
import ASTNodes.AST_Stats.*;
import ASTNodes.AST_Stats.AST_StatAssignLHSs.AST_StatArrayElemLHS;
import ASTNodes.AST_Stats.AST_StatAssignLHSs.AST_StatIdentLHS;
import ASTNodes.AST_Stats.AST_StatAssignLHSs.AST_StatPairElemLHS;
import ASTNodes.AST_Stats.AST_StatAssignRHSs.*;
import ASTNodes.AST_Stats.AST_StatIfs.AST_StatIfElse;
import ASTNodes.AST_Stats.AST_StatIfs.AST_StatIfThen;
import ErrorMessages.FunctionRedeclarationError;
import ErrorMessages.VariableRedeclarationError;
import IdentifierObjects.BaseTypeObj;
import IdentifierObjects.FunctionObj;
import IdentifierObjects.IDENTIFIER;
import IdentifierObjects.ParamListObj;
import SymbolTable.SymbolTable;
import ASTNodes.AST_TYPES.AST_ArrayType;
import ASTNodes.AST_TYPES.AST_BaseType;
import ASTNodes.AST_TYPES.AST_PairElemTypes.AST_ArrayTypePair;
import ASTNodes.AST_TYPES.AST_PairElemTypes.AST_BaseTypePair;
import ASTNodes.AST_TYPES.AST_PairElemTypes.AST_PairString;
import ASTNodes.AST_TYPES.AST_PairType;
import ErrorMessages.FilePosition;

import antlr.*;

import java.util.Arrays;

/**
 * Go through all the nodes in parse tree
 * Generate AST tree
 */

public class waccVisitor extends WaccParserBaseVisitor<Void> {

  //private field for storing root nodes
  private AST_Program progBase;

  //private field for storing current parent visitor node
  private AST_Node parentVisitorNode;

  //private field for storing Top level symbol table which initialises the wacc keywords
  private SymbolTable TOP_ST = new SymbolTable();

  //private field for storing current symbol table
  //and initialises it with Top level symbol table
  private SymbolTable currentGlobalTree = TOP_ST;



  /**
   * Get the root node of the tree
   *
   * @return progBase
   */
  public AST_Program getRootNode() {
    return progBase;
  }

  /**
   * Iterate through every AST nodes to print out our own AST tree
   * Call method printContents which is unique for each AST nodes to print out the class names
   * and the private fields from the node class
   *
   * @param root
   */
  public void printNodes(AST_Node root) {
    System.out.println();
    if (root.getNodes() != null) {
      for (AST_Node node : root.getNodes()) {
        node.printContents();
        System.out.println();
        printNodes(node);
      }
    }
  }

  private void addStandardLibrary() {

    currentGlobalTree.add("min", new FunctionObj("min", new BaseTypeObj("int"),
            new ParamListObj(Arrays.asList(new BaseTypeObj("int"), new BaseTypeObj("int")))));
    currentGlobalTree.add("max", new FunctionObj("max", new BaseTypeObj("int"),
            new ParamListObj(Arrays.asList(new BaseTypeObj("int"), new BaseTypeObj("int")))));
    currentGlobalTree.add("avg", new FunctionObj("avg", new BaseTypeObj("int"),
            new ParamListObj(Arrays.asList(new BaseTypeObj("int"), new BaseTypeObj("int")))));
    currentGlobalTree.add("pow", new FunctionObj("pow", new BaseTypeObj("int"),
            new ParamListObj(Arrays.asList(new BaseTypeObj("int"), new BaseTypeObj("int")))));
    currentGlobalTree.add("factorial", new FunctionObj("factorial", new BaseTypeObj("int"),
            new ParamListObj(Arrays.asList(new BaseTypeObj("int")))));

  }



  /**
   * ----------------------------------------------------------------------------------------
   * General layout of visitor functions
   * Set the current visitor Node
   * Assign new visitor Node to its embedded ast value through accessing its parent
   * Set the Curr Node
   * Semantic analysis on the current node
   * Debug message
   * Iterate through the rest of the tree
   * ----------------------------------------------------------------------------------------
   */

  /**
   * Visitor function for Program.
   * Non-Terminal Node
   *
   * @param ctx
   */
  @Override
  public Void visitProgram(WaccParser.ProgramContext ctx) {

    //Create the node for the current visitor function
    progBase = new AST_Program(ctx.getChildCount());
    addStandardLibrary();
    //Set parentNode of AST class and global visitor class
    progBase.setParentNode(null);
    parentVisitorNode = progBase;
    progBase.symbolTable.setEncSymTable(TOP_ST);
    currentGlobalTree = progBase.symbolTable;


    //Debug statement
    System.out.println("Prog");

    //Iterate through rest of the tree
    visitChildren(ctx);
    currentGlobalTree = progBase.symbolTable.encSymTable;

    return null;
  }

  /**
   * Visitor function for Func.
   * Non-Terminal Node
   * Assigns AST_FuncDecl node to parent AST Node (AST_Program)
   *
   * @param ctx
   */
  @Override
  public Void visitFunc(WaccParser.FuncContext ctx) {

    //Create the node for the current visitor function
    AST_FuncDecl funcNode = new AST_FuncDecl(ctx.getChildCount(), ctx);

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("functionList", funcNode);

    //Set the syntactic value of the AST Class
    funcNode.setSyntacticAttributes(ctx.IDENT().getText());

    //Set parentNode of AST class and global visitor class
    funcNode.setParentNode(parentVisitorNode);
    parentVisitorNode = funcNode;
    currentGlobalTree = funcNode.symbolTable;

    SymbolTable tempST = currentGlobalTree;
    String funcName = funcNode.getFuncName();
    IDENTIFIER type = tempST.lookup(funcName);

    while (type == null) {
      tempST = tempST.encSymTable;
      try {
        type = tempST.lookup(funcName);
      } catch (NullPointerException e) {
        System.out.println("NullPointerException caught");
        type = null;
        break;
      }
    }


    if (type != null) {
      new FunctionRedeclarationError(new FilePosition(ctx)).printAll();
    }

    //Debug statement
    System.out.println("Func");

    //Iterate through rest of the tree
    visitChildren(ctx);


    //Do semantic analysis
    funcNode.Assign();
    currentGlobalTree = funcNode.symbolTable.encSymTable;
    if (funcNode.checkForParamList()) {
      currentGlobalTree = funcNode.symbolTable.encSymTable;
    }

    return null;
  }

  /**
   * Visitor function for Param_list.
   * Non-Terminal Node
   * Assigns AST_ParamList node to parent AST Node (AST_FuncDecl)
   *
   * @param ctx
   */
  @Override
  public Void visitParam_list(WaccParser.Param_listContext ctx) {

    //Create the node for the current visitor function
    AST_ParamList paramListNode = new AST_ParamList(ctx.getChildCount());

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("paramList", paramListNode);

    //Set parentNode of AST class and global visitor class
    paramListNode.setParentNode(parentVisitorNode);
    parentVisitorNode = paramListNode;

    currentGlobalTree = paramListNode.symbolTable;


    //Debug statement
    System.out.println("ParamList");

    //Iterate through rest of the tree
    visitChildren(ctx);

    //Do semantic analysis

    return null;
  }

  /**
   * Visitor function for Param.
   * Non-Terminal Node
   * Assigns AST_Param node to parent AST Node (AST_ParamList)
   *
   * @param ctx
   */
  @Override
  public Void visitParam(WaccParser.ParamContext ctx) {

    //Create the node for the current visitor function
    AST_Param paramNode = new AST_Param();

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("listParam", paramNode);

    //Set the syntactic value of the AST Class
    paramNode.setSyntacticAttributes(ctx.IDENT().getText());

    //Set parentNode of AST class and global visitor class
    paramNode.setParentNode(parentVisitorNode);
    parentVisitorNode = paramNode;

    //Debug statement
    System.out.println("Param");

    //Iterate through rest of the tree
    visitChildren(ctx);
    paramNode.Assign();
    return null;
  }

  /**
   * Visitor function for EXPR_ASSIGN.
   * Non-Terminal Node
   * Assigns AST_StatExprRHS node to parent AST Node (AST_StatAssign and AST_StatVarDecl)
   *
   * @param ctx
   */
  @Override
  public Void visitEXPR_ASSIGN(WaccParser.EXPR_ASSIGNContext ctx) {

    //Create the node for the current visitor function
    AST_StatExprRHS statExprRHSNode = new AST_StatExprRHS();

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("statAssignRHS", statExprRHSNode);

    //Set parentNode of AST class and global visitor class
    statExprRHSNode.setParentNode(parentVisitorNode);
    parentVisitorNode = statExprRHSNode;

    //Debug statement
    System.out.println("StatExprAssign");

    //Iterate through rest of the tree
    visitChildren(ctx);
    return null;
  }

  /**
   * Visitor function for PRINTLN_STAT.
   * Non-Terminal Node
   * Assigns AST_StatExpr node to parent AST Node (AST_Stat)
   *
   * @param ctx
   */
  @Override
  public Void visitPRINTLN_STAT(WaccParser.PRINTLN_STATContext ctx) {

    //Create the node for the current visitor function
    AST_StatExpr printlnExprNode = new AST_StatExpr(ctx, currentGlobalTree);

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("statement", printlnExprNode);

    //Set syntactic value of member variable
    printlnExprNode.setSyntacticAttributes("println");

    //Set parentNode of AST class and global visitor class
    printlnExprNode.setParentNode(parentVisitorNode);
    parentVisitorNode = printlnExprNode;

    //Debug statement
    System.out.println("printlnStat");

    //Iterate through rest of the tree
    visitChildren(ctx);
    return null;
  }

  /**
   * Visitor function for ARRAY_ELEM_LHS.
   * Non-Terminal Node
   * Assigns AST_StatArrayElemLHS node to parent AST Node (AST_StatAssign)
   *
   * @param ctx
   */
  @Override
  public Void visitARRAY_ELEM_LHS(WaccParser.ARRAY_ELEM_LHSContext ctx) {

    //Create the node for the current visitor function
    AST_StatArrayElemLHS statArrayElemLHSNode = new AST_StatArrayElemLHS(ctx.getChildCount());

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("ast_statAssignLHS", statArrayElemLHSNode);

    //Set syntactic value of member variable
    statArrayElemLHSNode.setSyntacticAttributes(ctx.IDENT().getText());

    //Set parentNode of AST class and global visitor class
    statArrayElemLHSNode.setParentNode(parentVisitorNode);
    parentVisitorNode = statArrayElemLHSNode;

    //Debug statement
    System.out.println("statArrayElemLHS");

    //Iterate through rest of the tree
    visitChildren(ctx);
    return null;
  }

  /**
   * Visitor function for PAIR_ELEM_LHS.
   * Non-Terminal Node
   * Assigns AST_StatPairElemLHS node to parent AST Node (AST_StatAssign)
   *
   * @param ctx
   */
  @Override
  public Void visitPAIR_ELEM_LHS(WaccParser.PAIR_ELEM_LHSContext ctx) {

    //Create the node for the current visitor function
    AST_StatPairElemLHS statPairElemLHSNode = new AST_StatPairElemLHS(ctx, currentGlobalTree);

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("ast_statAssignLHS", statPairElemLHSNode);

    //Set parentNode of AST class and global visitor class
    statPairElemLHSNode.setParentNode(parentVisitorNode);
    parentVisitorNode = statPairElemLHSNode;

    //Debug statement
    System.out.println("statPairElemLHS");

    //Iterate through rest of the tree
    visitChildren(ctx);
    return null;
  }

  /**
   * Visitor function for PAIR_ELEM_RHS.
   * Non-Terminal Node
   * Assigns AST_StatPairElemRHS node to parent AST Node (AST_StatVarDecl and AST_StatAssign)
   *
   * @param ctx
   */
  @Override
  public Void visitPAIR_ELEM_RHS(WaccParser.PAIR_ELEM_RHSContext ctx) {

    //Create the node for the current visitor function
    AST_StatPairElemRHS statPairElemRHSNode = new AST_StatPairElemRHS(ctx, currentGlobalTree);

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("statAssignRHS", statPairElemRHSNode);

    //Set parentNode of AST class and global visitor class
    statPairElemRHSNode.setParentNode(parentVisitorNode);
    parentVisitorNode = statPairElemRHSNode;

    //Debug statement
    System.out.println("statPairElemRHS");

    //Iterate through rest of the tree
    visitChildren(ctx);
    return null;
  }

  /**
   * Visitor function for CHAR_LITER_EXPR.
   * Terminal Node
   * Assigns AST_ExprLiter node to parent AST Node (AST_Expr)
   *
   * @param ctx
   */
  @Override
  public Void visitCHAR_LITER_EXPR(WaccParser.CHAR_LITER_EXPRContext ctx) {

    //Create the node for the current visitor function
    AST_ExprLiter exprLiterNode = new AST_ExprLiter(ctx);

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("expr", exprLiterNode);

    //Set Embedded Syntactic value in AST Node class
    //Have to assign Constant first then literal
    exprLiterNode.setSyntacticAttributes(ctx.CHAR_LITER().getText());
    exprLiterNode.setSyntacticAttributes("char");

    //Set parentNode of AST class and global visitor class
    exprLiterNode.setParentNode(parentVisitorNode);
    parentVisitorNode = exprLiterNode;

    //Debug statement
    System.out.println("exprCharLiter");

    //Set the parent node for terminal node
    while (parentVisitorNode.isEmbeddedNodesFull()) {
      if (parentVisitorNode.getClass().getSimpleName().equals("AST_Program")) {
        System.out.println("End of visitor function");
        break;
      }
      parentVisitorNode = parentVisitorNode.getParentNode();
    }

    visitChildren(ctx);

    return null;
  }

  /**
   * Visitor function for UNARY_OP_EXPR.
   * Non-Terminal Node
   * Assigns AST_ExprUnary node to parent AST Node (AST_Expr)
   *
   * @param ctx
   */
  @Override
  public Void visitUNARY_OP_EXPR(WaccParser.UNARY_OP_EXPRContext ctx) {

    //Create the node for the current visitor function
    AST_ExprUnary exprUnaryNode = new AST_ExprUnary(ctx, currentGlobalTree);

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("expr", exprUnaryNode);

    //Set syntactic member variable in AST
    exprUnaryNode.setSyntacticAttributes(ctx.unaryOp().getText());

    //Set parentNode of AST class and global visitor class
    exprUnaryNode.setParentNode(parentVisitorNode);
    parentVisitorNode = exprUnaryNode;

    //Debug statement
    System.out.println("exprUnary");

    //Iterate through rest of the tree
    visitChildren(ctx);
    return null;
  }

  /**
   * Visitor function for SKIP_STAT.
   * Terminal Node
   * Assigns AST_Stat node to parent AST Node (AST_FuncDecl and AST_Program)
   *
   * @param ctx
   */
  @Override
  public Void visitSKIP_STAT(WaccParser.SKIP_STATContext ctx) {

    //Create the node for the current visitor function
    AST_Stat skipNode = new AST_Stat();

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("statement", skipNode);

    //Set syntactic value of member variable
    skipNode.setSyntacticAttributes("skip");

    //Set parentNode of AST class and global visitor class
    skipNode.setParentNode(parentVisitorNode);
    parentVisitorNode = skipNode;

    //Debug statement
    System.out.println("Skip");

    //Set the parent node for terminal node
    while (parentVisitorNode.isEmbeddedNodesFull()) {
      if (parentVisitorNode.getClass().getSimpleName().equals("AST_Program")) {
        System.out.println("End of visitor function");
        break;
      }
      parentVisitorNode = parentVisitorNode.getParentNode();
    }

    //Iterate through rest of the tree
    visitChildren(ctx);
    return null;
  }

  /**
   * Visitor function for READ_STAT.
   * Non-Terminal Node
   * Assigns AST_StatRead node to parent AST Node (AST_Stat)
   *
   * @param ctx
   */
  @Override
  public Void visitREAD_STAT(WaccParser.READ_STATContext ctx) {

    //Create the node for the current visitor function
    AST_StatRead statReadNode = new AST_StatRead(ctx, currentGlobalTree);

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("statement", statReadNode);

    //Set parentNode of AST class and global visitor class
    statReadNode.setParentNode(parentVisitorNode);
    parentVisitorNode = statReadNode;

    //Debug statement
    System.out.println("statRead");

    //Iterate through rest of the tree
    visitChildren(ctx);
    return null;
  }

  /**
   * Visitor function for WHILE_STAT.
   * Non-Terminal Node
   * Assigns AST_StatWhile node to parent AST Node (AST_Stat)
   *
   * @param ctx
   */
  @Override
  public Void visitWHILE_STAT(WaccParser.WHILE_STATContext ctx) {

    //Create the node for the current visitor function

    AST_StatWhile statWhileNode = new AST_StatWhile(currentGlobalTree);

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("statement", statWhileNode);

    //Set parentNode of AST class and global visitor class
    statWhileNode.setParentNode(parentVisitorNode);
    parentVisitorNode = statWhileNode;
    currentGlobalTree = statWhileNode.symbolTable;

    //Debug statement
    System.out.println("statWhile");

    //Iterate through rest of the tree
    visitChildren(ctx);
    currentGlobalTree = statWhileNode.symbolTable.encSymTable;
    return null;
  }

  /**
   * Visitor function for NEWPAIR_RHS.
   * Non-Terminal Node
   * Assigns AST_StatNewPairRHS node to parent AST Node (AST_StatVarDecl and AST_StatAssign)
   *
   * @param ctx
   */
  @Override
  public Void visitNEWPAIR_RHS(WaccParser.NEWPAIR_RHSContext ctx) {

    //Create the node for the current visitor function
    AST_StatNewPairRHS statNewPairRHSNode = new AST_StatNewPairRHS();

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("statAssignRHS", statNewPairRHSNode);

    //Set parentNode of AST class and global visitor class
    statNewPairRHSNode.setParentNode(parentVisitorNode);
    parentVisitorNode = statNewPairRHSNode;

    //Debug statement
    System.out.println("statNewPairRHS");

    //Iterate through rest of the tree
    visitChildren(ctx);
    return null;
  }

  /**
   * Visitor function for IDENT_EXPR.
   * Terminal Node
   * Assigns AST_ExprIdent node to parent AST Node (AST_Expr)
   *
   * @param ctx
   */
  @Override
  public Void visitIDENT_EXPR(WaccParser.IDENT_EXPRContext ctx) {

    //Create the node for the current visitor function
    AST_ExprIdent exprIdentNode = new AST_ExprIdent(ctx, currentGlobalTree);

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("expr", exprIdentNode);

    //Set the syntactic value of the AST Class
    exprIdentNode.setSyntacticAttributes(ctx.IDENT().getText());

    //Set parentNode of AST class and global visitor class
    exprIdentNode.setParentNode(parentVisitorNode);
    parentVisitorNode = exprIdentNode;

    //Debug statement
    System.out.println("exprIdent");

    //Set the parent node for terminal node
    while (parentVisitorNode.isEmbeddedNodesFull()) {
      if (parentVisitorNode.getClass().getSimpleName().equals("AST_Program")) {
        System.out.println("End of visitor function");
        break;
      }
      parentVisitorNode = parentVisitorNode.getParentNode();
    }

    //Iterate through rest of the tree
    visitChildren(ctx);
    return null;
  }

  /**
   * Visitor function for ARRAY_ELEM_EXPR.
   * Non-Terminal Node
   * Assigns AST_ExprArrayElem node to parent AST Node (AST_Expr)
   *
   * @param ctx
   */
  @Override
  public Void visitARRAY_ELEM_EXPR(WaccParser.ARRAY_ELEM_EXPRContext ctx) {

    //Create the node for the current visitor function
    AST_ExprArrayElem exprArrayElemNode = new AST_ExprArrayElem(ctx.getChildCount(), currentGlobalTree);

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("expr", exprArrayElemNode);

    //Set syntactic member variable in AST

    exprArrayElemNode.setSyntacticAttributes(ctx.IDENT().getText());

    //Set parentNode of AST class and global visitor class
    exprArrayElemNode.setParentNode(parentVisitorNode);
    parentVisitorNode = exprArrayElemNode;

    //Debug statement
    System.out.println("exprArrayElem");

    //Iterate through rest of the tree
    visitChildren(ctx);
    return null;
  }

  /**
   * Visitor function for ENCLOSED_EXPR.
   * Non-Terminal Node
   * Assigns AST_ExprEnclosed node to parent AST Node (AST_Expr)
   *
   * @param ctx
   */
  @Override
  public Void visitENCLOSED_EXPR(WaccParser.ENCLOSED_EXPRContext ctx) {

    //Create the node for the current visitor function
    AST_ExprEnclosed exprEnclosedNode = new AST_ExprEnclosed();

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("expr", exprEnclosedNode);

    //Set parentNode of AST class and global visitor class
    exprEnclosedNode.setParentNode(parentVisitorNode);
    parentVisitorNode = exprEnclosedNode;

    //Debug statement
    System.out.println("exprEnclosed");

    //Iterate through rest of the tree
    visitChildren(ctx);
    return null;
  }

  /**
   * Visitor function for PRINT_STAT.
   * Non-Terminal Node
   * Assigns AST_StatExpr node to parent AST Node (AST_Stat)
   *
   * @param ctx
   */
  @Override
  public Void visitPRINT_STAT(WaccParser.PRINT_STATContext ctx) {

    //Create the node for the current visitor function
    AST_StatExpr printNode = new AST_StatExpr(ctx, currentGlobalTree);

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("statement", printNode);

    //Set syntactic value of member variable
    printNode.setSyntacticAttributes("print");

    //Set parentNode of AST class and global visitor class
    printNode.setParentNode(parentVisitorNode);
    parentVisitorNode = printNode;

    //Debug statement
    System.out.println("statExprNode");

    //Iterate through rest of the tree
    visitChildren(ctx);
    return null;
  }

  /**
   * Visitor function for ASSIGN_STAT.
   * Non-Terminal Node
   * Assigns AST_StatAssign node to parent AST Node (AST_Stat)
   *
   * @param ctx
   */
  @Override
  public Void visitASSIGN_STAT(WaccParser.ASSIGN_STATContext ctx) {

    //Create the node for the current visitor function
    AST_StatAssign statAssignNode = new AST_StatAssign(ctx, currentGlobalTree);

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("statement", statAssignNode);

    //Set parentNode of AST class and global visitor class
    statAssignNode.setParentNode(parentVisitorNode);
    parentVisitorNode = statAssignNode;

    //Debug statement
    System.out.println("statAssign");

    //Iterate through rest of the tree
    visitChildren(ctx);
    return null;
  }

  /**
   * Visitor function for IDENT_ASSIGN.
   * Terminal Node
   * Assigns AST_StatIdentLHS node to parent AST Node (AST_StatAssign)
   *
   * @param ctx
   */
  @Override
  public Void visitIDENT_ASSIGN(WaccParser.IDENT_ASSIGNContext ctx) {

    //Create the node for the current visitor function
    AST_StatIdentLHS statIdentLHSNode = new AST_StatIdentLHS();

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("ast_statAssignLHS", statIdentLHSNode);

    //Set the syntactic value of the AST Class
    statIdentLHSNode.setSyntacticAttributes(ctx.IDENT().getText(), currentGlobalTree);

    //Set parentNode of AST class and global visitor class
    statIdentLHSNode.setParentNode(parentVisitorNode);
    parentVisitorNode = statIdentLHSNode;

    //Debug statement
    System.out.println("statIdentLHS");

    //Set the parent node for terminal node
    while (parentVisitorNode.isEmbeddedNodesFull()) {
      if (parentVisitorNode.getClass().getSimpleName().equals("AST_Program")) {
        System.out.println("End of visitor function");
        break;
      }
      parentVisitorNode = parentVisitorNode.getParentNode();
    }

    //Iterate through rest of the tree
    visitChildren(ctx);
    return null;
  }

  /**
   * Visitor function for INT_LITER_EXPR.
   * Terminal Node
   * Assigns AST_ExprLiter node to parent AST Node (AST_Expr)
   *
   * @param ctx
   */
  @Override
  public Void visitINT_LITER_EXPR(WaccParser.INT_LITER_EXPRContext ctx) {

    //Create the node for the current visitor function
    AST_ExprLiter exprLiterNode = new AST_ExprLiter(ctx);

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("expr", exprLiterNode);

    //Set Embedded Syntactic value in AST Node class
    //Have to assign Constant first then literal
    exprLiterNode.setSyntacticAttributes(ctx.INT_LITER().getText());
    exprLiterNode.setSyntacticAttributes("int");

    //Set parentNode of AST class and global visitor class
    exprLiterNode.setParentNode(parentVisitorNode);
    parentVisitorNode = exprLiterNode;

    //Debug statement
    System.out.println("exprIntLiter");

    //Set the parent node for terminal node
    while (parentVisitorNode.isEmbeddedNodesFull()) {
      if (parentVisitorNode.getClass().getSimpleName().equals("AST_Program")) {
        System.out.println("End of visitor function");
        break;
      }
      parentVisitorNode = parentVisitorNode.getParentNode();
    }

    //Iterate through rest of the tree
    visitChildren(ctx);
    return null;
  }

  /**
   * Visitor function for VAR_DECL_STAT.
   * Non-Terminal Node
   * Assigns AST_StatVarDecl node to parent AST Node (AST_Stat)
   *
   * @param ctx
   */
  @Override
  public Void visitVAR_DECL_STAT(WaccParser.VAR_DECL_STATContext ctx) {

    //Create the node for the current visitor function
    AST_StatVarDecl statVarDeclNode = new AST_StatVarDecl(ctx, currentGlobalTree);

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("statement", statVarDeclNode);

    //Set the syntactic value of the AST Class
    statVarDeclNode.setSyntacticAttributes(ctx.IDENT().getText());

    //Set parentNode of AST class and global visitor class
    statVarDeclNode.setParentNode(parentVisitorNode);
    parentVisitorNode = statVarDeclNode;

    SymbolTable tempST = currentGlobalTree;
    String identName = statVarDeclNode.getIdentName();
    IDENTIFIER type = tempST.lookup(identName);

    while (type == null) {
      tempST = tempST.encSymTable;
      try {
        type = tempST.lookup(identName);
      } catch (NullPointerException e) {
        System.out.println("NullPointerException caught");
        type = null;
        break;
      }
    }

    //find its type, if type differ from that it's fine

    System.out.println(identName);
    IDENTIFIER value = currentGlobalTree.encSymTable.getSymMap().get(identName);

    System.out.println(value);

    /*if (type != null) {
      if (!type.toString().contains("FUNCTION")) {
        new VariableRedeclarationError(new FilePosition(ctx)).printAll();
      }



    }*/

    //Debug statement
    System.out.println("statVarDecl");

    //Iterate through rest of the tree
    visitChildren(ctx);
    statVarDeclNode.Assign(currentGlobalTree);
    return null;
  }

  /**
   * Visitor function for FREE_STAT.
   * Non-Terminal Node
   * Assigns AST_StatExpr node to parent AST Node (AST_Stat)
   *
   * @param ctx
   */
  @Override
  public Void visitFREE_STAT(WaccParser.FREE_STATContext ctx) {

    //Create the node for the current visitor function
    AST_StatExpr statExprNode = new AST_StatExpr(ctx, currentGlobalTree);

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("statement", statExprNode);

    //Set syntactic value of member variable
    statExprNode.setSyntacticAttributes("free");

    //Set parentNode of AST class and global visitor class
    statExprNode.setParentNode(parentVisitorNode);
    parentVisitorNode = statExprNode;

    //Debug statement
    System.out.println("statExpr");

    //Iterate through rest of the tree
    visitChildren(ctx);
    return null;
  }

  /**
   * Visitor function for BEGIN_END_STAT.
   * Non-Terminal Node
   * Assigns AST_StatBeginEnd node to parent AST Node (AST_Stat)
   *
   * @param ctx
   */
  @Override
  public Void visitBEGIN_END_STAT(WaccParser.BEGIN_END_STATContext ctx) {

    //Create the node for the current visitor function
    AST_StatBeginEnd statBeginEndNode = new AST_StatBeginEnd(currentGlobalTree);

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("statement", statBeginEndNode);

    //Set parentNode of AST class and global visitor class
    statBeginEndNode.setParentNode(parentVisitorNode);
    parentVisitorNode = statBeginEndNode;
    currentGlobalTree = statBeginEndNode.symbolTable;

    //Debug statement
    System.out.println("statBeginEnd");

    //Iterate through rest of the tree
    visitChildren(ctx);
    currentGlobalTree = statBeginEndNode.symbolTable.encSymTable;
    return null;
  }

  /**
   * Visitor function for IF_STAT.
   * Non-Terminal Node
   * Assigns AST_StatIf node to parent AST Node (AST_Stat)
   *
   * @param ctx
   */
  @Override
  public Void visitIF_STAT(WaccParser.IF_STATContext ctx) {

    //Create the node for the current visitor function
    AST_StatIf statIfNode = new AST_StatIf(ctx, currentGlobalTree);

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("statement", statIfNode);

    //Set parentNode of AST class and global visitor class
    statIfNode.setParentNode(parentVisitorNode);
    parentVisitorNode = statIfNode;

    //Debug statement
    System.out.println("statIf");

    //Iterate through rest of the tree
    visitChildren(ctx);

    //Do semantic analysis
    statIfNode.Check(currentGlobalTree);
    return null;
  }

  @Override
  public Void visitThenstat(WaccParser.ThenstatContext ctx) {
    //Create the node for the current visitor function
    AST_StatIfThen statIfThenNode = new AST_StatIfThen(currentGlobalTree);

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("statement", statIfThenNode);

    //Set parentNode of AST class and global visitor class
    statIfThenNode.setParentNode(parentVisitorNode);
    parentVisitorNode = statIfThenNode;
    currentGlobalTree = statIfThenNode.symbolTable;

    //Debug statement
    System.out.println("statThenIf");

    //Iterate through rest of the tree
    visitChildren(ctx);
    currentGlobalTree = statIfThenNode.symbolTable.encSymTable;
    return null;
  }

  @Override
  public Void visitElsestat(WaccParser.ElsestatContext ctx) {
    //Create the node for the current visitor function
    AST_StatIfElse statIfElseNode = new AST_StatIfElse(currentGlobalTree);

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("statement", statIfElseNode);

    //Set parentNode of AST class and global visitor class
    statIfElseNode.setParentNode(parentVisitorNode);
    parentVisitorNode = statIfElseNode;
    currentGlobalTree = statIfElseNode.symbolTable;

    //Debug statement
    System.out.println("statElseIf");

    //Iterate through rest of the tree
    visitChildren(ctx);
    currentGlobalTree = statIfElseNode.symbolTable.encSymTable;
    return null;
  }


  /**
   * Visitor function for CALL_ASSIGN.
   * Terminal Node
   * Assigns AST_StatCallRHS node to parent AST Node (AST_StatVarDecl and AST_StatAssign)
   *
   * @param ctx
   */
  @Override
  public Void visitCALL_ASSIGN(WaccParser.CALL_ASSIGNContext ctx) {

    //Create the node for the current visitor function
    AST_StatCallRHS statCallRHSNode = new AST_StatCallRHS(ctx.getChildCount(), ctx, currentGlobalTree);

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("statAssignRHS", statCallRHSNode);

    //Set the syntactic value of the AST Class
    statCallRHSNode.setSyntacticAttributes(ctx.IDENT().getText(), currentGlobalTree);

    //Set parentNode of AST class and global visitor class
    statCallRHSNode.setParentNode(parentVisitorNode);
    parentVisitorNode = statCallRHSNode;

    //Debug statement
    System.out.println("statCallRHS");

    //If there are no expression, treat this visitor function as a terminal node
    if (ctx.expr().size() == 0) {
      //Set the parent node for terminal node
      while (parentVisitorNode.isEmbeddedNodesFull()) {
        if (parentVisitorNode.getClass().getSimpleName().equals("AST_Program")) {
          break;
        }
        parentVisitorNode = parentVisitorNode.getParentNode();
      }
    }

    //Iterate through rest of the tree
    visitChildren(ctx);
    return null;
  }

  /**
   * Visitor function for BINARY_OP_EXPR.
   * Non-Terminal Node
   * Assigns AST_ExprBinary node to parent AST Node (AST_Expr)
   *
   * @param ctx
   */
  @Override
  public Void visitBINARY_OP_EXPR(WaccParser.BINARY_OP_EXPRContext ctx) {

    //Create the node for the current visitor function
    AST_ExprBinary exprBinaryNode = new AST_ExprBinary(ctx, currentGlobalTree);

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("expr", exprBinaryNode);

    //Set syntactic member variable in AST
    exprBinaryNode.setSyntacticAttributes(ctx.binaryOp().getText());

    //Set parentNode of AST class and global visitor class
    exprBinaryNode.setParentNode(parentVisitorNode);
    parentVisitorNode = exprBinaryNode;

    //Debug statement
    System.out.println("exprBinary");

    //Iterate through rest of the tree
    visitChildren(ctx);
    return null;
  }

  /**
   * Visitor function for MULT_STAT.
   * Non-Terminal Node
   * Assigns AST_StatMult node to parent AST Node (AST_Stat)
   *
   * @param ctx
   */
  @Override
  public Void visitMULT_STAT(WaccParser.MULT_STATContext ctx) {

    //Create the node for the current visitor function
    AST_StatMult statMultNode = new AST_StatMult();

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("statement", statMultNode);

    //Set parentNode of AST class and global visitor class
    statMultNode.setParentNode(parentVisitorNode);
    parentVisitorNode = statMultNode;

    //Debug statement
    System.out.println("statMult");

    //Iterate through rest of the tree
    visitChildren(ctx);
    return null;
  }

  /**
   * Visitor function for STR_LITER_EXPR.
   * Terminal Node
   * Assigns AST_ExprLiter node to parent AST Node (AST_Expr)
   *
   * @param ctx
   */
  @Override
  public Void visitSTR_LITER_EXPR(WaccParser.STR_LITER_EXPRContext ctx) {

    //Create the node for the current visitor function
    AST_ExprLiter str_literNode = new AST_ExprLiter(ctx);

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("expr", str_literNode);

    //Set Embedded Syntactic value in AST Node class
    //Have to assign Constant first then literal
    str_literNode.setSyntacticAttributes(ctx.STR_LITER().getText());
    str_literNode.setSyntacticAttributes("str");

    //Set parentNode of AST class and global visitor class
    str_literNode.setParentNode(parentVisitorNode);
    parentVisitorNode = str_literNode;

    //Debug statement
    System.out.println("str_liter");

    //Set the parent node for terminal node
    while (parentVisitorNode.isEmbeddedNodesFull()) {
      if (parentVisitorNode.getClass().getSimpleName().equals("AST_Program")) {
        System.out.println("End of visitor function");
        break;
      }
      parentVisitorNode = parentVisitorNode.getParentNode();
    }

    //Iterate through rest of the tree
    visitChildren(ctx);
    return null;
  }

  /**
   * Visitor function for ARRAY_LITER_RHS.
   * Non-Terminal Node
   * Assigns AST_StatArrayLitRHS node to parent AST Node (AST_StatVarDecl and AST_StatAssign)
   *
   * @param ctx
   */
  @Override
  public Void visitARRAY_LITER_RHS(WaccParser.ARRAY_LITER_RHSContext ctx) {

    //Create the node for the current visitor function
    AST_StatArrayLitRHS statArrayLitRHSNode = new AST_StatArrayLitRHS(ctx.getChildCount(), ctx);

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("statAssignRHS", statArrayLitRHSNode);

    //Set parentNode of AST class and global visitor class
    statArrayLitRHSNode.setParentNode(parentVisitorNode);
    parentVisitorNode = statArrayLitRHSNode;

    //Debug statement
    System.out.println("statArrayLitRHS");

    //Iterate through rest of the tree
    visitChildren(ctx);
    return null;
  }

  /**
   * Visitor function for EXIT_STAT.
   * Non-Terminal Node
   * Assigns AST_StatExpr node to parent AST Node (AST_Stat)
   *
   * @param ctx
   */
  @Override
  public Void visitEXIT_STAT(WaccParser.EXIT_STATContext ctx) {

    //Create the node for the current visitor function
    AST_StatExpr exitNode = new AST_StatExpr(ctx, currentGlobalTree);

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("statement", exitNode);

    //Set syntactic value of member variable
    exitNode.setSyntacticAttributes("exit");

    //Set parentNode of AST class and global visitor class
    exitNode.setParentNode(parentVisitorNode);
    parentVisitorNode = exitNode;

    //Debug statement
    System.out.println("exit");

    //Iterate through rest of the tree
    visitChildren(ctx);
    return null;
  }

  /**
   * Visitor function for BOOL_LITER_EXPR.
   * Terminal Node
   * Assigns AST_ExprLiter node to parent AST Node (AST_Expr)
   *
   * @param ctx
   */
  @Override
  public Void visitBOOL_LITER_EXPR(WaccParser.BOOL_LITER_EXPRContext ctx) {

    //Create the node for the current visitor function
    AST_ExprLiter boolLiterNode = new AST_ExprLiter(ctx);

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("expr", boolLiterNode);

    //Set Embedded Syntactic value in AST Node class
    //Have to assign Constant first then literal
    boolLiterNode.setSyntacticAttributes(ctx.BOOL_LITER().getText());
    boolLiterNode.setSyntacticAttributes("bool");

    //Set parentNode of AST class and global visitor class
    boolLiterNode.setParentNode(parentVisitorNode);
    parentVisitorNode = boolLiterNode;

    //Debug statement
    System.out.println("boolLiter");

    //Set the parent node for terminal node
    while (parentVisitorNode.isEmbeddedNodesFull()) {
      if (parentVisitorNode.getClass().getSimpleName().equals("AST_Program")) {
        System.out.println("End of visitor function");
        break;
      }
      parentVisitorNode = parentVisitorNode.getParentNode();
    }

    //Iterate through rest of the tree
    visitChildren(ctx);
    return null;
  }

  /**
   * Visitor function for PAIR_LITER_EXPR.
   * Terminal Node
   * Assigns AST_ExprLiter node to parent AST Node (AST_Expr)
   *
   * @param ctx
   */
  @Override
  public Void visitPAIR_LITER_EXPR(WaccParser.PAIR_LITER_EXPRContext ctx) {

    //Create the node for the current visitor function
    AST_ExprLiter pairLiterNode = new AST_ExprLiter(ctx);

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("expr", pairLiterNode);

    //Set Embedded Syntactic value in AST Node class
    //Have to assign Constant first then literal
    pairLiterNode.setSyntacticAttributes(ctx.PAIR_LITER().getText());
    pairLiterNode.setSyntacticAttributes("pair");

    //Set parentNode of AST class and global visitor class
    pairLiterNode.setParentNode(parentVisitorNode);
    parentVisitorNode = pairLiterNode;

    //Debug statement
    System.out.println("pairLiter");

    //Set the parent node for terminal node
    while (parentVisitorNode.isEmbeddedNodesFull()) {
      if (parentVisitorNode.getClass().getSimpleName().equals("AST_Program")) {
        System.out.println("End of visitor function");
        break;
      }
      parentVisitorNode = parentVisitorNode.getParentNode();
    }

    //Iterate through rest of the tree
    visitChildren(ctx);
    return null;
  }

  /**
   * Visitor function for RETURN_STAT.
   * Non-Terminal Node
   * Assigns AST_StatExpr node to parent AST Node (AST_Stat)
   *
   * @param ctx
   */
  @Override
  public Void visitRETURN_STAT(WaccParser.RETURN_STATContext ctx) {

    //Create the node for the current visitor function
    AST_StatExpr returnStatNode = new AST_StatExpr(ctx, currentGlobalTree);

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("statement", returnStatNode);

    //Set syntactic value of member variable
    returnStatNode.setSyntacticAttributes("return");

    //Set parentNode of AST class and global visitor class
    returnStatNode.setParentNode(parentVisitorNode);
    parentVisitorNode = returnStatNode;

    AST_Node tempNode = parentVisitorNode;
    System.out.println(tempNode.getClass().getSimpleName());

    //Debug statement
    System.out.println("returnStat");

    //Syntatic check
    if (!returnStatNode.getParentNode().isEmbeddedNodesFull()) {
      //throw syntatic error
      System.out.println("Errors detected during compilation! Exit code 200 returned.");
      System.out.println("#semantic_error#");
      System.exit(200);
    }

    //Iterate through rest of the tree
    visitChildren(ctx);
    return null;
  }

  /**
   * Visitor function for BASE_TYPE.
   * Terminal Node
   * Assigns AST_BaseType node to parent AST Node (AST_Type)
   *
   * @param ctx
   */
  @Override
  public Void visitBASE_TYPE(WaccParser.BASE_TYPEContext ctx) {

    //Create the node for the current visitor function
    AST_BaseType baseTypeNode = new AST_BaseType();

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("ast_type", baseTypeNode);

    //Set base type syntactic value
    baseTypeNode.setSyntacticAttributes(ctx.getText());

    //Set parentNode of AST class and global visitor class
    baseTypeNode.setParentNode(parentVisitorNode);
    parentVisitorNode = baseTypeNode;

    //Debug statement
    System.out.println("baseType");

    //Set the parent node for terminal node
    while (parentVisitorNode.isEmbeddedNodesFull()) {
      if (parentVisitorNode.getClass().getSimpleName().equals("AST_Program")) {
        System.out.println("End of visitor function");
        break;
      }
      parentVisitorNode = parentVisitorNode.getParentNode();
    }

    //Iterate through rest of the tree
    visitChildren(ctx);
    return null;
  }

  /**
   * Visitor function for ARRAY_TYPE.
   * Non-Terminal Node
   * Assigns AST_ArrayType node to parent AST Node (AST_Type)
   *
   * @param ctx
   */
  @Override
  public Void visitARRAY_TYPE(WaccParser.ARRAY_TYPEContext ctx) {

    //Create the node for the current visitor function
    AST_ArrayType arrayTypeNode = new AST_ArrayType();

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("ast_type", arrayTypeNode);

    //Set parentNode of AST class and global visitor class
    arrayTypeNode.setParentNode(parentVisitorNode);
    parentVisitorNode = arrayTypeNode;

    //Debug statement
    System.out.println("arrayType");

    //Iterate through rest of the tree
    visitChildren(ctx);
    return null;
  }

  /**
   * Visitor function for PAIR_TYPE.
   * Non-Terminal Node
   * Assigns AST_PairType node to parent AST Node (AST_Type)
   *
   * @param ctx
   */
  @Override
  public Void visitPAIR_TYPE(WaccParser.PAIR_TYPEContext ctx) {

    //Create the node for the current visitor function
    AST_PairType pairTypeNode = new AST_PairType();

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("ast_type", pairTypeNode);

    //Set parentNode of AST class and global visitor class
    pairTypeNode.setParentNode(parentVisitorNode);
    parentVisitorNode = pairTypeNode;

    //Debug statement
    System.out.println("pairType");

    //Iterate through rest of the tree
    visitChildren(ctx);
    return null;
  }

  /**
   * Visitor function for BASE_TYPE_PAIR.
   * Terminal Node
   * Assigns AST_BaseTypePair node to parent AST Node (AST_PairElemType and AST_PairType)
   *
   * @param ctx
   */
  @Override
  public Void visitBASE_TYPE_PAIR(WaccParser.BASE_TYPE_PAIRContext ctx) {

    //Create the node for the current visitor function
    AST_BaseTypePair baseTypePairNode = new AST_BaseTypePair();

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("pairElemType", baseTypePairNode);

    //Set base type syntactic value
    baseTypePairNode.setSyntacticAttributes(ctx.getText());

    //Set parentNode of AST class and global visitor class
    baseTypePairNode.setParentNode(parentVisitorNode);
    parentVisitorNode = baseTypePairNode;

    //Debug statement
    System.out.println("baseTypePair");

    //Set the parent node for terminal node
    while (parentVisitorNode.isEmbeddedNodesFull()) {
      if (parentVisitorNode.getClass().getSimpleName().equals("AST_Program")) {
        System.out.println("End of visitor function");
        break;
      }
      parentVisitorNode = parentVisitorNode.getParentNode();
    }

    //Iterate through rest of the tree
    visitChildren(ctx);
    return null;
  }

  /**
   * Visitor function for ARRAY_TYPE_PAIR.
   * Non-Terminal Node
   * Assigns AST_ArrayTypePair node to parent AST Node (AST_PairElemType and AST_PairType)
   *
   * @param ctx
   */
  @Override
  public Void visitARRAY_TYPE_PAIR(WaccParser.ARRAY_TYPE_PAIRContext ctx) {

    //Create the node for the current visitor function
    AST_ArrayTypePair arrayTypePairNode = new AST_ArrayTypePair();

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("pairElemType", arrayTypePairNode);

    //Set parentNode of AST class and global visitor class
    arrayTypePairNode.setParentNode(parentVisitorNode);
    parentVisitorNode = arrayTypePairNode;

    //Debug statement
    System.out.println("arrayTypePair");

    //Iterate through rest of the tree
    visitChildren(ctx);
    return null;
  }

  /**
   * Visitor function for PAIR_STRING.
   * Terminal Node
   * Assigns AST_PairString node to parent AST Node (AST_PairElemType and AST_PairType)
   *
   * @param ctx
   */
  @Override
  public Void visitPAIR_STRING(WaccParser.PAIR_STRINGContext ctx) {

    //Create the node for the current visitor function
    AST_PairString pairStringNode = new AST_PairString();

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("pairElemType", pairStringNode);

    //Set base type syntactic value
    pairStringNode.setSyntacticAttributes(ctx.getText());

    //Set parentNode of AST class and global visitor class
    pairStringNode.setParentNode(parentVisitorNode);
    parentVisitorNode = pairStringNode;

    //Debug statement
    System.out.println("pairString");

    //Set the parent node for terminal node
    while (parentVisitorNode.isEmbeddedNodesFull()) {
      if (parentVisitorNode.getClass().getSimpleName().equals("AST_Program")) {
        System.out.println("End of visitor function");
        break;
      }
      parentVisitorNode = parentVisitorNode.getParentNode();
    }

    //Iterate through rest of the tree
    visitChildren(ctx);
    return null;
  }

  /**
   * Visitor function for PAIR_FST.
   * Non-Terminal Node
   *
   * @param ctx
   */
  @Override
  public Void visitPAIR_FST(WaccParser.PAIR_FSTContext ctx) {

    //Set Embedded Syntactic value in AST Node class
    parentVisitorNode.setSyntacticAttributes(ctx.FST().getText());

    //Debug statement
    System.out.println("pairFst");

    //Iterate through rest of the tree
    return visitChildren(ctx);
  }

  /**
   * Visitor function for PAIR_SND.
   * Non-Terminal Node
   *
   * @param ctx
   */
  @Override
  public Void visitPAIR_SND(WaccParser.PAIR_SNDContext ctx) {

    //Set Embedded Syntactic value in AST Node class
    parentVisitorNode.setSyntacticAttributes(ctx.SND().getText());

    //Debug statement
    System.out.println("pairSnd");

    //Iterate through rest of the tree
    return visitChildren(ctx);
  }

  @Override
  public Void visitIDENT_PLUS_PLUS(WaccParser.IDENT_PLUS_PLUSContext ctx) {
    return visitChildren(ctx);
  }

  @Override
  public Void visitPLUS_PLUS_IDENT(WaccParser.PLUS_PLUS_IDENTContext ctx) {

    AST_SideEffectPreInc sideEffectPreInc = new AST_SideEffectPreInc();

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("sideEffect", sideEffectPreInc);

    //Set syntactic member variable in AST
    sideEffectPreInc.setSyntacticAttributes("++X");
    sideEffectPreInc.setSyntacticAttributes(ctx.IDENT().getText());

    //Set parentNode of AST class and global visitor class
    sideEffectPreInc.setParentNode(parentVisitorNode);
    parentVisitorNode = sideEffectPreInc;

    //Debug statement
    System.out.println("plusPlusExpr");

    //Set the parent node for terminal node
    while (parentVisitorNode.isEmbeddedNodesFull()) {
      if (parentVisitorNode.getClass().getSimpleName().equals("AST_Program")) {
        System.out.println("End of visitor function");
        break;
      }
      parentVisitorNode = parentVisitorNode.getParentNode();
    }


    //Iterate through rest of the tree
    visitChildren(ctx);
    return null;

  }

  @Override
  public Void visitMINUS_MINUS_IDENT(WaccParser.MINUS_MINUS_IDENTContext ctx) {
    AST_SideEffectPreInc sideEffectPreInc = new AST_SideEffectPreInc();

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("sideEffect", sideEffectPreInc);

    //Set syntactic member variable in AST
    sideEffectPreInc.setSyntacticAttributes("--X");
    sideEffectPreInc.setSyntacticAttributes(ctx.IDENT().getText());

    //Set parentNode of AST class and global visitor class
    sideEffectPreInc.setParentNode(parentVisitorNode);
    parentVisitorNode = sideEffectPreInc;

    //Debug statement
    System.out.println("minusMinusExpr");

    //Set the parent node for terminal node
    while (parentVisitorNode.isEmbeddedNodesFull()) {
      if (parentVisitorNode.getClass().getSimpleName().equals("AST_Program")) {
        System.out.println("End of visitor function");
        break;
      }
      parentVisitorNode = parentVisitorNode.getParentNode();
    }


    //Iterate through rest of the tree
    visitChildren(ctx);
    return null;
  }

  @Override
  public Void visitIDENT_MINUS_MINUS(WaccParser.IDENT_MINUS_MINUSContext ctx) {
    return visitChildren(ctx);
  }

  @Override
  public Void visitIDENT_PLUS_EQUALS(WaccParser.IDENT_PLUS_EQUALSContext ctx) {
    AST_SideEffectBinary sideEffectBinary = new AST_SideEffectBinary();

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("sideEffect", sideEffectBinary);

    //Set syntactic member variable in AST
    sideEffectBinary.setSyntacticAttributes("+=");
    sideEffectBinary.setSyntacticAttributes(ctx.IDENT().getText());

    //Set parentNode of AST class and global visitor class
    sideEffectBinary.setParentNode(parentVisitorNode);
    parentVisitorNode = sideEffectBinary;

    //Debug statement
    System.out.println("exprPlusEqual");

    //Iterate through rest of the tree
    visitChildren(ctx);
    return null;
  }

  @Override
  public Void visitIDENT_MINUS_EQUALS(WaccParser.IDENT_MINUS_EQUALSContext ctx) {
    AST_SideEffectBinary sideEffectBinary = new AST_SideEffectBinary();

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("sideEffect", sideEffectBinary);

    //Set syntactic member variable in AST
    sideEffectBinary.setSyntacticAttributes("-=");
    sideEffectBinary.setSyntacticAttributes(ctx.IDENT().getText());

    //Set parentNode of AST class and global visitor class
    sideEffectBinary.setParentNode(parentVisitorNode);
    parentVisitorNode = sideEffectBinary;

    //Debug statement
    System.out.println("exprMinusEqual");

    //Iterate through rest of the tree
    visitChildren(ctx);
    return null;
  }

  @Override
  public Void visitIDENT_EQUAL(WaccParser.IDENT_EQUALContext ctx) {
    AST_SideEffectBinary sideEffectBinary = new AST_SideEffectBinary();

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("sideEffect", sideEffectBinary);

    //Set syntactic member variable in AST
    sideEffectBinary.setSyntacticAttributes("=");
    sideEffectBinary.setSyntacticAttributes(ctx.IDENT().getText());

    //Set parentNode of AST class and global visitor class
    sideEffectBinary.setParentNode(parentVisitorNode);
    parentVisitorNode = sideEffectBinary;

    //Debug statement
    System.out.println("exprEqual");

    //Iterate through rest of the tree
    visitChildren(ctx);
    return null;
  }

  @Override
  public Void visitIDENT_MULT_EQUALS(WaccParser.IDENT_MULT_EQUALSContext ctx) {
    AST_SideEffectBinary sideEffectBinary = new AST_SideEffectBinary();

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("sideEffect", sideEffectBinary);

    //Set syntactic member variable in AST
    sideEffectBinary.setSyntacticAttributes("*=");
    sideEffectBinary.setSyntacticAttributes(ctx.IDENT().getText());

    //Set parentNode of AST class and global visitor class
    sideEffectBinary.setParentNode(parentVisitorNode);
    parentVisitorNode = sideEffectBinary;

    //Debug statement
    System.out.println("exprMultEqual");

    //Iterate through rest of the tree
    visitChildren(ctx);
    return null;
  }

  @Override
  public Void visitIDENT_DIV_EQUALS(WaccParser.IDENT_DIV_EQUALSContext ctx) {
    AST_SideEffectBinary sideEffectBinary = new AST_SideEffectBinary();

    //Set currNode to corresponding embedded AST in parent node
    parentVisitorNode.setEmbeddedAST("sideEffect", sideEffectBinary);

    //Set syntactic member variable in AST
    sideEffectBinary.setSyntacticAttributes("/=");
    sideEffectBinary.setSyntacticAttributes(ctx.IDENT().getText());

    //Set parentNode of AST class and global visitor class
    sideEffectBinary.setParentNode(parentVisitorNode);
    parentVisitorNode = sideEffectBinary;

    //Debug statement
    System.out.println("exprDivEqual");

    //Iterate through rest of the tree
    visitChildren(ctx);
    return null;
  }

}


/**
 * 1. Override all the Base Visitor functions
 * - Add the node to the AST node to the symbol table
 * - Depending on the function do semantic analysis on it by calling check function of the AST Node class
 * 2. Override all the Base Visitor functions
 * - Create an AST Class which corresponds to the Visitor function
 **/

package VisitorClass;

import ASTNodes.*;
import ASTNodes.AST_Exprs.*;
import ASTNodes.AST_Stats.*;
import ASTNodes.AST_Stats.AST_StatAssignLHSs.AST_StatArrayElemLHS;
import ASTNodes.AST_Stats.AST_StatAssignLHSs.AST_StatAssignLHS;
import ASTNodes.AST_Stats.AST_StatAssignLHSs.AST_StatIdentLHS;
import ASTNodes.AST_Stats.AST_StatAssignLHSs.AST_StatPairElemLHS;
import ASTNodes.AST_Stats.AST_StatAssignRHSs.*;
import ASTNodes.AST_Stats.AST_StatIfs.AST_StatIfElse;
import ASTNodes.AST_Stats.AST_StatIfs.AST_StatIfThen;
import ASTNodes.AST_Stats.AST_StatIfs.AST_StatSubIf;
import ASTNodes.AST_TYPES.AST_ArrayType;
import ASTNodes.AST_TYPES.AST_BaseType;
import ASTNodes.AST_TYPES.AST_PairElemTypes.AST_ArrayTypePair;
import ASTNodes.AST_TYPES.AST_PairElemTypes.AST_BaseTypePair;
import ASTNodes.AST_TYPES.AST_PairElemTypes.AST_PairElemType;
import ASTNodes.AST_TYPES.AST_PairElemTypes.AST_PairString;
import ASTNodes.AST_TYPES.AST_PairType;
import ASTNodes.AST_TYPES.AST_Type;
import VisitorClass.AST_NodeVisitor;

public class AST_VisitSemantic implements AST_NodeVisitor {

  public void visit(AST_FuncDecl funcDecl) {
    System.out.println("Visiting: " + funcDecl.getClass().getSimpleName());
    funcDecl.CheckSemantics();
  }

  public void visit(AST_Keyword keyword) {
    System.out.println("Visiting: " + keyword.getClass().getSimpleName());
    keyword.CheckSemantics();
  }

  public void visit(AST_Param param) {
    System.out.println("Visiting: " + param.getClass().getSimpleName());
    param.CheckSemantics();
  }

  public void visit(AST_ParamList paramList) {
    System.out.println("Visiting: " + paramList.getClass().getSimpleName());
    paramList.CheckSemantics();
  }

  public void visit(AST_Program program) {
    System.out.println("Visiting: " + program.getClass().getSimpleName());
    program.CheckSemantics();
  }

  public void visit(AST_Separator separator) {
    System.out.println("Visiting: " + separator.getClass().getSimpleName());
    separator.CheckSemantics();
  }

  public void visit(AST_ExprArrayElem exprArrayElem) {
    System.out.println("Visiting: " + exprArrayElem.getClass().getSimpleName());
    exprArrayElem.CheckSemantics();
  }

  public void visit(AST_ExprBinary exprBinary) {
    System.out.println("Visiting: " + exprBinary.getClass().getSimpleName());
    exprBinary.CheckSemantics();
  }

  public void visit(AST_ExprEnclosed exprEnclosed) {
    System.out.println("Visiting: " + exprEnclosed.getClass().getSimpleName());
    exprEnclosed.CheckSemantics();
  }

  public void visit(AST_ExprIdent exprIdent) {
    System.out.println("Visiting: " + exprIdent.getClass().getSimpleName());
    exprIdent.CheckSemantics();
  }

  public void visit(AST_ExprLiter exprLiter) {
    System.out.println("Visiting: " + exprLiter.getClass().getSimpleName());
    exprLiter.CheckSemantics();
  }

  public void visit(AST_ExprUnary exprUnary) {
    System.out.println("Visiting: " + exprUnary.getClass().getSimpleName());
    exprUnary.CheckSemantics();
  }

  public void visit(AST_StatAssign statAssign) {
    System.out.println("Visiting: " + statAssign.getClass().getSimpleName());
    statAssign.CheckSemantics();
  }

  public void visit(AST_StatBeginEnd statBeginEnd) {
    System.out.println("Visiting: " + statBeginEnd.getClass().getSimpleName());
    statBeginEnd.CheckSemantics();
  }

  public void visit(AST_StatExpr statExpr) {
    System.out.println("Visiting: " + statExpr.getClass().getSimpleName());
    statExpr.CheckSemantics();
  }

  public void visit(AST_StatIf statIf) {
    System.out.println("Visiting: " + statIf.getClass().getSimpleName());
    statIf.CheckSemantics();
  }

  public void visit(AST_StatMult statMult) {
    System.out.println("Visiting: " + statMult.getClass().getSimpleName());
    statMult.CheckSemantics();
  }

  public void visit(AST_StatRead statRead) {
    System.out.println("Visiting: " + statRead.getClass().getSimpleName());
    statRead.CheckSemantics();
  }

  public void visit(AST_StatVarDecl statVarDecl) {
    System.out.println("Visiting: " + statVarDecl.getClass().getSimpleName());
    statVarDecl.CheckSemantics();
  }

  public void visit(AST_StatWhile statWhile) {
    System.out.println("Visiting: " + statWhile.getClass().getSimpleName());
    statWhile.CheckSemantics();
  }

  public void visit(AST_StatArrayElemLHS statArrayElemLHS) {
    System.out.println("Visiting: " + statArrayElemLHS.getClass().getSimpleName());
    statArrayElemLHS.CheckSemantics();
  }

  public void visit(AST_StatIdentLHS statIdentLHS) {
    System.out.println("Visiting: " + statIdentLHS.getClass().getSimpleName());
    statIdentLHS.CheckSemantics();
  }

  public void visit(AST_StatPairElemLHS statPairElemLHS) {
    System.out.println("Visiting: " + statPairElemLHS.getClass().getSimpleName());
    statPairElemLHS.CheckSemantics();
  }

  public void visit(AST_StatArrayLitRHS statArrayLitRHS) {
    System.out.println("Visiting: " + statArrayLitRHS.getClass().getSimpleName());
    statArrayLitRHS.CheckSemantics();
  }

  public void visit(AST_StatCallRHS statCallRHS) {
    System.out.println("Visiting: " + statCallRHS.getClass().getSimpleName());
    statCallRHS.CheckSemantics();
  }

  public void visit(AST_StatExprRHS statExprRHS) {
    System.out.println("Visiting: " + statExprRHS.getClass().getSimpleName());
    statExprRHS.CheckSemantics();
  }

  public void visit(AST_StatNewPairRHS statNewPairRHS) {
    System.out.println("Visiting: " + statNewPairRHS.getClass().getSimpleName());
    statNewPairRHS.CheckSemantics();
  }

  public void visit(AST_StatPairElemRHS statPairElemRHS) {
    System.out.println("Visiting: " + statPairElemRHS.getClass().getSimpleName());
    statPairElemRHS.CheckSemantics();
  }

  public void visit(AST_StatIfElse statIfElse) {
    System.out.println("Visiting: " + statIfElse.getClass().getSimpleName());
    statIfElse.CheckSemantics();
  }

  public void visit(AST_StatIfThen statIfThen) {
    System.out.println("Visiting: " + statIfThen.getClass().getSimpleName());
    statIfThen.CheckSemantics();
  }

  public void visit(AST_ArrayType arrayType) {
    System.out.println("Visiting: " + arrayType.getClass().getSimpleName());
    arrayType.CheckSemantics();
  }

  public void visit(AST_BaseType baseType) {
    System.out.println("Visiting: " + baseType.getClass().getSimpleName());
    baseType.CheckSemantics();
  }

  public void visit(AST_PairType pairType) {
    System.out.println("Visiting: " + pairType.getClass().getSimpleName());
    pairType.CheckSemantics();
  }

  public void visit(AST_ArrayTypePair arrayTypePair) {
    System.out.println("Visiting: " + arrayTypePair.getClass().getSimpleName());
    arrayTypePair.CheckSemantics();
  }

  public void visit(AST_BaseTypePair baseTypePair) {
    System.out.println("Visiting: " + baseTypePair.getClass().getSimpleName());
    baseTypePair.CheckSemantics();
  }

  public void visit(AST_PairString pairString) {
    System.out.println("Visiting: " + pairString.getClass().getSimpleName());
    pairString.CheckSemantics();
  }

  /**
   * BASE CLASSES
   */


  public void visit(AST_Node ast_node) {
    System.out.println("Visiting: " + ast_node.getClass().getSimpleName());
    ast_node.CheckSemantics();
  }

  public void visit(AST_Expr ast_expr) {
    System.out.println("Visiting: " + ast_expr.getClass().getSimpleName());
    ast_expr.CheckSemantics();
  }

  public void visit(AST_Stat ast_stat) {
    System.out.println("Visiting: " + ast_stat.getClass().getSimpleName());
    ast_stat.CheckSemantics();
  }

  public void visit(AST_StatAssignLHS ast_statAssignLHS) {
    System.out.println("Visiting: " + ast_statAssignLHS.getClass().getSimpleName());
    ast_statAssignLHS.CheckSemantics();
  }

  public void visit(AST_StatAssignRHS ast_statAssignRHS) {
    System.out.println("Visiting: " + ast_statAssignRHS.getClass().getSimpleName());
    ast_statAssignRHS.CheckSemantics();
  }

  public void visit(AST_Type ast_type) {
    System.out.println("Visiting: " + ast_type.getClass().getSimpleName());
    ast_type.CheckSemantics();
  }

  public void visit(AST_PairElemType ast_pairElemType) {
    System.out.println("Visiting: " + ast_pairElemType.getClass().getSimpleName());
    ast_pairElemType.CheckSemantics();
  }

  public void visit(AST_StatSubIf ast_statSubIf) {
    System.out.println("Visiting: " + ast_statSubIf.getClass().getSimpleName());
    ast_statSubIf.CheckSemantics();
  }
}

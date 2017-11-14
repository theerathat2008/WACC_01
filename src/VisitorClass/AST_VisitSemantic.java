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
  }

  public void visit(AST_Keyword keyword) {
    System.out.println("Visiting: " + keyword.getClass().getSimpleName());
  }

  public void visit(AST_Param param) {
    System.out.println("Visiting: " + param.getClass().getSimpleName());
  }

  public void visit(AST_ParamList paramList) {
    System.out.println("Visiting: " + paramList.getClass().getSimpleName());
  }

  public void visit(AST_Program program) {
    System.out.println("Visiting: " + program.getClass().getSimpleName());
  }

  public void visit(AST_Separator separator) {
    System.out.println("Visiting: " + separator.getClass().getSimpleName());
  }

  public void visit(AST_ExprArrayElem exprArrayElem) {
    System.out.println("Visiting: " + exprArrayElem.getClass().getSimpleName());
  }

  public void visit(AST_ExprBinary exprBinary) {
    System.out.println("Visiting: " + exprBinary.getClass().getSimpleName());
  }

  public void visit(AST_ExprEnclosed exprEnclosed) {
    System.out.println("Visiting: " + exprEnclosed.getClass().getSimpleName());
  }

  public void visit(AST_ExprIdent exprIdent) {
    System.out.println("Visiting: " + exprIdent.getClass().getSimpleName());
  }

  public void visit(AST_ExprLiter exprLiter) {
    System.out.println("Visiting: " + exprLiter.getClass().getSimpleName());
  }

  public void visit(AST_ExprUnary exprUnary) {
    System.out.println("Visiting: " + exprUnary.getClass().getSimpleName());
  }

  public void visit(AST_StatAssign statAssign) {
    System.out.println("Visiting: " + statAssign.getClass().getSimpleName());
  }

  public void visit(AST_StatBeginEnd statBeginEnd) {
    System.out.println("Visiting: " + statBeginEnd.getClass().getSimpleName());
  }

  public void visit(AST_StatExpr statExpr) {
    System.out.println("Visiting: " + statExpr.getClass().getSimpleName());
  }

  public void visit(AST_StatIf statIf) {
    System.out.println("Visiting: " + statIf.getClass().getSimpleName());
  }

  public void visit(AST_StatMult statMult) {
    System.out.println("Visiting: " + statMult.getClass().getSimpleName());
  }

  public void visit(AST_StatRead statRead) {
    System.out.println("Visiting: " + statRead.getClass().getSimpleName());
  }

  public void visit(AST_StatVarDecl statVarDecl) {
    System.out.println("Visiting: " + statVarDecl.getClass().getSimpleName());
  }

  public void visit(AST_StatWhile statWhile) {
    System.out.println("Visiting: " + statWhile.getClass().getSimpleName());
  }

  public void visit(AST_StatArrayElemLHS statArrayElemLHS) {
    System.out.println("Visiting: " + statArrayElemLHS.getClass().getSimpleName());
  }

  public void visit(AST_StatIdentLHS statIdentLHS) {
    System.out.println("Visiting: " + statIdentLHS.getClass().getSimpleName());
  }

  public void visit(AST_StatPairElemLHS statPairElemLHS) {
    System.out.println("Visiting: " + statPairElemLHS.getClass().getSimpleName());
  }

  public void visit(AST_StatArrayLitRHS statArrayLitRHS) {
    System.out.println("Visiting: " + statArrayLitRHS.getClass().getSimpleName());
  }

  public void visit(AST_StatCallRHS statCallRHS) {
    System.out.println("Visiting: " + statCallRHS.getClass().getSimpleName());
  }

  public void visit(AST_StatExprRHS statExprRHS) {
    System.out.println("Visiting: " + statExprRHS.getClass().getSimpleName());
  }

  public void visit(AST_StatNewPairRHS statNewPairRHS) {
    System.out.println("Visiting: " + statNewPairRHS.getClass().getSimpleName());
  }

  public void visit(AST_StatPairElemRHS statPairElemRHS) {
    System.out.println("Visiting: " + statPairElemRHS.getClass().getSimpleName());
  }

  public void visit(AST_StatIfElse statIfElse) {
    System.out.println("Visiting: " + statIfElse.getClass().getSimpleName());
  }

  public void visit(AST_StatIfThen statIfThen) {
    System.out.println("Visiting: " + statIfThen.getClass().getSimpleName());
  }

  public void visit(AST_ArrayType arrayType) {
    System.out.println("Visiting: " + arrayType.getClass().getSimpleName());
  }

  public void visit(AST_BaseType baseType) {
    System.out.println("Visiting: " + baseType.getClass().getSimpleName());
  }

  public void visit(AST_PairType pairType) {
    System.out.println("Visiting: " + pairType.getClass().getSimpleName());
  }

  public void visit(AST_ArrayTypePair arrayTypePair) {
    System.out.println("Visiting: " + arrayTypePair.getClass().getSimpleName());
  }

  public void visit(AST_BaseTypePair baseTypePair) {
    System.out.println("Visiting: " + baseTypePair.getClass().getSimpleName());
  }

  public void visit(AST_PairString pairString) {
    System.out.println("Visiting: " + pairString.getClass().getSimpleName());
  }

  /**
   * BASE CLASSES
   */


  public void visit(AST_Node ast_node) {
    System.out.println("Visiting: " + ast_node.getClass().getSimpleName());
  }

  public void visit(AST_Expr ast_expr) {
    System.out.println("Visiting: " + ast_expr.getClass().getSimpleName());
  }

  public void visit(AST_Stat ast_stat) {
    System.out.println("Visiting: " + ast_stat.getClass().getSimpleName());
  }

  public void visit(AST_StatAssignLHS ast_statAssignLHS) {
    System.out.println("Visiting: " + ast_statAssignLHS.getClass().getSimpleName());
  }

  public void visit(AST_StatAssignRHS ast_statAssignRHS) {
    System.out.println("Visiting: " + ast_statAssignRHS.getClass().getSimpleName());
  }

  public void visit(AST_Type ast_type) {
    System.out.println("Visiting: " + ast_type.getClass().getSimpleName());
  }

  public void visit(AST_PairElemType ast_pairElemType) {
    System.out.println("Visiting: " + ast_pairElemType.getClass().getSimpleName());
  }

  public void visit(AST_StatSubIf ast_statSubIf) {
    System.out.println("Visiting: " + ast_statSubIf.getClass().getSimpleName());
  }
}

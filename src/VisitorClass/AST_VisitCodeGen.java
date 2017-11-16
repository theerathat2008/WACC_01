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

import java.util.LinkedList;
import java.util.List;

public class AST_VisitCodeGen implements AST_NodeVisitor {

  List<String> instructions = new LinkedList<>();

  public void generateAssembly(){
    String indent = "\t";
    for(String str : instructions){
      if(str.equals("begin_indent")){
        indent = "\t\t";
        continue;
      } else if(str.equals("end_indent")){
        indent = "\t";
        continue;
      } else if(str.equals("new_line")){
        System.out.println();
        continue;
      }
      System.out.println(indent.concat(str));
    }
  }


  @Override
  public void visit(AST_FuncDecl funcDecl) {
    funcDecl.genCode(instructions);
  }

  @Override
  public void visit(AST_Keyword keyword) {
    keyword.genCode(instructions);
  }

  @Override
  public void visit(AST_Param param) {
    param.genCode(instructions);
  }

  @Override
  public void visit(AST_ParamList paramList) {
    paramList.genCode(instructions);
  }

  @Override
  public void visit(AST_Program program) {
    program.genCode(instructions);
  }

  @Override
  public void visit(AST_Separator separator) {
    separator.genCode(instructions);
  }

  @Override
  public void visit(AST_ExprArrayElem exprArrayElem) {
    exprArrayElem.genCode(instructions);
  }

  @Override
  public void visit(AST_ExprBinary exprBinary) {
    exprBinary.genCode(instructions);
  }

  @Override
  public void visit(AST_ExprEnclosed exprEnclosed) {
    exprEnclosed.genCode(instructions);
  }

  @Override
  public void visit(AST_ExprIdent exprIdent) {
    exprIdent.genCode(instructions);
  }

  @Override
  public void visit(AST_ExprLiter exprLiter) {
    exprLiter.genCode(instructions);
  }

  @Override
  public void visit(AST_ExprUnary exprUnary) {
    exprUnary.genCode(instructions);
  }

  @Override
  public void visit(AST_StatAssign statAssign) {
    statAssign.genCode(instructions);
  }

  @Override
  public void visit(AST_StatBeginEnd statBeginEnd) {
    statBeginEnd.genCode(instructions);
  }

  @Override
  public void visit(AST_StatExpr statExpr) {
    statExpr.genCode(instructions);
  }

  @Override
  public void visit(AST_StatIf statIf) {
    statIf.genCode(instructions);
  }

  @Override
  public void visit(AST_StatMult statMult) {
    statMult.genCode(instructions);
  }

  @Override
  public void visit(AST_StatRead statRead) {
    statRead.genCode(instructions);
  }

  @Override
  public void visit(AST_StatVarDecl statVarDecl) {
    statVarDecl.genCode(instructions);
  }

  @Override
  public void visit(AST_StatWhile statWhile) {
    statWhile.genCode(instructions);
  }

  @Override
  public void visit(AST_StatArrayElemLHS statArrayElemLHS) {
    statArrayElemLHS.genCode(instructions);
  }

  @Override
  public void visit(AST_StatIdentLHS statIdentLHS) {
    statIdentLHS.genCode(instructions);
  }

  @Override
  public void visit(AST_StatPairElemLHS statPairElemLHS) {
    statPairElemLHS.genCode(instructions);
  }

  @Override
  public void visit(AST_StatArrayLitRHS statArrayLitRHS) {
    statArrayLitRHS.genCode(instructions);
  }

  @Override
  public void visit(AST_StatCallRHS statCallRHS) {
    statCallRHS.genCode(instructions);
  }

  @Override
  public void visit(AST_StatExprRHS statExprRHS) {
    statExprRHS.genCode(instructions);
  }

  @Override
  public void visit(AST_StatNewPairRHS statNewPairRHS) {
    statNewPairRHS.genCode(instructions);
  }

  @Override
  public void visit(AST_StatPairElemRHS statPairElemRHS) {
    statPairElemRHS.genCode(instructions);
  }

  @Override
  public void visit(AST_StatIfElse statIfElse) {
    statIfElse.genCode(instructions);
  }

  @Override
  public void visit(AST_StatIfThen statIfThen) {
    statIfThen.genCode(instructions);
  }

  @Override
  public void visit(AST_ArrayType arrayType) {
    arrayType.genCode(instructions);
  }

  @Override
  public void visit(AST_BaseType baseType) {
    baseType.genCode(instructions);
  }

  @Override
  public void visit(AST_PairType pairType) {
    pairType.genCode(instructions);
  }

  @Override
  public void visit(AST_ArrayTypePair arrayTypePair) {
    arrayTypePair.genCode(instructions);
  }

  @Override
  public void visit(AST_BaseTypePair baseTypePair) {
    baseTypePair.genCode(instructions);
  }

  @Override
  public void visit(AST_PairString pairString) {
    pairString.genCode(instructions);
  }

  @Override
  public void visit(AST_Node ast_node) {
    ast_node.genCode(instructions);
  }

  @Override
  public void visit(AST_Expr ast_expr) {
    ast_expr.genCode(instructions);
  }

  @Override
  public void visit(AST_Stat ast_stat) {
    ast_stat.genCode(instructions);
  }

  @Override
  public void visit(AST_StatAssignLHS ast_statAssignLHS) {
    ast_statAssignLHS.genCode(instructions);
  }

  @Override
  public void visit(AST_StatAssignRHS ast_statAssignRHS) {
    ast_statAssignRHS.genCode(instructions);
  }

  @Override
  public void visit(AST_Type ast_type) {
    ast_type.genCode(instructions);
  }

  @Override
  public void visit(AST_PairElemType ast_pairElemType) {
    ast_pairElemType.genCode(instructions);
  }

  @Override
  public void visit(AST_StatSubIf ast_statSubIf) {
    ast_statSubIf.genCode(instructions);
  }
}

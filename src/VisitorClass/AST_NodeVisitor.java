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

public interface AST_NodeVisitor {

  void visit(AST_FuncDecl funcDecl);
  void visit(AST_Keyword keyword);
  void visit(AST_Param param);
  void visit(AST_ParamList paramList);
  void visit(AST_Program program);
  void visit(AST_Separator separator);

  void visit(AST_ExprArrayElem exprArrayElem);
  void visit(AST_ExprBinary exprBinary);
  void visit(AST_ExprEnclosed exprEnclosed);
  void visit(AST_ExprIdent exprIdent);
  void visit(AST_ExprLiter exprLiter);
  void visit(AST_ExprUnary exprUnary);

  void visit(AST_StatAssign statAssign);
  void visit(AST_StatBeginEnd statBeginEnd);
  void visit(AST_StatExpr statExpr);
  void visit(AST_StatIf statIf);
  void visit(AST_StatMult statMult);
  void visit(AST_StatRead statRead);
  void visit(AST_StatVarDecl statVarDecl);
  void visit(AST_StatWhile statWhile);

  void visit(AST_StatArrayElemLHS statArrayElemLHS);
  void visit(AST_StatIdentLHS statIdentLHS);
  void visit(AST_StatPairElemLHS statPairElemLHS);

  void visit(AST_StatArrayLitRHS statArrayLitRHS);
  void visit(AST_StatCallRHS statCallRHS);
  void visit(AST_StatExprRHS statExprRHS);
  void visit(AST_StatNewPairRHS statNewPairRHS);
  void visit(AST_StatPairElemRHS statPairElemRHS);

  void visit(AST_StatIfElse statIfElse);
  void visit(AST_StatIfThen statIfThen);

  void visit(AST_ArrayType arrayType);
  void visit(AST_BaseType baseType);
  void visit(AST_PairType pairType);

  void visit(AST_ArrayTypePair arrayTypePair);
  void visit(AST_BaseTypePair baseTypePair);
  void visit(AST_PairString pairString);

  void visit(AST_Node  ast_node);
  void visit(AST_Expr  ast_expr);
  void visit(AST_Stat  ast_stat);
  void visit(AST_StatAssignLHS ast_statAssignLHS);
  void visit(AST_StatAssignRHS ast_statAssignRHS);
  void visit(AST_Type ast_type);
  void visit(AST_PairElemType ast_pairElemType);
  void visit(AST_StatSubIf ast_statSubIf);

}

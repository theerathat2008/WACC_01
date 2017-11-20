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
import InstructionSet.Assembler;
import InstructionSet.Instruction;

import java.util.LinkedList;
import java.util.List;

public class AST_VisitCodeGen implements AST_NodeVisitor {

  List<Instruction> instructions = new LinkedList<>();




  /** PLAN 1
   * 1. Visit AST_Node using visitor pattern
   * 2. Generate instruction for each AST_Node by calling genInstructions(instructionList)
   *    - Pass in variables in instruction class constructor needed for assembly code
   * 3. Populate the instruction list
   **** At this point we have a full instruction list with no assembly code generated
   * 4. In generateAssembly iterate through the instructions
   * 5. Work out which register to use
   * 5. Hard code the special cases and output the right order to assembly output
   * 6. Print out ordered assembly instructions in printAssembly
   */




  public void generateAssembly(){
    Assembler assembler = Assembler.getInstance();
    assembler.setInstructions(instructions);
  }



  @Override
  public void visit(AST_FuncDecl funcDecl) {
    funcDecl.genInstruction(instructions);
  }

  @Override
  public void visit(AST_Keyword keyword) {
    keyword.genInstruction(instructions);
  }

  @Override
  public void visit(AST_Param param) {
    param.genInstruction(instructions);
  }

  @Override
  public void visit(AST_ParamList paramList) {
    paramList.genInstruction(instructions);
  }

  @Override
  public void visit(AST_Program program) {
    program.genInstruction(instructions);
  }

  @Override
  public void visit(AST_Separator separator) {
    separator.genInstruction(instructions);
  }

  @Override
  public void visit(AST_ExprArrayElem exprArrayElem) {
    exprArrayElem.genInstruction(instructions);
  }

  @Override
  public void visit(AST_ExprBinary exprBinary) {
    exprBinary.genInstruction(instructions);
  }

  @Override
  public void visit(AST_ExprEnclosed exprEnclosed) {
    exprEnclosed.genInstruction(instructions);
  }

  @Override
  public void visit(AST_ExprIdent exprIdent) {
    exprIdent.genInstruction(instructions);
  }

  @Override
  public void visit(AST_ExprLiter exprLiter) {
    exprLiter.genInstruction(instructions);
  }

  @Override
  public void visit(AST_ExprUnary exprUnary) {
    exprUnary.genInstruction(instructions);
  }

  @Override
  public void visit(AST_StatAssign statAssign) {
    statAssign.genInstruction(instructions);
  }

  @Override
  public void visit(AST_StatBeginEnd statBeginEnd) {
    statBeginEnd.genInstruction(instructions);
  }

  @Override
  public void visit(AST_StatExpr statExpr) {
    statExpr.genInstruction(instructions);
  }

  @Override
  public void visit(AST_StatIf statIf) {
    statIf.genInstruction(instructions);
  }

  @Override
  public void visit(AST_StatMult statMult) {
    statMult.genInstruction(instructions);
  }

  @Override
  public void visit(AST_StatRead statRead) {
    statRead.genInstruction(instructions);
  }

  @Override
  public void visit(AST_StatVarDecl statVarDecl) {
    statVarDecl.genInstruction(instructions);
  }

  @Override
  public void visit(AST_StatWhile statWhile) {
    statWhile.genInstruction(instructions);
  }

  @Override
  public void visit(AST_StatArrayElemLHS statArrayElemLHS) {
    statArrayElemLHS.genInstruction(instructions);
  }

  @Override
  public void visit(AST_StatIdentLHS statIdentLHS) {
    statIdentLHS.genInstruction(instructions);
  }

  @Override
  public void visit(AST_StatPairElemLHS statPairElemLHS) {
    statPairElemLHS.genInstruction(instructions);
  }

  @Override
  public void visit(AST_StatArrayLitRHS statArrayLitRHS) {
    statArrayLitRHS.genInstruction(instructions);
  }

  @Override
  public void visit(AST_StatCallRHS statCallRHS) {
    statCallRHS.genInstruction(instructions);
  }

  @Override
  public void visit(AST_StatExprRHS statExprRHS) {
    statExprRHS.genInstruction(instructions);
  }

  @Override
  public void visit(AST_StatNewPairRHS statNewPairRHS) {
    statNewPairRHS.genInstruction(instructions);
  }

  @Override
  public void visit(AST_StatPairElemRHS statPairElemRHS) {
    statPairElemRHS.genInstruction(instructions);
  }

  @Override
  public void visit(AST_StatIfElse statIfElse) {
    statIfElse.genInstruction(instructions);
  }

  @Override
  public void visit(AST_StatIfThen statIfThen) {
    statIfThen.genInstruction(instructions);
  }

  @Override
  public void visit(AST_ArrayType arrayType) {
    arrayType.genInstruction(instructions);
  }

  @Override
  public void visit(AST_BaseType baseType) {
    baseType.genInstruction(instructions);
  }

  @Override
  public void visit(AST_PairType pairType) {
    pairType.genInstruction(instructions);
  }

  @Override
  public void visit(AST_ArrayTypePair arrayTypePair) {
    arrayTypePair.genInstruction(instructions);
  }

  @Override
  public void visit(AST_BaseTypePair baseTypePair) {
    baseTypePair.genInstruction(instructions);
  }

  @Override
  public void visit(AST_PairString pairString) {
    pairString.genInstruction(instructions);
  }

  @Override
  public void visit(AST_Node ast_node) {
    ast_node.genInstruction(instructions);
  }

  @Override
  public void visit(AST_Expr ast_expr) {
    ast_expr.genInstruction(instructions);
  }

  @Override
  public void visit(AST_Stat ast_stat) {
    ast_stat.genInstruction(instructions);
  }

  @Override
  public void visit(AST_StatAssignLHS ast_statAssignLHS) {
    ast_statAssignLHS.genInstruction(instructions);
  }

  @Override
  public void visit(AST_StatAssignRHS ast_statAssignRHS) {
    ast_statAssignRHS.genInstruction(instructions);
  }

  @Override
  public void visit(AST_Type ast_type) {
    ast_type.genInstruction(instructions);
  }

  @Override
  public void visit(AST_PairElemType ast_pairElemType) {
    ast_pairElemType.genInstruction(instructions);
  }

  @Override
  public void visit(AST_StatSubIf ast_statSubIf) {
    ast_statSubIf.genInstruction(instructions);
  }
}

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
import Registers.RegisterAllocation;

import java.util.LinkedList;
import java.util.List;

public class AST_VisitCodeGen implements AST_NodeVisitor {

  List<Instruction> instructions = new LinkedList<>();

  RegisterAllocation registerAllocation = new RegisterAllocation();




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
    try {
      funcDecl.genInstruction(instructions, );
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void visit(AST_Keyword keyword) {
    try {
      keyword.genInstruction(instructions, );
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void visit(AST_Param param) {
    try {
      param.genInstruction(instructions, );
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void visit(AST_ParamList paramList) {
    try {
      paramList.genInstruction(instructions, );
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void visit(AST_Program program) {
    try {
      program.genInstruction(instructions, );
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void visit(AST_Separator separator) {
    try {
      separator.genInstruction(instructions, );
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void visit(AST_ExprArrayElem exprArrayElem) {
    try {
      exprArrayElem.genInstruction(instructions, );
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void visit(AST_ExprBinary exprBinary) {
    try {
      exprBinary.genInstruction(instructions, );
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void visit(AST_ExprEnclosed exprEnclosed) {
    try {
      exprEnclosed.genInstruction(instructions, );
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void visit(AST_ExprIdent exprIdent) {
    try {
      exprIdent.genInstruction(instructions, );
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void visit(AST_ExprLiter exprLiter) {
    try {
      exprLiter.genInstruction(instructions, );
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void visit(AST_ExprUnary exprUnary) {
    try {
      exprUnary.genInstruction(instructions, );
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void visit(AST_StatAssign statAssign) {
    try {
      statAssign.genInstruction(instructions, );
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void visit(AST_StatBeginEnd statBeginEnd) {
    try {
      statBeginEnd.genInstruction(instructions, );
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void visit(AST_StatExpr statExpr) {
    try {
      statExpr.genInstruction(instructions, );
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void visit(AST_StatIf statIf) {
    try {
      statIf.genInstruction(instructions, registerAllocation);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void visit(AST_StatMult statMult) {
    try {
      statMult.genInstruction(instructions, );
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void visit(AST_StatRead statRead) {
    try {
      statRead.genInstruction(instructions, );
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void visit(AST_StatVarDecl statVarDecl) {
    try {
      statVarDecl.genInstruction(instructions, );
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void visit(AST_StatWhile statWhile) {
    try {
      statWhile.genInstruction(instructions, );
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void visit(AST_StatArrayElemLHS statArrayElemLHS) {
    try {
      statArrayElemLHS.genInstruction(instructions, );
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void visit(AST_StatIdentLHS statIdentLHS) {
    try {
      statIdentLHS.genInstruction(instructions, );
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void visit(AST_StatPairElemLHS statPairElemLHS) {
    try {
      statPairElemLHS.genInstruction(instructions, );
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void visit(AST_StatArrayLitRHS statArrayLitRHS) {
    try {
      statArrayLitRHS.genInstruction(instructions, );
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void visit(AST_StatCallRHS statCallRHS) {
    try {
      statCallRHS.genInstruction(instructions, );
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void visit(AST_StatExprRHS statExprRHS) {
    try {
      statExprRHS.genInstruction(instructions, );
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void visit(AST_StatNewPairRHS statNewPairRHS) {
    try {
      statNewPairRHS.genInstruction(instructions, );
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void visit(AST_StatPairElemRHS statPairElemRHS) {
    try {
      statPairElemRHS.genInstruction(instructions, );
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void visit(AST_StatIfElse statIfElse) {
    try {
      statIfElse.genInstruction(instructions, );
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void visit(AST_StatIfThen statIfThen) {
    try {
      statIfThen.genInstruction(instructions, );
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void visit(AST_ArrayType arrayType) {
    try {
      arrayType.genInstruction(instructions, );
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void visit(AST_BaseType baseType) {
    try {
      baseType.genInstruction(instructions, );
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void visit(AST_PairType pairType) {
    try {
      pairType.genInstruction(instructions, );
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void visit(AST_ArrayTypePair arrayTypePair) {
    try {
      arrayTypePair.genInstruction(instructions, );
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void visit(AST_BaseTypePair baseTypePair) {
    try {
      baseTypePair.genInstruction(instructions, );
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void visit(AST_PairString pairString) {
    try {
      pairString.genInstruction(instructions, );
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void visit(AST_Node ast_node) {
    try {
      ast_node.genInstruction(instructions, );
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void visit(AST_Expr ast_expr) {
    try {
      ast_expr.genInstruction(instructions, );
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void visit(AST_Stat ast_stat) {
    try {
      ast_stat.genInstruction(instructions, );
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void visit(AST_StatAssignLHS ast_statAssignLHS) {
    try {
      ast_statAssignLHS.genInstruction(instructions, );
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void visit(AST_StatAssignRHS ast_statAssignRHS) {
    try {
      ast_statAssignRHS.genInstruction(instructions, );
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void visit(AST_Type ast_type) {
    try {
      ast_type.genInstruction(instructions, );
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void visit(AST_PairElemType ast_pairElemType) {
    try {
      ast_pairElemType.genInstruction(instructions, );
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void visit(AST_StatSubIf ast_statSubIf) {
    try {
      ast_statSubIf.genInstruction(instructions, );
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

package ASTNodes.AST_SideEffect;

import ASTNodes.AST_Exprs.AST_Expr;
import Registers.RegisterAllocation;

public class AST_SideEffect extends AST_Expr {

  /**
   * Used to flag special cases where the register needs a stack implementation before the backend parse
   * @param regAlloc
   */
  @Override
  public void acceptPreProcess(RegisterAllocation regAlloc) {

  }
}

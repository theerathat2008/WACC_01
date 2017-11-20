package src.InstructionSet;

import java.util.List;

public class InstructionIf extends Instruction {

  /**
   * Generated from AST_StatIf
   * The ARM code blocks needed are:
   * 1. the calling of the then branch
   * 2. the calling of the else branch
   * Assumes an input reg has the evaluation of the expression
   */

  String exprReg;
  String branchElseName;
  String continueName;

  String blockIf;
  String blockElse;
  String blockContinue;


  public InstructionIf(){
  }

  public void allocateRegisters(RegisterARM registerARM){
    this.exprReg = regList.get(0);
  }

  @Override
  public void genInstruction(){
    StringBuilder block1 = new StringBuilder();
    block1.append("\t\tCMP ");
    block1.append(exprReg);
    block1.append(", #0\n");
    block1.append("\t\tBEQ ");
    block1.append(branchElseName);
    block1.append("\n");
    blockIf = block1.toString();

    StringBuilder block2 = new StringBuilder();
    block2.append("\t\tB ");
    block2.append(continueName);
    block2.append("\n");
    block2.append(branchElseName);
    block2.append(":\n");
    blockElse = block2.toString();

    StringBuilder block3 = new StringBuilder();
    block3.append(blockContinue);
    block3.append(":");
    blockContinue = block3.toString();

  }

}

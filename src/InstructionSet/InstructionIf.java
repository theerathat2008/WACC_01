package InstructionSet;

import Registers.RegisterARM;

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

  public String blockIf;
  public String blockElse;
  public String blockContinue;

  /**
   * Class constructor
   */
  public InstructionIf() {
    exprReg = "exprReg";
  }

  /**
   * Set value of branchElseName and continueName
   * @param branchElseName
   * @param continueName
   */
  public void setLabels(String branchElseName, String continueName) {
    this.branchElseName = branchElseName;
    this.continueName = continueName;
  }

  /**
   * Assigned string value indicating name of register
   * @param registerARM
   */
  public void allocateRegisters(RegisterARM registerARM) {
    this.exprReg = registerARM.name();
  }

  /**
   * Generates the instruction block as a string for the current instruction
   */
  @Override
  public void genInstruction() {
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
    block2.append("\n\t");
    block2.append(branchElseName);
    block2.append(":\n");
    blockElse = block2.toString();

    StringBuilder block3 = new StringBuilder("\t");
    block3.append(continueName);
    block3.append(":\n");
    blockContinue = block3.toString();

  }

}

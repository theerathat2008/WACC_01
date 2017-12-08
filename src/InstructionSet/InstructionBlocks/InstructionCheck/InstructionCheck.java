package InstructionSet.InstructionBlocks.InstructionCheck;

import InstructionSet.InstructionBlocks.InstructionBlocks;

public class InstructionCheck extends InstructionBlocks {
  String reg1;
  int msgNum1;

  /**
   * Class constructor
   */
  public InstructionCheck(int msgNum1) {
    this.msgNum1 = msgNum1;
    reg1 = "reg1";
  }

  /**
   * Generates the instruction block as a string for the current instruction
   */
  @Override
  public void genInstruction() {
  }

}

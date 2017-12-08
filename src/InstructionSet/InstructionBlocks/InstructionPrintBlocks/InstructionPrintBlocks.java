package InstructionSet.InstructionBlocks.InstructionPrintBlocks;

import InstructionSet.InstructionBlocks.InstructionBlocks;

/**
 * Base class of all print instructions.
 */
public class InstructionPrintBlocks extends InstructionBlocks {
  String reg1;
  int msgNum1;

  /**
   * Class constructor - all subclasses use this
   * @param msgNum1 - Indicates the ID of the message to be output
   */
  public InstructionPrintBlocks(int msgNum1) {
    this.msgNum1 = msgNum1;
    reg1 = "r0";
  }

  /**
   * Generates the instruction block as a string for the current instruction
   */
  @Override
  public void genInstruction(){

  }

}

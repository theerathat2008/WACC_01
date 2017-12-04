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
   *
   * @param msgNum1 - Indicates the ID of the message to be output
   */
  public InstructionPrintBlocks(int msgNum1) {
    this.msgNum1 = msgNum1;
    reg1 = "r0";
  }

  @Override
  public void genInstruction(){

  }

  @Override
  public int requiresRegisters() {
    return 1;
  }

  @Override
  public boolean crossOverRegister() {
    return false;
  }

}

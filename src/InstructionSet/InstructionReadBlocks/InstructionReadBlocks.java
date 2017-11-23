package InstructionSet.InstructionReadBlocks;

import InstructionSet.Instruction;

/**
 * Base class of all print instructions.
 */
public class InstructionReadBlocks extends Instruction{
  String reg1;
  String resultBlock = "\t";
  int msgNum1;

  /**
   * Class constructor - all subclasses use this
   * @param msgNum1 - Indicates the ID of the message to be output
   */
  public InstructionReadBlocks(int msgNum1) {
    this.msgNum1 = msgNum1;
  }


  @Override
  public void genInstruction() {

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

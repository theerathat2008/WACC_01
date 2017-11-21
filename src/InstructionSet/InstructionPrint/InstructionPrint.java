package InstructionSet.InstructionPrint;

import InstructionSet.Instruction;

/**
 * Base class of all print instructions.
 */
public class InstructionPrint extends Instruction{
  String reg1;
  String resultBlock;
  int msgNum1;

  /**
   * Class constructor - all subclasses use this
   * @param msgNum1 - Indicates the ID of the message to be output
   */
  public InstructionPrint(int msgNum1) {
    this.msgNum1 = msgNum1;
  }


  @Override
  public void genInstruction() {

  }
}

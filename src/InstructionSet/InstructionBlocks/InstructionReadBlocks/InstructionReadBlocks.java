package InstructionSet.InstructionBlocks.InstructionReadBlocks;

import InstructionSet.InstructionBlocks.InstructionBlocks;
import Registers.RegisterARM;

/**
 * Base class of all print instructions.
 */
public class InstructionReadBlocks extends InstructionBlocks {
  String reg1;
  String reg2;
  int msgNum1;

  /**
   * Class constructor - all subclasses use this
   *
   * @param msgNum1 - Indicates the ID of the message to be output
   */
  public InstructionReadBlocks(int msgNum1) {
    this.msgNum1 = msgNum1;
    reg1 = "reg1";
  }

  public void allocateRegisters(RegisterARM reg1, RegisterARM reg2) {
    this.reg1 = reg1.name();
    this.reg2 = reg2.name();
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

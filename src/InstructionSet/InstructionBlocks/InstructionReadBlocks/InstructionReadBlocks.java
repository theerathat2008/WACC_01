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
   * @param msgNum1 - Indicates the ID of the message to be output
   */
  public InstructionReadBlocks(int msgNum1) {
    this.msgNum1 = msgNum1;
    this.reg1 = "r0";
    this.reg2 = "r1";
  }

  /**
   * Assigned string value indicating name of register
   * @param reg1 - first register
   * @param reg2 - second register
   */
  public void allocateRegisters(RegisterARM reg1, RegisterARM reg2) {
    this.reg1 = reg1.name();
    this.reg2 = reg2.name();
  }

  /**
   * Generates the instruction block as a string for the current instruction
   */
  @Override
  public void genInstruction() {

  }

}

package InstructionSet.InstructionError;

import InstructionSet.Instruction;
import Registers.RegisterARM;

public class InstructionErrorOverflow extends Instruction {
  String reg1;
  String resultBlock;
  /**
   * Class constructor
   */
  public InstructionErrorOverflow() {

  }

  /**
   * Assigned string value indicating name of register
   * @param reg1 - first register
   */
  public void allocateRegisters(String reg1) {
    this.reg1 = reg1;
  }

  /**
   * Generates the instruction block as a string for the current instruction
   */
  public void genInstruction() {
    resultBlock.concat("p_throw_overflow_error:\n");
    resultBlock.concat("\t\tLDR " +  reg1 + ", =msg_2\n");
    resultBlock.concat("\t\tBL p_throw_runtime_error\n");
  }
}

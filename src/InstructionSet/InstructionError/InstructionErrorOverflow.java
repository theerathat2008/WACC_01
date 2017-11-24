package InstructionSet.InstructionError;

import InstructionSet.Instruction;
import Registers.RegisterARM;

public class InstructionErrorOverflow extends InstructionError {
  String reg1;

  /**
   * Class constructor
   */
  public InstructionErrorOverflow() {
    reg1 = "reg1";
  }

  /**
   * Assigned string value indicating name of register
   *
   * @param reg1 - first register
   */
  public void allocateRegisters(RegisterARM reg1) {
    this.reg1 = reg1.name();
  }

  /**
   * Generates the instruction block as a string for the current instruction
   */
  public void genInstruction() {
    StringBuilder builder = new StringBuilder();
    builder.append("\tp_throw_overflow_error:\n\t\tLDR ");
    builder.append(reg1);
    builder.append(", =msg_2\n\t\tBL p_throw_runtime_error\n");

    resultBlock = builder.toString();
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

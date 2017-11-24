package InstructionSet.InstructionError;

import InstructionSet.Instruction;
import Registers.RegisterARM;

public class InstructionErrorRuntime extends InstructionError {
  String reg1;

  /**
   * Class constructor
   */
  public InstructionErrorRuntime() {
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
    builder.append("\tp_throw_runtime_error:\n\t\tBL p_print_string\n\t\tMOV ");
    builder.append(reg1);
    builder.append(", #-1\n\t\tBL exit\n");

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

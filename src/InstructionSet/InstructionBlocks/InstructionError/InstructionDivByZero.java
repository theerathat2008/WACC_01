package InstructionSet.InstructionBlocks.InstructionError;

import Registers.RegisterARM;

public class InstructionDivByZero extends InstructionError {
  String reg1;
  String reg2;
  String outputMessageNumber;

  /**
   * Class constructor
   */
  public InstructionDivByZero() {
    reg1 = "reg1";
    reg2 = "reg2";
    this.blockType = "check_divide_by_zero";
  }

  public void setOutputMessageNumber(String number) {
    outputMessageNumber = number;
  }

  /**
   * Assigned string value indicating name of register
   *
   * @param reg1 - first register
   */
  public void allocateRegisters(RegisterARM reg1, RegisterARM reg2) {
    this.reg1 = reg1.name();
    this.reg2 = reg2.name();
  }

  /**
   * Generates the instruction block as a string for the current instruction
   */
  public void genInstruction() {
    StringBuilder builder = new StringBuilder();
    builder.append("\tp_check_divide_by_zero:\n\t\tPUSH {LR}\n\t\tCMP ");
    builder.append(reg1);
    builder.append(", #0\n\t\tLDREQ r0, =msg_");
    builder.append(outputMessageNumber);
    builder.append("\n\t\tBLEQ p_throw_runtime_error\n");
    this.resultBlock = builder.toString();
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

package InstructionSet.InstructionBlocks.InstructionCheck;

public class InstructionCheckNullPointer extends InstructionCheck {

  public InstructionCheckNullPointer(int msgNum) {
    super(msgNum);
    reg1 = "r0";
    this.blockType = "check_null_pointer";
  }

  /**
   * Assigned string value indicating name of register
   *
   * @param reg1 - first register
   */
  public void allocateRegisters(String reg1) {
    this.reg1 = reg1;
  }

  /**
   * Generates the instruction block as a string for the current instruction
   */
  public void genInstruction() {
    StringBuilder builder = new StringBuilder();
    builder.append("\tp_check_null_pointer:\n\t\tPUSH {lr}\n\t\tCMP ");
    builder.append(reg1);
    builder.append(", #0\n\t\tLDREQ ");
    builder.append(reg1);
    builder.append(", =msg_");
    builder.append(msgNum1);
    builder.append("\n\t\tBLEQ p_throw_runtime_error\n\t\tPOP {pc}\n");
    this.resultBlock = builder.toString();
  }

}

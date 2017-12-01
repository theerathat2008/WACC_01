package InstructionSet.InstructionBlocks.InstructionCheck;

public class InstructionCheckArrayBounds extends InstructionCheck {
  String reg2;
  int msgNum2;

  public InstructionCheckArrayBounds(int msgNum1, int msgNum2) {
    super(msgNum1);
    this.msgNum2 = msgNum2;
    reg1 = "reg1";
    reg2 = "reg2";
    this.blockType = "check_array_bounds";
  }

  /**
   * Assigned string value indicating name of register
   *
   * @param reg1 - first register
   */
  public void allocateRegisters(String reg1, String reg2) {
    this.reg1 = reg1;
    this.reg2 = reg2;
  }

  /**
   * Generates the instruction block as a string for the current instruction
   */
  public void genInstruction() {
    StringBuilder builder = new StringBuilder("");
    builder.append("\tp_check_array_bounds:\n");
    builder.append("\t\tPUSH {lr}\n");
    builder.append("\t\tCMP ");
    builder.append(reg1);
    builder.append(", #0\n\t\tLDRLT ");
    builder.append(reg1);
    builder.append(", =msg_");
    builder.append(msgNum1);
    builder.append("\n\t\tBLLT p_throw_runtime_error\n\t\tLDR ");
    builder.append(reg2);
    builder.append(", [");
    builder.append(reg2);
    builder.append("]\n\t\tCMP ");
    builder.append(reg1);
    builder.append(", ");
    builder.append(reg2);
    builder.append("\n\t\tLDRCS ");
    builder.append(reg1);
    builder.append(", =msg_");
    builder.append(msgNum2);
    builder.append("\n\t\tBLCS p_throw_runtime_error\n\t\tPOP {pc}\n");
    resultBlock = builder.toString();
  }

}

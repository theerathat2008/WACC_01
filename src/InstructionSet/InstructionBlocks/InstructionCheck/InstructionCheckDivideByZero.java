package InstructionSet.InstructionBlocks.InstructionCheck;

public class InstructionCheckDivideByZero extends InstructionCheck {
  String reg2;

  public InstructionCheckDivideByZero(int msgNum) {
    super(msgNum);
    reg1 = "r0";
    reg2 = "r1";
    this.blockType = "check_divide_by_zero";
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
    builder.append("p_check_divide_by_zero:\n\t\tPUSH {lr}\n\t\tCMP ");
    builder.append(reg2);
    builder.append(", #0\n\t\tLDREQ ");
    builder.append(reg1);
    builder.append(", =msg_");
    builder.append(msgNum1);
    builder.append("\n\t\tBLEQ p_throw_runtime_error\n\t\tPOP {pc}\n");
    this.resultBlock = builder.toString();
  }

}

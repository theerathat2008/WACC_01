package InstructionSet.InstructionCheck;

public class InstructionCheckArrayBounds extends InstructionCheck {
  String reg2;
  int msgNum2;

  public InstructionCheckArrayBounds(int msgNum1, int msgNum2) {
    super(msgNum1);
    this.msgNum2 = msgNum2;
    reg1 = "reg1";
    reg2 = "reg2";
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
    builder.append("p_check_array_bounds:\n");
    builder.append("\t\tPUSH {lr}\n");
    builder.append("\t\tCMP " + reg1 + ", #0\n");
    builder.append("\t\tLDRLT " + reg1 + ", =msg_" + msgNum1 + "\n");
    builder.append("\t\tBLLT p_throw_runtime_error\n");
    builder.append("\t\tLDR " + reg2 + ", [" + reg2 + "]\n");
    builder.append("\t\tCMP " + reg1 + ", " + reg2 + "\n");
    builder.append("\t\tLDRCS " + reg1 + ", =msg_" + msgNum2 + "\n");
    builder.append("\t\tBLCS p_throw_runtime_error\n");
    builder.append("\t\tPOP {pc}\n");
    resultBlock = builder.toString();
  }

}

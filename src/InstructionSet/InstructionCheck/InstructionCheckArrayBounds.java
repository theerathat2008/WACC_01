package InstructionSet.InstructionCheck;

public class InstructionCheckArrayBounds extends InstructionCheck {
  String reg2;

  public InstructionCheckArrayBounds(int msgNum) {
    super(msgNum);
  }


  /**
   * Assigned string value indicating name of register
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
    resultBlock.concat("p_check_array_bounds:\n");
    resultBlock.concat("\t\tPUSH {lr}\n");
    resultBlock.concat("\t\tCMP " +  reg1 + ", #0\n");
    resultBlock.concat("\t\tLDRLT " +  reg1 + ", =msg_" + msgNum + "\n");
    resultBlock.concat("\t\tBLLT p_throw_runtime_error\n");
    resultBlock.concat("\t\tLDR " +  reg2 + ", [" + reg2+ "]\n");
    resultBlock.concat("\t\tCMP " +  reg1 + ", "+ reg2 + "\n");
    resultBlock.concat("\t\tBLCS p_throw_runtime_error\n");
    resultBlock.concat("\t\tPOP {pc}\n");
  }

}

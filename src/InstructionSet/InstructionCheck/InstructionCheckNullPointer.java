package InstructionSet.InstructionCheck;

public class InstructionCheckNullPointer extends InstructionCheck {

  public InstructionCheckNullPointer(int msgNum) {
    super(msgNum);
    reg1 = "reg1";
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
    resultBlock.concat("p_check_null_pointer:\n");
    resultBlock.concat("\t\tPUSH {lr}\n");
    resultBlock.concat("\t\tCMP " + reg1 + ", #0\n");
    resultBlock.concat("\t\tLDREQ " + reg1 + ", =msg_" + msgNum + "\n");
    resultBlock.concat("\t\tBLEQ p_throw_runtime_error\n");
    resultBlock.concat("\t\tPOP {pc}\n");
  }

}

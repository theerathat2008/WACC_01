package InstructionSet.InstructionCheck;

public class InstructionCheckDivideByZero extends InstructionCheck {
  String reg2;

  public InstructionCheckDivideByZero(int msgNum) {
    super(msgNum);
    reg1 = "reg1";
    reg2 = "reg2";
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
    resultBlock.concat("p_check_divide_by_zero:\n");
    resultBlock.concat("\t\tPUSH {lr}\n");
    resultBlock.concat("\t\tCMP " +  reg2 + ", #0\n");
    resultBlock.concat("\t\tLDREQ " +  reg1 + ", =msg_" + msgNum + "\n");
    resultBlock.concat("\t\tBLEQ p_throw_runtime_error\n");
    resultBlock.concat("\t\tPOP {pc}\n");
  }

}

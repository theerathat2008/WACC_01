package InstructionSet.InstructionError;

import InstructionSet.Instruction;

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
  }

  public void setOutputMessageNumber(String number) {
    outputMessageNumber = number;
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
    resultBlock.concat("\t\tPUSH {LR}\n");
    resultBlock.concat("\t\tCMP ");
    resultBlock.concat(reg1);
    resultBlock.concat(", #0");
    resultBlock.concat("LDREQ r0, =msg_");
    resultBlock.concat(outputMessageNumber);
    resultBlock.concat("\n\t\tBLEQ p_throw_runtime_error\n");
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

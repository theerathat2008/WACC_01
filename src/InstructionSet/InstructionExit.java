package InstructionSet;

public class InstructionExit extends Instruction {
  String reg1;
  String reg2;
  String exitCode;
  String resultBlock = "";

  public InstructionExit(String exitCode) {
    this.exitCode = exitCode;
  }

  /**
   * Assigned string value indicating name of register
   * @param reg1 - first register
   * @param reg2 - second register
   */
  public void allocateRegisters(String reg1, String reg2) {
    this.reg1 = reg1;
    this.reg2 = reg2;
  }

  @Override
  public void genInstruction() {
    resultBlock.concat("\t\tLDR " +  reg2 + ", =" + exitCode + "\n");
    resultBlock.concat("\t\tMOV " +  reg1 + ", " + reg2 +"\n");
    resultBlock.concat("\t\tBL exit\n");
  }

  @Override
  public int requiresRegisters() {
    return 0;
  }

  @Override
  public boolean crossOverRegister() {
    return false;
  }

}

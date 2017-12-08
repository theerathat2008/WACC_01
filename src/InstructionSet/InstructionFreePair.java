package InstructionSet;

public class InstructionFreePair extends Instruction {
  String reg1;
  String reg2;
  String resultBlock = "";

  /**
   * Set and replace the value of sp
   */
  public void allocateSP() {
  }

  /**
   * Assigned string value indicating name of register
   * @param reg1
   * @param reg2
   */
  public void allocateRegisters(String reg1, String reg2) {
    this.reg1 = reg1;
    this.reg2 = reg2;
  }

  /**
   * Generates the instruction block as a string for the current instruction
   */
  @Override
  public void genInstruction() {
    resultBlock.concat("\t\tMOV " + reg1 + ", " + reg2 + "\n");
    resultBlock.concat("\t\tBL p_free_pair\n");
  }

  /**
   * @return Return the resultBlock attribute
   */
  public String getResultBlock() {
    return resultBlock;
  }

}

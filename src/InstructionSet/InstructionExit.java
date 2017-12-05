package InstructionSet;

import Registers.RegisterARM;

public class InstructionExit extends Instruction {
  String reg1;
  String reg2;
  //String exitCode;
  String resultBlock;

  public String getResultBlock() {
    return resultBlock;
  }

  public InstructionExit() {
    //this.exitCode = exitCode;
    this.resultBlock = "";
    reg1 = "reg1";
    reg2 = "src";
  }

  /**
   * Assigned string value indicating name of register
   *
   * @param reg1 - first register
   * @param reg2 - second register
   */
  public void allocateRegisters(RegisterARM reg1, RegisterARM reg2) {
    this.reg1 = reg1.name();
    this.reg2 = reg2.name();
  }

  @Override
  public void genInstruction() {
    //resultBlock.concat("\t\tLDR " +  src + ", =" + exitCode + "\n");

    StringBuilder block1 = new StringBuilder();
    block1.append("\t\tMOV ");
    block1.append(reg1);
    block1.append(", ");
    block1.append(reg2);
    block1.append("\n");
    block1.append("\t\tBL exit\n");
    resultBlock = block1.toString();

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

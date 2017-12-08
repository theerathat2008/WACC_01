package InstructionSet;

import Registers.RegisterARM;

public class InstructionExit extends Instruction {
  String reg1;
  String reg2;
  String resultBlock;

  /**
   * Class constructor
   */
  public InstructionExit() {
    this.resultBlock = "";
    reg1 = "reg1";
    reg2 = "src";
  }

  /**
   * Assigned string value indicating name of register
   * @param reg1 - first register
   * @param reg2 - second register
   */
  public void allocateRegisters(RegisterARM reg1, RegisterARM reg2) {
    this.reg1 = reg1.name();
    this.reg2 = reg2.name();
  }

  /**
   * Generates the instruction block as a string for the current instruction
   */
  @Override
  public void genInstruction() {

    StringBuilder block1 = new StringBuilder();
    block1.append("\t\tMOV ");
    block1.append(reg1);
    block1.append(", ");
    block1.append(reg2);
    block1.append("\n");
    block1.append("\t\tBL exit\n");
    resultBlock = block1.toString();
  }

  /**
   * @return Return the resultBlock attribute
   */
  public String getResultBlock() {
    return resultBlock;
  }

}

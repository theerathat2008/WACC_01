package InstructionSet;

import Registers.RegisterARM;

public class InstructionReturn extends Instruction {
  String reg1;
  String reg2;
  String resultBlock;
  String sp;
  String type;

  /**
   * Class constructor
   * @param type
   */
  public InstructionReturn(String type) {
    this.type = type;
    this.resultBlock = "";
    reg1 = "r0";
    reg2 = "src";
  }

  /**
   * Assigned string value indicating name of register
   * @param reg1
   * @param reg2
   */
  public void allocateRegisters(RegisterARM reg1, RegisterARM reg2) {
    this.reg1 = reg1.name();
    this.reg2 = reg2.name();
  }

  /**
   * Set the sp attribute
   * @param sp
   */
  public void allocateSP(String sp) {
    this.sp = sp;
  }

  /**
   * Generates the instruction block as a string for the current instruction
   */
  @Override
  public void genInstruction() {
    StringBuilder block = new StringBuilder();
    block.append("\t\tMOV ");
    block.append(reg1);
    block.append(", ");
    block.append(reg2);
    block.append("\n");
    resultBlock = block.toString();
  }

  /**
   * @return Return the resultBlock attribute
   */
  public String getResultBlock() {
    return resultBlock;
  }

}

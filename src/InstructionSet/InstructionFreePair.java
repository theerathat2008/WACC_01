package InstructionSet;

import Registers.RegisterARM;

public class InstructionFreePair extends Instruction {
  String r0;
  String pairLocReg;
  String resultBlock = "";


  /**
   * Assigned string value indicating name of register
   * @param r0
   * @param pairLocReg
   */
  public void allocateRegisters(RegisterARM r0, RegisterARM pairLocReg) {
    this.r0 = r0.name();
    this.pairLocReg = pairLocReg.name();
  }

  /**
   * Generates the instruction block as a string for the current instruction
   */
  @Override
  public void genInstruction() {
    StringBuilder builder = new StringBuilder();
    builder.append("\t\tMOV ");
    builder.append(r0);
    builder.append(", ");
    builder.append(pairLocReg);
    builder.append("\n\t\tBL p_free_pair\n");
    resultBlock = builder.toString();
  }

  /**
   * @return Return the resultBlock attribute
   */
  public String getResultBlock() {
    return resultBlock;
  }

}

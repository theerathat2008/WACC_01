package InstructionSet;

import Registers.RegisterARM;

public class InstructionAccessPairElem extends Instruction {
  public String getResultBlock() {
    return resultBlock;
  }

  String resultBlock = "";
  String pos;
  String reg1;
  String reg2;

  /**
   * Class constructor
   * @param pos
   */
  public InstructionAccessPairElem(String pos) {
    this.pos = pos;
    this.reg1 = "r0";
    this.reg2 = "tempReg";

  }

  /**
   * Assigned string value indicating name of register
   * @param reg1
   * @param reg2
   */
  public void allocateRegisters(RegisterARM reg1, RegisterARM reg2) {
    this.reg1 = reg1.name();  //always r0
    this.reg2 = reg2.name();  //
  }

  /**
   * Generates the instruction block as a string for the current instruction
   */
  @Override
  public void genInstruction() {
    StringBuilder builder = new StringBuilder();
    builder.append("\t\tMOV ");
    builder.append(reg1);
    builder.append(", ");
    builder.append(reg2);
    builder.append("\n\t\tBL p_check_null_pointer\n");
    builder.append("\t\tLDR ");
    builder.append(reg2);
    builder.append(", [");
    builder.append(reg2);
    builder.append(", #");
    builder.append(getDisp());
    builder.append("]\n\t\tLDR ");
    builder.append(reg2);
    builder.append(", [");
    builder.append(reg2);
    builder.append("]\n");
    resultBlock = builder.toString();
  }

  /**
   * @return Return display string
   */
  private String getDisp() {
    if (this.pos.equals("fst")) {
      return "0";
    } else if (this.pos.equals("snd")) {
      return "4";
    }
    return "UNDEFINED PAIRPOS IN GETDISP IN InstructionDeclAssPairElem";
  }
}
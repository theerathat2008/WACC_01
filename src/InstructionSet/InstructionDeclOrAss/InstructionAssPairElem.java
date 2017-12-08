package InstructionSet.InstructionDeclOrAss;

import InstructionSet.Instruction;
import Registers.RegisterARM;

public class InstructionAssPairElem extends Instruction {

  String resultBlock = "";
  String pos;
  String sp;
  String reg1;
  String pairLocreg;
  String itemreg;

  /**
   * Class constructor
   * @param pos
   */
  public InstructionAssPairElem(String pos) {
    this.pos = pos;
    this.reg1 = "r0";
    this.pairLocreg = "pairLocReg";
    this.sp = "TODOSP";
  }

  /**
   * Set and replace the value of sp
   * @param sp
   */
  public void allocateLocation(String sp) {
    this.sp = sp.replace("[", "").replace("]", "");
  }

  /**
   * Assigned string value indicating name of register
   * @param reg1
   * @param pairLocReg
   * @param itemreg
   */
  public void allocateRegisters(RegisterARM reg1, RegisterARM pairLocReg, RegisterARM itemreg) {
    this.reg1 = reg1.name();  //always r0
    this.pairLocreg = pairLocReg.name();
    this.itemreg = itemreg.name();
  }

  /**
   * @return Return the resultBlock attribute
   */
  public String getResultBlock() {
    return resultBlock;
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
    builder.append(pairLocreg);
    builder.append("\n\t\tBL p_check_null_pointer\n");
    builder.append("\t\tLDR ");
    builder.append(pairLocreg);
    builder.append(", [");
    builder.append(pairLocreg);
    builder.append(", #");
    builder.append(getDisp());
    builder.append("]\n\t\tSTR ");
    builder.append(itemreg);
    builder.append(", [");
    builder.append(pairLocreg);
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
    return "UNDEFINED PAIRPOS IN GETDISP IN InstructionAssPairElem";
  }

}

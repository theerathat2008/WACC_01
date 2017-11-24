package InstructionSet.InstructionDeclOrAss;

import InstructionSet.Instruction;
import Registers.RegisterARM;

public class InstructionDeclAssChar extends Instruction {
  String resultBlock;
  String reg;
  //String charData;
  String sp;

  /**
   * Class constructor calls super constructor
   */
  public InstructionDeclAssChar(){//String charData) {
    //this.charData = charData;
  }

  public void allocateSP(String sp) {
    this.sp = sp;
    reg = "reg";
  }

  /**
   * Assigned string value indicating name of register
   * @param reg - first register
   */
  public void allocateRegisters(RegisterARM reg) {
    this.reg = reg.name();
  }

  /**
   * Generates the instruction block as a string for the current instruction
   */
  public void genInstruction() {
    //resultBlock.concat("\t\tMOV " + reg + ", #'" + charData + "'\n");
    StringBuilder builder = new StringBuilder();
    builder.append("\t\tSTRB ");
    builder.append(reg);
    builder.append(", [");
    builder.append(sp);
    builder.append("]\n");
    resultBlock = builder.toString();
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

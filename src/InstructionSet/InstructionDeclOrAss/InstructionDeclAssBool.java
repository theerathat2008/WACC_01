package InstructionSet.InstructionDeclOrAss;

import InstructionSet.Instruction;
import Registers.RegisterARM;

public class InstructionDeclAssBool extends Instruction {
  String resultBlock;
  String reg1;
  //String boolData;
  String sp;

  /**
   * Class constructor calls super constructor
   */

  //public InstructionDeclAssBool(){//String boolData) {
  //this.boolData = boolData;
  public InstructionDeclAssBool() {//String boolData, String sp) {
    //this.boolData = boolData;
    //this.sp = sp;
    reg1 = "regR0";

  }

  public int getBoolNum(String bool) {
    if (bool.equals("true")) {
      return 1;
    }
    return 0;
  }

  public void allocateSP(String sp) {
    this.sp = sp;
  }

  /**
   * Assigned string value indicating name of register
   *
   * @param reg1 - first register
   */
  public void allocateRegisters(RegisterARM reg1) {
    this.reg1 = reg1.name();
  }

  /**
   * Generates the instruction block as a string for the current instruction
   */
  public void genInstruction() {
    // resultBlock.concat("\t\tMOV " +  regR0 + ", #" + getBoolNum(boolData) + "\n");
    StringBuilder builder = new StringBuilder();
    builder.append("\t\tSTRB ");
    builder.append(reg1);
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

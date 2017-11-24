package InstructionSet.InstructionDeclOrAss;

import InstructionSet.Instruction;
import Registers.RegisterARM;

public class InstructionDeclAssInt extends Instruction {
  String resultBlock;
  String reg;
  String sp;
  //String intData;

  /**
   * Class constructor calls super constructor
   */
  public InstructionDeclAssInt() {//String intData) {
    //this.intData = intData;
  }

  public void allocateSP(String sp) {
    this.sp = sp;
    //this.intData = intData;
    reg = "reg";

  }

  /**
   * Assigned string value indicating name of register
   *
   * @param reg - first register
   */
  public void allocateRegisters(RegisterARM reg) {
    this.reg = reg.name();
  }

  /**
   * Generates the instruction block as a string for the current instruction
   */
  public void genInstruction() {
    //resultBlock.concat("\t\tLDR " +  reg + ", =" + intData + "\n");
    StringBuilder builder = new StringBuilder();
    builder.append("\t\tSTR ");
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
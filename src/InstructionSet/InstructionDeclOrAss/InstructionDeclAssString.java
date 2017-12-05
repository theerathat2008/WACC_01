package InstructionSet.InstructionDeclOrAss;

import InstructionSet.Instruction;
import Registers.RegisterARM;

public class InstructionDeclAssString extends Instruction {
  String resultBlock;
  String reg1;
  //int msgNum;
  String sp;

  /**
   * Class constructor calls super constructor
   *
   * @param msgNum - Indicates the ID of the message to be stored
   */
  public InstructionDeclAssString() {//int msgNum) {
    //this.msgNum = msgNum;
  }

  public void allocateSP(String sp) {
    this.sp = sp;
    reg1 = "regR0";
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
    //resultBlock.concat("\t\tLDR " + regR0 + ", =msg_" + msgNum + "\n");
    StringBuilder builder = new StringBuilder();
    builder.append("\t\tSTR ");
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


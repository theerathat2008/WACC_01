package InstructionSet.InstructionDeclOrAss;

import InstructionSet.Instruction;
import Registers.RegisterARM;

public class InstructionDeclAssBool extends Instruction {
  String resultBlock;
  String reg1;
  String sp;

  /**
   * Class constructor calls super constructor
   */
  public InstructionDeclAssBool() {
    reg1 = "regR0";

  }

  /**
   * @param bool
   * @return Return int value of bool
   */
  public int getBoolNum(String bool) {
    if (bool.equals("true")) {
      return 1;
    }
    return 0;
  }

  /**
   * Set and replace the value of sp
   * @param sp
   */
  public void allocateSP(String sp) {
    this.sp = sp;
  }

  /**
   * Assigned string value indicating name of register
   * @param reg1 - first register
   */
  public void allocateRegisters(RegisterARM reg1) {
    this.reg1 = reg1.name();
  }

  /**
   * Generates the instruction block as a string for the current instruction
   */
  public void genInstruction() {
    StringBuilder builder = new StringBuilder();
    builder.append("\t\tSTRB ");
    builder.append(reg1);
    builder.append(", [");
    builder.append(sp);
    builder.append("]\n");
    resultBlock = builder.toString();
  }
}

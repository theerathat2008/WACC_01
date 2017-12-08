package InstructionSet.InstructionDeclOrAss;

import InstructionSet.Instruction;
import Registers.RegisterARM;

public class InstructionDeclAssString extends Instruction {
  String resultBlock;
  String reg1;
  String sp;

  /**
   * Class constructor calls super constructor
   */
  public InstructionDeclAssString() {
  }

  /**
   * Set and replace the value of sp
   * @param sp
   */
  public void allocateSP(String sp) {
    this.sp = sp;
    reg1 = "regR0";
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
    builder.append("\t\tSTR ");
    builder.append(reg1);
    builder.append(", [");
    builder.append(sp);
    builder.append("]\n");
    resultBlock = builder.toString();
  }
}


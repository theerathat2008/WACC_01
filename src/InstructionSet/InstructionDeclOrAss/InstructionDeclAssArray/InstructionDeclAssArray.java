package InstructionSet.InstructionDeclOrAss.InstructionDeclAssArray;

import InstructionSet.Instruction;
import Registers.RegisterARM;

public abstract class InstructionDeclAssArray extends Instruction {
  String resultBlock;
  String reg1;
  String reg2;
  String reg3;
  int arraySize;

  protected InstructionDeclAssArray() {

  }

  /**
   * Assigned string value indicating name of register
   * PARAM? TODO
   */
  public void allocateRegisters(RegisterARM reg1, RegisterARM reg2, RegisterARM reg3) {
    this.reg1 = reg1.name();
    this.reg2 = reg2.name();
    this.reg3 = reg3.name();
  }

  public abstract String getArrayElems();

  /**
   * Generates the instruction block as a string for the current instruction
   */
  public void genInstruction() {
    StringBuilder builder = new StringBuilder();
    builder.append("\t\tLDR ");
    builder.append(reg1);
    builder.append(", =");
    builder.append((4*(arraySize + 1)));
    builder.append("\n\t\tBL malloc\n\t\tMOV ");
    builder.append(reg2);
    builder.append(", ");
    builder.append(reg1);
    builder.append("\n");
    builder.append(getArrayElems());
    builder.append("\t\tLDR ");
    builder.append(reg3);
    builder.append(", =");
    builder.append(arraySize);
    builder.append("\n\t\tSTR ");
    builder.append(reg3);
    builder.append(", [");
    builder.append(reg2);
    builder.append("]\n\t\tSTR ");
    builder.append(reg3);
    builder.append(", [sp]\n");
    resultBlock = builder.toString();
  }

}

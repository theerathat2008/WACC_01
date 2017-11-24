package InstructionSet.InstructionDeclOrAss.InstructionAssArrayElem;

import InstructionSet.Instruction;
import Registers.RegisterARM;

public abstract class InstructionAssArrayElem extends Instruction {
  String ResultBlock;
  String reg1;
  String reg2;
  String reg3;
  String reg4;
  String reg5;
  String spDisp;
  String pos;
  String data;

  public InstructionAssArrayElem(String spDisp, String posInArray, String data) {
    this.pos = posInArray;
    this.spDisp = spDisp;
    this.data = data;
    this.reg1 = "reg1";
    this.reg2 = "reg2";
    this.reg3 = "reg3";
    this.reg4 = "reg4";
    this.reg5 = "reg5";
  }

  public void allocateRegisters(RegisterARM reg1, RegisterARM reg2, RegisterARM reg3, RegisterARM reg4,
                                RegisterARM reg5) {
    this.reg1 = reg1.name();
    this.reg2 = reg2.name();
    this.reg3 = reg3.name();
    this.reg4 = reg4.name();
    this.reg5 = reg5.name();
  }

  public abstract String getLoadData();

  public abstract String getSTRLast();
//  r0   r1   r4   r5   r6
  //reg1 reg2 reg3 reg4 reg5

  @Override
  public void genInstruction() {
    StringBuilder builder = new StringBuilder();
    builder.append(getLoadData());
    builder.append("\t\tADD ");
    builder.append(reg4);
    builder.append(", sp #");
    builder.append(spDisp);
    builder.append("\n\t\tLDR ");
    builder.append(reg5);
    builder.append(", =");
    builder.append(pos);
    builder.append("\n\t\tLDR ");
    builder.append(reg4);
    builder.append(", [");
    builder.append(reg4);
    builder.append("]\n\t\tMOV ");
    builder.append(reg1);
    builder.append(", ");
    builder.append(reg5);
    builder.append("\n\t\tMOV ");
    builder.append(reg2);
    builder.append(", ");
    builder.append(reg4);
    builder.append("\n\t\tBL p_check_array_bounds\n\t\tADD ");
    builder.append(reg4);
    builder.append(", ");
    builder.append(reg4);
    builder.append(", #4\n");
    builder.append(getSTRLast());
    ResultBlock = builder.toString();
  }

  @Override
  public int requiresRegisters() {
    return 5;
  }

  @Override
  public boolean crossOverRegister() {
    return false;
  }

}

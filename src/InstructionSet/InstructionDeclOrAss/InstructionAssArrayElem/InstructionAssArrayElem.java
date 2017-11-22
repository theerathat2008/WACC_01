package InstructionSet.InstructionDeclOrAss.InstructionAssArrayElem;

import InstructionSet.Instruction;

public abstract class InstructionAssArrayElem extends Instruction {
  String resultBlock = "";
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
  }

  public void allocateRegisters(String reg1, String reg2, String reg3, String reg4, String reg5) {
    this.reg1 = reg1;
    this.reg2 = reg2;
    this.reg3 = reg3;
    this.reg4 = reg4;
    this.reg5 = reg5;
  }

  public abstract String getLoadData();
  public abstract String getSTRLast();
//  r0   r1   r4   r5   r6
  //reg1 reg2 reg3 reg4 reg5

  @Override
  public void genInstruction() {
    resultBlock.concat(getLoadData());
    resultBlock.concat("\t\tADD " +  reg4 + ", sp #" + spDisp + "\n");
    resultBlock.concat("\t\tLDR " +  reg5 + ", =" + pos + "\n");
    resultBlock.concat("\t\tLDR " +  reg4 + ", [" + reg4 + "]\n");
    resultBlock.concat("\t\tMOV " +  reg1 + ", " + reg5 + "\n");
    resultBlock.concat("\t\tMOV " +  reg2 + ", " + reg4 + "\n");
    resultBlock.concat("\t\tBL p_check_array_bounds\n");
    resultBlock.concat("\t\tADD " +  reg4 + ", " + reg4 + ", #4" + "\n");
    resultBlock.concat(getSTRLast());
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

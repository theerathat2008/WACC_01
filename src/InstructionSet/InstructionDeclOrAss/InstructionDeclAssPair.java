package InstructionSet.InstructionDeclOrAss;

import InstructionSet.Instruction;
import Registers.RegisterARM;

public class InstructionDeclAssPair extends Instruction {
  String reg1;
  String reg2;
  String reg3;
  String block1 = "";
  String block2 = "";
  String block3 = "";
  String firstType;
  String secondType;
  String firstElem;
  String secondElem;
  String sp1;
  String sp2;

  public InstructionDeclAssPair(String firstType, String secondType, String firstElem, String secondElem) {
    this.firstType = firstType;
    this.secondType = secondType;
    this.firstElem = firstElem;
    this.secondElem = secondElem;
    reg1 = "regR0";
    reg2 = "memoryAddressReg";
    reg3 = "interTempReg";
  }

  public String getBlock1() {
    return block1;
  }

  public String getBlock2() {
    return block2;
  }

  public String getBlock3() {
    return block3;
  }

  public void allocateRegisters(RegisterARM reg1, RegisterARM reg2, RegisterARM reg3) {
    this.reg1 = reg1.name();
    this.reg2 = reg2.name();
    this.reg3 = reg3.name();
  }

  public void allocateSP(String sp1, String sp2) {
    this.sp1 = sp1;
    this.sp2 = sp2;
  }

  public int getMsgNum() {
    return 12345; //TODO
  }

  public String getElemBlock(String type, String elem) {

    if (type.equals("bool")) {
      return "\t\tMOV " + reg3 + ", #" + getBool() + "\n";
    } else if (type.equals("char")) {
      return "\t\tMOV " + reg3 + ", #'" + elem + "'\n";
    } else if (type.equals("string")) {
      return "\t\tLDR " + reg3 + ", =msg_" + getMsgNum() + "\n";
    } else if (type.equals("int")) {
      return "\t\tLDR " + reg3 + ", =" + elem + "\n";
    } else if (type.equals("array")) {
      return "\t\tLDR " + reg3 + ", [sp, #" + sp1 + "]\n";
    }
    return "FAILED getElemBlock in Instruction New Pair\n";
  }

  //TODO 3 blocks for below?
  public void genInstruction() {
    StringBuilder builder = new StringBuilder();
    builder.append("\t\tLDR ");
    builder.append(reg1);
    builder.append(", =8\n\t\tBL malloc\n\t\tMOV ");
    builder.append(reg2);
    builder.append(", ");
    builder.append(reg1);
    builder.append("\n");
    block1 = builder.toString();

    builder = new StringBuilder();
//    builder.append(getElemBlock(firstType, firstElem));  //maybe, not sure if this is intended use of this function
    builder.append("\t\tLDR ");
    builder.append(reg1);
    builder.append(", =");
    builder.append(getTypeInt());
    builder.append("\n\t\tBL malloc\n\t\tSTR ");
    builder.append(reg3);
    builder.append(", [");
    builder.append(reg1);
    builder.append("]\n\t\tSTR ");
    builder.append(reg1);
    builder.append(", [");
    builder.append(reg2);
    builder.append("]\n");
    block2 = builder.toString();

    builder = new StringBuilder();
//    builder.append(getElemBlock(secondType, secondElem)); //maybe, not sure if this is intended use of this function
    builder.append("\t\tLDR ");
    builder.append(reg1);
    builder.append(", =");
    builder.append(getTypeInt());
    builder.append("\n\t\tBL malloc\n\t\tSTR ");
    builder.append(reg3);
    builder.append(", [");
    builder.append(reg1);
    builder.append("]\n\t\tSTR ");
    builder.append(reg1);
    builder.append(", [");
    builder.append(reg2);
    builder.append(", #4]\n\t\tSTR ");
    builder.append(reg2);
    builder.append(", [sp, #");
    builder.append(sp2);
    builder.append("]\n");
    block3 = builder.toString();

//    resultBlock.concat("\t\tLDR " +  regR0 + ", =8" + "\n");
//    resultBlock.concat("\t\tBL malloc\n");
//    resultBlock.concat("\t\tMOV " +  memoryAddressReg + ", " + regR0 + "\n");
//    getElemBlock(firstType, firstElem);
//    resultBlock.concat("\t\tLDR " +  regR0 + ", =" + getTypeInt() + "\n");
//    resultBlock.concat("\t\tBL malloc\n");
//    resultBlock.concat("\t\tSTR " +  interTempReg + ", [" +  regR0 + "]\n");
//    resultBlock.concat("\t\tSTR " +  regR0 + ", [" +  memoryAddressReg + "]\n");
//    getElemBlock(secondType, secondElem);
//    resultBlock.concat("\t\tLDR " +  regR0 + ", =" + getTypeInt() + "\n");
//    resultBlock.concat("\t\tBL malloc\n");
//    resultBlock.concat("\t\tSTR " +  interTempReg + ", [" +  regR0 + "]\n");
//    resultBlock.concat("\t\tSTR " +  regR0 + ", [" +  memoryAddressReg + ", #4]\n");
//    resultBlock.concat("\t\tSTR " +  memoryAddressReg + ", [sp, #" + sp2 + "]\n");
  }

  @Override
  public int requiresRegisters() {
    return 3;
  }

  @Override
  public boolean crossOverRegister() {
    return false;
  }

  public int getTypeInt() {
    if (this.firstType.equals("bool") || this.firstType.equals("char")) {
      return 1;
    }
    return 4;
  }

  public int getBool() {
    if (this.firstElem.equals("true")) {
      return 1;
    }
    return 0;
  }
}

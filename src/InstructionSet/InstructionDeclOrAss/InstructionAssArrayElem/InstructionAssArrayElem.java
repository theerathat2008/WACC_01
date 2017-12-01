package InstructionSet.InstructionDeclOrAss.InstructionAssArrayElem;

import InstructionSet.Instruction;
import Registers.RegisterARM;

public class InstructionAssArrayElem extends Instruction {
  String resultBlock1;
  String resultBlock2;
  String resultBlock3;
  String reg1;
  String reg2;
  String reg3;
  String reg4;
  String reg5;
  String pos;
  //String data;
  String type;

  public InstructionAssArrayElem(String posInArray, String type) {//}, String data, String type) {
    this.type = type;
    this.pos = posInArray;
    //this.data = data;
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

  public String getResultBlock1() {
    return resultBlock1;
  }

  public String getResultBlock2() {
    return resultBlock2;
  }

  public String getResultBlock3() {
    return resultBlock3;
  }

  public int getBoolNum(String s) {
    if (s.equals("true")) {
      return 1;
    }
    return 0;
  }

  public String getSTRLast(){
    switch (type) {
      case ("int"):
      case ("string"):
        return "\t\tADD " + reg4 + ", " + reg4 + ", " + reg5
                + ", LSL #2" + "\n\t\tLDR " + reg3 + ", [" + reg4 + "]\n";
      case ("bool"):
      case ("char"):
        return "\t\tADD " + reg4 + ", " + reg4 + ", " + reg5
                + "\n\t\tLDRSB " + reg3 + ", " + "[" + reg4 + "]\n";
    }

    return "Unrecognised type, instrassarrayelem->getStrlast\n";
  }

  @Override
  public void genInstruction() {
    StringBuilder builder = new StringBuilder();
    //builder.append(getLoadData());
    builder.append("\t\tADD ");
    builder.append(reg4);
    builder.append(", sp #0");
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
    resultBlock1 = builder.toString();
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











/*
  public String getLoadData(){
    switch (type) {
      case ("int"):
        return "\t\tMOV " + reg3 + ", =" + data + "\n";
      case ("string"):
        return "\t\tMOV " + reg3 + ", =msg_" + data + "\n";
      case ("bool"):
        return "\t\tMOV " + reg3 + ", #" + getBoolNum(data) + "\n";
      case ("char"):
        return "\t\tMOV " + reg3 + ", #'" + data + "'\n";
    }

    return "Unrecognised type, instrassarrayelem->getLoaddata\n";
  }
*/


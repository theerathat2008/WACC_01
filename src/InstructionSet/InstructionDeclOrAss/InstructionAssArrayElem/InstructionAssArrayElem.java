package InstructionSet.InstructionDeclOrAss.InstructionAssArrayElem;

import InstructionSet.Instruction;
import Registers.RegisterARM;

public class InstructionAssArrayElem extends Instruction {
  String resultBlock1;
  String regR0;
  String regR1;
  String reg4;
  String reg3;
  String posReg;
  String pos;
  //String data;
  String type;
  String arrayLocationReg;

  public InstructionAssArrayElem(String posInArray, String type) {
    this.type = type;
    this.pos = posInArray;
    this.regR0 = "arrayBoundReg1";
    this.regR1 = "regR1";
    this.reg3 = "reg3";
    this.reg4 = "reg4";
    this.posReg = "posReg";
  }

  public void allocateRegisters(RegisterARM regR0, RegisterARM regR1, RegisterARM reg3, RegisterARM reg4,
                                RegisterARM posReg, RegisterARM arrayLocation) {
    this.regR0 = regR0.name(); //always r0
    this.regR1 = regR1.name(); //always r1
    this.reg3 = reg3.name(); //any free reg
    this.reg4 = reg4.name(); //any free reg
    this.posReg = posReg.name(); //any free reg
    this.arrayLocationReg = arrayLocation.name(); //position of array - EITHER sp or reg in which array is stored
  }

  public String getResultBlock1() {
    return resultBlock1;
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
        return "\t\tADD " + reg4 + ", " + reg4 + ", " + posReg
                + ", LSL #2" + "\n\t\tLDR " + reg3 + ", [" + reg4 + "]\n";
      case ("bool"):
      case ("char"):
        return "\t\tADD " + reg4 + ", " + reg4 + ", " + posReg
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
    builder.append(", " + arrayLocationReg + ", #0");
    builder.append("\n\t\tLDR ");
    builder.append(posReg);
    builder.append(", =");
    builder.append(pos);
    builder.append("\n\t\tLDR ");
    builder.append(reg4);
    builder.append(", [");
    builder.append(reg4);
    builder.append("]\n\t\tMOV ");
    builder.append(regR0);
    builder.append(", ");
    builder.append(posReg);
    builder.append("\n\t\tMOV ");
    builder.append(regR1);
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


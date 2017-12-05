package InstructionSet.InstructionDeclOrAss.InstructionAssArrayElem;

import InstructionSet.Instruction;
import Registers.RegisterARM;

public class InstructionAssArrayElem extends Instruction {
  String resultBlock1;
  String regR0;
  String regR1;
  String resultReg;
  String reg3;
  String posReg;
  String pos;
  boolean isStack;
  //String data;
  String type;
  String arrayLocationReg;

  public InstructionAssArrayElem(String posInArray, String type) {
    this.type = type;
    this.pos = posInArray;
    this.regR0 = "arrayBoundReg1";
    this.regR1 = "regR1";
    this.reg3 = "reg3";
    this.resultReg = "resultReg";
    this.posReg = "posReg";
    this.isStack = false;
  }

  public void allocateRegisters(RegisterARM resultReg, RegisterARM posReg) {
    this.regR0 = "r0"; //always r0
    this.regR1 = "r1"; //always r1
    //this.reg3 = reg3.name(); //any free reg
    this.resultReg = resultReg.name(); //any free reg
    this.posReg = posReg.name(); //any free reg
  }

  public void allocateLocation(String arrayLocation, boolean isStack){
    this.isStack = isStack;
    this.arrayLocationReg = arrayLocation;
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
        return "\t\tADD " + resultReg + ", " + resultReg + ", " + posReg
                + ", LSL #2" + "\n\t\tLDR " + resultReg + ", [" + resultReg + "]\n";
      case ("bool"):
      case ("char"):
        return "\t\tADD " + resultReg + ", " + resultReg + ", " + posReg
                + "\n\t\tLDRSB " + resultReg + ", " + "[" + resultReg + "]\n";
    }

    return "Unrecognised type, instrassarrayelem->getStrlast\n";
  }


  //ArrayLocationReg is the memory address of the array variable
  //posReg is just a temp reg
  //resultReg is just temp reg and holds the final result i.e. the value at the array index

  @Override
  public void genInstruction() {
    StringBuilder builder = new StringBuilder();
    //builder.append(getLoadData());

    //You want pointer to the memory heap location to be in resultReg
    //In arrayLocationReg we have the either reg   = memory heap address (r4)
    //                                       stack = memory heap address ([sp, #8])

    if(isStack){
      builder.append("\t\tADD ");
      builder.append(resultReg);
      builder.append(", ");
      int displacement = Integer.parseInt(arrayLocationReg.replaceAll("[\\D]", ""));
      builder.append("sp");
      builder.append(", #"+ displacement + "\n");
    } else {
      builder.append("\t\tMOV ");
      builder.append(resultReg);
      builder.append(", ");
      System.out.println("ARRAY LOCATION IS :  " + arrayLocationReg);
      builder.append(arrayLocationReg);
      builder.append("\n");
    }
    builder.append("\t\tLDR ");
    builder.append(posReg);
    builder.append(", =");
    builder.append(pos);
    builder.append("\n\t\tLDR ");
    builder.append(resultReg);
    builder.append(", [");
    builder.append(resultReg);
    builder.append("]\n\t\tMOV ");
    builder.append(regR0);
    builder.append(", ");
    builder.append(posReg);
    builder.append("\n\t\tMOV ");
    builder.append(regR1);
    builder.append(", ");
    builder.append(resultReg);
    builder.append("\n\t\tBL p_check_array_bounds\n");
    builder.append("\t\tADD ");
    builder.append(resultReg);
    builder.append(", ");
    builder.append(resultReg);
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


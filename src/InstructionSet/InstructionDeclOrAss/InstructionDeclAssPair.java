package InstructionSet.InstructionDeclOrAss;

import InstructionSet.Instruction;
import Registers.RegisterARM;

public class InstructionDeclAssPair extends Instruction {
  String regR0;
  String tempReg;
  String tempPairAddressReg;
  String block1 = "";
  String block2 = "";
  String block3 = "";
  String firstType;
  String secondType;
  String firstElem;
  String secondElem;
  String finalPairAddressReg;

  /**
   * Class constructor
   * @param firstType
   * @param secondType
   * @param firstElem
   * @param secondElem
   */
  public InstructionDeclAssPair(String firstType, String secondType, String firstElem, String secondElem) {
    this.firstType = firstType;
    this.secondType = secondType;
    this.firstElem = firstElem;
    this.secondElem = secondElem;
    this.regR0 = "regR0";
    this.tempReg = "interReg";
    this.tempPairAddressReg = "tempMemoryAddressReg";
    this.finalPairAddressReg = "memoryLocationOfPair";
  }

  /**
   * @return Return the block1 atribute
   */
  public String getBlock1() {
    return block1;
  }

  /**
   * @return Return the block2 attribute
   */
  public String getBlock2() {
    return block2;
  }

  /**
   * @return Return the block3 attribute
   */
  public String getBlock3() {
    return block3;
  }

  /**
   * Assigned string value indicating name of register
   * @param regR0
   * @param tempReg
   * @param tempPairAddressReg
   */
  public void allocateRegisters(RegisterARM regR0, RegisterARM tempReg, RegisterARM tempPairAddressReg) {
    this.regR0 = regR0.name();
    this.tempReg = tempReg.name();

    // Memory address for pair reg to be stored temporarily -> Any FREE REG
    // Either SP with displacement of where pair variable is stored
    // OR the register name holding the pair variable in the case of (totalvars <= 2)
    this.tempPairAddressReg = tempPairAddressReg.name();
  }

  /**
   * @param elem
   * @return Return the type of the elem
   */
  public String getSTRtype(String elem) {
    switch (elem) {
      case "bool":
      case "char":
        return "STRB ";
      default:
        return "STR ";
    }
  }

  /**
   * Generates the instruction block as a string for the current instruction
   */
  public void genInstruction() {
    StringBuilder builder = new StringBuilder();
    builder.append("\t\tLDR ");
    builder.append(regR0);
    builder.append(", =8\n\t\tBL malloc\n\t\tMOV ");
    builder.append(tempReg);
    builder.append(", ");
    builder.append(regR0);
    builder.append("\n");
    block1 = builder.toString();

    //LDR r5, =10 result of the evaluation of the fst pair
    //r5 is the tempPairAddressReg

    builder = new StringBuilder();
    builder.append("\t\tLDR ");
    builder.append(regR0);
    builder.append(", =");
    builder.append(getTypeInt(firstType));
    builder.append("\n\t\tBL malloc\n\t\t");
    builder.append(getSTRtype(firstType));
    builder.append(tempPairAddressReg);
    builder.append(", [");
    builder.append(regR0);
    builder.append("]\n\t\tSTR ");
    builder.append(regR0);
    builder.append(", [");
    builder.append(tempReg);
    builder.append("]\n");
    block2 = builder.toString();

    //LDR r5, =3 result of the evaluation of the snd pair
    //reusing r5 as the tempPairAddessReg

    builder = new StringBuilder();
    builder.append("\t\tLDR ");
    builder.append(regR0);
    builder.append(", =");
    builder.append(getTypeInt(secondType));
    builder.append("\n\t\tBL malloc\n\t\t");
    builder.append(getSTRtype(secondType));
    builder.append(tempPairAddressReg);
    builder.append(", [");
    builder.append(regR0);
    builder.append("]\n\t\tSTR ");
    builder.append(regR0);
    builder.append(", [");
    builder.append(tempReg);
    builder.append(", #4]\n");
    block3 = builder.toString();
  }

  /**
   * @param elem
   * @return Return the int value of the type
   */
  public int getTypeInt(String elem) {
    if (elem.equals("bool") || elem.equals("char")) {
      return 1;
    }
    return 4;
  }

  /**
   * @return Return the bool value
   */
  public int getBool() {
    if (this.firstElem.equals("true")) {
      return 1;
    }
    return 0;
  }
}

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

  public InstructionDeclAssPair(String firstType, String secondType, String firstElem, String secondElem) {
    this.firstType = firstType;
    this.secondType = secondType;
    this.firstElem = firstElem;
    this.secondElem = secondElem;
    regR0 = "regR0";
    tempReg = "interReg";
    tempPairAddressReg = "tempMemoryAddressReg";
    finalPairAddressReg = "memoryLocationOfPair";
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

  public void allocateRegisters(RegisterARM regR0, RegisterARM tempReg, RegisterARM tempPairAddressReg, String finalPairAddressReg) {
    this.regR0 = regR0.name();                                // Always R0
    this.tempReg = tempReg.name();                            // Any FREE REG
    this.tempPairAddressReg = tempPairAddressReg.name();      // Memory address for pair reg to be stored temporarily -> Any FREE REG
    this.finalPairAddressReg = finalPairAddressReg;           // Either SP with displacement of where pair variable is stored
                                                              // OR the register name holding the pair variable in the case of (totalvars <= 2)
  }
//
//  public int getMsgNum() {
//    return 123456789; //TODO
//  }
//
//  public String getElemBlock(String type, String elem) {
//
//    if (type.equals("bool")) {
//      return "\t\tMOV " + tempPairAddressReg + ", #" + getBool() + "\n";
//    } else if (type.equals("char")) {
//      return "\t\tMOV " + tempPairAddressReg + ", #'" + elem + "'\n";
//    } else if (type.equals("string")) {
//      return "\t\tLDR " + tempPairAddressReg + ", =msg_" + getMsgNum() + "\n";
//    } else if (type.equals("int")) {
//      return "\t\tLDR " + tempPairAddressReg + ", =" + elem + "\n";
//    } else if (type.equals("array")) {
//      return "\t\tLDR " + tempPairAddressReg + ", [sp, #SOMETHING" + "]\n";
//    }
//    return "FAILED getElemBlock in Instruction New Pair\n";
//  }

  public String getSTRtype(String elem) {
    switch (elem) {
      case "bool":
      case "char":
        return "STRB ";
      default:
        return "STR ";
    }
  }


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

    builder = new StringBuilder();
//    builder.append(getElemBlock(firstType, firstElem));  //maybe, not sure if this is intended use of this function
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

    builder = new StringBuilder();
//    builder.append(getElemBlock(secondType, secondElem)); //maybe, not sure if this is intended use of this function
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
    builder.append(", #4]\n\t\tSTR ");
    builder.append(tempReg);
    builder.append(", [");
    builder.append(finalPairAddressReg);
    builder.append("]\n");
    block3 = builder.toString();
  }

  @Override
  public int requiresRegisters() {
    return 3;
  }

  @Override
  public boolean crossOverRegister() {
    return false;
  }

  public int getTypeInt(String elem) {
    if (elem.equals("bool") || elem.equals("char")) {
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

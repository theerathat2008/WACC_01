package InstructionSet.InstructionDeclOrAss;

import InstructionSet.Instruction;

public class InstructionDeclAssPair extends Instruction {
  String reg1;
  String reg2;
  String reg3;
  String resultBlock = "";
  String firstType;
  String secondType;
  String firstElem;
  String secondElem;

  public InstructionDeclAssPair(String firstType, String secondType, String firstElem, String secondElem) {
    this.firstType = firstType;
    this.secondType = secondType;
    this.firstElem = firstElem;
    this.secondElem = secondElem;
  }

  public void allocateRegisters(String reg1, String reg2, String reg3) {
    this.reg1 = reg1;
    this.reg2 = reg2;
    this.reg3 = reg3;
  }

  public String getSP1() {
    return "TODOOOOOOOOOO"; //TODO
  }

  public String getSP2() {
    return "TODOOOOOOOOOO"; //TODO
  }

  public int getMsgNum(){
    return 12345; //TODO
  }

  public String getElemBlock(String type, String elem) {

    if (type.equals("bool")) {
      return "\t\tMOV " + reg3 + ", #"  + getBool() + "\n";
    } else if (type.equals("char")){
      return "\t\tMOV " + reg3 + ", #'"  + elem + "'\n";
    } else if (type.equals("string")){
      return "\t\tLDR " + reg3 + ", =msg_"  + getMsgNum() + "\n";
    } else if (type.equals("int")){
      return "\t\tLDR " + reg3 + ", ="  + elem + "\n";
    } else if (type.equals("array")){
      return "\t\tLDR " + reg3 + ", [sp, #"  + getSP1() + "]\n";
    }
    return "FAILED getElemBlock in Instruction New Pair\n";
  }


  public void genInstruction() {
    resultBlock.concat("\t\tLDR " +  reg1 + ", =8" + "\n");
    resultBlock.concat("\t\tBL malloc\n");
    resultBlock.concat("\t\tMOV " +  reg2 + ", " + reg1 + "\n");
    getElemBlock(firstType, firstElem);
    resultBlock.concat("\t\tLDR " +  reg1 + ", =" + getTypeInt() + "\n");
    resultBlock.concat("\t\tBL malloc\n");
    resultBlock.concat("\t\tSTR " +  reg3 + ", [" +  reg1 + "]\n");
    resultBlock.concat("\t\tSTR " +  reg1 + ", [" +  reg2 + "]\n");
    getElemBlock(secondType, secondElem);
    resultBlock.concat("\t\tLDR " +  reg1 + ", =" + getTypeInt() + "\n");
    resultBlock.concat("\t\tBL malloc\n");
    resultBlock.concat("\t\tSTR " +  reg3 + ", [" +  reg1 + "]\n");
    resultBlock.concat("\t\tSTR " +  reg1 + ", [" +  reg2 + ", #4]\n");
    resultBlock.concat("\t\tSTR " +  reg2 + ", [sp, #" + getSP2() + "]\n");
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

  public int getBool(){
    if (this.firstElem.equals("true")) {
      return 1;
    }
    return 0;
  }
}

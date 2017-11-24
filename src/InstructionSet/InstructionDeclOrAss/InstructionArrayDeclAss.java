package InstructionSet.InstructionDeclOrAss;

import InstructionSet.Instruction;

public class InstructionArrayDeclAss extends Instruction {
  String resultBlock = "";
  String resultBlock1 = "";
  String resultBlock2 = "";
  int arraySize;
  int arrayLength;
  String reg1;
  String reg2;
  String reg3;
  int disp;
  String strType;


  public InstructionArrayDeclAss(int arraySize, int arrayLength, String strType) {
    this.arraySize = arraySize + 4;
    this.arrayLength = arrayLength;
    this.strType = strType;
  }

  public void allocateRegisters(String reg1, String reg2, String reg3) {
    this.reg1 = reg1;
    this.reg2 = reg2;
    this.reg3 = reg3;
  }

  public void setDisp(int disp) {
    this.disp = disp;
  }

  public int getArraySize() {
    return arraySize;
  }

  public String getResultBlock() {
    return resultBlock;
  }

  public String getResultBlock1() {
    return resultBlock1;
  }

  public String getResultBlock2() {
    return resultBlock2;
  }


  @Override
  public void genInstruction() {
    StringBuilder block = new StringBuilder();
    block.append("\t\t" + strType + " " + reg3 + ", [" + reg2 + ", #" + disp + "]\n"); // TODO find num #INT
    resultBlock = block.toString();

    StringBuilder block1 = new StringBuilder();
    block1.append("\t\tLDR " + reg1 + ", =" + arraySize + "\n");
    block1.append("\t\tBL malloc\n");
    block1.append("\t\tMOV " + reg2 + ", " + reg1 + "\n");
    resultBlock1 = block1.toString();

    StringBuilder block2 = new StringBuilder();
    block2.append("\t\tLDR " + reg3 + ", =" + arrayLength + "\n");
    block2.append("\t\tSTR " + reg3 + ", [" + reg2 + "]\n");
    resultBlock2 = block2.toString();
  }

  @Override
  public int requiresRegisters() {
    return 0;
  }

  @Override
  public boolean crossOverRegister() {
    return false;
  }
}

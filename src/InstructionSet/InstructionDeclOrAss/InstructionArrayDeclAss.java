package InstructionSet.InstructionDeclOrAss;

import InstructionSet.Instruction;
import Registers.RegisterARM;

public class InstructionArrayDeclAss extends Instruction {
  String resultBlock = "";
  String resultBlock1 = "";
  String resultBlock2 = "";
  int arraySize;
  int arrayLength;
  String regR0; //Always r0
  String memoryAddressReg;
  String interTempReg;
  int disp;
  String strType;


  public InstructionArrayDeclAss(int arraySize, int arrayLength, String strType) {
    this.arraySize = arraySize + 4;
    this.arrayLength = arrayLength;
    this.strType = strType;
  }

  public void allocateRegisters(RegisterARM dst, RegisterARM inter, RegisterARM memoryAddress) {
    this.regR0 = dst.name();
    this.memoryAddressReg = memoryAddress.name();
    this.interTempReg = inter.name();
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


  /**
   * ResultBlock1
   * LDR r0, =arraySize  where r0 is regR0 a dstReg
   * BL malloc
   * MOV memoryAddressReg, r0  where r4 is memoryAddressReg an intermediateReg
   *
   * Expr evaluation
   * LDR interTempReg, =expressionEvaluation
   *
   * ResultBlock
   * STR interTempReg, [memoryAddressReg, #displacement]
   *
   * ResultBlock2
   * LDR interTempReg, =arrayLength
   * STR interTempReg, [memoryAddressReg]
   *
   */

  @Override
  public void genInstruction() {
    StringBuilder block1 = new StringBuilder();
    block1.append("\t\tLDR " + regR0 + ", =" + arraySize + "\n");
    block1.append("\t\tBL malloc\n");
    block1.append("\t\tMOV " + memoryAddressReg + ", " + regR0 + "\n");
    resultBlock1 = block1.toString();

    StringBuilder block = new StringBuilder();
    block.append("\t\t" + strType + " " + interTempReg + ", [" + memoryAddressReg + ", #" + disp + "]\n");
    resultBlock = block.toString();

    StringBuilder block2 = new StringBuilder();
    block2.append("\t\tLDR " + interTempReg + ", =" + arrayLength + "\n");
    block2.append("\t\tSTR " + interTempReg + ", [" + memoryAddressReg + "]\n");
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

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

  /**
   * Class constructor
   * @param arraySize
   * @param arrayLength
   * @param strType
   */
  public InstructionArrayDeclAss(int arraySize, int arrayLength, String strType) {
    this.arraySize = arraySize + 4;
    this.arrayLength = arrayLength;
    this.strType = strType;
  }

  /**
   * Assigned string value indicating name of register
   * @param dst
   * @param inter
   * @param memoryAddress
   */
  public void allocateRegisters(RegisterARM dst, RegisterARM inter, RegisterARM memoryAddress) {
    this.regR0 = dst.name();
    this.memoryAddressReg = memoryAddress.name();
    this.interTempReg = inter.name();
  }

  /**
   * Set the disp attriubte
   * @param disp
   */
  public void setDisp(int disp) {
    this.disp = disp;
  }

  /**
   * @return Return the size of the array
   */
  public int getArraySize() {
    return arraySize;
  }

  /**
   * @return Return the resultBlock attribute
   */
  public String getResultBlock() {
    return resultBlock;
  }

  /**
   * @return Return the resultBlock1 attribute
   */
  public String getResultBlock1() {
    return resultBlock1;
  }

  /**
   * @return Return the resultBlock2 attribute
   */
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

  /**
   * Generates the instruction block as a string for the current instruction
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
}

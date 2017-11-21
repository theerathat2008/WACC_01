package InstructionSet.InstructionArray;

import InstructionSet.Instruction;

import java.util.List;

public abstract class InstructionArray extends Instruction {
  String resultBlock;
  String reg1;
  String reg2;
  String reg3;
  String type;
  int arraySize;

  public InstructionArray(String type) {
    this.type = type;
  }

  /**
   * Assigned string value indicating name of register
   * PARAM? TODO
   */
  public void allocateRegisters(String reg1, String reg2, String reg3) {
    this.reg1 = reg1;
    this.reg2 = reg2;
    this.reg3 = reg3;
  }

  public abstract String getArrayElem();

  /**
   * Generates the instruction block as a string for the current instruction
   */
  public void genInstruction() {
    resultBlock.concat("\t\tLDR " +  reg1 + ", =" + (4*(arraySize + 1)) + "\n");
    resultBlock.concat("\t\tBL malloc\n");
    resultBlock.concat("\t\tMOV " +  reg2 + ", " + reg1 + "\n");
    resultBlock.concat(getArrayElem());
    resultBlock.concat("\t\tLDR " +  reg3 + ", =" + arraySize + "\n");
    resultBlock.concat("\t\tSTR " +  reg3 + ", " + "[" + reg2 + "]" + "\n");
    resultBlock.concat("\t\tSTR " +  reg3 + ", " + "[sp]" + "\n");
  }
}

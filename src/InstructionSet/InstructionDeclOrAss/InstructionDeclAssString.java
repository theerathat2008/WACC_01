package InstructionSet.InstructionDeclOrAss;

import InstructionSet.Instruction;

public class InstructionDeclAssString extends Instruction {
  String resultBlock;
  String reg1;
  int msgNum;
  String sp;

  /**
   * Class constructor calls super constructor
   *
   * @param msgNum - Indicates the ID of the message to be stored
   */
  public InstructionDeclAssString(int msgNum, String sp) {
    this.msgNum = msgNum;
    this.sp = sp;
  }

  /**
   * Assigned string value indicating name of register
   *
   * @param reg1 - first register
   */
  public void allocateRegisters(String reg1) {
    this.reg1 = reg1;
  }

  /**
   * Generates the instruction block as a string for the current instruction
   */
  public void genInstruction() {
    resultBlock.concat("\t\tLDR " + reg1 + ", =msg_" + msgNum + "\n");
    resultBlock.concat("\t\tSTR " + reg1 + ", [" + sp + "]\n");
  }

  @Override
  public int requiresRegisters() {
    return 1;
  }

  @Override
  public boolean crossOverRegister() {
    return false;
  }

}


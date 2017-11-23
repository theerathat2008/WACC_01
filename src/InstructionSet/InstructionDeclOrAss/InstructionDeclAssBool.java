package InstructionSet.InstructionDeclOrAss;

import InstructionSet.Instruction;

public class InstructionDeclAssBool extends Instruction {
  String resultBlock;
  String reg1;
  //String boolData;
  String sp;

  /**
   * Class constructor calls super constructor
   */
  public InstructionDeclAssBool(){//String boolData) {
    //this.boolData = boolData;
  }

  public int getBoolNum(String bool){
    if (bool.equals("true")) {
      return 1;
    } return 0;
  }

  public void allocateSP(String sp) {
    this.sp = sp;
  }

  /**
   * Assigned string value indicating name of register
   * @param reg1 - first register
   */
  public void allocateRegisters(String reg1) {
    this.reg1 = reg1;
  }

  /**
   * Generates the instruction block as a string for the current instruction
   */
  public void genInstruction() {
   // resultBlock.concat("\t\tMOV " +  reg1 + ", #" + getBoolNum(boolData) + "\n");
    resultBlock.concat("\t\tSTRB " +  reg1 + ", [" + sp + "]\n");
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

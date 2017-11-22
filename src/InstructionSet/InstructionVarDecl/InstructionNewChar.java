package InstructionSet.InstructionVarDecl;

import InstructionSet.Instruction;

public class InstructionNewChar extends Instruction {
  String resultBlock;
  String reg;
  String charData;
  String sp;

  /**
   * Class constructor calls super constructor
   */
  public InstructionNewChar(String charData, String sp) {
    this.charData = charData;
    this.sp = sp;
  }

  /**
   * Assigned string value indicating name of register
   * @param reg - first register
   */
  public void allocateRegisters(String reg) {
    this.reg = reg;
  }

  /**
   * Generates the instruction block as a string for the current instruction
   */
  public void genInstruction() {
    resultBlock.concat("\t\tMOV " + reg + ", #'" + charData + "'\n");
    resultBlock.concat("\t\tSTRB " + reg + ", [" + sp + "]\n");
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

package InstructionSet.InstructionVarDecl;

import InstructionSet.Instruction;

public class InstructionNewInt extends Instruction{
  String resultBlock;
  String reg;
  String sp;
  String intData;

  /**
   * Class constructor calls super constructor
   */
  public InstructionNewInt(String sp, String intData) {
    this.sp = sp;
    this.intData = intData;
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
    resultBlock.concat("\t\tLDR " +  reg + ", =" + intData + "\n");
    resultBlock.concat("\t\tSTR " +  reg + ", [" + sp + "]\n");
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
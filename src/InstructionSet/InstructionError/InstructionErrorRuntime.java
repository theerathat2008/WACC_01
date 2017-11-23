package InstructionSet.InstructionError;

import InstructionSet.Instruction;

public class InstructionErrorRuntime extends Instruction {
  String reg1;
  String resultBlock;
  /**
   * Class constructor
   */
  public InstructionErrorRuntime() {

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
    resultBlock.concat("p_throw_runtime_error:\n");
    resultBlock.concat("\t\tBL p_print_string\n");
    resultBlock.concat("\t\tMOV " +  reg1 + ", #-1\n");
    resultBlock.concat("\t\tBL exit\n");
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

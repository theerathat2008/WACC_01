package InstructionSet.InstructionError;

import InstructionSet.Instruction;


public class InstructionError extends Instruction {

  public String resultBlock;

  @Override
  public void genInstruction() {

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

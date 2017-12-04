package InstructionSet.InstructionBlocks.InstructionError;

import InstructionSet.InstructionBlocks.InstructionBlocks;


public class InstructionError extends InstructionBlocks {

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

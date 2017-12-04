package InstructionSet.InstructionBlocks;

import InstructionSet.Instruction;

public abstract class InstructionBlocks extends Instruction {
  protected String blockType;
  protected String resultBlock;

  public String getResultBlock() {
    return resultBlock;
  }

  public String getBlockType() {
    return blockType;
  }

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

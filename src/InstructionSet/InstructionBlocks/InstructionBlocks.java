package InstructionSet.InstructionBlocks;

import InstructionSet.Instruction;

public abstract class InstructionBlocks extends Instruction {

  protected String blockType;
  protected String resultBlock;

  /**
   * Generates the instruction block as a string for the current instruction
   */
  @Override
  public void genInstruction() {

  }

  /**
   * @return Return resultBlock attribute
   */
  public String getResultBlock() {
    return resultBlock;
  }

  /**
   * @return Return blockType attribute
   */
  public String getBlockType() {
    return blockType;
  }
}

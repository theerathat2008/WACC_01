package InstructionSet;

public class InstructionProgram extends Instruction {

  public String block1;
  public String block2;

  public InstructionProgram() {}


  /**
   * Uses special registers lr(link register) and pc(program counter)
   */

  @Override
  public void genInstruction() {
    StringBuilder builder = new StringBuilder("\t.global main\n");
    builder.append("\tmain:\n");
    builder.append("\t\tPUSH (lr)\n");
    block1 = builder.toString();

    StringBuilder builder2 = new StringBuilder("\t\tLDR r0, =0\n");
    builder2.append("\t\tPOP (pc)\n");
    builder2.append("\t\t.ltorg\n");
    block2 = builder2.toString();
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

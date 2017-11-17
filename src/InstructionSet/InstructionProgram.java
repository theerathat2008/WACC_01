package InstructionSet;

import java.util.List;

public class InstructionProgram extends Instruction {

  public String block1;
  public String block2;

  public InstructionProgram() {}


  @Override
  public void genInstruction(List<Instruction> instructions) {
    StringBuilder builder = new StringBuilder("\t.global main\n");
    builder.append("\tmain:\n");
    builder.append("\t\tPUSH (lr)");
    block1 = builder.toString();

    StringBuilder builder2 = new StringBuilder("\t\tLDR r0, =0\n");
    builder2.append("\t\tPOP (pc)");
    builder2.append("\t\t.ltorg");
    block2 = builder2.toString();
  }
}

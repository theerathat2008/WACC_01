package InstructionSet;

import java.util.List;

public class InstructionFunction extends Instruction {
  String name;
  public String block1;
  public String block2;
  public InstructionFunction(String name) {
    this.name = name;
  }

  @Override
  public void genInstruction(List<Instruction> instructions) {
    StringBuilder builder = new StringBuilder("\t");
    builder.append("f_" + name);
    builder.append("\n");
    builder.append("\t\tPUSH (lr)\n");
    block1 = builder.toString();

    StringBuilder builder2 = new StringBuilder("\t\tPOP (pc)\n");
    builder2.append("\t\t.ltorg\n");
    block2 = builder2.toString();
  }
}

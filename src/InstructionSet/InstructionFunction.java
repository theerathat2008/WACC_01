package InstructionSet;


import Registers.RegisterAllocation;

public class InstructionFunction extends Instruction {
  String name;
  public String block1;
  public String block2;
  RegisterAllocation registerAllocation;

  /**
   * Class construction
   * @param name
   * @param registerAllocation
   */
  public InstructionFunction(String name, RegisterAllocation registerAllocation) {
    this.name = name;
    this.registerAllocation = registerAllocation;
  }

  /**
   * Generates the instruction block as a string for the current instruction
   */
  @Override
  public void genInstruction() {
    StringBuilder builder = new StringBuilder("\t");
    builder.append("f_" + name);
    builder.append(":\n");
    builder.append("\t\tPUSH {lr}\n");

    block1 = builder.toString();

    StringBuilder builder2 = new StringBuilder();

    builder2.append("\t\tPOP {pc}\n");
    builder2.append("\t\t.ltorg\n");
    block2 = builder2.toString();
  }

}

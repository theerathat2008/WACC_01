package InstructionSet;


import Registers.RegisterAllocation;

public class InstructionFunction extends Instruction {
  String name;
  public String block1;
  public String block2;
  RegisterAllocation registerAllocation;

  public InstructionFunction(String name, RegisterAllocation registerAllocation) {
    this.name = name;
    this.registerAllocation = registerAllocation;
  }

  @Override
  public void genInstruction() {
    StringBuilder builder = new StringBuilder("\t");
    builder.append("f_" + name);
    builder.append(":\n");
    builder.append("\t\tPUSH {lr}\n");
    if (registerAllocation.getStackSize() > 0) {
      builder.append("\t\tSUB sp, sp, #");
      builder.append(registerAllocation.getStackSize());
      builder.append("\n");
    }
    block1 = builder.toString();

    StringBuilder builder2 = new StringBuilder();
    if (registerAllocation.getStackSize() > 0) {
      builder2.append("\t\tADD sp, sp, #");
      builder2.append(registerAllocation.getStackSize());
      builder2.append("\n");
    }
    builder2.append("\t\tPOP {pc}\n");
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

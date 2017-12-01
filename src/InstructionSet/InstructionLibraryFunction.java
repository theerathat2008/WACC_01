package InstructionSet;

public class InstructionLibraryFunction extends Instruction {

  private String name;
  private String block1;

  public InstructionLibraryFunction(String name) {
    this.name = name;
  }

  public String getInstruction() {
    return block1;
  }

  @Override
  public void genInstruction() {
    StringBuilder builder = new StringBuilder("\tf_");
    builder.append(name);
    builder.append("\n\t\t");

    if (name.equals("max")) {

    } else if (name.equals("min")) {

    } else if (name.equals("factorial")) {

    } else if (name.equals("avg")) {

    } else if (name.equals("pow")) {

    }

    block1 = builder.toString();
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

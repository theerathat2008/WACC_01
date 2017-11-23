package InstructionSet;

public class InstructionCall extends Instruction{






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

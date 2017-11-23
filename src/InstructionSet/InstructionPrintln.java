package InstructionSet;

public class InstructionPrintln extends Instruction {
  String resultBlock = "";

  public InstructionPrintln() {

  }

  @Override
  public void genInstruction() {
    resultBlock.concat("\t\tBL p_print_ln\n");
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

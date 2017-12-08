package InstructionSet;

public class InstructionPrintln extends Instruction {
  String resultBlock;

  public InstructionPrintln() {
    this.resultBlock = "";
  }

  public String getResultBlock() {
    return resultBlock;
  }

  @Override
  public void genInstruction() {

    resultBlock = "\t\tBL p_print_ln\n";
  }

}

package InstructionSet;

public class InstructionPrintln extends Instruction {
  String resultBlock;

  /**
   * Class construction
   */
  public InstructionPrintln() {
    this.resultBlock = "";
  }

  /**
   * Generates the instruction block as a string for the current instruction
   */
  @Override
  public void genInstruction() {

    resultBlock = "\t\tBL p_print_ln\n";
  }

  /**
   * @return Return the resultBlock attribute
   */
  public String getResultBlock() {
    return resultBlock;
  }

}

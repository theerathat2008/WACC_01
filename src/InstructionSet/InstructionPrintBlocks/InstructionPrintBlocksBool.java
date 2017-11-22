package InstructionSet.InstructionPrintBlocks;

/**
 * Instruction class for printing boolean expressions
 */
public class InstructionPrintBlocksBool extends InstructionPrintBlocks {
  int msgNum2;

  /**
   * Class constructor calls super constructor
   * @param msgNum1 - Indicates the ID of the message to be output
   * @param msgNum2 - Indicates the ID of the message to be output
   * "true\0" AND "false\0" should be added and looked up in stringMap
   * @param msgNum1 = trueID
   * @param msgNum2 = falseID
   */
  public InstructionPrintBlocksBool(int msgNum1, int msgNum2) {
    super(msgNum1);
    this.msgNum2 = msgNum2;
  }

  /**
   * Assigned string value indicating name of register
   * @param reg1 - first register
   */
  public void allocateRegisters(String reg1) {
    this.reg1 = reg1;
  }

  /**
   * Generates the instruction block as a string for the current instruction
   */
  public void genInstruction() {
    resultBlock.concat("p_print_bool:\n");
    resultBlock.concat("\t\tPUSH {lr}\n");
    resultBlock.concat("\t\tCMP " +  reg1 + ", #0\n");
    resultBlock.concat("\t\tLDRNE " +  reg1 + ", =msg_" + msgNum1 + "\n");
    resultBlock.concat("\t\tLDREQ " +  reg1 + ", =msg_" + msgNum2 + "\n");
    resultBlock.concat("\t\tADD " +  reg1 + ", " +  reg1 + ", #4\n");
    resultBlock.concat("\t\tBL printf\n");
    resultBlock.concat("\t\tMOV " +  reg1 + ", #0\n");
    resultBlock.concat("\t\tBL fflush\n");
    resultBlock.concat("\t\tPOP {pc}\n");
  }
}

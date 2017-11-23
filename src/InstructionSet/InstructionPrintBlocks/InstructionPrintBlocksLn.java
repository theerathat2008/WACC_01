package InstructionSet.InstructionPrintBlocks;

/**
 * Instruction class for printing whole lines
 */
public class InstructionPrintBlocksLn extends InstructionPrintBlocks {

  /**
   * Class constructor calls super constructor
   * @param msgNum1 - Indicates the ID of the message to be output
   */
  public InstructionPrintBlocksLn(int msgNum1) {
    super(msgNum1);
    reg1 = "reg1";
  }

  /**
   * Assigned string value indicating name of register
   * @param reg1 - first register
   * "\0" should be added and looked up in stringMap
   */
  public void allocateRegisters(String reg1) {
    this.reg1 = reg1;
  }

  /**
   * Generates the instruction block as a string for the current instruction
   */
  public void genInstruction() {
    resultBlock.concat("p_print_ln:\n");
    resultBlock.concat("\t\tPUSH {lr}\n");
    resultBlock.concat("\t\tLDR " +  reg1 + ", =msg_" + msgNum1 + "\n");
    resultBlock.concat("\t\tADD " +  reg1 + ", " +  reg1 + ", #4\n");
    resultBlock.concat("\t\tBL puts\n");
    resultBlock.concat("\t\tMOV " +  reg1 + ", #0\n");
    resultBlock.concat("\t\tBL fflush\n");
    resultBlock.concat("\t\tPOP {pc}\n");
  }

}

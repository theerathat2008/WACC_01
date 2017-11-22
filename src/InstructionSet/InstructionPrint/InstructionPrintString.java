package InstructionSet.InstructionPrint;

/**
 * Instruction class for printing string expressions
 */
public class InstructionPrintString extends InstructionPrint {
  String reg2;
  String reg3;

  /**
   * Class constructor calls super constructor
   * @param msgNum1 - Indicates the ID of the message to be output
   * "%.*s\0" should be added and looked up in stringMap
   */
  public InstructionPrintString(int msgNum1) {
    super(msgNum1);
  }

  /**
   * Assigned string value indicating name of register
   * @param reg1 - first register
   * @param reg2 - second register
   * @param reg3 - third register
   */
  public void allocateRegisters(String reg1, String reg2, String reg3) {
    this.reg1 = reg1;
    this.reg2 = reg2;
    this.reg3 = reg3;
  }

  /**
   * Generates the instruction block as a string for the current instruction
   */
  public void genInstruction() {
    resultBlock.concat("p_print_string:\n");
    resultBlock.concat("\t\tPUSH {lr}\n");
    resultBlock.concat("\t\tLDR " +  reg2 + ", [" +  reg1 + "]\n");
    resultBlock.concat("\t\tADD " +  reg3 + ", " +  reg1 + ", #4\n");
    resultBlock.concat("\t\tLDR " +  reg1 + ", =msg_" + msgNum1 + "\n");
    resultBlock.concat("\t\tADD " +  reg1 + ", " +  reg1 + ", #4\n");
    resultBlock.concat("\t\tBL printf\n");
    resultBlock.concat("\t\tMOV " +  reg1 + ", #0\n");
    resultBlock.concat("\t\tBL fflush\n");
    resultBlock.concat("\t\tPOP {pc}\n");
  }




}

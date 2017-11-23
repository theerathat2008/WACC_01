package InstructionSet.InstructionReadBlocks;

/**
 * Instruction class for printing int expressions
 */
public class InstructionReadBlocksChar extends InstructionReadBlocks {
  String reg2;

  /**
   * Class constructor calls super constructor
   * @param msgNum1 - Indicates the ID of the message to be output
   * "%d\0" should be added and looked up in stringMap - result = msgNum1
   */
  public InstructionReadBlocksChar(int msgNum1) {
    super(msgNum1);
    reg2 = "reg2";
    reg1 = "reg1";
  }

  /**
   * Assigned string value indicating name of register
   * @param reg1 - first register
   * @param reg2 - second register
   */
  public void allocateRegisters(String reg1, String reg2) {
    this.reg1 = reg1;
    this.reg2 = reg2;
  }

  /**
   * Generates the instruction block as a string for the current instruction
   */
  public void genInstruction() {
    resultBlock.concat("p_read_char:\n");
    resultBlock.concat("\t\tPUSH {lr}\n");
    resultBlock.concat("\t\tMOV " +  reg2 + ", " + reg1 + "\n");
    resultBlock.concat("\t\tLDR " +  reg1 + ", =msg_" + msgNum1 + "\n");
    resultBlock.concat("\t\tADD " +  reg1 + ", " +  reg1 + ", #4\n");
    resultBlock.concat("\t\tBL scanf\n");
    resultBlock.concat("\t\tPOP {pc}\n");
  }


}

package InstructionSet.InstructionReadBlocks;

/**
 * Instruction class for printing int expressions
 */
public class InstructionReadBlocksInt extends InstructionReadBlocks {

  /**
   * Class constructor calls super constructor
   * @param msgNum1 - Indicates the ID of the message to be output
   * "%d\0" should be added and looked up in stringMap - result = msgNum1
   */
  public InstructionReadBlocksInt(int msgNum1) {
    super(msgNum1);
    reg2 = "reg2";
    reg1 = "reg1";
  }

  /**
   * Assigned string value indicating name of register
   * @param reg1 - first register
   * @param reg2 - second register
   */


  /**
   * Generates the instruction block as a string for the current instruction
   */
  public void genInstruction() {
    StringBuilder builder = new StringBuilder();
    builder.append("\tp_read_int:\n\t\tPUSH {lr}\n\t\tMOV ");
    builder.append(reg2);
    builder.append(", ");
    builder.append(reg1);
    builder.append("\n\t\tLDR ");
    builder.append(reg1);
    builder.append(", =msg_");
    builder.append(msgNum1);
    builder.append("\n\t\tADD ");
    builder.append(reg1);
    builder.append(", ");
    builder.append(reg1);
    builder.append(", #4\n\t\tBL scanf\n\t\tPOP {pc}\n");
    resultBlock = builder.toString();
  }


}

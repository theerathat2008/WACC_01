package InstructionSet.InstructionPrintBlocks;

import Registers.RegisterARM;

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
    reg1 = "reg1";
  }


  /**
   * Assigned string value indicating name of register
   * @param reg1 - first register
   */
  public void allocateRegisters(RegisterARM reg1) {
    this.reg1 = reg1.name();
  }

  /**
   * Generates the instruction block as a string for the current instruction
   */
  public void genInstruction() {
    StringBuilder block = new StringBuilder();
    block.append("\tp_print_bool:\n");
    block.append("\t\tPUSH {lr}\n");
    block.append("\t\tCMP ");
    block.append(reg1);
    block.append(", #0\n");
    block.append("\t\tLDRNE ");
    block.append(reg1);
    block.append(", =msg_");
    block.append(msgNum1);
    block.append("\n");
    block.append("\t\tLDREQ ");
    block.append(reg1);
    block.append(", =msg_");
    block.append(msgNum2);
    block.append("\n");
    block.append("\t\tADD ");
    block.append(reg1);
    block.append(", ");
    block.append(reg1);
    block.append(", #4\n");
    block.append("\t\tBL printf\n");
    block.append("\t\tMOV ");
    block.append(reg1);
    block.append(", #0\n");
    block.append("\t\tBL fflush\n");
    block.append("\t\tPOP {pc}\n");
    super.resultBlock = block.toString();
  }

}

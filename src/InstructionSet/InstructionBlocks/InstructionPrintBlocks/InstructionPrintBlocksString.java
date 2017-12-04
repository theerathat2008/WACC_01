package InstructionSet.InstructionBlocks.InstructionPrintBlocks;

import Registers.RegisterARM;

/**
 * Instruction class for printing string expressions
 */
public class InstructionPrintBlocksString extends InstructionPrintBlocks {


  String reg2;
  String reg3;

  /**
   * Class constructor calls super constructor
   *
   * @param msgNum1 - Indicates the ID of the message to be output
   *                "%.*s\0" should be added and looked up in stringMap
   */
  public InstructionPrintBlocksString(int msgNum1) {
    super(msgNum1);
    this.reg1 = "r0";
    this.reg2 = "r1";
    this.reg3 = "r2";
    this.blockType = "print_string";
  }

  /**
   * Assigned string value indicating name of register
   *
   * @param reg1 - first register
   * @param reg2 - second register
   * @param reg3 - third register
   */
  public void allocateRegisters(RegisterARM reg1, RegisterARM reg2, RegisterARM reg3) {
    this.reg1 = reg1.name();
    this.reg2 = reg2.name();
    this.reg3 = reg3.name();
  }

  /**
   * Generates the instruction block as a string for the current instruction
   */
  public void genInstruction() {
    StringBuilder block = new StringBuilder();
    block.append("\tp_print_string:\n");
    block.append("\t\tPUSH {lr}\n");
    block.append("\t\tLDR ");
    block.append(reg2);
    block.append(", [");
    block.append(reg1);
    block.append("]\n");
    block.append("\t\tADD ");
    block.append(reg3);
    block.append(", ");
    block.append(reg1);
    block.append(", #4\n");
    block.append("\t\tLDR ");
    block.append(reg1);
    block.append(", =msg_");
    block.append(msgNum1);
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
    this.resultBlock = block.toString();
  }
}

package InstructionSet.InstructionBlocks.InstructionPrintBlocks;

import Registers.RegisterARM;

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
    this.reg1 = "r0";
    this.blockType = "print_ln";
  }

  /**
   * Assigned string value indicating name of register
   * @param reg1 - first register
   *             "\0" should be added and looked up in stringMap
   */
  public void allocateRegisters(RegisterARM reg1) {
    this.reg1 = reg1.name();
  }

  /**
   * Generates the instruction block as a string for the current instruction
   */
  public void genInstruction() {

    StringBuilder block1 = new StringBuilder();
    block1.append("\tp_print_ln:\n");
    block1.append("\t\tPUSH {lr}\n");
    block1.append("\t\tLDR ");
    block1.append(reg1);
    block1.append(", =msg_");
    block1.append(msgNum1);
    block1.append("\n");
    block1.append("\t\tADD ");
    block1.append(reg1);
    block1.append(", ");
    block1.append(reg1);
    block1.append(", #4\n");
    block1.append("\t\tBL puts\n");
    block1.append("\t\tMOV ");
    block1.append(reg1);
    block1.append(", #0\n");
    block1.append("\t\tBL fflush\n");
    block1.append("\t\tPOP {pc}\n");
    this.resultBlock = block1.toString();
  }
}

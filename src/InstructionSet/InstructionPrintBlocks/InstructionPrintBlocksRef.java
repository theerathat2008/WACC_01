package InstructionSet.InstructionPrintBlocks;

import Registers.RegisterARM;

/**
 * Instruction class for printing references
 */
public class InstructionPrintBlocksRef extends InstructionPrintBlocks {
  String reg2;


  /**
   * Class constructor calls super constructor
   * @param msgNum1 - Indicates the ID of the message to be output
   * "%p\0" should be added and looked up in stringMap
   */
  public InstructionPrintBlocksRef(int msgNum1) {
    super(msgNum1);
    reg1 = "reg1";
  }


  /**
   * Assigned string value indicating name of register
   * @param reg1 - first register
   * @param reg2 - second register
   */
  public void allocateRegisters(RegisterARM reg1, RegisterARM reg2) {
    this.reg1 = reg1.name();
    this.reg2 = reg2.name();
  }

  /**
   * Generates the instruction block as a string for the current instruction
   */
  public void genInstruction() {
    StringBuilder block = new StringBuilder();
    block.append("\tp_print_reference:\n");
    block.append("\t\tPUSH {lr}\n");
    block.append("\t\tMOV ");
    block.append(reg2);
    block.append(", ");
    block.append(reg1);
    block.append("\n");
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
    super.resultBlock = block.toString();
  }

}

package InstructionSet;

import Registers.RegisterARM;

/**
 * Instruction class for stack alloc
 */
public class InstructionStack extends Instruction {

  String reg;
  String block1;
  String op;

  /**
   * Class constructor
   * @param op
   */
  public InstructionStack(String op) {
    this.op = op;
    reg = "reg";
  }

  /**
   * Assigned string value indicating name of register
   * @param reg
   */
  public void allocateRegisters(RegisterARM reg) {
    this.reg = reg.name();
  }

  /**
   * Generates the instruction block as a string for the current instruction
   */
  @Override
  public void genInstruction() {
    StringBuilder builder = new StringBuilder("\t\t");
    builder.append(op);
    builder.append(", ");
    builder.append(reg + "\n");
    block1 = builder.toString();
  }
}

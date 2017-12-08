package InstructionSet;

import Registers.RegisterARM;

public class InstructionLoadStore extends Instruction {

  String op;
  String reg;
  String mem;
  String block1;

  /**
   * Class constructor
   * @param op
   */
  public InstructionLoadStore(String op) {
    this.op = op;
    reg = "reg";
  }

  /**
   * Assigned string value indicating name of register
   * @param reg
   * @param mem
   */
  public void allocateRegisters(RegisterARM reg, RegisterARM mem) {
    this.reg = reg.name();
    this.mem = mem.name();
  }

  /**
   * Generates the instruction block as a string for the current instruction
   */
  @Override
  public void genInstruction() {
    StringBuilder builder = new StringBuilder("\t\t");
    builder.append(op);
    builder.append(", ");
    builder.append(reg);
    builder.append(", ");
    builder.append(mem + "\n");
    block1 = builder.toString();
  }
}

package InstructionSet;

import Registers.RegisterARM;

public class InstructionStack extends Instruction {

  String reg;
  String block1;
  String op;

  public InstructionStack(String op) {
    this.op = op;
    reg = "reg";
  }

  public void allocateRegisters(RegisterARM reg) {
    this.reg = reg.name();
  }

  @Override
  public void genInstruction() {
    StringBuilder builder = new StringBuilder("\t\t");
    builder.append(op);
    builder.append(", ");
    builder.append(reg + "\n");
    block1 = builder.toString();
  }

}

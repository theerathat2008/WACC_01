package InstructionSet;

import Registers.RegisterARM;

import java.util.List;

public class InstructionLoadStore extends Instruction{

  String op;
  String reg;
  String mem;
  String block1;

  public InstructionLoadStore(String op) {
    this.op = op;
  }

  public void allocateRegisters(RegisterARM reg, RegisterARM mem){
    this.reg = reg.name();
    this.mem = mem.name();
  }

  @Override
  public void genInstruction() {
    StringBuilder builder = new StringBuilder("\t\t");
    builder.append(op);
    builder.append(" ");
    builder.append(reg);
    builder.append(" ");
    builder.append(mem + "\n");
    block1 = builder.toString();
  }

  @Override
  public int requiresRegisters() {
    return 0;
  }

  @Override
  public boolean crossOverRegister() {
    return false;
  }
}

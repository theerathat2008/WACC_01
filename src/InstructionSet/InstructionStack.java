package InstructionSet;

import Registers.RegisterARM;

public class InstructionStack extends Instruction {

  String reg;
  String block1;
  String op;

  public InstructionStack(String op) {
    this.op = op;
  }

  public void allocateRegisters(RegisterARM reg){
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

  @Override
  public int requiresRegisters() {
    return 2;
  }

  @Override
  public boolean crossOverRegister() {
    //TODO
    return false;
  }

}

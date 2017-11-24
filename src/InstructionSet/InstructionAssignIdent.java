package InstructionSet;

import Registers.RegisterARM;

public class InstructionAssignIdent extends Instruction {


  String location;
  String reg;
  public String block1;

  public InstructionAssignIdent() {
    this.location = "SP";
    reg = "reg";
  }

  public void registerAllocation(RegisterARM reg) {
    this.reg = reg.name();
  }

  public void allocateLocation(String location) {
    this.location = location;
  }

  @Override
  public void genInstruction() {

    //LDR r4, [sp]

    StringBuilder builder = new StringBuilder();
    builder.append("\t\tLDR ");
    builder.append(reg);
    builder.append(", ");
    builder.append(location);
    builder.append("\n");
    block1 = builder.toString();


  }

  @Override
  public int requiresRegisters() {
    return 1;
  }

  @Override
  public boolean crossOverRegister() {
    return false;
  }
}

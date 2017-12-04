package InstructionSet;

import Registers.RegisterARM;

public class InstructionAssignIdent extends Instruction {


  String location;
  String reg;
  public String block1;
  boolean isStack;

  public InstructionAssignIdent() {
    this.location = "SP";
    this.reg = "reg";
    this.isStack = true;
  }

  public void registerAllocation(RegisterARM reg) {
    this.reg = reg.name();
  }

  public void allocateLocation(String location, boolean isStack) {
    this.location = location;
    this.isStack = isStack;
  }

  @Override
  public void genInstruction() {

    //LDR r4, [sp]

    StringBuilder builder = new StringBuilder();
    if(isStack){
      builder.append("\t\tLDR ");
      builder.append(reg);
      builder.append(", ");
      builder.append(location);
      builder.append("\n");
    } else {
      builder.append("\t\tMOV ");
      builder.append(reg);
      builder.append(", ");
      builder.append(location);
      builder.append("\n");
    }
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

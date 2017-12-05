package InstructionSet;

import Registers.RegisterARM;

public class InstructionAssignIdent extends Instruction {


  String location;
  String reg;
  public String block1;
  boolean isStack;
  String type;

  public InstructionAssignIdent(String type) {
    this.location = "SP";
    this.reg = "reg";
    this.isStack = true;
    this.type = type;
  }

  public void registerAllocation(RegisterARM reg) {
    this.reg = reg.name();
  }

  public void allocateLocation(String location, boolean isStack) {
    this.location = location;
    this.isStack = isStack;
  }

  public String getLDRType() {
    switch (type) {
      case ("bool"):
        return "LDRSB ";
      default:
        return "LDR ";
    }
  }
  @Override
  public void genInstruction() {

    //LDR r4, [sp]

    StringBuilder builder = new StringBuilder();
    if(isStack){
      builder.append("\t\t");
      builder.append(getLDRType());
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

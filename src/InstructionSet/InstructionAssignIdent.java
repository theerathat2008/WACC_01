package InstructionSet;

import Registers.RegisterARM;

public class InstructionAssignIdent extends Instruction {


  String location;
  String reg;
  public String block1;
  boolean isStack;
  String type;

  /**
   * Class constructor
   * @param type
   */
  public InstructionAssignIdent(String type) {
    this.location = "SP";
    this.reg = "reg";
    this.isStack = true;
    this.type = type;
  }

  /**
   * Set the value of reg
   * @param reg
   */
  public void registerAllocation(RegisterARM reg) {
    this.reg = reg.name();
  }

  /**
   * Assigned string value indicating name of register
   * @param location
   * @param isStack
   */
  public void allocateLocation(String location, boolean isStack) {
    this.location = location;
    this.isStack = isStack;
  }

  /**
   * @return Return the type of LDR
   */
  public String getLDRType() {
    switch (type) {
      case ("bool"):
        return "LDRSB ";
      default:
        return "LDR ";
    }
  }

  /**
   * Generates the instruction block as a string for the current instruction
   */
  @Override
  public void genInstruction() {

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
}

package InstructionSet;

import Registers.RegisterARM;

public class InstructionAssignIdentLHS extends Instruction {

  String location;
  String src;
  String type;
  boolean usingStack;
  String block1;

  public InstructionAssignIdentLHS(String type) {
    this.type = type;
    this.location = "SP";
    this.src = "srcReg";
    this.usingStack = true;
  }

  public String getBlock1() {
    return block1;
  }

  public void setUsingStack(boolean usingStack) {
    this.usingStack = usingStack;
  }

  public void registerAllocation(RegisterARM reg) {
    this.src = reg.name();
  }

  public void allocateLocation(String location) {
    this.location = location;
  }
//
//   * MOV r4, #'Z'    ->CHAR
//   * STRB r4, [sp]

//   * LDR r4, =20     ->INT
//   * STR r4, [sp]

//   * LDR r4, =msg_1   ->STRING
//   * STR r4, [sp]
//
//   * STRB r4, [sp]    ->BOOL
//   * LDRSB r4, [sp]

  public String getLDRType() {
    switch (type) {
      case ("str"):
        return "STR";
      case ("bool"):
        return "LDRSB";
      case ("array"):
        return "ARRAYTODO";
      case ("char"):
        return "STRB";
      case ("pair"):
        return "PAIRTODO";
      case ("int"):
        return "STR";
      default:
        System.out.println("Unrecognised type on InstructionAssignIdentLHS");
        System.out.println("Was type:" + type);
        break;
    }
    return "";
  }

  @Override
  public void genInstruction() {

    //LDR r4, [sp]

    StringBuilder builder = new StringBuilder();
    builder.append("\t\t");
    if(usingStack){
      builder.append(getLDRType());
    } else {
      builder.append("MOV");
    }
    builder.append(" ");
    builder.append(src);
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

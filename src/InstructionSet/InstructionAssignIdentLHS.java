package InstructionSet;

import Registers.RegisterARM;

public class InstructionAssignIdentLHS extends Instruction {

  String location;
  String src;
  String type;
  boolean usingStack;
  String block1;

  /**
   * Class constructor
   * @param type
   */
  public InstructionAssignIdentLHS(String type) {
    this.type = type;
    this.location = "SP";
    this.src = "srcReg";
    this.usingStack = true;
  }

  /**
   * @return Return the bloack1 attribute
   */
  public String getBlock1() {
    return block1;
  }

  /**
   * Set the boolean value of the usingStack attribute
   * @param usingStack
   */
  public void setUsingStack(boolean usingStack) {
    this.usingStack = usingStack;
  }

  /**
   * Set the value of reg
   * @param reg
   */
  public void registerAllocation(RegisterARM reg) {
    this.src = reg.name();
  }

  /**
   * Set the location attribute
   * @param location
   */
  public void allocateLocation(String location) {
    this.location = location;
  }

  /**
   *  MOV r4, #'Z'    ->CHAR
   * STRB r4, [sp]
   * LDR r4, =20     ->INT
   * STR r4, [sp]
   * LDR r4, =msg_1   ->STRING
   * STR r4, [sp]
   * STRB r4, [sp]    ->BOOL
   * LDRSB r4, [sp]
   */

  /**
   * @return Return the type of LDR
   */
  public String getLDRType() {
    switch (type) {
      case ("str"):
      case ("string"):
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

  /**
   * Generates the instruction block as a string for the current instruction
   */
  @Override
  public void genInstruction() {

    //LDR r4, [sp]

    StringBuilder builder = new StringBuilder();
    builder.append("\t\t");
    if(usingStack){
      builder.append(getLDRType());
      builder.append(" ");
      builder.append(src);
      builder.append(", ");
      builder.append(location);
      builder.append("\n");
    } else {
      builder.append("MOV");
      builder.append(" ");
      builder.append(location);
      builder.append(", ");
      builder.append(src);
      builder.append("\n");
    }
    block1 = builder.toString();
  }
}

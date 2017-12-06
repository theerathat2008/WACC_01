package InstructionSet;

import Registers.RegisterARM;

public class InstructionRead extends Instruction {

  public String resultBlock = "";
  String dstReg;
  String interReg;
  String sp;
  String type;
  boolean usingStack;

  public InstructionRead(String type) {
    this.type = type;
    this.dstReg = "dst";
    this.interReg = "inter";
    this.usingStack = true;
  }

  public void setUsingStack(boolean usingStack) {
    this.usingStack = usingStack;
  }

  public void allocateLocation(String sp) {
    this.sp = sp;
  }

  public void allocateRegisters(RegisterARM dstReg, RegisterARM interReg) {
    this.dstReg = dstReg.name();
    this.interReg = interReg.name();
  }


  public String getPrintType() {
    switch (type) {
      case ("char"):
        return "p_read_char";
      case ("int"):
        return "p_read_int";
      default:
        System.out.println("Unrecognised type on InstructionReadBlocks");
        break;
    }
    return "";

  }

  /**
   * Possible implementations for Read
   * Int : ADD r4, sp, #0
           MOV r0, r4
           BL p_read_int
   * Char :ADD r4, sp, #0
           MOV r0, r4
       		 BL p_read_char
   */

  /**
   * Use ADD interReg, sp, displacement if allocated on the stack
   * Use MOV interReg, sp if using registers
   */


  @Override
  public void genInstruction() {
    StringBuilder builder = new StringBuilder();


    if(usingStack){
      builder.append("\t\tADD ");
      builder.append(interReg);
      builder.append(", ");
      int displacement = Integer.parseInt(sp.replaceAll("[\\D]", ""));
      builder.append("sp");
      builder.append(", ");
      builder.append("#");
      builder.append(displacement);
      builder.append("\n\t\tMOV ");
      builder.append(dstReg);
      builder.append(", ");
      builder.append(interReg);
    } else {
      builder.append("\t\tMOV ");
      builder.append(dstReg);
      builder.append(", ");
      builder.append(sp);
    }
    builder.append("\n\t\tBL ");
    builder.append(getPrintType());
    builder.append("\n");

    resultBlock = builder.toString();
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

package InstructionSet;

import Registers.RegisterARM;

public class InstructionSideEffect extends Instruction{

  RegisterARM reg1;
  RegisterARM reg2;
  String op;
  public String block1;

  public InstructionSideEffect(String op) {
    this.op = op;
  }

  public void allocateRegisters(RegisterARM reg1, RegisterARM reg2) {
    this.reg1 = reg1;
    this.reg2 = reg2;
  }

  public void registerAllocation(RegisterARM reg1) {
    this.reg1 = reg1;
  }

  @Override
  public void genInstruction() {
    StringBuilder builder = new StringBuilder("\t\t");
    if (op.equals("X++")) {  //Still need to work out how to implement this

    } else if (op.equals("X--")) {

    } else if (op.equals("--X")) {
      builder.append("SUBS ");
      builder.append(reg1);
      builder.append(", ");
      builder.append(reg1);
      builder.append(", #1");
      builder.append("\n\t\tBLVS p_throw_overflow_error\n");
    } else if (op.equals("++X")) {
      builder.append("ADDS ");
      builder.append(reg1);
      builder.append(", ");
      builder.append(reg1);
      builder.append(", #1");
      builder.append("\n\t\tBLVS p_throw_overflow_error\n");
    } else if (op.equals("+=")) {
      builder.append("ADDS ");
      builder.append(reg1);
      builder.append(", ");
      builder.append(reg1);
      builder.append(", ");
      builder.append(reg2);
      builder.append("\n\t\tBLVS p_throw_overflow_error\n");
    } else if (op.equals("-=")) {
      builder.append("ADDS ");
      builder.append(reg1);
      builder.append(", ");
      builder.append(reg1);
      builder.append(", ");
      builder.append(reg2);
      builder.append("\n\t\tBLVS p_throw_overflow_error\n");
    } else if (op.equals("=")) {
      builder.append("MOV ");
      builder.append(reg1);
      builder.append(", ");
      builder.append(reg2);
      builder.append("\n");
    } else if (op.equals("*=")) {
      builder.append("MULLS ");
      builder.append(reg1);
      builder.append(", ");
      builder.append(reg2);
      builder.append(", ");
      builder.append(reg1);
      builder.append(", ");
      builder.append(reg2);
      builder.append("\n CMP ");
      builder.append(reg2);
      builder.append(", ");
      builder.append(reg1);
      builder.append(" ASR #31\n\t\tBLNE p_throw_overflow_error\n");
    } else if (op.equals("/=")) {
      builder.append("MOV r0 ");
      builder.append(reg1);
      builder.append("\n\t\tMOV r1 ");
      builder.append(reg2);
      builder.append("\n\t\tBL p_check_divide_by_zero\nBl __aeabi_idiv\n");
      builder.append("MOV ");
      builder.append(reg1);
      builder.append(", r0\n");
    }

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

package InstructionSet;

import Registers.RegisterARM;

public class InstructionArithmetic extends Instruction {
  String operand;
  String dst;
  String reg1;
  String reg2;
  public String block1;

  public InstructionArithmetic(String operand) {
    this.operand = operand;
    reg1 = "r0";
    reg2 = "src";
  }

  public void allocateRegisters(RegisterARM dst, RegisterARM reg1, RegisterARM reg2) {
    this.dst = dst.name();
    this.reg1 = reg1.name();
    this.reg2 = reg2.name();
  }

  public void genInstruction() {



    if (operand.equals("%")) {
      StringBuilder builder = new StringBuilder("\t\tMOV r0, ");
      builder.append(reg1);
      builder.append("\n\t\tMOV r1, ");
      builder.append(reg2);
      builder.append("\n\t\tBL p_check_divide_by_zero\n\t\tBl __aeabi_idivmod\n");
      block1 = builder.toString();
    } else if (operand.equals("/")) {
      StringBuilder builder = new StringBuilder("\t\tMOV r0, ");
      builder.append(reg1);
      builder.append("\n\t\tMOV r1, ");
      builder.append(reg2);
      builder.append("\n\t\tBL p_check_divide_by_zero\n\t\tBl __aeabi_idiv\n");
      block1 = builder.toString();
    } else if (operand.equals("*")) {
      StringBuilder builder = new StringBuilder("\t\tSMULL ");
      builder.append(reg1);
      builder.append(", ");
      builder.append(reg2);
      builder.append(", ");
      builder.append(reg1);
      builder.append(", ");
      builder.append(reg2);
      builder.append("\n\t\tCMP ");
      builder.append(reg2);
      builder.append(", ");
      builder.append(reg1);
      builder.append(", ASR #31\n\t\tBLNE p_throw_overflow_error\n");
      block1 = builder.toString();
    } else {
      StringBuilder builder = new StringBuilder("\t\t" + getOperand(operand) + "S ");
      builder.append(dst);
      builder.append(", ");
      builder.append(reg1);
      builder.append(", ");
      builder.append(reg2);
      builder.append("\n\t\tBLVS p_throw_overflow_error\n");
      block1 = builder.toString();
    }
  }


  public String getOperand(String operand) {
    switch (operand) {
      case "+":
        return "ADD";
      case "-":
        return "SUB";
      default:
        return "null";
    }
  }


}

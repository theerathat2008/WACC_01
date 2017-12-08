package InstructionSet;

import Registers.RegisterARM;

public class InstructionUnary extends Instruction {

  String dst;
  String src;
  String op;
  String extraReg;
  public String block1;

  public InstructionUnary(String op) {
    this.op = op;
    this.src = "src";
    this.dst = "dst";
    this.extraReg = null;
  }

  public void allocateRegisters(RegisterARM dst, RegisterARM src) {
    this.dst = dst.name();
    this.src = src.name();
  }

  public void extraRegister(RegisterARM reg) {
    this.extraReg = reg.name();
  }


  //TODO DOESN't include all the necessary assembly code

  @Override
  public void genInstruction() {
    StringBuilder builder = new StringBuilder("\t\t");
    switch (op) {
      case "!":
        builder.append("EOR ");
        builder.append(dst);
        builder.append(", ");
        builder.append(src);
        builder.append(", #1\n");
        break;
      case "-":
        builder.append("LDR ");
        builder.append(extraReg);
        builder.append(", =0\n\t\t");
        builder.append("SUBS ");
        builder.append(dst);
        builder.append(", ");
        builder.append(extraReg);
        builder.append(", ");
        builder.append(src);
        builder.append("\n\t\tBLVS p_throw_overflow_error\n");
        break;
      case "len":
        builder.append("LDR ");
        builder.append(dst);
        builder.append(", ");
        builder.append("[" + src + "]");
        builder.append("\n");
        break;
      case "ord":
        builder.append("MOV r0, ");
        builder.append(src);
        builder.append("\n");
//        builder.append("\t\tBL putchar\n");
//        builder.append("\t\tMOV ");
//        builder.append(dst);
//        builder.append(", r0\n");
        break;
      case "chr":
        builder.append("MOV r0, ");
        builder.append(src);
        builder.append("\n");
//        builder.append("\t\tBL putchar\n");
//        builder.append("\t\tMOV ");
//        builder.append(dst);
//        builder.append(", r0\n");
        break;
      default:
        break;
    }
    block1 = builder.toString();
  }

  @Override
  public int requiresRegisters() {
    switch (op) {
      case "!":
        return 2;
      case "-":
        return 2;
      case "len":
        return 2;
      case "ord":
        return 1;
      case "chr":
        return 1;
      default:
        break;
    }
    return 2;
  }

  @Override
  public boolean crossOverRegister() {
    //Maybe
    return false;
  }

}

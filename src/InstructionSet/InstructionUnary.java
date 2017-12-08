package InstructionSet;

import Registers.RegisterARM;

/**
 * Instruction class for unary expressions
 */
public class InstructionUnary extends Instruction {

  String dst;
  String src;
  String op;
  String extraReg;
  public String block1;

  /**
   * Class constructor
   * @param op
   */
  public InstructionUnary(String op) {
    this.op = op;
    this.src = "src";
    this.dst = "dst";
    this.extraReg = null;
  }

  /**
   * Assigned string value indicating name of register
   * @param dst
   * @param src
   */
  public void allocateRegisters(RegisterARM dst, RegisterARM src) {
    this.dst = dst.name();
    this.src = src.name();
  }

  /**
   * Set the name of the extraReg attribute
   * @param reg
   */
  public void extraRegister(RegisterARM reg) {
    this.extraReg = reg.name();
  }

  /**
   * Generates the instruction block as a string for the current instruction
   */
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
        break;
      case "chr":
        builder.append("MOV r0, ");
        builder.append(src);
        builder.append("\n");
        break;
      default:
        break;
    }
    block1 = builder.toString();
  }
}

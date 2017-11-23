package InstructionSet;

import Registers.RegisterARM;

public class InstructionUnary extends Instruction{

  String dst;
  String reg2;
  String op;
  public String block1;

  public InstructionUnary(String op) {
    this.op = op;
    reg2 = "reg2";
    dst = "dst";
  }

  public void allocateRegisters(RegisterARM dst, RegisterARM reg2){
    this.dst = dst.name();
    this.reg2 = reg2.name();
  }


  //TODO DOESN't include all the necessary assembly code

  @Override
  public void genInstruction() {
    StringBuilder builder = new StringBuilder("\t\t");
    switch(op) {
      case "!":
        builder.append("EOR ");
        builder.append(dst);
        builder.append(", ");
        builder.append(reg2);
        builder.append(", #1\n");
        break;
      case "-":
        builder.append("SUB ");
        builder.append(dst);
        builder.append(", =0 ");
        builder.append(reg2);
        builder.append("\n");
        break;
      case "len":
        builder.append("LDR ");
        builder.append(dst);
        builder.append(", ");
        builder.append(reg2);
        builder.append("\n");
        break;
      case "ord":
        builder.append("MOV R0, ");
        builder.append(reg2);
        builder.append("\n");
        builder.append("\t\tBL PUTCHAR\n");
        builder.append("\t\tMOV ");
        builder.append(dst);
        builder.append(", r0\n");
        break;
      case "chr":
        builder.append("MOV R0, ");
        builder.append(reg2);
        builder.append("\n");
        builder.append("\t\tBL PUTCHAR\n");
        builder.append("\t\tMOV ");
        builder.append(dst);
        builder.append(", r0\n");
        break;
      default:
        break;
    }
    block1 = builder.toString();
  }

  @Override
  public int requiresRegisters() {
    switch(op) {
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

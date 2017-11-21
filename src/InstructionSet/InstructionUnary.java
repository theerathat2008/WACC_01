package InstructionSet;

import Registers.RegisterARM;

import java.util.List;

public class InstructionUnary extends Instruction{

  String reg1;
  String reg2;
  String op;
  public String block1;

  public InstructionUnary(String op) {
    this.op = op;
  }

  public void allocateRegisters(RegisterARM reg1, RegisterARM reg2){
    this.reg1 = reg1.name();
    this.reg2 = reg2.name();
  }


  @Override
  public void genInstruction() {
    StringBuilder builder = new StringBuilder("\t\t");
    switch(op) {
      case "!":
        builder.append("EOR ");
        builder.append(reg1);
        builder.append(" ");
        builder.append(reg2);
        builder.append(" #1");
        break;
      case "-":

        break;
      case "len":

        break;
      case "ord":
        builder.append("MOV R0 ");
        builder.append(reg1);
        builder.append("\n");
        builder.append("\t\tBL PUTCHAR");
        break;
      case "chr":
        builder.append("MOV R0 ");
        builder.append(reg1);
        builder.append("\n");
        builder.append("\t\tBL PUTCHAR");
        break;
      default:
        break;
    }
    block1 = builder.toString();
  }
}

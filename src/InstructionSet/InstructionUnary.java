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


  //TODO DOESN't include all the necessary assembly code

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

  @Override
  public int requiresRegisters() {
    switch(op) {
      case "!":
        return 2;
      case "-":

        break;
      case "len":

        break;
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

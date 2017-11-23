package InstructionSet;

import Registers.RegisterARM;

public class InstructionComparison extends Instruction {

  String op;
  String reg1;
  String reg2;
  String dst;
  public String block1;
  final String tr = " " + dst + " #1";
  final String fal = " " + dst + " #0";

  public InstructionComparison(String op) {
    this.op = op;
  }

  public int requiresRegisters(){
    return 3;
  }

  /**
   * returns true as this claass uses registers that could be referencing the stack variables
   * or been assigned in a variable declaration
   */

  @Override
  public boolean crossOverRegister() {
    return true;
  }

  public void allocateRegisters(RegisterARM reg1, RegisterARM reg2, RegisterARM dst){
    this.reg1 = reg1.name();
    this.reg2 = reg2.name();
    this.dst = dst.name();
  }

  @Override
  public void genInstruction() {
    StringBuilder builder = new StringBuilder("\t\t");
    if (!(op.equals("&&")||op.equals("||"))) {
        builder.append("CMP");
        builder.append(" ");
        builder.append(reg1);
        builder.append(" ");
        builder.append(reg2);
        builder.append("\n");
        switch (op) {
          case ">": builder.append("\t\tMOVGT");
                    builder.append(tr + "\n");
                    builder.append("\t\tMOVLE");
                    builder.append(fal + "\n");
                    break;
          case ">=": builder.append("\t\tMOVGE");
                     builder.append(tr + "\n");
                     builder.append("\t\tMOVLT");
                     builder.append(fal + "\n");
                     break;
          case "<": builder.append("\t\tMOVLT");
                    builder.append(tr + "\n");
                    builder.append("\t\tMOVGE");
                    builder.append(fal + "\n");
                    break;
          case "<=": builder.append("\t\tMOVLE");
                     builder.append(tr + "\n");
                     builder.append("\t\tMOVGT");
                     builder.append(fal + "\n");
                     break;
          case "==": builder.append("\t\tMOVEQ");
                     builder.append(tr + "\n");
                     builder.append("\t\tMOVNE");
                     builder.append(fal + "\n");
                     break;
          case "!=": builder.append("\t\tMOVNE");
                     builder.append(tr + "\n");
                     builder.append("\t\tMOVEQ");
                     builder.append(fal + "\n");
                     break;
          default : break;
        }
      } else if (op.equals("&&")){
        builder.append("AND ");
        builder.append(dst);
        builder.append(" ");
        builder.append(reg1);
        builder.append(" ");
        builder.append(reg2 + "\n");
      } else if (op.equals("||")){
        builder.append("ORR ");
        builder.append(dst);
        builder.append(" ");
        builder.append(reg1);
        builder.append(" ");
        builder.append(reg2 + "\n");
      }
    block1 = builder.toString();


  }
}

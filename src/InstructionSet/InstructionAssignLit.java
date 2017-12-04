package InstructionSet;

import Registers.RegisterARM;

public class InstructionAssignLit extends Instruction {

  String constant;
  String lit;
  String reg;
  String stringMsgNum;
  public String block1;

  public InstructionAssignLit(String constant, String lit) {
    this.constant = constant;
    this.lit = lit;
    reg = "reg";
  }

  public void registerAllocation(RegisterARM reg) {
    this.reg = reg.name();
  }

  public void setStringMsgNum(String num) {
    this.stringMsgNum = num;
  }

  @Override
  public void genInstruction() {


    if (lit.equals("char")) {
      lit = "'" + lit + "'";
      StringBuilder builder = new StringBuilder("\t\tMOV ");
      builder.append(reg);
      builder.append(", #");
      builder.append(constant);
      builder.append("\n");
      block1 = builder.toString();
    } else if (lit.equals("int")) {
      StringBuilder builder = new StringBuilder("\t\tLDR ");
      builder.append(reg);
      builder.append(", =");
      builder.append(constant);
      builder.append("\n");
      block1 = builder.toString();
    } else if (lit.equals("bool")) {
      StringBuilder builder = new StringBuilder("\t\tMOV ");
      builder.append(reg);
      builder.append(", #");
      if (constant.equals("true")) {
        builder.append("1");
      } else {
        builder.append("0");
      }
      builder.append("\n");
      block1 = builder.toString();
    } else if (lit.equals("str")) {
      StringBuilder builder = new StringBuilder("\t\tLDR ");
      builder.append(reg);
      builder.append(", =msg_");
      builder.append(stringMsgNum);
      builder.append("\n");
      block1 = builder.toString();
    }


  }

  @Override
  public int requiresRegisters() {
    return 1;
  }

  @Override
  public boolean crossOverRegister() {
    return false;
  }

}

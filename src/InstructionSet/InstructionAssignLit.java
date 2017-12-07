package InstructionSet;

import Registers.RegisterARM;

public class InstructionAssignLit extends Instruction {

  String constant;
  String lit;
  String reg;
  String stringMsgNum;
  public String resultBlock;

  public InstructionAssignLit(String constant, String lit) {
    this.constant = constant;
    this.lit = lit;
    reg = "reg";
    resultBlock = "undefined";
  }

  public void registerAllocation(RegisterARM reg) {
    this.reg = reg.name();
  }

  public void setStringMsgNum(String num) {
    this.stringMsgNum = num;
  }

  public String stripZeros(String constant){
    return new Integer(constant).toString();
  }

  @Override
  public void genInstruction() {
    StringBuilder builder = new StringBuilder();

    if (lit.equals("char")) {
      lit = "'" + lit + "'";
      builder.append("\t\tMOV ");
      builder.append(reg);
      builder.append(", #");
      builder.append(constant);
      builder.append("\n");
    } else if (lit.equals("int")) {
      builder.append("\t\tLDR ");
      builder.append(reg);
      builder.append(", =");
      builder.append(stripZeros(constant));
      builder.append("\n");
    } else if (lit.equals("bool")) {
      builder.append("\t\tMOV ");
      builder.append(reg);
      builder.append(", #");
      if (constant.equals("true")) {
        builder.append("1");
      } else {
        builder.append("0");
      }
      builder.append("\n");
    } else if (lit.equals("str")) {
      builder.append("\t\tLDR ");
      builder.append(reg);
      builder.append(", =msg_");
      builder.append(stringMsgNum);
      builder.append("\n");
    }

    resultBlock = builder.toString();
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

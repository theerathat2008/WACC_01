package InstructionSet;

import Registers.RegisterARM;

public class InstructionAssignLit extends Instruction {

  String constant;
  String lit;
  String reg;
  String stringMsgNum;
  public String resultBlock;

  /**
   * Class constructor
   * @param constant
   * @param lit
   */
  public InstructionAssignLit(String constant, String lit) {
    this.constant = constant;
    this.lit = lit;
    reg = "reg";
    resultBlock = "undefined";
  }

  /**
   * Set the value of reg
   * @param reg
   */
  public void registerAllocation(RegisterARM reg) {
    this.reg = reg.name();
  }

  /**
   * Set the value for the stringMsgNum attribute
   * @param num
   */
  public void setStringMsgNum(String num) {
    this.stringMsgNum = num;
  }

  /**
   * @param constant
   * @return Return the string representation
   */
  public String stripZeros(String constant){
    return new Integer(constant).toString();
  }

  /**
   * Generates the instruction block as a string for the current instruction
   */
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
    } else if (lit.equals("pair") && constant.equals("null")) {
      builder.append("\t\tLDR ");
      builder.append(reg);
      builder.append(", =0");
      builder.append("\n");
    }
    resultBlock = builder.toString();
  }
}

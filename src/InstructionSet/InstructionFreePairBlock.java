package InstructionSet;

public class InstructionFreePairBlock extends Instruction {
  String reg1;
  String sp;
  String resultBlock = "";
  int msgNum;

  /**
   * Class constructor
   * @param msgNum
   */
  public InstructionFreePairBlock(int msgNum) {
    this.msgNum = msgNum;
    reg1 = "reg1";
  }

  /**
   * Set and replace the value of sp
   */
  public void allocateSP(String sp) {
    this.sp = sp;
  }

  /**
   * Assigned string value indicating name of register
   * @param reg1
   */
  public void allocateRegisters(String reg1) {
    this.reg1 = reg1;
  }

  /**
   * Generates the instruction block as a string for the current instruction
   */
  @Override
  public void genInstruction() {
    StringBuilder builder = new StringBuilder();
    builder.append("p_free_pair:\n");
    builder.append("\t\tPUSH {lr}\n");
    builder.append("\t\tCMP ");
    builder.append(reg1);
    builder.append(", #0\n");
    builder.append("\t\tLDREQ ");
    builder.append(reg1);
    builder.append(", =msg_");
    builder.append(msgNum);
    builder.append("\n\t\tBEQ p_throw_runtime_error\n\t\tPUSH {");
    builder.append(reg1);
    builder.append("}\n\t\tLDR ");
    builder.append(reg1);
    builder.append(", [");
    builder.append(reg1);
    builder.append("]\n\t\tBL free\n\t\tLDR ");
    builder.append(reg1);
    builder.append(", ");
    builder.append(sp);
    builder.append("\n\t\tLDR ");
    builder.append(reg1);
    builder.append(", [");
    builder.append(reg1);
    builder.append(", #4]\n\t\tBL free\n\t\tPOP {");
    builder.append(reg1);
    builder.append("}\n\t\tBL free\n\t\tPOP {pc}\n");
    resultBlock = builder.toString();
  }

  /**
   * @return Return the resultBlock attribute
   */
  public String getResultBlock() {
    return resultBlock;
  }

}

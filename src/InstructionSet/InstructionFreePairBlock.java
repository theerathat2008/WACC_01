package InstructionSet;

public class InstructionFreePairBlock extends Instruction {
  String reg1;
  String sp;
  String resultBlock = "";
  int msgNum;

  public InstructionFreePairBlock(int msgNum) {
    this.msgNum = msgNum;
    reg1 = "reg1";
  }

  public void allocateSP(String sp) {
    this.sp = sp;
  }

  public void allocateRegisters(String reg1) {
    this.reg1 = reg1;
  }

  public String getResultBlock() {
    return resultBlock;
  }

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

  @Override
  public int requiresRegisters() {
    return 1;
  }

  @Override
  public boolean crossOverRegister() {
    return false;
  }

}

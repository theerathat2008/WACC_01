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

  @Override
  public void genInstruction() {
    resultBlock.concat("p_free_pair:\n");
    resultBlock.concat("\t\tPUSH {lr}\n");
    resultBlock.concat("\t\tCMP " +  reg1 + ", #0\n");
    resultBlock.concat("\t\tLDREQ " +  reg1 + ", =msg_" + msgNum + "\n");
    resultBlock.concat("\t\tBEQ p_throw_runtime_error\n");
    resultBlock.concat("\t\tPUSH {" + reg1 + "}\n");
    resultBlock.concat("\t\tLDR " +  reg1 + ", [" + reg1 + "]\n");
    resultBlock.concat("\t\tBL free\n");
    resultBlock.concat("\t\tLDR " +  reg1 + ", " + sp + "\n");
    resultBlock.concat("\t\tLDR " +  reg1 + ", [" + reg1 + ", #4]\n");
    resultBlock.concat("\t\tBL free\n");
    resultBlock.concat("\t\tPOP {" + reg1 + "}\n");
    resultBlock.concat("\t\tBL free\n");
    resultBlock.concat("\t\tPOP {pc}\n");
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

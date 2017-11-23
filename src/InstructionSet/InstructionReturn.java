package InstructionSet;

public class InstructionReturn extends Instruction{
  String reg1;
  String reg2;
  public String resultBlock = "";
  String sp;
  String type;

  public InstructionReturn(String type) {
    this.type = type;
    reg1 = "reg1";
    reg2 = "reg2";
  }


  public void allocateRegisters(String reg1, String reg2) {
    this.reg1 = reg1;
    this.reg2 = reg2;
  }

  public void allocateSP(String sp) {
    this.sp = sp;
  }

  public String getLDType() {
    if (type.equals("bool") || type.equals("char")) {
      return "LDRSB";
    }
    System.out.println("TYPE in Instruction return = " + type);
    return "LDR";
  }

  @Override
  public void genInstruction() {
    resultBlock.concat("\t\t" + getLDType() + " " + reg2 + ", " + sp + "\n");
    resultBlock.concat("\t\tMOV " +  reg2 + ", " + reg1 + "\n");
    resultBlock.concat("\t\tADD " +  sp + ", " +  sp + ", #4\n");
    resultBlock.concat("\t\tPOP {pc}\n");
  }

  @Override
  public int requiresRegisters() {
    return 2;
  }

  @Override
  public boolean crossOverRegister() {
    return false;
  }

}

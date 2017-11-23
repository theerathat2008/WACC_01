package InstructionSet;

public class InstructionPrint extends Instruction {
  String resultBlock = "";
  String reg1;
  String reg2;
  String sp;
  String type;

  public InstructionPrint(String type) {
    this.type = type;
    reg1 = "reg1";
    reg2 = "reg2";
  }

  public void allocateSP(String sp){
    this.sp = sp;
  }

  public void allocateRegisters(String reg1, String reg2) {
    this.reg1 = reg1;
    this.reg2 = reg2;
  }

  public String getLDType() {
    if (type.equals("bool") || type.equals("char")) {
      return "LDRSB";
    }
    return "LDR";
  }

  public String getPrintType() {
    switch (type){
      case("string"):
        return "p_print_string";
      case("bool"):
        return "p_print_bool";
      case("array"):
        return "p_print_reference";
      case("char"):
        return "putchar";
      case("pair"):
        return "p_print_reference";
      case("int"):
        return "p_print_int";
      default:
        System.out.println("Unrecognised type on InstructionReadBlocks");
        break;
    }
    return "";

  }

  @Override
  public void genInstruction() {
    resultBlock.concat("\t\t" + getLDType() + " " + reg2 + sp + "\n");
    resultBlock.concat("\t\tMOV " +  reg1 + ", " + reg2 + "\n");
    resultBlock.concat("\t\tBL " + getPrintType() + "\n");
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

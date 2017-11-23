package InstructionSet;

public class InstructionRead extends Instruction{

  String resultBlock = "";
  String reg1;
  String reg2;
  String sp;
  String type;

  public InstructionRead(String type) {
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


  public String getPrintType() {
    switch (type){
      case("char"):
        return "p_read_char";
      case("int"):
        return "p_read_int";
      default:
        System.out.println("Unrecognised type on InstructionReadBlocks");
        break;
    }
    return "";

  }



  @Override
  public void genInstruction() {
    resultBlock.concat("\t\tLDRSB " + reg2 + sp + "\n");
    resultBlock.concat("\t\tMOV " +  reg1 + ", " + reg2 + "\n");
    resultBlock.concat("\t\tBL " + getPrintType() + "\n");
  }

  @Override
  public int requiresRegisters() {
    return 0;
  }

  @Override
  public boolean crossOverRegister() {
    return false;
  }

}

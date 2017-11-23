package InstructionSet;

public class InstructionCall extends Instruction{
  String resultBlock = "";
  String sp;
  String fName;
  String reg1;
  String reg2;
  String returnType;

  public InstructionCall(String fName, String returnType) {
    this.fName = fName;
    this.returnType = returnType;
  }


  public void allocateSP(String sp) {
    this.sp = sp;
  }

  public void allocateregisters(String reg1, String reg2) {
    this.reg1 = reg1;
    this.reg2 = reg2;
  }

  public String getThirdLine() {
    switch (returnType) {
      case ("int"):
      case ("string"):
      case ("pair"):
      case ("array"):
        return "STR";
      case ("char"):
      case ("bool"):
        return "STRB";
    }
    return "CANNOT IDENTIFY TYPE IN GETTHIRDLINE INSTRUCTIONCALL";
  }

  public String getFourthLine() {
    switch (returnType) {
      case ("int"):
      case ("string"):
      case ("pair"):
      case ("array"):
        return "LDR";
      case ("char"):
      case ("bool"):
        return "LDRSB";
    }
    return "CANNOT IDENTIFY TYPE IN GETFOURTHLINE INSTRUCTIONCALL";
  }



  @Override
  public void genInstruction() {
    resultBlock.concat("\t\tBL f_" + fName + "\n");
    resultBlock.concat("\t\tMOV " +  reg2 + ", " + reg1 + "\n");
    resultBlock.concat("\t\t" + getThirdLine() + " " +  reg2 + ", " + sp + "\n");
    resultBlock.concat("\t\t" + getFourthLine() + " " +  reg2 + ", " + sp + "\n");
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

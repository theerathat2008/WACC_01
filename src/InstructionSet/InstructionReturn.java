package InstructionSet;

import Registers.RegisterARM;

public class InstructionReturn extends Instruction{
  String reg1;
  String reg2;
  String resultBlock;
  String sp;
  String type;


  public String getResultBlock() {
    return resultBlock;
  }

  public InstructionReturn(String type) {
    this.type = type;
    this.resultBlock = "";
    reg1 = "reg1";
    reg2 = "reg2";
  }


  public void allocateRegisters(RegisterARM reg1, RegisterARM reg2) {
    this.reg1 = reg1.name();
    this.reg2 = reg2.name();
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
    StringBuilder block = new StringBuilder();
    block.append("\t\tMOV ");
    block.append(reg1);
    block.append(", ");
    block.append(reg2);
    block.append("\n");
    //block.append("\t\tPOP {pc}\n");
    resultBlock = block.toString();


    //resultBlock.concat("\t\t" + getLDType() + " " + reg2 + ", " + sp + "\n");
    //resultBlock.concat("\t\tADD " +  sp + ", " +  sp + ", #4\n");

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

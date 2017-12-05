package InstructionSet;

import Registers.RegisterARM;

public class InstructionReturn extends Instruction {
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
    reg2 = "src";
  }


  public void allocateRegisters(RegisterARM reg1, RegisterARM reg2) {
    this.reg1 = reg1.name();
    this.reg2 = reg2.name();
  }

  public void allocateSP(String sp) {
    this.sp = sp;
  }



  @Override
  public void genInstruction() {
    StringBuilder block = new StringBuilder();
    block.append("\t\tMOV ");
    block.append(reg1);
    block.append(", ");
    block.append(reg2);
    block.append("\n");
    resultBlock = block.toString();
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

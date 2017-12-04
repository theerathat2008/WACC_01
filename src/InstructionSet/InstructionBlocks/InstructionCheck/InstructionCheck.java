package InstructionSet.InstructionBlocks.InstructionCheck;

import InstructionSet.InstructionBlocks.InstructionBlocks;

public class InstructionCheck extends InstructionBlocks {
  String reg1;
  int msgNum1;


  public InstructionCheck(int msgNum1) {
    this.msgNum1 = msgNum1;
    reg1 = "reg1";
  }



  @Override
  public void genInstruction() {
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

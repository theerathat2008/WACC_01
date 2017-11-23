package InstructionSet.InstructionCheck;

import InstructionSet.Instruction;

public class InstructionCheck extends Instruction{
  String reg1;
  int msgNum;
  String resultBlock;

  public InstructionCheck(int msgNum) {
    this.msgNum = msgNum;
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

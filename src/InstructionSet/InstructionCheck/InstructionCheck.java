package InstructionSet.InstructionCheck;

import InstructionSet.Instruction;

public class InstructionCheck extends Instruction {
  String reg1;
  int msgNum1;
  String resultBlock;

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

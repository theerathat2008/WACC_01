package InstructionSet;

import Registers.RegisterARM;

public class InstructionFreePair extends Instruction {
  String r0;
  String pairLocReg;
  String resultBlock = "";

  public String getResultBlock() {
    return resultBlock;
  }


  public void allocateRegisters(RegisterARM r0, RegisterARM pairLocReg) {
    this.r0 = r0.name();
    this.pairLocReg = pairLocReg.name();
  }

  @Override
  public void genInstruction() {
    StringBuilder builder = new StringBuilder();
    builder.append("\t\tMOV ");
    builder.append(r0);
    builder.append(", ");
    builder.append(pairLocReg);
    builder.append("\n\t\tBL p_free_pair\n");
    resultBlock = builder.toString();
  }

}

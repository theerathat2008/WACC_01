package InstructionSet;

import Registers.RegisterARM;

public class InstructionAssignLit extends Instruction{

  String constant;
  String lit;
  String reg;
  String block1;

  public InstructionAssignLit(String constant, String lit){
    this.constant = constant;
    this.lit = lit;
  }

  public void registerAllocation(RegisterARM reg){
    this.reg = reg.name();
  }

  @Override
  public void genInstruction() {
    if (lit.equals("char")) {
      lit = "'" + lit + "'";
    } else if (lit.equals("string")) {
      
    }


    StringBuilder builder = new StringBuilder("\t\tMOV ");
    builder.append(reg);
    builder.append(" #");
    builder.append(constant);
    builder.append("\n");
  }

  @Override
  public int requiresRegisters() {
    return 1;
  }

  @Override
  public boolean crossOverRegister() {
    return false;
  }

}

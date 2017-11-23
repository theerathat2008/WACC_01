package InstructionSet;

import Registers.RegisterARM;

public class InstructionAssignLit extends Instruction{

  String constant;
  String lit;
  String reg;
  public String block1;

  public InstructionAssignLit(String constant, String lit){
    this.constant = constant;
    this.lit = lit;
    reg = "reg";
  }

  public void registerAllocation(RegisterARM reg){
    this.reg = reg.name();
  }

  @Override
  public void genInstruction() {

    if (lit.equals("char")) {
      lit = "'" + lit + "'";
      StringBuilder builder = new StringBuilder("\t\tMOV ");
      builder.append(reg);
      builder.append(", #");
      builder.append(constant);
      builder.append("\n");
      block1 = builder.toString();
    } else if (lit.equals("int")) {
      StringBuilder builder = new StringBuilder("\t\tLDR ");
      builder.append(reg);
      builder.append(", =");
      builder.append(constant);
      builder.append("\n");
      block1 = builder.toString();
    } else if (lit.equals("bool")) {

    } else if (lit.equals("pair")){

    }



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

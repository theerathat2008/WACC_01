package InstructionSet;

import Registers.RegisterARM;

public class Instruction_Print extends Instruction{

  String type;
  String reg1;
  boolean printLn;
  String block1;

  public Instruction_Print(String type, boolean println) {
    this.type = type;
    this.printLn = println;
  }

  public void registerAllocation(RegisterARM reg1) {
    this.reg1 = reg1.name();
  }



  @Override
  public void genInstruction() {
    StringBuilder builder = new StringBuilder("\t\tMOV R0 ");
    builder.append(reg1);
    builder.append("\n\t\tBL p_print_");
    builder.append(type);
    builder.append("\n");
    if (printLn) {
      builder.append("\t\tBL p_print_ln\n");
    }
    block1 = builder.toString();
  }
}

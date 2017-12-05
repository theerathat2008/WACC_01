package InstructionSet;

import Registers.RegisterARM;

public class InstructionPrint extends Instruction {
  String resultBlock = "";
  String reg1;
  String reg2;
  String sp;
  String type;

  public InstructionPrint(String type) {
    this.type = type;
    reg1 = "reg1";
    reg2 = "reg2";
  }

  public String getResultBlock() {
    return resultBlock;
  }

  public void allocateSP(String sp) {
    this.sp = sp;
  }

  public void allocateRegisters(RegisterARM reg1, RegisterARM reg2) {
    this.reg1 = reg1.name();
    this.reg2 = reg2.name();
  }

  public String getPrintType() {
    switch (type) {
      case ("string"):  //falls through to "str" case.
      case ("str"):
        return "p_print_string";
      case ("bool"):
        return "p_print_bool";
      case ("char"):
        return "putchar";
      case ("array"):
      case ("pair"):
        return "p_print_reference";
      case ("int"):
        return "p_print_int";
      default:
        if (type.contains("[")) {
          return "p_print_reference";
        }
        System.out.println("Unrecognised type on InstructionPrintBlocks");
        System.out.println("Was type:" + type);
    }
    return "";

  }

  @Override
  public void genInstruction() {
    StringBuilder block = new StringBuilder();
    block.append("\t\tMOV ");
    block.append(reg1);
    block.append(", ");
    block.append(reg2);
    block.append("\n\t\tBL ");
    block.append(getPrintType());
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

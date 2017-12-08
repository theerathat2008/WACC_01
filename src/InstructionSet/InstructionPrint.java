package InstructionSet;

import Registers.RegisterARM;

public class InstructionPrint extends Instruction {
  String resultBlock = "";
  String reg1;
  String reg2;
  String sp;
  String type;

  /**
   * Class constructor
   * @param type
   */
  public InstructionPrint(String type) {
    this.type = type;
    reg1 = "r0";
    reg2 = "src";
  }

  /**
   * Set and replace the value of sp
   * @param sp
   */
  public void allocateSP(String sp) {
    this.sp = sp;
  }

  public void allocateRegisters(RegisterARM reg1, RegisterARM reg2) {
    this.reg1 = reg1.name();
    this.reg2 = reg2.name();
  }

  /**
   * @return Return the print type
   */
  public String getPrintType() {

    switch (type) {
      case ("string"):  //falls through to "str" case.
      case ("str"):
        return "p_print_string";
      case ("bool"):
        return "p_print_bool";
      case ("char"):
        return "putchar";
      case ("int"):
        return "p_print_int";
      case ("pair"):
        return "p_print_reference";
      default:
        if (type.contains("[") || type.contains("PAIR")) {
          return "p_print_reference";
        }
        System.out.println("Unrecognised type on InstructionPrintBlocks");
        System.out.println("Was type:" + type);
    }
    return "";

  }

  /**
   * Generates the instruction block as a string for the current instruction
   */
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

  /**
   * @return Return the resultBlock attribute
   */
  public String getResultBlock() {
    return resultBlock;
  }

}

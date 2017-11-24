package InstructionSet;

import Registers.RegisterARM;

public class InstructionRead extends Instruction{

  public String resultBlock = "";
  String reg1;
  String reg2;
  String sp;
  String type;

  public InstructionRead(String type) {
    this.type = type;
    reg1 = "reg1";
    reg2 = "reg2";
  }

  public void allocateSP(String sp){
    this.sp = sp;
  }

  public void allocateRegisters(RegisterARM reg1, RegisterARM reg2) {
    this.reg1 = reg1.name();
    this.reg2 = reg2.name();
  }


  public String getPrintType() {
    switch (type){
      case("char"):
        return "p_read_char";
      case("int"):
        return "p_read_int";
      default:
        System.out.println("Unrecognised type on InstructionReadBlocks");
        break;
    }
    return "";

  }



  @Override
  public void genInstruction() {
    StringBuilder builder = new StringBuilder();
    builder.append("\t\tLDRSB ");
    builder.append(reg2);
    builder.append(", "); //not in original, not sure if correct
    builder.append(sp);
    builder.append("\n\t\tMOV ");
    builder.append(reg1);
    builder.append(", ");
    builder.append(reg2);
    builder.append("\n\t\tBL ");
    builder.append(getPrintType());
    builder.append("\n");

    resultBlock = builder.toString();
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

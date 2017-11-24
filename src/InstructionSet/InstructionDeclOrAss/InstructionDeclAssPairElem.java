package InstructionSet.InstructionDeclOrAss;

import InstructionSet.Instruction;
import Registers.RegisterARM;

public class InstructionDeclAssPairElem extends Instruction{
  String resultBlock = "";
  String pos;
  String sp;
  String reg1;
  String reg2;

  public InstructionDeclAssPairElem(String pos) {
    this.pos = pos;

  }

  public void allocateSP(){
    this.sp = sp;
  }
  public void allocateRegisters(RegisterARM reg1, RegisterARM reg2) {
    this.reg1 = reg1.name();
    this.reg2 = reg2.name();
  }



  @Override
  public void genInstruction() {
    StringBuilder builder = new StringBuilder();
    builder.append("\t\tLDR ");
    builder.append(reg2);
    builder.append(", [sp, #");
    builder.append(sp);
    builder.append("]\n\t\tMOV ");
    builder.append(reg1);
    builder.append(", ");
    builder.append(reg2);
    builder.append("\n\t\tBL p_check_null_pointer\n\t\tLDR ");
    builder.append(reg2);
    builder.append(", [");
    builder.append(reg2);
    builder.append(", #");
    builder.append(getDisp());
    builder.append("]\n\t\tLDR ");
    builder.append(reg2);
    builder.append(", [");
    builder.append(reg1);
    builder.append("]\n\t\tSTR ");
    builder.append(reg2);
    builder.append(", [");
    builder.append(reg1);
    builder.append("]\n");

//    resultBlock.concat("\t\tLDR " +  reg2 + ", [sp, #" + sp + "]\n");
//    resultBlock.concat("\t\tMOV " +  reg1 + ", " + reg2 + "\n");
//    resultBlock.concat("\t\tBL p_check_null_pointer\n");
//    resultBlock.concat("\t\tLDR " +  reg2 + ", [" + reg2 + ", #" + getDisp() + "]\n");
//    resultBlock.concat("\t\tLDR " +  reg2 + ", [" +  reg1 + "]\n");
//    resultBlock.concat("\t\tSTR " +  reg2 + ", [" +  reg1 + "]\n");
    resultBlock = builder.toString();
  }

  private String getDisp() {
    if (this.pos.equals("fst")){
      return "0";
    } else if (this.pos.equals("snd")) {
      return "4";
    }
    return "UNDEFINED PAIRPOS IN GETDISP IN InstructionDeclAssPairElem";
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

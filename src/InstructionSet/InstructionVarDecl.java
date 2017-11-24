package InstructionSet;

import Registers.RegisterARM;

public class InstructionVarDecl extends Instruction {

  String resultBlock;
  String srcReg;
  String dstReg;
  String stackLocation;
  String varType;


  public InstructionVarDecl(String varType) {
    this.varType = varType;
    this.srcReg = "srcReg";
    this.dstReg = "dstReg";
    this.stackLocation = "SP";
    this.resultBlock = "";
  }

  public String getResultBlock() {
    return resultBlock;
  }

  public void allocateRegisters(RegisterARM dstReg, RegisterARM srcReg) {
    this.srcReg = srcReg.name();
    this.dstReg = dstReg.name();
  }

  public void setStackLocation(String location) {
    this.stackLocation = location;
  }


  public String getSTRType() {
    if (varType.equals("bool") || varType.equals("char")) {
      return "STRB";
    }
    return "STR";
  }


  @Override
  public void genInstruction() {
    StringBuilder block = new StringBuilder();
    block.append("\t\tMOV ");
    block.append(dstReg);
    block.append(", ");
    block.append(srcReg);
    block.append("\n");
    block.append("\t\t");
    block.append(getSTRType());
    block.append(" ");
    block.append(dstReg);
    block.append(", ");
    block.append(stackLocation);
    block.append("\n");
    resultBlock = block.toString();

    //MOV r4, r0
    //STR r4, [sp]


    //resultBlock.concat("\t\t" + getLDType() + " " + reg2 + sp + "\n");
  }

  @Override
  public int requiresRegisters() {
    return 2;
  }

  @Override
  public boolean crossOverRegister() {
    return true;
  }

}

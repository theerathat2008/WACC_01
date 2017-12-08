package InstructionSet;

import Registers.RegisterARM;

/**
 * Instruction class for variable declarations
 */
public class InstructionVarDecl extends Instruction {

  String resultBlock;
  String srcReg;
  String dstReg;
  String stackLocation;
  String varType;
  boolean isStack;

  /**
   * Class constructor
   * @param varType
   */
  public InstructionVarDecl(String varType) {
    this.varType = varType;
    this.srcReg = "srcReg";
    this.stackLocation = "SP";
    this.isStack = true;
    this.resultBlock = "";
  }

  /**
   * Assigned string value indicating name of register
   * @param dstReg
   * @param srcReg
   */
  public void allocateRegisters(RegisterARM dstReg, RegisterARM srcReg) {
    this.srcReg = srcReg.name();
    this.dstReg = dstReg.name();
  }

  /**
   * Set the stackLocation and isStack attribute
   * @param location
   * @param isStack
   */
  public void setStackLocation(String location, boolean isStack) {
    this.stackLocation = location;
    this.isStack = isStack;
  }

  /**
   * @return Return the type of STR
   */
  public String getSTRType() {
    if (varType.equals("bool") || varType.equals("char")) {
      return "STRB";
    }
    return "STR";
  }

  /**
   * Generates the instruction block as a string for the current instruction
   */
  @Override
  public void genInstruction() {
    StringBuilder block = new StringBuilder();

    if(!compareDstSrc(srcReg, dstReg)){
      block.append("\t\tMOV ");
      block.append(dstReg);
      block.append(", ");
      block.append(srcReg);
      block.append("\n");
    }
    if(isStack){
      block.append("\t\t");
      block.append(getSTRType());
      block.append(" ");
      block.append(dstReg);
      block.append(", ");
      block.append(stackLocation);
      block.append("\n");
    } else{
      if(!compareDstSrc(stackLocation,dstReg)){
        block.append("\t\t");
        block.append("MOV ");
        block.append(stackLocation);
        block.append(", ");
        block.append(dstReg);
        block.append("\n");
      }
    }

    resultBlock = block.toString();
  }

  /**
   * @return Return the resultBlock attribute
   */
  public String getResultBlock() {
    return resultBlock;
  }

}

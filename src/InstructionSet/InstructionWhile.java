package InstructionSet;

import Registers.RegisterARM;

/**
 * Instruction class for while loops
 */
public class InstructionWhile extends Instruction {

  String exprReg;
  String loopLabel;
  String loopExit;

  public String block1;
  public String loopEval;
  public String afterLoop;

  /**
   * Class constructor
   */
  public InstructionWhile() {
    exprReg = "exprReg";
  }

  /**
   * Set loopLabel and loopExit attribute
   * @param loopLabel
   * @param loopExit
   */
  public void setLabels(String loopLabel, String loopExit) {
    this.loopLabel = loopLabel;
    this.loopExit = loopExit;
  }

  /**
   * Assigned string value indicating name of register
   * @param exprReg
   */
  public void allocateRegisters(RegisterARM exprReg) {
    this.exprReg = exprReg.name();
  }

  /**
   * Generates the instruction block as a string for the current instruction
   */
  public void genInstruction() {
    block1 = "\t" + loopLabel + ":\n";

    StringBuilder block2 = new StringBuilder();
    block2.append("\t\tCMP ");
    block2.append(exprReg);
    block2.append(", #0\n");
    block2.append("\t\tBEQ ");
    block2.append(loopExit);
    block2.append("\n");
    loopEval = block2.toString();

    StringBuilder after = new StringBuilder("\t\tB ");
    after.append(loopLabel);
    after.append("\n\t");
    after.append(loopExit);
    after.append(":\n");
    afterLoop = after.toString();
  }
}

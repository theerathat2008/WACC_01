package InstructionSet;

import Registers.RegisterARM;

public class InstructionWhile extends Instruction {

  String exprReg;
  String loopLabel;
  String loopExit;

  String block1;
  String loopEval;
  String afterLoop;


  public InstructionWhile(){}


  public void allocateRegisters(RegisterARM exprReg) {
    this.exprReg = exprReg.name();
  }


  public void genInstruction() {
    block1 = "\t" + loopLabel;
    //TODO put expr between block1 and 2

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
    afterLoop = after.toString();

  }
}

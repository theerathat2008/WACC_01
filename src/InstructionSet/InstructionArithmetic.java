package InstructionSet;
import Registers.RegisterARM;

import java.util.LinkedList;

import java.util.List;

public class InstructionArithmetic extends Instruction {
  String operand;
  String dst;
  String reg1;
  String reg2;
  public String block1;
  public InstructionArithmetic(String operand, String dst, String fst, String snd) {
    this.operand = operand;
  }

  public void allocateRegisters(RegisterARM reg1, RegisterARM reg2, RegisterARM dst){
    this.reg1 = reg1.name();
    this.reg2 = reg2.name();
    this.dst = dst.name();
  }

  public void genInstruction() {
    StringBuilder builder = new StringBuilder("\t\t" + operand + "S");
    builder.append(" ");
    builder.append(dst);
    builder.append(" ");
    builder.append(fst);
    builder.append(" ");
    builder.append(snd);
    builder.append("\n\t\tBLVS p_throw_overflow_error\n");
    block1 = builder.toString();
  }
}

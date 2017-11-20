package InstructionSet;
import java.util.LinkedList;

import java.util.List;

public class InstructionArithmetic extends Instruction {
  String operand;
  String dst;
  String fst;
  String snd;
  public String block1;
  public InstructionArithmetic(String operand, String dst, String fst, String snd) {

  List<String> instr = new LinkedList<>();

    this.operand = operand;
    this.dst = dst;
    this.fst = fst;
    this.snd = snd;
  }

  public void addInstruction(List<Instruction> instructions) {
    instructions.add(this);
  }

  public void genInstruction(List<Instruction> output) {
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

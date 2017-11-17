package InstructionSet;
import java.util.LinkedList;

import java.util.List;

public class InstructionArithmetic extends Instruction {
  String operand;
  String dst;
  String fst;
  String snd;
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

  public void genCode(List<String> output) {
    StringBuilder builder = new StringBuilder(operand);
    builder.append(" ");
    builder.append(dst);
    builder.append(" ");
    builder.append(fst);
    builder.append(" ");
    builder.append(snd);
    output.add(builder.toString());
  }

  public void makeInstr(){
    instr.add(make());
  }

}

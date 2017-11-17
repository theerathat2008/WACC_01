package InstructionSet;

import java.util.LinkedList;
import java.util.List;

public class InstructionArithmetic extends Instruction {
  String operand;
  String output;
  String fst;
  String snd;

  List<String> instr = new LinkedList<>();

  public InstructionArithmetic(String operand, String output, String fst, String snd) {
    this.operand = operand;
    this.output = output;
    this.fst = fst;
    this.snd = snd;
  }

  public String make() {
    return operand + output + fst + snd;
  }

  public void makeInstr(){
    instr.add(make());
  }

}

package InstructionSet;

public class InstructionArithmetic extends Instruction {
  String operand;
  String output;
  String fst;
  String snd;

  public InstructionArithmetic(String operand, String output, String fst, String snd) {
    this.operand = operand;
    this.output = output;
    this.fst = fst;
    this.snd = snd;
  }

  public String make() {
    return operand + output + fst + snd;
  }

}

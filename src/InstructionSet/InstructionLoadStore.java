package InstructionSet;

import java.util.List;

public class InstructionLoadStore extends Instruction{

  String op;
  String reg;
  String mem;
  String block1;

  public InstructionLoadStore(String op, String reg, String mem) {
    this.op = op;
    this.reg = reg;
    this.mem = mem;
  }

  @Override
  public void genInstruction() {
    StringBuilder builder = new StringBuilder("\t\t");
    builder.append(op);
    builder.append(" ");
    builder.append(reg);
    builder.append(" ");
    builder.append(mem + "\n");
    block1 = builder.toString();
  }
}

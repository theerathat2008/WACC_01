package InstructionSet;
import Registers.RegisterARM;

import java.util.List;

public class InstructionArithmetic extends Instruction {
  String operand;
  String dst;
  String reg1;
  String reg2;
  public String block1;

  public InstructionArithmetic(String operand) {
    this.operand = operand;
  }

  public void allocateRegisters(RegisterARM reg1, RegisterARM reg2, RegisterARM dst){
    this.dst = dst.name();
    this.reg1 = reg1.name();
    this.reg2 = reg2.name();
  }


  public void addInstruction(List<Instruction> instructions) {
    instructions.add(this);
  }

  public void genInstruction() {
    StringBuilder builder = new StringBuilder("\t\t" + operand + "S");
    builder.append(" ");
    builder.append(dst);
    builder.append(" ");
    builder.append(reg1);
    builder.append(" ");
    builder.append(reg2);
    builder.append("\n\t\tBLVS p_throw_overflow_error\n");
    block1 = builder.toString();
  }

  @Override
  public int requiresRegisters() {
    return 3;
  }


  /**
   * returns true as this class uses registers that could be referencing the stack variables
   * or been assigned in a variable declaration
   */

  @Override
  public boolean crossOverRegister() {
    return true;
  }


}

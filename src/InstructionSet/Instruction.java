package InstructionSet;

import java.util.List;

public abstract class Instruction {

  //Base instruction class that all the other will be built off of, most will involve registers being passed
  //into the instruction which are then used to compute the output instruction.
  public Instruction() {


  }

  public abstract void genInstruction(List<Instruction> instructions);

}

package InstructionSet;

import java.util.List;

public abstract class Instruction {

  //Base instruction class that all the other will be built off of, most will involve registers being passed
  //into the instruction which are then used to compute the output instruction.
  public Instruction() {

  }

  public abstract void genInstruction();

  /**
   * @return the number of registers the instruction requires
   */
  public abstract int requiresRegisters();

  /**
   * @return true if the instruction requires a previously defined register
   */
  public abstract boolean crossOverRegister();

  public String getID(){
    return this.getClass().getSimpleName();
  }

}

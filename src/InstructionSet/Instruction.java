package InstructionSet;

import java.util.List;

public abstract class Instruction {

  //Base instruction class that all the other will be built off of, most will involve registers being passed
  //into the instruction which are then used to compute the output instruction.
  public Instruction() {

  }

  /**
   * Returns true if src is equal to dst
   */
  public boolean compareDstSrc(String src, String dst){
    return src.equals(dst);
  }

  /**
   * Generates the instruction block as a string for the current instruction
   */
  public abstract void genInstruction();

  public String getID() {
    return this.getClass().getSimpleName();
  }

}

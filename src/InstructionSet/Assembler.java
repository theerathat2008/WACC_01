package InstructionSet;

import java.util.List;

/**
 * Implemented the singleton pattern for assmebler
 */

public class Assembler {

  List<Instruction> instructions;

  private static Assembler instance = null;

  private Assembler(){

  }

  public void setInstructions(List<Instruction> instructions) {
    this.instructions = instructions;
  }

  private void parseInstructions(){
    for(Instruction currInstr : instructions){
      currInstr.genInstruction();
    }
  }

  public static Assembler getInstance(){
    if(instance == null){
      instance = new Assembler();
    }
    return instance;
  }

}

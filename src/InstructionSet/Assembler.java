package InstructionSet;

import Registers.RegisterARM;
import Registers.RegisterAllocation;

import java.util.List;

/**
 * Implemented the singleton pattern for assmebler
 */

public class Assembler {

  List<Instruction> instructions;
  RegisterAllocation registerAlloc;

  private static Assembler instance = null;

  private Assembler(){

  }

  public void setInstructions(List<Instruction> instructions) {
    this.instructions = instructions;
  }

  public void setRegisterAlloc(RegisterAllocation registerAlloc){
    this.registerAlloc = registerAlloc;
  }

  public void parseInstructions() throws Exception{
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

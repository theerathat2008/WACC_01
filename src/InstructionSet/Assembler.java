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

  private void parseInstructions() throws Exception{
    for(Instruction currInstr : instructions){
      if(currInstr instanceof InstructionIf){
        RegisterARM freeReg = registerAlloc.useRegister();
      }
    }
  }



  public void allocateRegInstr(InstructionIf instructionIf) throws Exception{
    RegisterARM freeReg = registerAlloc.useRegister();
    instructionIf.allocateRegisters(freeReg);
  }


  public static Assembler getInstance(){
    if(instance == null){
      instance = new Assembler();
    }
    return instance;
  }

}

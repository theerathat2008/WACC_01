package InstructionSet;

import ASTNodes.AST_Node;
import Registers.RegisterARM;
import Registers.RegisterAllocation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Implemented the singleton pattern for assmebler
 */

public class Assembler {

  List<Instruction> instructions;
  RegisterAllocation registerAlloc;

  AST_Node rootNode;

  List<String> assemblyCode = new LinkedList<>();

  public void setRootNode(AST_Node rootNode) {
    this.rootNode = rootNode;
  }

  private static Assembler instance = null;

  private Assembler(){

  }

  public void setInstructions(List<Instruction> instructions) {
    this.instructions = instructions;
  }

  public void setRegisterAlloc(RegisterAllocation registerAlloc){
    this.registerAlloc = registerAlloc;
  }

  public void parseInstructions(){
    for(Instruction currInstr : instructions){
      currInstr.genInstruction();
    }
  }


  public void assembleInstructions() {
    rootNode.acceptInstr(assemblyCode);
  }

  
  public static Assembler getInstance(){
    if(instance == null){
      instance = new Assembler();
    }
    return instance;
  }
}

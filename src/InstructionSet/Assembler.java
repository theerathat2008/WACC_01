package InstructionSet;

import ASTNodes.AST_Node;
import InstructionSet.InstructionError.InstructionError;
import InstructionSet.InstructionPrintBlocks.InstructionPrintBlocks;
import InstructionSet.InstructionReadBlocks.InstructionReadBlocks;
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
    String Output = String.join("", assemblyCode);
    Output = generatePreCode() +"\n\n\t.text\n\n" +  Output + generatePostCode();


    System.out.println(Output);
  }

  public String generatePreCode() {
    List<String> stringList = registerAlloc.getStringList();
    String result = "\t.data\n\n";
    System.out.println(stringList.size());
    for (int i = 0; i < stringList.size(); i++) {
      result.concat("\tmsg_");
      result.concat(Integer.toString(i));
      result.concat("\n\t\t.word ");
      result.concat(Integer.toString(stringList.get(i).length()));
      result.concat("\n\t\t.ascii \"");
      result.concat(stringList.get(i));
      result.concat("\"\n");
    }
    return result;
  }

  public String generatePostCode() {
    String result = "";
    for(Instruction currInstr : instructions){
      String superName = currInstr.getClass().getSuperclass().getSimpleName();
      if (superName.equals("InstructionReadBlocks")) {
        System.out.println("Type ReadBlocks");
        result.concat(((InstructionReadBlocks) currInstr).resultBlock);
      } else if(superName.equals("InstructionPrintBlocks")) {
        System.out.println("Type PrintBlocks");
        result.concat(((InstructionPrintBlocks) currInstr).resultBlock);
      } else if (superName.equals("InstructionError")) {
        System.out.println("Type Error");
        result.concat(((InstructionError) currInstr).resultBlock);
      }
    }
    return result;
  }


  
  public static Assembler getInstance(){
    if(instance == null){
      instance = new Assembler();
    }
    return instance;
  }
}

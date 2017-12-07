package InstructionSet;

import Registers.RegisterARM;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InstructionCall extends Instruction {
  String resultBlock;
  String fName;
  String returnType;
  List<String> varCallBlocks;
  Stack<String> stackRegisters;


  public InstructionCall(String fName, String returnType) {
    this.fName = fName;
    this.returnType = returnType;
    this.resultBlock = "";
    this.varCallBlocks = new ArrayList<>();
    stackRegisters = new Stack<String>();
  }

  public List<String> getVarCallBlocks() {
    return varCallBlocks;
  }

  public String getResultBlock() {
    return resultBlock;
  }

  public void genCallInstruction(String src, String dst, String type, RegisterARM interReg){
    StringBuilder callBlock = new StringBuilder();
    if(!compareDstSrc(src, dst)){
      if(type.equals("reg, reg")){
        callBlock.append("\t\t");
        callBlock.append("MOV");
        callBlock.append(" ");
        callBlock.append(src);
        callBlock.append(", ");
        callBlock.append(dst);
        callBlock.append("\n");
      } else if(type.equals("stack, stack")){
        // LDR inter, Src
        // STR inter, Dst
        callBlock.append("\t\t");
        callBlock.append("LDR ");
        callBlock.append(interReg.name());
        callBlock.append(", ");
        callBlock.append(src);
        callBlock.append("\n");
        callBlock.append("\t\t");
        callBlock.append("STR ");
        callBlock.append(interReg.name());
        callBlock.append(", ");
        callBlock.append(dst);
        callBlock.append("\n");
      } else if(type.equals("stack, reg")){
        // LDR src, dst
        callBlock.append("\t\t");
        callBlock.append("LDR");
        callBlock.append(" ");
        callBlock.append(src);
        callBlock.append(", ");
        callBlock.append(dst);
        callBlock.append("\n");
      } else if(type.equals("reg, stack")){
        // LDR inter, src
        // MOV dst, inter
        callBlock.append("\t\t");
        callBlock.append("LDR ");
        callBlock.append(interReg.name());
        callBlock.append(", ");
        callBlock.append(src);
        callBlock.append("\n");
        callBlock.append("\t\t");
        callBlock.append("MOV ");
        callBlock.append(dst);
        callBlock.append(", ");
        callBlock.append(interReg.name());
        callBlock.append("\n");
      }
    } else if(type.equals("reg, reg")) {
      callBlock.append("\t\t");
      callBlock.append("PUSH {");
      callBlock.append(src);
      callBlock.append("}\n");
      stackRegisters.push(src);
    }
    varCallBlocks.add(callBlock.toString());
  }


  @Override
  public void genInstruction() {
    StringBuilder block = new StringBuilder();
    block.append("\t\tBL f_");
    block.append(fName);
    block.append("\n");
    for (String reg : stackRegisters) {
      block.append("\t\t");
      block.append("POP {");
      block.append(reg);
      block.append("}\n");
    }

    resultBlock = block.toString();
  }

  @Override
  public int requiresRegisters() {
    return 2;
  }

  @Override
  public boolean crossOverRegister() {
    return false;
  }

}

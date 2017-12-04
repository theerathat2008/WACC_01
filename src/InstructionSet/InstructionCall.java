package InstructionSet;

import java.util.ArrayList;
import java.util.List;

public class InstructionCall extends Instruction {
  String resultBlock;
  String fName;
  String returnType;
  List<String> varCallBlocks;


  public InstructionCall(String fName, String returnType) {
    this.fName = fName;
    this.returnType = returnType;
    this.resultBlock = "";
    this.varCallBlocks = new ArrayList<>();
  }

  public List<String> getVarCallBlocks() {
    return varCallBlocks;
  }

  public String getResultBlock() {
    return resultBlock;
  }

  public void genCallInstruction(String src, String dst, String type){
    StringBuilder callBlock = new StringBuilder();
    if(!compareDstSrc(src, dst)){
      callBlock.append("\t\t");
      if(type.equals("regMOV")){
        callBlock.append("MOV");
      } else {
        callBlock.append("STR");
      }
      callBlock.append(" ");
      callBlock.append(src);
      callBlock.append(", ");
      callBlock.append(dst);
      callBlock.append("\n");
      varCallBlocks.add(callBlock.toString());
    }
  }


  @Override
  public void genInstruction() {
    StringBuilder block = new StringBuilder();
    block.append("\t\tBL f_");
    block.append(fName);
    block.append("\n");
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

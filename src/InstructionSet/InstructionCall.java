package InstructionSet;

import java.util.ArrayList;
import java.util.List;

public class InstructionCall extends Instruction {
  String resultBlock;
  String fName;
  String returnType;
  List<String> varCallBlocks = new ArrayList<>();

  public InstructionCall(String fName, String returnType) {
    this.fName = fName;
    this.returnType = returnType;
    this.resultBlock = "";
    this.varCallBlocks = null;
  }

  public List<String> getVarCallBlocks() {
    return varCallBlocks;
  }

  public String getResultBlock() {
    return resultBlock;
  }

  public void genCallInstruction(String src, String dst, String type){
    StringBuilder callBlock = new StringBuilder();
    callBlock.append("\t\t");
    callBlock.append(getType(type));
    callBlock.append(src);
    callBlock.append(", ");
    callBlock.append(dst);
    varCallBlocks.add(callBlock.toString());
  }

  private String getType(String type){
    return "MOV";
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

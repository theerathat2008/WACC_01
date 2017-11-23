package InstructionSet;

import java.util.List;

public class InstructionMessage extends Instruction {
  String resultBlock = "";
  List<String> stringList;

  public InstructionMessage(List<String> stringList) {
    this.stringList = stringList;
  }



  @Override
  public void genInstruction() {
    resultBlock.concat(".data\n");
    resultBlock.concat("\n");
    for (int i = 0; i < stringList.size(); i++) {
      resultBlock.concat("msg_" + i + ":\n");
      resultBlock.concat("\t\t.word " + stringList.get(i).length() + "\n");
      resultBlock.concat("\t\t.ascii \"" + stringList.get(i) + "\"\n");
    }
    resultBlock.concat("\n");
  }

  @Override
  public int requiresRegisters() {
    return 0;
  }

  @Override
  public boolean crossOverRegister() {
    return false;
  }

}

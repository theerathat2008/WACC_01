package InstructionSet;

import java.util.List;

public class InstructionMessage extends Instruction {
  String resultBlock = "";
  List<String> stringList;

  /**
   * Class constructor
   * @param stringList
   */
  public InstructionMessage(List<String> stringList) {
    this.stringList = stringList;
  }

  /**
   * Generates the instruction block as a string for the current instruction
   */
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
}

package InstructionSet.InstructionNewArray;

import java.util.List;

public class InstructionArrayString extends InstructionArray {
  List<String> arrayElems;

  public InstructionArrayString(List<String> arrayElems, String type) {
    super(type);
    this.arrayElems = arrayElems;
    this.arraySize = arrayElems.size();
  }

  public String getMsgNum() {
    //TODO
    return null;
  }

  @Override
  public String getArrayElems() {
    String result = "";
    for (int i = 1; i < arraySize + 1; i++) {
      result.concat("\t\tLDR " + reg3 + ", =msg_" + getMsgNum() + "\n");
      result.concat("\t\tSTR " + reg3 + ", [" + reg2 + ", #" + ((i*4) + "]\n"));
    }
    return result;
  }

}

package InstructionSet.InstructionDeclOrAss.InstructionDeclAssArray;

import java.util.List;

public class InstructionDeclAssArrayString extends InstructionDeclAssArray {
  List<String> arrayElems;

  public InstructionDeclAssArrayString(List<String> arrayElems) {
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

  @Override
  public int requiresRegisters() {
    return 0;
  }

  @Override
  public boolean crossOverRegister() {
    return false;
  }

}

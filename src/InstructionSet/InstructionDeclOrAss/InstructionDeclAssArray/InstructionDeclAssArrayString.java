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
    StringBuilder result = new StringBuilder();
    for (int i = 1; i < arraySize + 1; i++) {
      result.append("\t\tLDR ");
      result.append(reg3);
      result.append(", =msg_");
      result.append(getMsgNum());
      result.append("\n\t\tSTR ");
      result.append(reg3);
      result.append(", [");
      result.append(reg2);
      result.append(", #");
      result.append((4 * (i + 1)));
      result.append("]\n");
    }
    return result.toString();
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

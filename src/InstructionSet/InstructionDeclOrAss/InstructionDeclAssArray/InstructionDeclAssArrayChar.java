package InstructionSet.InstructionDeclOrAss.InstructionDeclAssArray;

import java.util.List;

public class InstructionDeclAssArrayChar extends InstructionDeclAssArray {
  List<Character> arrayElems;

  public InstructionDeclAssArrayChar(List<Character> arrayElems) {
    this.arrayElems = arrayElems;
    this.arraySize = arrayElems.size();
  }

  @Override
  public String getArrayElems() {
    StringBuilder result = new StringBuilder();

    for (int i = 0; i < arraySize; i ++) {
      result.append("\t\tMOV ");
      result.append(reg3);
      result.append(", #");
      result.append(arrayElems.get(i));
      result.append("\n\t\tSTRB ");
      result.append(reg3);
      result.append(", [");
      result.append(reg2);
      result.append(", #");
      result.append((4+i));
      result.append("]\n");

    }
    return result.toString();
  }

  @Override
  public int requiresRegisters() {
    return 3;
  }

  @Override
  public boolean crossOverRegister() {
    return false;
  }

}

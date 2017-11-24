package InstructionSet.InstructionDeclOrAss.InstructionDeclAssArray;

import java.util.List;

public class InstructionDeclAssArrayBool extends InstructionDeclAssArray {
  List<Boolean> arrayElems;

  public InstructionDeclAssArrayBool(List<Boolean> arrayElems) {
    this.arrayElems = arrayElems;
    this.arraySize = arrayElems.size();
  }

  public int getBoolNum(Boolean bool) {
    if (bool) {
      return 1;
    }
    return 0;
  }

  @Override
  public String getArrayElems() {
    StringBuilder result = new StringBuilder();

    for (int i = 0; i < arraySize; i++) {
      result.append("\t\tMOV ");
      result.append(reg3);
      result.append(", #");
      result.append(getBoolNum(arrayElems.get(i)));
      result.append("\n\t\tSTRB "); //may need a ] here, not sure, was in original code but doesnt make sense
      result.append(reg3);
      result.append(", [");
      result.append(reg2);
      result.append(", #");
      result.append((4 + i));
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

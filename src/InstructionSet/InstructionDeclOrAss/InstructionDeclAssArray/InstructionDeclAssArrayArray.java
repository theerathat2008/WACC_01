package InstructionSet.InstructionDeclOrAss.InstructionDeclAssArray;

import java.util.List;

public class InstructionDeclAssArrayArray<T> extends InstructionDeclAssArray {
  List<List<T>> arrayElems;

  public InstructionDeclAssArrayArray(List<List<T>> arrayElems, String type) {
    super();
    this.arrayElems = arrayElems;
    this.arraySize = arrayElems.size();
  }

  public String getArrayFromSP() {
    //TODO
    return null;
  }

  @Override
  public String getArrayElems() {
    StringBuilder result = new StringBuilder();

    for (int i = 0; i < arraySize; i++) {
      result.append("\t\tLDR ");
      result.append(reg3);
      result.append(", [sp, #");
      result.append(getArrayFromSP());
      result.append("]\n\t\tSTR ");
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
    return 3;
  }

  @Override
  public boolean crossOverRegister() {
    return false;
  }

}
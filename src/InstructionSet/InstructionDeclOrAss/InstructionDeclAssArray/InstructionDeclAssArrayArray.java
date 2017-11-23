package InstructionSet.InstructionDeclOrAss.InstructionDeclAssArray;

import java.util.List;

public class InstructionDeclAssArrayArray<T> extends InstructionDeclAssArray {
  List<List<T>> arrayElems;

  public InstructionDeclAssArrayArray(List<List<T>> arrayElems, String type) {
    super(type);
    this.arrayElems = arrayElems;
    this.arraySize = arrayElems.size();
  }

  public String getArrayFromSP() {
    //TODO
    return null;
  }

  @Override
  public String getArrayElems() {
    String result = "";

    for (int i = 0; i < arraySize; i++) {
      result.concat("\t\tLDR " + reg3 + ", " + "[sp, #" + getArrayFromSP() + "]" + "\n");
      result.concat("\t\tSTR " + reg3 + ", " + "[" + reg2 + ", " + "#" + (4 * (i + 1)) + "]\n");
    }
    return result;
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
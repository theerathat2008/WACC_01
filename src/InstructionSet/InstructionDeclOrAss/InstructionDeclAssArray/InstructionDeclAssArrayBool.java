package InstructionSet.InstructionDeclOrAss.InstructionDeclAssArray;

import java.util.List;

public class InstructionDeclAssArrayBool extends InstructionDeclAssArray {
  List<Boolean> arrayElems;

  public InstructionDeclAssArrayBool(List<Boolean> arrayElems) {
    this.arrayElems = arrayElems;
    this.arraySize = arrayElems.size();
  }

  public int getBoolNum(Boolean bool){
    if (bool) {
      return 1;
    } return 0;
  }

  @Override
  public String getArrayElems() {
    String result = "";

    for (int i = 0; i < arraySize; i++) {
      result.concat("\t\tMOV " + reg3 + ", #" + getBoolNum(arrayElems.get(i)) + "]" + "\n");
      result.concat("\t\tSTRB " + reg3 + ", [" + reg2 + ", " + "#" + (4+i) + "]\n");
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

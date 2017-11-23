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
    String result = "";

    for (int i = 0; i < arraySize; i ++) {
      result.concat("\t\tMOV " +  reg3 + ", #'" + arrayElems.get(i) + "'\n");
      result.concat("\t\tSTRB " +  reg3 + ", [" + reg2 + ", #" + (4+i) + "]\n");
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

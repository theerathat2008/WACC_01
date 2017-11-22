package InstructionSet.InstructionVarDecl.InstructionNewArray;

import java.util.List;

public class InstructionArrayChar extends InstructionArray {
  List<Character> arrayElems;

  public InstructionArrayChar(List<Character> arrayElems, String type) {
    super(type);
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
}

package InstructionSet.InstructionDeclOrAss.InstructionAssArrayElem;

public class InstructionAssArrayBool extends InstructionAssArrayElem {


  public InstructionAssArrayBool(String sp, String posInArray, String data) {
    super(sp, posInArray, data);
  }

  public int getBoolNum(String s) {
    if (s.equals("true")) {
      return 1;
    }
    return 0;
  }


  @Override
  public String getLoadData() {
    return "\t\tMOV " + reg3 + ", #" + getBoolNum(data) + "\n";
  }

  @Override
  public String getSTRLast() {
    StringBuilder result = new StringBuilder();
    result.append("\t\tADD ");
    result.append(reg4);
    result.append(", ");
    result.append(reg4);
    result.append(", ");
    result.append(reg5);
    result.append("\n\t\tSTRB ");
    result.append(reg3);
    result.append(", ");
    result.append("[");
    result.append(reg4);
    result.append("]\n");
    return result.toString();
  }

}

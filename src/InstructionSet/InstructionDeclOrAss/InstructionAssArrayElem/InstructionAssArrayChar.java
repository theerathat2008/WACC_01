package InstructionSet.InstructionDeclOrAss.InstructionAssArrayElem;

public class InstructionAssArrayChar extends InstructionAssArrayElem {

  public InstructionAssArrayChar(String sp, String posInArray, String data) {
    super(sp, posInArray, data);
  }

  @Override
  public String getLoadData() {
    return "\t\tMOV " + reg3 + ", #'" + data + "'\n";
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
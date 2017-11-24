package InstructionSet.InstructionDeclOrAss.InstructionAssArrayElem;

public class InstructionAssArrayInt extends InstructionAssArrayElem {

  public InstructionAssArrayInt(String sp, String posInArray, String data) {
    super(sp, posInArray, data);
  }

  @Override
  public String getLoadData() {
    return "\t\tMOV " + reg3 + ", =" + data + "\n";
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
    result.append(", LSL #2");
    result.append("\n\t\tSTR ");
    result.append(reg3);
    result.append(", [");
    result.append(reg4);
    result.append("]\n");

    return result.toString();
  }

}

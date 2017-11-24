package InstructionSet.InstructionDeclOrAss.InstructionAssArrayElem;

public class InstructionAssArrayString extends InstructionAssArrayElem {

  public InstructionAssArrayString(String sp, String posInArray, String msgNum) {
    super(sp, posInArray, msgNum);
  }

  @Override
  public String getLoadData() {
    return "\t\tMOV " + reg3 + ", =msg_" + data + "\n";
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

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
    String result = "";
    result.concat("\t\tADD " + reg4 + ", " + reg4 + ", " + reg5 + ", LSL #2" + "\n");
    result.concat("\t\tSTR " + reg3 + ", " + "[" + reg4 + "]" + "\n");
    return result;
  }

}

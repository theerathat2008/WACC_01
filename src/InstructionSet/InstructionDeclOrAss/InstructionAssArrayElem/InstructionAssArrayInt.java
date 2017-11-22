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
    String result = "";
    result.concat("\t\tADD " + reg4 + ", " + reg4 + ", " + reg5 + "LSL #2" + "\n");
    result.concat("\t\tSTR " + reg3 + ", " + "[" + reg4 + "]" + "\n");
    return result;
  }
}

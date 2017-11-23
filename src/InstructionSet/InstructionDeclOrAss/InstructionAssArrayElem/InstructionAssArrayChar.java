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
    String result = "";
    result.concat("\t\tADD " + reg4 + ", " + reg4 + ", " + reg5 + "\n");
    result.concat("\t\tSTRB " + reg3 + ", " + "[" + reg4 + "]" + "\n");
    return result;
  }

}
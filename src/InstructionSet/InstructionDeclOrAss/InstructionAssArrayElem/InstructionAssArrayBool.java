package InstructionSet.InstructionDeclOrAss.InstructionAssArrayElem;

public class InstructionAssArrayBool extends InstructionAssArrayElem {

  public InstructionAssArrayBool(String sp, String posInArray, String data) {
    super(sp, posInArray, data);
  }

  public int getBoolNum(String s){
    if (s.equals("true")) {
      return 1;
    }
    return 0;
  }


  @Override
  public String getLoadData() {
    return "\t\tMOV " +  reg3 + ", #" + getBoolNum(data) + "\n";
  }

  @Override
  public String getSTRLast() {
    String result = "";
    result.concat("\t\tADD " +  reg4 + ", " + reg4 +  ", " + reg5 + "\n");
    result.concat("\t\tSTRB " +  reg3 + ", " + "[" + reg4 + "]" + "\n");
    return result;
  }

}

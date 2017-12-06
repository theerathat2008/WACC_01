package InstructionSet;

import Registers.RegisterARM;

public class InstructionAccessArrayElem extends Instruction {
  private String resultBlock;
  private String regR0;
  private String regR1;
  private String resultReg;
  private String posReg;
  private String pos;
  private boolean isStack;
  private String type;
  private String arrayLocationReg;
  boolean str;

  public InstructionAccessArrayElem(String posInArray, String type, boolean str) {
    this.type = type;
    this.pos = posInArray;
    this.regR0 = "arrayBoundReg1";
    this.regR1 = "regR1";
    this.resultReg = "resultReg";
    this.posReg = "posReg";
    this.isStack = false;
    this.str = str;
  }

  public void allocateRegisters(RegisterARM resultReg, RegisterARM posReg) {
    this.regR0 = "r0"; //always r0
    this.regR1 = "r1"; //always r1
    this.resultReg = resultReg.name(); //any free reg
    this.posReg = posReg.name(); //any free reg
  }

  public void allocateLocation(String arrayLocation, boolean isStack){
    this.isStack = isStack;
    this.arrayLocationReg = arrayLocation;
  }

  public String getResultBlock() {
    return resultBlock;
  }



  public int getBoolNum(String s) {
    if (s.equals("true")) {
      return 1;
    }
    return 0;
  }

  public String getLastLine(){
    StringBuilder builder = new StringBuilder();

    switch (type) {
      case ("int"):
      case ("string"):
        builder.append("\t\tADD " + resultReg + ", " + resultReg + ", " + posReg + ", LSL #2\n");
        if (str) {
          builder.append("\t\tSTR ");
        } else {
          builder.append("\t\tLDR ");
        }
        break;
      case ("strElem"):
      case ("bool"):
      case ("char"):
        builder.append("\t\tADD " + resultReg + ", " + resultReg + ", " + posReg + "\n");
        if (str) {
          builder.append("\t\tSTRB ");
        } else {
          builder.append("\t\tLDRSB ");
        }
        break;
      default:
        return "Unrecognised type, instrassarrayelem->getStrlast\n";
    }

    builder.append(resultReg + ", [" + resultReg + "]\n");
    return builder.toString();


  }


  //ArrayLocationReg is the memory address of the array variable
  //posReg is just a temp reg
  //resultReg is just temp reg and holds the final result i.e. the value at the array index

  @Override
  public void genInstruction() {
    StringBuilder builder = new StringBuilder();
    //builder.append(getLoadData());

    //You want pointer to the memory heap location to be in resultReg
    //In arrayLocationReg we have the either reg   = memory heap address (r4)
    //                                       stack = memory heap address ([sp, #8])

    if(isStack){
      builder.append("\t\tADD ");
      builder.append(resultReg);
      builder.append(", ");
      int displacement = 0;
      if(!arrayLocationReg.equals("[sp]")){
        displacement = Integer.parseInt(arrayLocationReg.replaceAll("[\\D]", ""));
      }
      builder.append("sp");
      builder.append(", #"+ displacement + "\n");
    } else {
      builder.append("\t\tMOV ");
      builder.append(resultReg);
      builder.append(", ");
      //System.out.println("ARRAY LOCATION IS :  " + arrayLocationReg);
      builder.append(arrayLocationReg);
      builder.append("\n");
    }
    builder.append("\t\tLDR ");
    builder.append(posReg);
    builder.append(", =");
    builder.append(pos);
    builder.append("\n\t\tLDR ");
    builder.append(resultReg);
    builder.append(", [");
    builder.append(resultReg);
    builder.append("]\n\t\tMOV ");
    builder.append(regR0);
    builder.append(", ");
    builder.append(posReg);
    builder.append("\n\t\tMOV ");
    builder.append(regR1);
    builder.append(", ");
    builder.append(resultReg);
    builder.append("\n\t\tBL p_check_array_bounds\n");
    builder.append("\t\tADD ");
    builder.append(resultReg);
    builder.append(", ");
    builder.append(resultReg);
    builder.append(", #4\n");
    builder.append(getLastLine());
    builder.append("\t\tMOV r5, r4\n");
    resultBlock = builder.toString();
  }

  @Override
  public int requiresRegisters() {
    return 5;
  }

  @Override
  public boolean crossOverRegister() {
    return false;
  }

}
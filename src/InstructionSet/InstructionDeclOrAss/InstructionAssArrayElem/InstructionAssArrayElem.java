package InstructionSet.InstructionDeclOrAss.InstructionAssArrayElem;

import InstructionSet.Instruction;
import Registers.RegisterARM;

public class InstructionAssArrayElem extends Instruction {
  private String resultBlock1;
  private String resultBlock2;
  private String regR0;
  private String regR1;
  private String resultReg;
  private String posReg;
  //private String pos;
  private boolean isStack;
  private String type;
  private String arrayLocationReg;
  private String itemReg;
  boolean str;

  public InstructionAssArrayElem(String type, boolean str) {
    this.type = type;
    this.regR0 = "arrayBoundReg1";
    this.regR1 = "regR1";
    this.resultReg = "resultReg";
    this.posReg = "posReg";
    this.isStack = false;
    this.str = str;
    this.itemReg = "itemReg";
  }

  public void allocateRegisters(RegisterARM resultReg, RegisterARM posReg, RegisterARM itemReg) {
    this.regR0 = "r0"; //always r0
    this.regR1 = "r1"; //always r1
    this.resultReg = resultReg.name(); //any free reg
    this.posReg = posReg.name(); //any free reg
    this.itemReg = itemReg.name();
  }

  public void allocateLocation(String arrayLocation, boolean isStack){
    this.isStack = isStack;
    this.arrayLocationReg = arrayLocation;
  }

  public String getResultBlock1() {
    return resultBlock1;
  }

  public String getResultBlock2() {
    return resultBlock2;
  }



  public int getBoolNum(String s) {
    if (s.equals("true")) {
      return 1;
    }
    return 0;
  }

  public String getLastLine(){
    StringBuilder builder = new StringBuilder();

    System.out.println("TYPE: " + type);

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

    builder.append(itemReg + ", [" + resultReg + "]\n");
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

    resultBlock1 = builder.toString();



    builder = new StringBuilder();

    //builder.append("\n\n\n\n LDR instr: ");

//    builder.append("\t\tLDR ");
//    builder.append(posReg);
//    builder.append(", =");
//    builder.append(pos);
//    builder.append("\n");

    //builder.append("\n\n\n\n LDR instr: ");

    builder.append("\t\tLDR ");
    builder.append(posReg);
    builder.append(", [sp]");
    builder.append("\n");

    builder.append("\t\tLDR ");
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
    resultBlock2 = builder.toString();
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
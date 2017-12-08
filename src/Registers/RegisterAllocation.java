package Registers;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Class to keep track of free registers and allocate registers
 */
public class RegisterAllocation {

  /**
   * Class Constructor - Adds all normal registers to the stack
   * constructor for freeRegisters
   */
  public RegisterAllocation() {
    stackSize = 0;
    currentScope = "Global";
    freeRegisters.push(RegisterARM.r12);
    freeRegisters.push(RegisterARM.r11);
    freeRegisters.push(RegisterARM.r10);
    freeRegisters.push(RegisterARM.r9);
    freeRegisters.push(RegisterARM.r8);
    freeRegisters.push(RegisterARM.r7);
    freeRegisters.push(RegisterARM.r6);
    freeRegisters.push(RegisterARM.r5);
    freeRegisters.push(RegisterARM.r4);
  }


  /**
   * Stack holding all free registers
   */
  Stack<RegisterARM> freeRegisters = new Stack<>();

  /**
   * Map that Maps a register to a usage described in the String
   */
  Map<RegisterARM, RegisterUsage> registerInUse = new ConcurrentHashMap<>();

  public void printRegInUse(){
    for (Map.Entry<RegisterARM, RegisterUsage> entry : registerInUse.entrySet()) {
      System.out.println(entry.getKey() + " with type " + entry.getValue().usageType);
    }
  }

  public void printfreeReg(){
    System.out.println(Arrays.toString(freeRegisters.toArray()));
  }

  /**
   * List that stores variables that have to be created on the stack
   */
  List<String> stackOnlyVar = new ArrayList<>();
  public void addToStackOnlyVar(String varName){
    stackOnlyVar.add(varName);
  }
  public boolean checkIfOnStackOnlyVar(String varName){
    return stackOnlyVar.contains(varName);
  }

  public void printStackOnlyVar(){
    System.out.println(Arrays.toString(stackOnlyVar.toArray()));
  }


  /**
   * Map that stores variables declared
   */
  Map<RegisterARM, RegisterUsage> varRegisters = new ConcurrentHashMap<>();


  /**
   * Map that stores a funcRegisters with the key being the funcName
   */
  Map<String, Map<RegisterARM, RegisterUsage>> funcRegisters = new ConcurrentHashMap<>();

  /**
   * Map that takes a variable name and maps it to a StackLocation
   */
  Map<String, StackLocation> stackInUse = new HashMap<>();

  /**
   * Map that stores the stack locations for functions with the key being the funcName
   */
  Map<String, Map<String, StackLocation>> funcStackVar = new HashMap<>();

  /**
   * List that holds the string messages that are generated in Assembly
   */
  List<String> stringList = new ArrayList<>();

  /**
   * The current scope of the Program
   */
  String currentScope;

  /**
   * The current stack size
   */
  int stackSize;

  int varDeclCount = 0;


  public int getVarDeclCount() {
    return varDeclCount;
  }

  public void incVarDeclCount() {
    this.varDeclCount++;
  }

  /**
   * The final stack size based on the number of variables allocated on the stack
   */
  int finalStackSize = 0;

  int currentLabel = 0;


  /**
   * returns the current stack size
   */
  public int getStackSize() {
    return stackSize;
  }

  /**
   * returns the final stack size
   */
  public int getFinalStackSize() {
    return finalStackSize;
  }

  /**
   * function to set the final stack size
   */
  public void setFinalStackSize(int finalStackSize) {
    this.finalStackSize = finalStackSize;
  }

  /**
   * function to set the current stack size
   */
  public void setStackSize(int stackSize) {
    this.stackSize = stackSize;
  }

  /**
   * function to set the current scope using an input string variable
   * Options of Scope are: "funcScope" "globalScope"
   */
  public void setCurrentScope(String currentScope) {
    this.currentScope = currentScope;
  }

  public String getCurrentScope() {
    return currentScope;
  }

  public int getMemSize(String type) {
    switch (type) {
      case "char":
        return 1;
      case "int":
        return 4;
      case "bool":
        return 1;
      case "string":
      case "str":
        return 4;
      default:
        if (type.contains("[]")) {
          return 4; //for arrays -> elements of the array are stored on the heap so no need to account for those in sp size
        }
        return 4;
    }
  }


  /**
   * Adds given identName and created stackLocation to the stackInUse map
   */
  public void addToStack(String identName, StackLocation stackLocation) {
    stackInUse.put(identName, stackLocation);
  }

  public void addToFuncStack(String funcName, String identName, StackLocation stackLocation){

    if(funcStackVar.containsKey(funcName)){
      funcStackVar.get(funcName).put(identName, stackLocation);
    } else {
      Map<String, StackLocation> newMap = new HashMap<>();
      newMap.put(identName, stackLocation);
      funcStackVar.put(funcName, newMap);
    }
  }

  /**
   * Returns a stackLocation based on the variable name
   */
  public String getStackLocation(String identName) {
    if (stackInUse.containsKey(identName)) {
      return stackInUse.get(identName).getLocation();
    }
    return "null";
  }

  public String getFuncStackLocation(String funcName, String varName){
    if(funcStackVar.containsKey((funcName))){
      Map<String, StackLocation> tempMap = funcStackVar.get(funcName);
      if(tempMap.containsKey(varName)){
        return tempMap.get(varName).getLocation();
      }
      System.out.println("Can't find " + varName + " in " + funcName + " map");
    }
    System.out.println("Can't find " + funcName + " map");
    return "null";
  }

  public String getFuncStackLocationCounter(String funcName, int counter){
    if(funcStackVar.containsKey((funcName))){
      Map<String, StackLocation> tempMap = funcStackVar.get(funcName);
      for (Map.Entry<String, StackLocation> entry : tempMap.entrySet()) {
        if (entry.getValue().getPos() == counter) {
          return entry.getValue().getLocation();
        }
      }
      System.out.println("Can't find " + counter + " in " + funcName + " map");
    }
    System.out.println("Can't find " + funcName + " map");
    return "null";
  }

  public List<String> getStringList() {
    return stringList;
  }

  boolean exprIdentFlag = false;

  public void setExprIdentFlag(boolean exprIdentFlag) {
    this.exprIdentFlag = exprIdentFlag;
  }

  public void addString(String string) {
    if (!stringList.contains(string) || exprIdentFlag) {
      stringList.add(string);
      exprIdentFlag = false;
    }
  }

  /**
   * Searches the Register in use Map by the usage varName
   * Returns the register if it used
   */
  public RegisterARM searchByVarValue(String varName) {
    for (Map.Entry<RegisterARM, RegisterUsage> entry : varRegisters.entrySet()) {
      if (varName.equals(entry.getValue().getVarName())) {
        return entry.getKey();
      }
    }
    return RegisterARM.NULL_REG;
  }

  /**
   * Searches the Register in use func Map by the usage varName
   * Returns the register if it used
   */
  public RegisterARM searchByFuncVarValue(String varName, String funcName) {
    for (Map.Entry<String, Map<RegisterARM, RegisterUsage>> entry : funcRegisters.entrySet()) {
      if (funcName.equals(entry.getKey())) {

        for(Map.Entry<RegisterARM, RegisterUsage> entryEmbedded : entry.getValue().entrySet()){
          if(varName.equals(entryEmbedded.getValue().getVarName())){
            return entryEmbedded.getKey();
          }
        }

      }
    }
    return RegisterARM.NULL_REG;
  }

  /**
   * Searches the Register in use func Map by the counter
   * Returns the register if it used
   */
  public RegisterARM searchByFuncVarCounter(int pos, String funcName) {
    for (Map.Entry<String, Map<RegisterARM, RegisterUsage>> entry : funcRegisters.entrySet()) {
      if (funcName.equals(entry.getKey())) {

        for(Map.Entry<RegisterARM, RegisterUsage> entryEmbedded : entry.getValue().entrySet()){
          if(entryEmbedded.getValue().getParamCallPos() == pos){
            return entryEmbedded.getKey();
          }
        }

      }
    }
    return RegisterARM.NULL_REG;
  }


  public int getStringID(String string) {
    int frequency = Collections.frequency(stringList, string);
    int counter = 1;
    int index = stringList.indexOf(string);
    while(frequency != counter){
      for(int i = stringList.indexOf(string) + 1; i < stringList.size(); i++){
        String curr = stringList.get(i);
        if(curr.equals(string)){
          index = i;
          break;
        }
      }
      counter++;
    }
    return index;
  }

  /**
   * @return - Returns next free register
   */
  public RegisterARM getNextFreeRegister() {
    return freeRegisters.pop();
  }

  /**
   * @param register
   * @return - Returns true if the register from the parameter is in the registerInUse list
   */
  public boolean checkIfRegisterInUse(RegisterARM register) {
    return registerInUse.containsKey(register);
  }

  /**
   * Add register from the parameter to the registerInUse list, meaning that this register is not free
   *
   * @param register
   */
  public void addRegisterInUse(RegisterARM register, RegisterUsage newReg) {
    registerInUse.put(register, newReg);
  }

  /**
   * @return - Returns a free register and removes it from the stack
   * Throws exception if no free registers remaining
   */
  public RegisterARM useRegister(RegisterUsage usage) throws Exception {
    if (registersFull()) {
      System.out.println("Registers are full at this point");
      return RegisterARM.NULL_REG;
    }
    RegisterARM poppedReg = freeRegisters.pop();
    addRegisterInUse(poppedReg, usage);

    if(usage.getUsageType().equals("funcType")){

      if(funcRegisters.containsKey(usage.getFuncName())){
        funcRegisters.get(usage.getFuncName()).put(poppedReg, usage);
      } else {
        Map<RegisterARM, RegisterUsage> newMap = new HashMap<>();
        newMap.put(poppedReg, usage);
        funcRegisters.put(usage.getFuncName(), newMap);
      }
    }

    if(usage.getUsageType().equals("varDecType")){
      varRegisters.put(poppedReg, usage);
    }
    return poppedReg;
  }

  public int getVarRegSize(){
    return varRegisters.size();
  }

  public void freeAllFuncReg(String funcName){
    List<RegisterARM> regToFree = new ArrayList<>();
    for (Map.Entry<RegisterARM, RegisterUsage> entry : registerInUse.entrySet()) {
      if (funcName.equals(entry.getValue().getFuncName())) {
        regToFree.add(entry.getKey());
      }
    }
    for(int j = 0; j < regToFree.size(); j++){
      freeRegister(regToFree.get(j));
    }
  }

  /**
   * @param register frees a register and pushes onto freeReg stack
   */
  public void freeRegister(RegisterARM register) {
    if (checkIfRegisterInUse(register)) {
      registerInUse.remove(register);
      freeRegisters.push(register);
    }
  }

  /**
   * @return Returns true if there are free registers remaining
   */
  public boolean registersFull() {
    return freeRegisters.isEmpty();
  }

  /**
   * @return - A new label for a branch
   */


  public String generateLabel() {
    return "L" + currentLabel++;
  }


}


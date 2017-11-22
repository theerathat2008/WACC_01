package Registers;

import java.util.*;

/**
 * Class to keep track of free registers and allocate registers
 */
public class RegisterAllocation{
  /**
   * Stack holding all free registers
   */
  Stack<RegisterARM> freeRegisters = new Stack<>();

  //List<RegisterARM> registerInUse = new ArrayList<>();

  Map<RegisterARM, String> registerInUse = new HashMap<>();

  List<String> stringList = new ArrayList<>();



  /**
   * Class Constructor - Adds all normal registers to the stack
   * constructor for freeRegisters
   */
  public RegisterAllocation() {
    freeRegisters.push(RegisterARM.R12);
    freeRegisters.push(RegisterARM.R11);
    freeRegisters.push(RegisterARM.R10);
    freeRegisters.push(RegisterARM.R9);
    freeRegisters.push(RegisterARM.R8);
    freeRegisters.push(RegisterARM.R7);
    freeRegisters.push(RegisterARM.R6);
    freeRegisters.push(RegisterARM.R5);
    freeRegisters.push(RegisterARM.R4);
  }


  public void addString(String string) {
    if (!stringList.contains(string)) {
      stringList.add(string);
    }
  }

  public int getStringID(String string) {
    return stringList.indexOf(string);
  }


  /**
   * @param register
   * @return - Returns next register of the register given in the parameter
   */
  public RegisterARM getNextReg(RegisterARM register) {
    return RegisterARM.values()[register.ordinal() + 1];
  }

  /**
   * @param register
   * @return - Returns previous register of the register given in the parameter
   */
  public RegisterARM getPreviousRegister(RegisterARM register) {
    return RegisterARM.values()[register.ordinal() - 1];
  }

  /**
   * @return - Returns last used register
   */
  public RegisterARM getLastUsedRegister() {
    //return registerInUse.get(registerInUse.size() - 1);
    return getPreviousRegister(freeRegisters.peek());
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
   * @param register
   */
  public void addRegisterInUse(RegisterARM register, String usage) {
    registerInUse.put(register, usage);
  }

  /**
   * Remove register from the parameter from the registerInUse list, meaning that this register becomes free
   * @param register
   */
  public void removeRegisterInUse(RegisterARM register) {
    registerInUse.remove(register);
  }

  /**
   * Remove all elements from the registerInUse list
   */
  public void clearRegisterInUseList() {
    registerInUse.clear();
  }

  /**
   * @return - Returns a free register and removes it from the stack
   * Throws exception if no free registers remaining
   */
  public RegisterARM useRegister(String usage) throws Exception{
    if (registersFull()) {
      throw new NullPointerException();
    }
    RegisterARM poppedReg = freeRegisters.pop();
    addRegisterInUse(poppedReg, usage);
    return poppedReg;
  }


//  public void addRegisterMap(String key, RegisterARM registerARM){
//    registerInUseMap.put(key, registerARM);
//  }
//
//  public void removeRegisterMap(String key){
//    registerInUseMap.remove(key);
//  }
//

  public String getRegisterMapValue(RegisterARM regToGet){
    if(registerInUse.containsKey(regToGet)){
      return registerInUse.get(regToGet);
    }
    System.out.println("Key is not in regMap");
    return "null";
  }


  /**
   * @param register frees a register and pushes onto freeReg stack
   */
  public void freeRegister(RegisterARM register) {
    if (checkIfRegisterInUse(register)){
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
   * @param register - Register to be searched in stack
   * @return - Returns true if register is not in the stack
   * This means that the register is not free
   */
  public boolean checkRegisterNotPresentOnStack(RegisterARM register) {
    return !freeRegisters.contains(register);
  }

  /**
   * @return - Returns a list of all normal registers that can be put in the free reg stack
   */
  public List<RegisterARM> getNormalRegisters() {
    List<RegisterARM> allRegs = new ArrayList<RegisterARM>(Arrays.asList(RegisterARM.values()));
    allRegs.remove(RegisterARM.CPSR);
    allRegs.remove(RegisterARM.LR);
    allRegs.remove(RegisterARM.PC);
    allRegs.remove(RegisterARM.SP);
    allRegs.remove(RegisterARM.SPSR);
    return allRegs;
  }

  /**
   * @param register
   * @return - Returns register name
   */
  public static String getRegName(RegisterARM register) {
    return register.name();
  }

  /**
   * Remove all elements from the freeRegister stack
   */
  public void clearFreeRegisters() {
    freeRegisters.clear();
  }
}

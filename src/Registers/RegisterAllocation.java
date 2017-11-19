package src.Registers;

import java.util.*;

/**
 * Class to keep track of free registers and allocate registers
 */
public class RegisterAllocation{
  /**
   * Stack holding all free registers
   */
  Stack<RegisterARM> freeRegisters = new Stack<>();
  List<RegisterARM> registerInUse = new ArrayList<>();

  /**
   * Class Constructor - Adds all normal registers to the stack
   * constructor for freeRegisters
   */
  public RegisterAllocation() {
    freeRegisters.addAll(getNormalRegisters());
  }

  public RegisterARM getRegR0() {
    return RegisterARM.R0;
  }

  public RegisterARM getRegR1() {
    return RegisterARM.R1;
  }

  public RegisterARM getRegR3() {
    return RegisterARM.R3;
  }

  /**
   * @return - Returns Stack Pointer Register
   */
  public RegisterARM getSPReg() {
    return RegisterARM.SP;
  }

  /**
   * @return - Returns Link Register
   */
  public RegisterARM getLinkReg() {
    return RegisterARM.LR;
  }

  /**
   * @return - Returns Program Counter Register
   */
  public RegisterARM getPCReg() {
    return RegisterARM.PC;
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

  public RegisterARM getLastUsedRegister() {
    return registerInUse.get(registerInUse.size() - 1);
  }

  /**
   * @return - Returns next free register
   */
  public RegisterARM getNextFreeRegister() {
    RegisterARM nxtFreeReg = getNextReg(getLastUsedRegister());
    return nxtFreeReg;
  }

  /**
   * @param register
   * @return - Returns true if the register from the parameter is in the registerInUse list
   */
  public boolean checkIfRegisterInUse(RegisterARM register) {
    return registerInUse.contains(register);
  }

  /**
   * Add register from the parameter to the registerInUse list
   * @param register
   */
  public void addRegisterInUse(RegisterARM register) {
    registerInUse.add(register);
  }

  public void removeRegisterInUse(RegisterARM register) {
    registerInUse.remove(register);
  }

  public void clearRegisterInUseList() {
    registerInUse.clear();
  }
  /**
   * @return - Returns a free register and removes it from the stack
   * Throws exception if no free registers remaining
   */
  public RegisterARM useRegister() throws Exception{
    if (registersFull()) {
      throw new NullPointerException();
    }
    return freeRegisters.pop();
  }

  /**
   * @param register frees a register and pushes onto freeReg stack
   */
  public void freeRegister(RegisterARM register) {
    if (checkRegisterNotPresentOnStack(register)) {
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

  public static String getRegName(RegisterARM register) {
    return register.name();
  }

  public void clearFreeRegisters() {
    freeRegisters.clear();
  }
}

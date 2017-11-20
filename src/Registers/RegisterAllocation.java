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

  /**
   * @return - Returns register R0
   */
  public RegisterARM getRegR0() {
    return RegisterARM.R0;
  }

  /**
   * @return - Returns register R1
   */
  public RegisterARM getRegR1() {
    return RegisterARM.R1;
  }

  /**
   * @return - Returns register R2
   */
  public RegisterARM getRegR2() {
    return RegisterARM.R2;
  }

  /**
   * @return - Returns register R3
   */
  public RegisterARM getRegR3() {
    return RegisterARM.R3;
  }

  /**
   * @return - Returns register R4
   */
  public RegisterARM getRegR4() {
    return RegisterARM.R4;
  }

  /**
   * @return - Returns register R5
   */
  public RegisterARM getRegR5() {
    return RegisterARM.R5;
  }

  /**
   * @return - Returns register R6
   */
  public RegisterARM getRegR6() {
    return RegisterARM.R6;
  }

  /**
   * @return - Returns register R7
   */
  public RegisterARM getRegR7() {
    return RegisterARM.R7;
  }

  /**
   * @return - Returns register R8
   */
  public RegisterARM getRegR8() {
    return RegisterARM.R8;
  }

  /**
   * @return - Returns register R9
   */
  public RegisterARM getRegR9() {
    return RegisterARM.R9;
  }

  /**
   * @return - Returns register R10
   */
  public RegisterARM getRegR10() {
    return RegisterARM.R10;
  }

  /**
   * @return - Returns register R11
   */
  public RegisterARM getRegR11() {
    return RegisterARM.R11;
  }

  /**
   * @return - Returns register R12
   */
  public RegisterARM getRegR12() {
    return RegisterARM.R12;
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
   * @return - Returns Current Program Status Register
   */
  public RegisterARM getCPSRReg() {
    return RegisterARM.CPSR;
  }

  /**
   * @return - Returns Saved Program Status Register
   */
  public RegisterARM getSPSRReg() {
    return RegisterARM.SPSR;
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
   * Add register from the parameter to the registerInUse list, meaning that this register is not free
   * @param register
   */
  public void addRegisterInUse(RegisterARM register) {
    registerInUse.add(register);
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

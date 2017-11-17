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

  /**
   * Class Constructor - Adds all normal registers to the stack
   */
  public RegisterAllocation() {
    freeRegisters.addAll(getNormalRegisters());
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
    if (checkRegisterNotPresent(register)) {
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
   */
  public boolean checkRegisterNotPresent(RegisterARM register) {
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
}

package src.Registers;

import java.util.*;

public class RegisterAllocation{
  Stack<RegisterARM> freeRegisters = new Stack<>();

  public RegisterAllocation() {
    List<RegisterARM> allRegs = new ArrayList<RegisterARM>(Arrays.asList(RegisterARM.values()));
    freeRegisters.addAll(allRegs);
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

}

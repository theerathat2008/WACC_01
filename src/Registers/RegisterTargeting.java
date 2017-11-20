package Registers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 *
 * THIS CLASS ACTUALLY HOLDS INFO OF REGISTERS - NOT FULLY IMPLEMENTED
 *
 * DELETE THIS CLASS IF NOT NEEDED
 *
 * USE REGISTERALLOCATION.JAVA IF NOT NEEDED
 *
 *
 *
 *
 */
public class RegisterTargeting<T>{

  Map<RegisterARM, T> registerMap = new HashMap<>();
  List<RegisterARM> registerNotInUse = new ArrayList<>();

  //TODO think of a way to add, design pattern
  //TODO don't add special registers e.g. PC
  public RegisterTargeting() {

    registerNotInUse.add(RegisterARM.R0);
    registerNotInUse.add(RegisterARM.R1);
  }

  public void addSpecialRegister(RegisterARM register, T value) {

  }

  public T getRegisterMap(RegisterARM registerARM) {
    return registerMap.get(registerARM);
  }

  public void addRegisterMap(RegisterARM register, T value) {

    //TODO throw some exceptions for register full
    if (!freeRegRemaining()) {

    }

    //check if this register is in the list of unused register
    if (checkRegisterNotInUse(register)) {
      registerMap.put(register, value);
      registerNotInUse.remove(register);
    } else {
      //TODO throw exception for register in use
    }

  }

  /**
   * @return true if there are free registers remaining
   */
  public boolean freeRegRemaining() {
    return !registerNotInUse.isEmpty();
  }

  /**
   * @param register - Check if register parameter is in the registerNotInUse list
   * @return - return true if register is in use
   */
  public boolean checkRegisterNotInUse(RegisterARM register) {
    return registerNotInUse.contains(register);
  }

}

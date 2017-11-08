package IdentifierObjects;

import java.util.List;

public class ProgramObj extends IDENTIFIER {

  List<FunctionObj> functionObjList;

  /**
   * Compares value for equality
   *
   * @param other
   */
  public boolean equals(IDENTIFIER other) {
    return false;
  }

  /**
   * Get String object representation of this class
   */
  public String toString() {
    return "PROGRAM";
  }
}

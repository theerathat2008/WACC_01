package src.IdentifierObjects;

public class ArrayObj extends IDENTIFIER {

  //private field for storing type of identifier
  IDENTIFIER type;

  public ArrayObj(String name, IDENTIFIER type) {
    this.name = name;
    this.type = type;
  }

  public ArrayObj(IDENTIFIER type) {
    this.type = type;
  }

  /**
   * Compares value for equality
   *
   * @param other
   */
  @Override
  public boolean equals(IDENTIFIER other) {
    if (other instanceof ArrayObj) {
      if (((ArrayObj) other).type.equals(type)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Get String object representation of this class
   */
  @Override
  public String toString() {
    if (type == null) {
      return "";
    }
    return type.toString() + "[]";
  }

}

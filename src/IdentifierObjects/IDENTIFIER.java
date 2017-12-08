package IdentifierObjects;

/**
 * Could hold reference to the ASTNode that declares IDENTIFIER
 **/
public abstract class IDENTIFIER {
  String name;

  /**
   * @return Return the name attribute
   */
  public String getName() {
    return name;
  }

  /**
   * Compares value for equality
   * @param other
   */
  public abstract boolean equals(IDENTIFIER other);

  /**
   * Get String object representation of this class
   */
  public abstract String toString();
}

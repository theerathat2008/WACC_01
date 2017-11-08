package IdentifierObjects;

public class KeywordObj extends IDENTIFIER{

  String keyword_name;

  /**
   * Compares value for equality
   * @param other
   */
  @Override
  public boolean equals(IDENTIFIER other) {
    return false;
  }

  /**
   * Get String object representation of this class
   */
  public String toString() {
    return keyword_name + " KEYWORD";
  }
}

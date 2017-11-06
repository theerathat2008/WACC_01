package IdentifierObjects;

public class KeywordObj extends IDENTIFIER{
  String keyword_name;

  public boolean equals(IDENTIFIER other) {
    return false;
  }

  public String toString() {
    return keyword_name + " KEYWORD";
  }
}

package src.IdentifierObjects;

/**
 * Could hold reference to the ASTNode that declares IDENTIFIER
 **/

public abstract class IDENTIFIER {
  String name;

  public abstract boolean equals(IDENTIFIER other);

  public abstract String toString();
}




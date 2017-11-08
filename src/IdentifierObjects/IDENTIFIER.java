package IdentifierObjects;

/**
Could hold reference to the ASTNode that declares IDENTIFIER
**/

public abstract class IDENTIFIER {
  String name;

  public abstract boolean equals(IDENTIFIER other);

  public abstract String toString();
}

/**
Holds attributes common to all types

public class TYPE extends IDENTIFIER{
  TYPE type_name;
}
**/

/**
 * Two sets of classes
 * 1. Represent the AST Nodes (Visitor function)
 * 2. Types(base types) and data structures(Arrays, pairs)
 * Visitor functions call the check() of the corresponding AST Node class which should then..
 * 1. check the semantics of the context
 * 2. Create a Symbol table if its a new scope
 * 3. Create an object for the new symbol table
 **/

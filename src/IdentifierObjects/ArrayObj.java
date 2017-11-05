package IdentifierObjects;

public class ArrayObj extends IDENTIFIER {
  IDENTIFIER type;

  public ArrayObj(String name, IDENTIFIER type) {
    this.name = name;
    this.type = type;
  }

  public boolean equals(IDENTIFIER other) {
   if (other instanceof ArrayObj) {
     if (((ArrayObj) other).type.equals(type)) {
       return true;
     }
   }
   return false;
  }


}

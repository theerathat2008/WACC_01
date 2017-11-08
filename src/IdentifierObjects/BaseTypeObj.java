package IdentifierObjects;

import java.util.Arrays;
import java.util.List;

public class BaseTypeObj extends IDENTIFIER {
  String base_type;
  List<String> types = Arrays.asList("int", "string", "char", "bool", "pair");
  public BaseTypeObj(String name, String base_type) {
    this.name = name;
    if (types.contains(base_type)) {
      this.base_type = base_type;
    } else {
      System.out.println("Unrecognised base type");
    }
  }

  public boolean equals(IDENTIFIER other) {
    if (other instanceof BaseTypeObj) {
      if (((BaseTypeObj) other).base_type.equals(base_type)) {
        return true;
      } else if (other instanceof PairObj && base_type.equals("pair")) {
        return true;
      }
    }
  return false;
  }

  public String toString() {
   return base_type;
  }
}

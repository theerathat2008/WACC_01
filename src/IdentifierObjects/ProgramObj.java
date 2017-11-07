package IdentifierObjects;

import java.util.List;

public class ProgramObj extends IDENTIFIER{
  List<FunctionObj> functionObjList;

  public boolean equals(IDENTIFIER other) {
    return false;
  }

  public String toString() {
    return "PROGRAM";
  }
}

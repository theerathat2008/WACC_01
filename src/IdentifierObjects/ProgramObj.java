package IdentifierObjects;

import IdentifierObjects.StatObjs.StatObj;

import java.util.List;

public class ProgramObj extends IDENTIFIER{
  List<FunctionObj> functionObjList;
  StatObj statement;

  public boolean equals(IDENTIFIER other) {
    return false;
  }
}

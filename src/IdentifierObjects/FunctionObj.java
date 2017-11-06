package IdentifierObjects;

public class FunctionObj extends IDENTIFIER {
  String returnTypeName; //type
  IDENTIFIER returnType;
  ParamListObj paramListObj;  //TODO set this at some point

  public FunctionObj(String name, IDENTIFIER returnType) {
    this.name = name;
    this.returnType = returnType;
    returnTypeName = returnType.toString();
  }

  public boolean equals(IDENTIFIER other) {
    if (other instanceof FunctionObj) {
      if (((FunctionObj) other).returnType.equals(returnType)) {
        if (((FunctionObj) other).paramListObj.equals(paramListObj)) {
          return true;
        }
      }
    }
    return false;
  }

  public String toString() {
    return returnTypeName + " FUNCTION";
  }

  public String getReturnTypeName() {
    return returnTypeName;
  }

  public ParamListObj getparamListObj() {
    return paramListObj;
  }
}

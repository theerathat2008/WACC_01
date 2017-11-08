package IdentifierObjects;

public class FunctionObj extends IDENTIFIER {
  String returnTypeName; //type
  public IDENTIFIER returnType;
  ParamListObj paramListObj;  //TODO set this at some point
  ASTNodes.AST_FuncDecl parent;

  public FunctionObj(String name, IDENTIFIER returnType, ASTNodes.AST_FuncDecl parent) {
    this.name = name;
    this.returnType = returnType;
    returnTypeName = returnType.toString();
    this.parent = parent;
  }

  public boolean equals(IDENTIFIER other) {
    if (other instanceof FunctionObj) {
      if (((FunctionObj) other).returnType.equals(returnType)) {
        //if (((FunctionObj) other).paramListObj.equals(paramListObj)) {
          return true;
        //}
      }
    }
    return false;
  }

  public String toString() {
    return returnTypeName + " FUNCTION";
  }

  public String getReturnTypeName() {
    return parent.getReturnTypeName();
  }

  public ParamListObj getparamListObj() {
    return paramListObj;
  }
}

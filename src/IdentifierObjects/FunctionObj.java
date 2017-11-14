package src.IdentifierObjects;

import src.ASTNodes.AST_FuncDecl;
import src.ASTNodes.AST_ParamList;

public class FunctionObj extends IDENTIFIER {

  String returnTypeName; //type
  public IDENTIFIER returnType;
  ParamListObj paramListObj;  //TODO set this at some point
  AST_FuncDecl parent;

  public FunctionObj(String name, IDENTIFIER returnType, ParamListObj paramListObj) {
    this.name = name;
    this.returnType = returnType;
    returnTypeName = returnType.toString();
    this.paramListObj = paramListObj;
    this.parent = parent;
  }

  /**
   * Compares value for equality
   *
   * @param other
   */
  @Override
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


  public IDENTIFIER getReturnType() {
    return returnType;
  }

  /**
   * Get String object representation of this class
   */
  @Override
  public String toString() {
    return returnTypeName + " FUNCTION";
  }

  public String getReturnTypeName() {
    return parent.getReturnTypeName();
  }

  public ParamListObj getparamListObj() {
    return paramListObj;
  }

  public void setParamListObj(ParamListObj paramListObj) {
    this.paramListObj = paramListObj;
  }
}

package IdentifierObjects;

import ASTNodes.AST_FuncDecl;
import ASTNodes.AST_ParamList;

public class FunctionObj extends IDENTIFIER {

  String returnTypeName;
  public IDENTIFIER returnType;
  ParamListObj paramListObj;
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
   * @param other
   */
  @Override
  public boolean equals(IDENTIFIER other) {
    if (other instanceof FunctionObj) {
      if (((FunctionObj) other).returnType.equals(returnType)) {
        return true;
      }
    }
    return false;
  }

  /**
   * @return Return the returnType attribute
   */
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

  /**
   * @return Return the returnTypeName of its parent
   */
  public String getReturnTypeName() {
    return parent.getReturnTypeName();
  }

  /**
   * @return Return the paramListObj attribute
   */
  public ParamListObj getparamListObj() {
    return paramListObj;
  }

  /**
   * Set the paramListObj attribute
   * @param paramListObj
   */
  public void setParamListObj(ParamListObj paramListObj) {
    this.paramListObj = paramListObj;
  }
}

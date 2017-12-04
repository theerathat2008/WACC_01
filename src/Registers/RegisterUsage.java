package Registers;

/**
 * UsageType can include: "funcType" which means that the registers are used in a function
 *                        "exprType" which means that the registers are used in a expression evaluation
 *                        "statType" which means that the registers are used in a statement evaluation
 *                        "resultType" which means that the register holds the result for an evaluation
 *                        "varDecType" which means that the register hold the content of a variable declaration
 *                        "interType" which means that the register hold the content of an intermediate value
 */

/**
 * Scopes can include: "BeginEnd"
 *                     "FuncScope"
 *                     "GlobalScope"
 *                     "IfThen"
 *                     "IfElse"
 *                     "WhileScope"
 */

public class RegisterUsage {

  String scope;
  String usageType;
  String subType;
  String content;
  String funcName;
  String varName;
  String operationType;

  public void setScope(String scope) {
    this.scope = scope;
  }

  public void setUsageType(String usageType) {
    this.usageType = usageType;
  }

  public void setVarName(String varName) {
    this.varName = varName;
  }

  public String getVarName() {
    return varName;
  }

  public void setSubType(String operationType) {
    this.subType = subType;
  }

  public String getSubType() {
    return subType;
  }

  public void setOperationType(String operationType) {
    this.operationType = operationType;
  }

  public String getOperationType() {
    return operationType;
  }

  public void setFuncName(String funcName) {
    this.funcName = funcName;
  }

  public String getFuncName() {
    return funcName;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getContent() {
    return content;
  }

  public String getScope() {
    return scope;
  }

  public String getUsageType() {
    return usageType;
  }
}

package Registers;

/**
 * UsageType can include: "funcType" which means that the registers are used in a function
 *                        "exprType" which means that the registers are used in a expression evaluation
 *                        "resultType" which means that the register holds the result for an evaluation
 */


public class RegisterUsage {

  String scope;
  String usageType;
  String content;
  String funcName;
  String operationType;

  public RegisterUsage(String usageType, String scope) {
    this.scope = scope;
    this.usageType = usageType;
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

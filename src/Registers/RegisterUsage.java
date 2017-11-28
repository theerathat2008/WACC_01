package Registers;

/**
 * UsageType can include: "funcType" which means that the registers are used in a function
 */


public class RegisterUsage {

  String scope;
  String usageType;
  String content;
  String funcName;

  public RegisterUsage(String usageType, String scope) {
    this.scope = scope;
    this.usageType = usageType;
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

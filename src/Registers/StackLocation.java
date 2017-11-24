package Registers;

public class StackLocation {
  String location;
  String scope;

  public StackLocation(String location, String scope) {
    this.location = location;
    this.scope = scope;
  }

  public String getLocation() {
    return location;
  }

  public String getScope() {
    return scope;
  }
}


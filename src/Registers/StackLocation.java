package Registers;

public class StackLocation {
  int location;
  String scope;

  public StackLocation(int location, String scope){
    this.location = location;
    this.scope = scope;
  }

  public int getLocation() {
    return location;
  }

  public String getScope() {
    return scope;
  }
}


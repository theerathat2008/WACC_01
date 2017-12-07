package Registers;

public class StackLocation {
  String location;
  String scope;
  int pos;

  public StackLocation(String location, String scope) {
    this.location = location;
    this.scope = scope;
    this.pos = 0;
  }

  public void setPos(int pos) {
    this.pos = pos;
  }

  public int getPos() {
    return pos;
  }

  public String getLocation() {
    return location;
  }

  public String getScope() {
    return scope;
  }
}


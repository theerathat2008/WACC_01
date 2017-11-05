package IdentifierObjects;

public class PairObj extends IDENTIFIER {
  IDENTIFIER LHS;
  IDENTIFIER RHS;

  public PairObj(String name, IDENTIFIER LHS, IDENTIFIER RHS) {
    this.name = name;
    this.LHS = LHS;
    this.RHS = RHS;
  }
  public boolean equals(IDENTIFIER other) {
    if (other instanceof PairObj) {
      if (((PairObj) other).LHS.equals(LHS) && ((PairObj) other).RHS.equals(RHS)) {
        return true;
      }
    }
    return false;
  }
}

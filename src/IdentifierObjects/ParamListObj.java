package IdentifierObjects;

import java.util.List;

public class ParamListObj extends IDENTIFIER{
  List<IDENTIFIER> paramObjList;

  public boolean equals(IDENTIFIER other) {
    if (other instanceof ParamListObj) {
      if (((ParamListObj) other).paramObjList.size() == paramObjList.size()) {
        for (int i = 0; i < paramObjList.size(); i++) {
          if (!(((ParamListObj) other).paramObjList.get(i).equals(paramObjList.get(i)))) {
            return false;
          }
        }
        return true;
      }
    }
    return false;
  }

  public String toString() {
    return "PARAM_LIST";
  }

}

package IdentifierObjects;

import java.util.List;

public class ParamListObj extends IDENTIFIER{
  List<IDENTIFIER> paramObjList;


  public ParamListObj(List<IDENTIFIER> paramObjList){
    this.paramObjList = paramObjList;
  }

  /**
   * Compares value for equality
   * @param other
   */
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


  public List<IDENTIFIER> getParamObjList(){
    return paramObjList;
  }

  /**
   * Get String object representation of this class
   */
  public String toString() {
    String ret = "(";
    for (int i = 0; i<paramObjList.size();i++) {
      ret = ret + paramObjList.get(i).toString() + ",";
    }
    return ret;
  }
}

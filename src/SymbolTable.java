
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import antlr.*;
import java.util.*;

public class SymbolTable {

  public SymbolTable encSymTable;
  public Map<String, IDENTIFIER> symMap;

  public SymbolTable(SymbolTable st){
    symMap = new HashMap<String, IDENTIFIER>();
    encSymTable = st;
  }

  public void add(String name, IDENTIFIER obj){
    symMap.put(name, obj);
  }

  public IDENTIFIER lookup(String name){
    return symMap.get(name);
  }

  public IDENTIFIER lookupAll(String name){
    SymbolTable S = this;
    while(S != null){
      IDENTIFIER obj = S.lookup(name);
      if(obj != null){
        return obj;
      }
      S = S.encSymTable;
    }
    return null;
  }

}

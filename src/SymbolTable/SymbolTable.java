package SymbolTable;

import IdentifierObjects.IDENTIFIER;
import IdentifierObjects.KeywordObj;

import java.util.*;

public class SymbolTable {

  public SymbolTable encSymTable;
  public Map<String, IDENTIFIER> symMap;

  public SymbolTable(SymbolTable st){
    symMap = new HashMap<String, IDENTIFIER>();
    encSymTable = st;
  }

  public SymbolTable() {
    symMap = new HashMap<String, IDENTIFIER>();
    encSymTable = null;
    encSymTable.add("int", new KeywordObj());
    encSymTable.add("bool", new KeywordObj());
    encSymTable.add("char", new KeywordObj());
    encSymTable.add("string", new KeywordObj());
    encSymTable.add("skip", new KeywordObj());
    encSymTable.add("read", new KeywordObj());
    encSymTable.add("free", new KeywordObj());
    encSymTable.add("return", new KeywordObj());
    encSymTable.add("exit", new KeywordObj());
    encSymTable.add("print", new KeywordObj());
    encSymTable.add("println", new KeywordObj());
    encSymTable.add("if", new KeywordObj());
    encSymTable.add("then", new KeywordObj());
    encSymTable.add("else", new KeywordObj());
    encSymTable.add("fi", new KeywordObj());
    encSymTable.add("while", new KeywordObj());
    encSymTable.add("do", new KeywordObj());
    encSymTable.add("done", new KeywordObj());
    encSymTable.add("begin", new KeywordObj());
    encSymTable.add("end", new KeywordObj());
    encSymTable.add("fst", new KeywordObj());
    encSymTable.add("snd", new KeywordObj());
    encSymTable.add("int", new KeywordObj());
    encSymTable.add("pair", new KeywordObj());
    encSymTable.add("len", new KeywordObj());
    encSymTable.add("ord", new KeywordObj());
    encSymTable.add("chr", new KeywordObj());
    encSymTable.add("true", new KeywordObj());
    encSymTable.add("false", new KeywordObj());
    encSymTable.add("null", new KeywordObj());
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

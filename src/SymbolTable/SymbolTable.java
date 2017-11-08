package SymbolTable;


import IdentifierObjects.*;

import java.util.*;

public class SymbolTable {

  public SymbolTable encSymTable;
  public Map<String, IDENTIFIER> symMap;
  String scope;


  public SymbolTable(String scope) {
    symMap = new HashMap<String, IDENTIFIER>();
    this.scope = scope;
  }

  public String getScope() {
    return this.scope;
  }

  /**
   * Initialise synbol table with WACC language syntax
   */
  public SymbolTable() {
    this.scope = "top_level";
    symMap = new HashMap<String, IDENTIFIER>();
    encSymTable = null;
    add("int", new KeywordObj());
    add("bool", new KeywordObj());
    add("char", new KeywordObj());
    add("string", new KeywordObj());
    add("skip", new KeywordObj());
    add("read", new KeywordObj());
    add("free", new KeywordObj());
    add("return", new KeywordObj());
    add("exit", new KeywordObj());
    add("print", new KeywordObj());
    add("println", new KeywordObj());
    add("if", new KeywordObj());
    add("then", new KeywordObj());
    add("else", new KeywordObj());
    add("fi", new KeywordObj());
    add("while", new KeywordObj());
    add("do", new KeywordObj());
    add("done", new KeywordObj());
    add("begin", new KeywordObj());
    add("end", new KeywordObj());
    add("fst", new KeywordObj());
    add("snd", new KeywordObj());
    add("int", new KeywordObj());
    add("pair", new KeywordObj());
    add("len", new KeywordObj());
    add("ord", new KeywordObj());
    add("chr", new KeywordObj());
    add("true", new KeywordObj());
    add("false", new KeywordObj());
    add("null", new KeywordObj());
  }

  public void add(String name, IDENTIFIER obj) {
    symMap.put(name, obj);
  }

  /**
   * Search for value of the identifier with a given name
   *
   * @param name
   */
  public IDENTIFIER lookup(String name) {
    return symMap.get(name);
  }

  public IDENTIFIER lookupAll(String name) {
    SymbolTable S = this;
    while (S != null) {
      IDENTIFIER obj = S.lookup(name);
      if (obj != null) {
        return obj;
      }
      S = S.encSymTable;
    }
    return null;
  }

  public void setEncSymTable(SymbolTable toSet) {
    this.encSymTable = toSet;
  }

  public void printAllTables() {
    SymbolTable S = this;
    while (S != null) {
      if (S.encSymTable == null) {
        break;
      }
      printKeysTable(S);
      S = S.encSymTable;
    }
  }

  public void printKeysTable(SymbolTable T) {
    System.out.println("The symbol table contents for: " + T.scope);
    Iterator<String> it = T.symMap.keySet().iterator();
    while (it.hasNext()) {
      String str = (String) it.next();
      if (T.symMap.get(str) == null) {
        System.out.println(str + " has a null IDENTIFIER");
      } else {
        System.out.println(str + ": " + T.symMap.get(str).getClass().getSimpleName());
      }

    }

  }

  public IDENTIFIER stringToIdent(String name, String type) {
    if (type.equals("int")) {
      return new BaseTypeObj(name, "int");
    } else if (type.equals("bool")) {
      return new BaseTypeObj(name, "bool");
    } else if (type.equals("char")) {
      return new BaseTypeObj(name, "char");
    } else if (type.equals("string")) {
      return new BaseTypeObj(name, "string");
    } else if (type.endsWith("[]")) {
      return new ArrayObj(name, stringToIdent(name, type.substring(0, type.length() - 3)));
    } else if (type.startsWith("PAIR(")) {

    } else if (type.endsWith(" FUNCTION")) {
      return new FunctionObj(name, stringToIdent(name, type.substring(0, type.length() - 10)), null);
    } else if (type.equals("param_list")) {

    } else if (type.equals("keyword")) {

    }
    return null;
  }
}



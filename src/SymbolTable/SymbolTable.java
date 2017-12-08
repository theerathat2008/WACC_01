package SymbolTable;

import IdentifierObjects.*;
import Registers.StackLocation;
import java.util.*;

public class SymbolTable {

  public SymbolTable encSymTable;
  public Map<String, IDENTIFIER> symMap;
  String scope;
  public List<SymbolTable> childTables = new ArrayList<>();

  /**
   * Class constructor
   * @param scope
   */
  public SymbolTable(String scope) {
    symMap = new HashMap<String, IDENTIFIER>();
    this.scope = scope;
  }

  /**
   * @return Return the scope attribute
   */
  public String getScope() {
    return this.scope;
  }

  /**
   * Set the scope to be the scope in the parameter
   * @param scope
   */
  public void changeScope(String scope) {
    this.scope = scope;
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

  /**
   * Add a new elements into symMap
   * @param name
   * @param obj
   */
  public void add(String name, IDENTIFIER obj) {
    symMap.put(name, obj);
  }

  /**
   * Search for value of the identifier with a given name
   * @param name
   */
  public IDENTIFIER lookup(String name) {
    return symMap.get(name);
  }

  /**
   * Search for value of the identifier with a given name in every scope
   * @param name
   * @return
   */
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

  /**
   * Search for value of the identifier with a given function name
   * @param name
   * @return
   */
  public IDENTIFIER lookupAllFunc(String name) {
    SymbolTable S = this;
    while (S != null) {
      IDENTIFIER obj = S.lookup(name);
      if (obj != null && obj instanceof FunctionObj) {
        return obj;
      }
      S = S.encSymTable;
    }
    return null;
  }

  /**
   * Count the number of existence of the string name
   * @param name
   * @return
   */
  public int count(String name) {
    SymbolTable S = this;
    int value = 0;
    if (symMap.containsKey(name)) {

    }
    return value;
  }

  /**
   * Set the enclosed symbol table attribute
   * @param toSet
   */
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

  /**
   * print the key contents of the symbol table
   * @param T
   */
  public void printKeysTable(SymbolTable T) {
    System.out.println("The symbol table contents for: " + T.scope);
    System.out.println("Enclosed Symbol Table has scope: " + T.encSymTable.getScope());
    Iterator<String> it = T.symMap.keySet().iterator();
    if (!it.hasNext()) {
      System.out.println("symbol table has no contents");
    }
    while (it.hasNext()) {
      String str = it.next();
      if (T.symMap.get(str) == null) {
        System.out.println(str + " has a null IDENTIFIER");
      } else {
        System.out.print(str + ": " + T.symMap.get(str).getClass().getSimpleName() + " --- ");
        System.out.println(T.lookupAll(str).toString());
      }

    }

  }

  /**
   * Add a symbol table to a childTable symbol table
   * @param ST
   */
  public void addChild(SymbolTable ST) {
    childTables.add(ST);
  }

  /**
   * @return Return childTables attribute
   */
  public List<SymbolTable> getChildren() {
    return childTables;
  }

  /**
   * Convert associated string into an ident
   * @param name
   * @param type
   * @return
   */
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

  /**
   * @return Return the symMap attribute
   */
  public Map<String, IDENTIFIER> getSymMap() {
    return symMap;
  }
}

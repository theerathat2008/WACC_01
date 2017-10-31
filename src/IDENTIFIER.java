package src;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import antlr.*;
import java.util.*;

/**
Could hold reference to the ASTNode that declares IDENTIFIER
**/

public class IDENTIFIER {
  String var_name;
  String type_name;
  public IDENTIFIER obj;

  public IDENTIFIER(){

  }
}

/**
Holds attributes comman to all types 

public class TYPE extends IDENTIFIER{
  TYPE type_name;
}
**/

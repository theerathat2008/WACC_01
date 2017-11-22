package ASTNodes;

import InstructionSet.Instruction;
import Registers.RegisterAllocation;
import SymbolTable.SymbolTable;

import java.util.ArrayDeque;

import IdentifierObjects.IDENTIFIER;
import IdentifierObjects.ParamListObj;
import IdentifierObjects.BaseTypeObj;
import VisitorClass.AST_NodeVisitor;
import java.util.ArrayList;
import java.util.List;

/**
 * Class representing node in AST tree for PARAMLIST
 */
public class AST_ParamList extends AST_Node {

  //Syntactic attributes
  List<AST_Param> listParam;
  int numOfParam;
  public SymbolTable symbolTable;

  /**
   * Constructor for class - initialises class variables
   *
   * @param numberOfChildren - Shows the number of parameters in the parameter list of function
   */
  public AST_ParamList(int numberOfChildren) {
    this.listParam = new ArrayList<>();
    this.numOfParam = (numberOfChildren + 1) / 2;
    symbolTable = new SymbolTable("function");
  }

  public List<AST_Param> getListParam() {
    return listParam;
  }

  /**
   * Gets all children nodes of current node
   *
   * @return list of AST nodes that are the children of the current node
   */
  @Override
  public ArrayDeque<AST_Node> getNodes() {
    ArrayDeque<AST_Node> returnList = new ArrayDeque<>();
    if (listParam.size() == 0) {
      return null;
    }
    for (AST_Param param : listParam) {
      returnList.addLast(param);
    }
    return returnList;
  }

  /**
   * Sets syntactic attributes of class variables by assigning it a value
   *
   * @param value - Value to be assigned to class variable
   */
  @Override
  public void setSyntacticAttributes(String value) {
    System.out.println("No String Syntactic Attributes in class: " + this.getClass().getSimpleName());
  }

  /**
   * Gets syntactic attributes of class variables
   *
   * @param strToGet - Value to be retrieved from class variable
   */
  @Override
  public String getSyntacticAttributes(String strToGet) {
    System.out.println("No String Syntactic Attributes in class: " + this.getClass().getSimpleName());
    return null;
  }

  /**
   * Returns true if the embedded Nodes have value
   */
  @Override
  public boolean isEmbeddedNodesFull() {
    return listParam.size() == numOfParam;
  }

  /**
   * @param astToGet Shows which child to get from current node
   * @param counter  Shows which child of child to get from current node
   * @return Returns the required child AST Node (determined by the astToGet parameter)
   */
  @Override
  public AST_Node getEmbeddedAST(String astToGet, int counter) {
    if (astToGet.equals("listParam")) {
      return listParam.get(counter);
    }
    System.out.println("Unrecognised AST Node at class: " + this.getClass().getSimpleName());
    return null;
  }

  /**
   * @param astToSet  Shows which child to set from current node
   * @param nodeToSet Shows which child of child to set from current node
   */
  @Override
  public void setEmbeddedAST(String astToSet, AST_Node nodeToSet) {
    if (astToSet.equals("listParam")) {
      listParam.add((AST_Param) nodeToSet);
    } else {
      System.out.println("Unrecognised AST Node at class: " + this.getClass().getSimpleName());
    }
  }

  /**
   * Semantic Analysis and print error message if needed
   *
   */
  @Override
  public boolean CheckSemantics() {
    return true;
  }

  /**
   * Called from visitor
   *
   * @param ST
   */
  @Override
  public void Check(SymbolTable ST) {
    if (CheckSemantics()) {
      List<IDENTIFIER> paramObjList = new ArrayList<>();
      for (AST_Param param : listParam) {
        paramObjList.add(new BaseTypeObj(param.getParamName(), (param.getEmbeddedAST("ast_type", 0)).toString()));
      }
      ST.encSymTable.add(((AST_FuncDecl) this.getParentNode()).getFuncName().concat("_paramList"), new ParamListObj(paramObjList));
    }
  }

  public void Assign(SymbolTable ST) {

  }

  public IDENTIFIER getIdentifier() {
    List<IDENTIFIER> params = new ArrayList<>();
    for (AST_Param param : listParam) {
      params.add(param.getIdentifier());
    }
    return new ParamListObj(params);
  }

  /**
   * Used for testing - Prints out contents of current AST node
   */
  @Override
  public void printContents() {
    System.out.println(this.getClass().getSimpleName() + ": ");
    System.out.println("numOfParam: " + numOfParam);
    if (listParam.size() == numOfParam) {
      System.out.println("ParamList: List full");
    } else {
      System.out.println("ParamList has size: " + listParam.size());
    }
    symbolTable.printKeysTable(symbolTable);

  }

  public void accept(AST_NodeVisitor visitor) {
    visitor.visit(this);
    for(AST_Param param : listParam){
      param.accept(visitor);
    }
  }

  /**
   * Could generate variable to show total stack displacement size by working out the
   * number and type of inbuilt parameters
   */

  @Override
  public void genInstruction(List<Instruction> instructionList, RegisterAllocation registerAllocation) throws Exception {
    System.out.println("Shouldn't generate any assembly code");

  }
}

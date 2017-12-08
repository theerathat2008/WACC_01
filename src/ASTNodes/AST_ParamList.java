package ASTNodes;

import ASTNodes.AST_Stats.AST_StatAssignRHSs.AST_StatArrayLitRHS;
import InstructionSet.Instruction;
import Registers.RegisterARM;
import Registers.RegisterAllocation;
import Registers.RegisterUsage;
import Registers.StackLocation;
import SymbolTable.SymbolTable;
import static Registers.RegisterUsageBuilder.*;
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
   * @param numberOfChildren - Shows the number of parameters in the parameter list of function
   */
  public AST_ParamList(int numberOfChildren) {
    this.listParam = new ArrayList<>();
    this.numOfParam = (numberOfChildren + 1) / 2;
    symbolTable = new SymbolTable("function");
  }

  /**
   * Gets all children nodes of current node
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
   * @param value - Value to be assigned to class variable
   */
  @Override
  public void setSyntacticAttributes(String value) {
    System.out.println("No String Syntactic Attributes in class: " + this.getClass().getSimpleName());
  }

  /**
   * Gets syntactic attributes of class variables
   * @param strToGet - Value to be retrieved from class variable
   */
  @Override
  public String getSyntacticAttributes(String strToGet) {
    System.out.println("No String Syntactic Attributes in class: " + this.getClass().getSimpleName());
    return null;
  }

  /**
   * @return returns the identifier of the attribute
   */
  public IDENTIFIER getIdentifier() {
    List<IDENTIFIER> params = new ArrayList<>();
    for (AST_Param param : listParam) {
      params.add(param.getIdentifier());
    }
    return new ParamListObj(params);
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
   */
  @Override
  public boolean CheckSemantics() {
    return true;
  }

  /**
   * Called from visitor
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

  /**
   * Assign the listParam with an associated identifier
   */
  public void Assign(SymbolTable ST) {

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

  /**
   * Used to flag special cases where the register needs a stack implementation before the backend parse
   * @param regAlloc
   */
  @Override
  public void acceptPreProcess(RegisterAllocation regAlloc) {

  }

  /**
   * Part of the visitor code gen pattern, used to generate the instruction classes
   * which are added to the instruction list
   * @param visitor
   */
  public void accept(AST_NodeVisitor visitor) {
    visitor.visit(this);
    for (AST_Param param : listParam) {
      param.accept(visitor);
    }
  }

  /**
   * Function that is iterates through the ast_nodes and adds the instruction blocks
   * in the right order to the assembly code list
   * @param assemblyCode
   */
  @Override
  public void acceptInstr(List<String> assemblyCode) {

  }

  /**
   * Allocate registers for the parameters to be stored in here for usage in the function up to the register limit
   * Registers are initially allocated here
   * Registers have to matched in the register allocation in AST_StatCallRHS when the function is called
   * Returns NULL_REG as there is no results reg
   */
  @Override
  public RegisterARM acceptRegister(RegisterAllocation registerAllocation) throws Exception {

    AST_FuncDecl tempNode = (AST_FuncDecl) parentNode;
    int counter = 0;


    for (AST_Param param : listParam) {

      if(registerAllocation.registersFull()){
        System.out.println("Should never be called in ParamList.");
        System.out.println("Registers full");

      } else if(counter < 3 && (!registerAllocation.checkIfOnStackOnlyVar(param.paramName))){

        //Reserve Registers for the functions
        RegisterUsage usage = aRegisterUsageBuilder()
            .withUsageType("funcType")
            .withVarName(param.paramName)
            .withScope(registerAllocation.getCurrentScope())
            .withFuncName(tempNode.funcName)
            .withParamCallPos(counter)
            .build();
        RegisterARM funcReg = registerAllocation.useRegister(usage);
        System.out.println("using reg: " + funcReg + " in func " + tempNode.funcName + " with name " + param.paramName);
        counter++;
        param.acceptRegister(registerAllocation);

      } else {
        //More than 4 parameters used in AST_ParamList
        //Allocate reg space on the stack
        //set stack location
        StringBuilder stackLocation = new StringBuilder();

        int displacement = registerAllocation.getFinalStackSize() - registerAllocation.getStackSize()
            - registerAllocation.getMemSize(param.ast_type.getIdentifier().toString());

        if (displacement == 0) {
          stackLocation.append("[sp]");
        } else {
          stackLocation.append("[sp, #");
          stackLocation.append(displacement);
          stackLocation.append("]");
        }

        registerAllocation.setStackSize(registerAllocation.getStackSize() + registerAllocation.getMemSize(param.ast_type.getIdentifier().toString()));

        StackLocation stackLocationClass = new StackLocation(stackLocation.toString(), registerAllocation.getCurrentScope());
        stackLocationClass.setPos(counter);
        counter++;

        registerAllocation.addToStack(param.getParamName(), stackLocationClass);
        registerAllocation.addToFuncStack(((AST_FuncDecl) parentNode).funcName, param.getParamName(), stackLocationClass);
        System.out.println("using location: " + stackLocation + " in func " + tempNode.funcName + " with name " + param.paramName);
      }
    }

    return RegisterARM.NULL_REG;
  }

  /**
   * takes the embeded information corresponding to the specific instruction class and generates blocks
   * of assembly code for that instruction class
   * The embeded information is mainly the registers which is allocated using registerAllocation.
   * @param instructionList
   * @param registerAllocation
   * @throws Exception
   */
  @Override
  public void genInstruction(List<Instruction> instructionList, RegisterAllocation registerAllocation) throws Exception {
    //Shouldn't generate any assembly code


    if(numOfParam > 3) {
      for(int i = 3; i < listParam.size(); i++){
        registerAllocation.setFinalStackSize(registerAllocation.getFinalStackSize() + registerAllocation.getMemSize(listParam.get(i).ast_type.getIdentifier().toString()));
      }
    } else {
      for(int i = 0; i < listParam.size(); i++){
        if(registerAllocation.checkIfOnStackOnlyVar(listParam.get(i).paramName)){
          registerAllocation.setFinalStackSize(registerAllocation.getFinalStackSize() + registerAllocation.getMemSize(listParam.get(i).ast_type.getIdentifier().toString()));
        }
      }
    }
  }

  /**
   * @return Return the listParam attribute
   */
  public List<AST_Param> getListParam() {
    return listParam;
  }


}

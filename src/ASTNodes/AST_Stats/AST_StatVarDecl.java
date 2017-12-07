package ASTNodes.AST_Stats;

import ASTNodes.AST_Exprs.AST_Expr;
import ASTNodes.AST_Exprs.AST_ExprBinary;
import ASTNodes.AST_Exprs.AST_ExprIdent;
import ASTNodes.AST_Node;
import ASTNodes.AST_Stats.AST_StatAssignRHSs.AST_StatArrayLitRHS;
import ASTNodes.AST_Stats.AST_StatAssignRHSs.AST_StatAssignRHS;

import ASTNodes.AST_Stats.AST_StatAssignRHSs.AST_StatExprRHS;
import ASTNodes.AST_Stats.AST_StatAssignRHSs.AST_StatPairElemRHS;
import IdentifierObjects.IDENTIFIER;
import InstructionSet.Instruction;
import InstructionSet.InstructionVarDecl;
import Registers.RegisterARM;
import Registers.RegisterAllocation;
import Registers.RegisterUsage;
import Registers.StackLocation;
import SymbolTable.SymbolTable;

import static Registers.RegisterUsageBuilder.*;

import ASTNodes.AST_TYPES.AST_Type;
import ErrorMessages.TypeMismatchError;
import ErrorMessages.VariableRedeclarationError;
import ErrorMessages.FilePosition;
import org.antlr.v4.runtime.ParserRuleContext;
import VisitorClass.AST_NodeVisitor;

import java.util.ArrayDeque;
import java.util.List;


public class AST_StatVarDecl extends AST_Stat {

  //Syntactic attributes
  AST_Type ast_type;
  String identName;
  AST_StatAssignRHS ast_assignRHS;
  ParserRuleContext ctx;
  SymbolTable symbolTable;
  InstructionVarDecl instrVar;

  /**
   * Assign the class variables when called
   *
   * @param ctx
   */
  public AST_StatVarDecl(ParserRuleContext ctx, SymbolTable symbolTable) {
    this.ast_assignRHS = null;
    this.statName = null;
    this.identName = null;
    this.ctx = ctx;
    this.symbolTable = symbolTable;
  }

  /**
   * Gets all children nodes of current node
   *
   * @return list of AST nodes that are the children of the current node
   */
  @Override
  public ArrayDeque<AST_Node> getNodes() {
    ArrayDeque<AST_Node> returnList = new ArrayDeque<>();
    returnList.addLast(ast_type);
    returnList.addLast(ast_assignRHS);
    return returnList;
  }

  /**
   * Sets syntactic attributes of class variables by assigning it a value
   *
   * @param value - Value to be assigned to class variable
   */
  @Override
  public void setSyntacticAttributes(String value) {
    if (identName == null) {
      this.identName = value;
    } else {
      System.out.println("Unrecognised String Attribute" + this.getClass().getSimpleName());
    }
  }

  /**
   * Gets syntactic attributes of class variables
   *
   * @param strToGet - Value to be retrieved from class variable
   */
  @Override
  public String getSyntacticAttributes(String strToGet) {
    if (identName == null) {
      return identName;
    } else {
      System.out.println("Unrecognised String Attribute" + this.getClass().getSimpleName());
      return null;
    }
  }

  /**
   * Returns true if the embedded Nodes have value
   */
  @Override
  public boolean isEmbeddedNodesFull() {
    return ast_assignRHS != null;
  }

  /**
   * @param astToGet Shows which child to get from current node
   * @param counter  Shows which child of child to get from current node
   * @return Returns the required child AST Node (determined by the astToGet parameter)
   */
  @Override
  public AST_Node getEmbeddedAST(String astToGet, int counter) {
    if (astToGet.equals("ast_assignRHS")) {
      return ast_assignRHS;
    } else if (astToGet.equals("ast_type")) {
      return ast_type;
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
    if (astToSet.equals("statAssignRHS")) {
      ast_assignRHS = (AST_StatAssignRHS) nodeToSet;
    } else if (astToSet.equals("ast_type")) {
      ast_type = (AST_Type) nodeToSet;
    } else {
      System.out.println("Unrecognised AST Node at class: " + this.getClass().getSimpleName());
    }
  }

  /**
   * Semantic Analysis and print error message if needed
   */
  @Override
  public boolean CheckSemantics() {

    SymbolTable ST = this.symbolTable;

    AST_Node parent = getParentNode();

    SymbolTable tempSymTable = ST;
    IDENTIFIER type = tempSymTable.lookup(identName);

    AST_Node tempNode = parent;

    while (type == null) {
      tempSymTable = tempSymTable.encSymTable;
      type = tempSymTable.lookup(identName);
    }

    if (ast_assignRHS instanceof AST_StatExprRHS) {
      AST_Expr ast_expr = ((AST_StatExprRHS) ast_assignRHS).getAst_expr();

      if (ast_expr instanceof AST_ExprBinary) {
        AST_Expr exprLeft = ((AST_ExprBinary) ast_expr).getExprLeftAST();
        AST_Expr exprRight = ((AST_ExprBinary) ast_expr).getExprRightAST();

        IDENTIFIER leftType = null;
        IDENTIFIER rightType = null;

        if (exprLeft instanceof AST_ExprIdent) {
          SymbolTable tempST = ST;
          String varNameExprLeft = ((AST_ExprIdent) exprLeft).getVarName();

          leftType = tempST.lookup(varNameExprLeft);

          while (leftType == null) {
            tempST = tempST.encSymTable;
            leftType = tempST.lookup(varNameExprLeft);
          }
        } else {

        }

        if (exprRight instanceof AST_ExprIdent) {

        } else {
          rightType = exprRight.getIdentifier();
        }

        if (leftType != null && rightType != null) {
          if (leftType.toString().contains(rightType.toString())) {
            return true;
          } else {
            new TypeMismatchError(new FilePosition(ctx)).printAll();
            return false;
          }
        }

      }
    }

    if (ast_assignRHS.getIdentifier() != null && type != null) {
      if (type.toString().contains("pair") || type.toString().contains("PAIR")) {
        if (ast_assignRHS.getIdentifier().toString().contains("pair")
            || ast_assignRHS.getIdentifier().toString().contains("PAIR")) {
          return true;
        }
      }
    }

    if (ast_assignRHS instanceof AST_StatPairElemRHS) {
      String typeName = ((AST_StatPairElemRHS) ast_assignRHS).getTypeName();
      AST_Expr ast_expr = ((AST_StatPairElemRHS) ast_assignRHS).getAst_expr();

      if (typeName.equals("fst")) {
        if (ast_expr instanceof AST_ExprIdent) {
          SymbolTable tempST = ST;
          String varName = ((AST_ExprIdent) ast_expr).getVarName();
          IDENTIFIER typeExpr = tempST.lookup(varName);

          while (typeExpr == null) {
            tempST = tempST.encSymTable;
            typeExpr = tempST.lookup(varName);
          }

          if (typeExpr.toString().contains("PAIR")) {
            String typeString = typeExpr.toString();
            String firstType = typeString.substring(typeString.indexOf("("), typeString.indexOf(","));
            String sndType = typeString.substring(typeString.indexOf(","), typeString.indexOf(")"));

            IDENTIFIER typeIdent = ast_type.getIdentifier();

            if (typeIdent != null) {
              if (typeIdent.toString().contains("PAIR")) {
                if (firstType.contains("pair") || firstType.contains("PAIR")) {
                  return true;
                } else {
                  new TypeMismatchError(new FilePosition(ctx)).printAll();
                  return false;
                }
              }
            }
          }

        }

      } else if (typeName.equals("snd")) {
        if (ast_expr instanceof AST_ExprIdent) {
          SymbolTable tempST = ST;
          String varName = ((AST_ExprIdent) ast_expr).getVarName();
          IDENTIFIER typeExpr = tempST.lookup(varName);

          while (typeExpr == null) {
            tempST = tempST.encSymTable;
            typeExpr = tempST.lookup(varName);
          }

          if (typeExpr.toString().contains("PAIR")) {
            String typeString = typeExpr.toString();
            String firstType = typeString.substring(typeString.indexOf("("), typeString.indexOf(","));
            String sndType = typeString.substring(typeString.indexOf(","), typeString.indexOf(")"));

            IDENTIFIER typeIdent = ast_type.getIdentifier();

            if (typeIdent != null) {
              if (typeIdent.toString().contains("PAIR")) {
                if (sndType.contains("pair") || sndType.contains("PAIR")) {
                  return true;
                } else {
                  new TypeMismatchError(new FilePosition(ctx)).printAll();
                  return false;
                }
              }
            }
          }

        }
      }
    }


    if (ast_type.getIdentifier() != null && ast_assignRHS.getIdentifier() != null) {
      //ast_type.getIdentifier() returns "str" so it's the problem
      if (!(ast_type.getIdentifier().toString().contains(ast_assignRHS.getIdentifier().toString())
          || ast_assignRHS.getIdentifier().toString().contains(ast_type.getIdentifier().toString()))) {
        new TypeMismatchError(new FilePosition(ctx)).printAll();
        return false;
      }
      return true;
    }

    System.out.println("ast_type is: " + ast_type);
    System.out.println("type is: " + type);

    if ((type.toString().contains(ast_type.getIdentifier().toString())
        || ast_type.getIdentifier().toString().contains(type.toString()))) {
      return true;
    } else {
      new VariableRedeclarationError(new FilePosition(ctx)).printAll();
      return false;
    }



  }

  /**
   * Called from visitor
   *
   * @param ST
   */
  @Override
  public void Check(SymbolTable ST) {
    //CheckSemantics(ST);
    ST.add(identName, ST.stringToIdent(identName, ast_type.toString()));
  }

  public void Assign(SymbolTable ST) {
    if (ast_type == null) {
      System.out.println("Variable " + identName + "'s AST_Type not set yet");
    }
    ST.add(identName, ast_type.getIdentifier());
  }

  /**
   * Used for testing - Prints out contents of current AST node
   */
  @Override
  public void printContents() {
    System.out.println(this.getClass().getSimpleName() + ": ");
    System.out.println("identName: " + identName);
    if (ast_assignRHS == null) {
      System.out.println("ast_assignRHS: null");
    } else {
      System.out.println("ast_assignRHS: has content");
    }
    if (ast_type == null) {
      System.out.println("ast_type: null");
    } else {
      System.out.println("ast_type: has content");
      System.out.println(ast_type.getIdentifier().toString());
    }
  }

  @Override
  public void acceptPreProcess(RegisterAllocation regAlloc) {
    ast_assignRHS.acceptPreProcess(regAlloc);

  }

  public void accept(AST_NodeVisitor visitor) {
    visitor.visit(this);
    ast_type.accept(visitor);
    ast_assignRHS.accept(visitor);
  }


  @Override
  public void acceptInstr(List<String> assemblyCode) {
    ast_assignRHS.acceptInstr(assemblyCode);
    assemblyCode.add(instrVar.getResultBlock());
  }


  /**
   * Has the format mov dst src
   *                str dst [SP]
   * For efficient register allocation, use up to 4 registers then use the stack
   * Doesn't need to return a  specific register as the result is held onto the stack
   * if allocated on the regMap then return that register
   */
  @Override
  public RegisterARM acceptRegister(RegisterAllocation registerAllocation) throws Exception {
    RegisterARM src = ast_assignRHS.acceptRegister(registerAllocation);
    registerAllocation.freeRegister(src);

    RegisterUsage interUsage = aRegisterUsageBuilder()
        .withUsageType("statType")
        .withSubType("interType")
        .withScope(registerAllocation.getCurrentScope())
        .build();

    RegisterARM interReg = registerAllocation.useRegister(interUsage);
    registerAllocation.freeRegister(interReg);
    instrVar.allocateRegisters(interReg, src);

//    if (ast_assignRHS instanceof AST_StatArrayLitRHS) {
//      AST_StatArrayLitRHS tempNode = (AST_StatArrayLitRHS) ast_assignRHS;
//      registerAllocation.setStackSize(registerAllocation.getStackSize() + 4);
//      System.out.println("HIIIIIIIIIIIIIIT 1");
//
//    } else {
//      registerAllocation.setStackSize(registerAllocation.getStackSize() + registerAllocation.getMemSize(ast_type.getIdentifier().toString()));
//      System.out.println("HIIIIIIIIIIIIIIT 2");
//    }

    if(registerAllocation.getVarRegSize() > 2 || (registerAllocation.checkIfOnStackOnlyVar(identName))){


      //set stack location
      StringBuilder stackLocation = new StringBuilder();

      int displacement = registerAllocation.getFinalStackSize() - registerAllocation.getStackSize()
          - registerAllocation.getMemSize(ast_type.getIdentifier().toString());

      if (displacement == 0) {
        stackLocation.append("[sp]");
      } else {
        stackLocation.append("[sp, #");
        stackLocation.append(displacement);
        stackLocation.append("]");
      }

      if (ast_assignRHS instanceof AST_StatArrayLitRHS) {
        AST_StatArrayLitRHS tempNode = (AST_StatArrayLitRHS) ast_assignRHS;
        registerAllocation.setStackSize(registerAllocation.getStackSize() + 4); //tempNode.getArraySize());
        //registerAllocation.setFinalStackSize(registerAllocation.getStackSize() + 4);
      } else {
        registerAllocation.setStackSize(registerAllocation.getStackSize() + 4); //+ registerAllocation.getMemSize(ast_type.getIdentifier().toString()));
        //registerAllocation.setFinalStackSize(registerAllocation.getStackSize() + 4);
      }


      registerAllocation.addToStack(identName, new StackLocation(stackLocation.toString(), registerAllocation.getCurrentScope()));

      instrVar.setStackLocation(stackLocation.toString(), true);

    } else {
      RegisterUsage varUsage = aRegisterUsageBuilder()
          .withScope(registerAllocation.getCurrentScope())
          .withUsageType("varDecType")
          .withVarName(identName)
          .build();
      RegisterARM varStore = registerAllocation.useRegister(varUsage);


      instrVar.setStackLocation(varStore.name(), false);
      return varStore;
      //TODO might need to free if out of scope
    }
    return RegisterARM.NULL_REG;
  }

  public void genInstruction(List<Instruction> instructionList, RegisterAllocation registerAllocation) throws Exception {
    /**
     * Content of the RHS:-  AST_StatArrayLit:-  [0,0,0]                          ---
     *                       AST_StatCall:- return value of the function          --- Create InstructionCall
     *                       AST_StatExpr:- evaluation of the expression 5, 5+5
     *                       AST_NewPair:- newpair()
     *                       AST_StatPairElem:- fst, snd
     */
    /**
     * Content of the LHS:- type varName
     */

    InstructionVarDecl instructionVarDecl = new InstructionVarDecl(ast_type.getIdentifier().toString());
    instructionList.add(instructionVarDecl);
    instrVar = instructionVarDecl;
    if(registerAllocation.getVarDeclCount() > 2 || (registerAllocation.checkIfOnStackOnlyVar(identName))) {
      //System.out.println("Final stack size at var: " +ast_type.getIdentifier().toString() + " is " + registerAllocation.getFinalStackSize());
      registerAllocation.setFinalStackSize(registerAllocation.getFinalStackSize() + registerAllocation.getMemSize(ast_type.getIdentifier().toString()));
    }
    registerAllocation.incVarDeclCount();
  }

  public String getIdentName() {
    return identName;
  }
}

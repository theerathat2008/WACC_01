package InstructionSet;

import ASTNodes.AST_Node;
import InstructionSet.InstructionBlocks.InstructionBlocks;

import Registers.RegisterAllocation;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.LinkedList;
import java.util.List;

/**
 * Implemented the singleton pattern for assmebler
 */

public class Assembler {

  List<Instruction> instructions;
  RegisterAllocation registerAlloc;

  AST_Node rootNode;
  String Output;

  List<String> assemblyCode = new LinkedList<>();

  /**
   * Sets the root node which is AST_Program
   * @param rootNode
   */
  public void setRootNode(AST_Node rootNode) {
    this.rootNode = rootNode;
  }

  private static Assembler instance = null;

  private Assembler() {

  }

  public void setInstructions(List<Instruction> instructions) {
    this.instructions = instructions;
  }

  public void setRegisterAlloc(RegisterAllocation registerAlloc) {
    this.registerAlloc = registerAlloc;
  }

  /**
   * Prints instructions for debug purposes
   */
  public void printInstructions() {
    System.out.println();
    System.out.println("---------------INSTRUCTIONS LIST --------------------");
    for (Instruction currInstr : instructions) {
      System.out.println(currInstr.getClass().getSimpleName());
    }
    System.out.println("---------------INSTRUCTIONS LIST --------------------");
  }

  /**
   * Allocates the registers for the created instruction list first then generate the actual assembly blocks
   */
  public void parseInstructions() throws Exception {
    System.out.println("--------------- REGISTER ALLOCATION --------------------");
    rootNode.acceptRegister(registerAlloc);
    System.out.println("--------------- REGISTER ALLOCATION --------------------");
    printInstructions();

    for (Instruction currInstr : instructions) {
      currInstr.genInstruction();
    }
  }

  /**
   * Assemble the instructions into the right order
   */
  public void assembleInstructions() {
    rootNode.acceptInstr(assemblyCode);
    String Output = String.join("", assemblyCode);
    Output = generatePreCode() + "\n\t.text\n\n" + Output + generatePostCode();


    System.out.println(Output);
    this.Output = Output;
  }


  /**
   * generate any special code for the assmebly file such as the messages
   */
  public String generatePreCode() {
    List<String> stringList = registerAlloc.getStringList();
    StringBuilder result = new StringBuilder("");
    if (stringList.size() > 0) {
      result.append("\t.data\n\n");
      // System.out.println(stringList.size());
      for (int i = 0; i < stringList.size(); i++) {
        result.append("\tmsg_");
        result.append(Integer.toString(i));
        result.append(":\n\t\t.word ");
        if (stringList.get(i).contains("\\")) {
          result.append(Integer.toString(stringList.get(i).length() - 1));
        } else {
          result.append(Integer.toString(stringList.get(i).length()));
        }
        result.append("\n\t\t.ascii \"");
        result.append(stringList.get(i));
        result.append("\"\n\n");
      }
    }
    return result.toString();
  }

  /**
   * Generates the post code at the end of the assembly file such as the print functions
   * @return
   */
  public String generatePostCode() {
    StringBuilder result = new StringBuilder("");

    for (Instruction currInstr : instructions) {
      if (currInstr instanceof InstructionBlocks) {
        String type = ((InstructionBlocks) currInstr).getBlockType();
        if (!(result.toString().contains(type))) {
          result.append(((InstructionBlocks) currInstr).getResultBlock());
        }
      }
    }
    return result.toString();
  }


  public static Assembler getInstance() {
    if (instance == null) {
      instance = new Assembler();
    }
    return instance;
  }


  /**
   * Generates the final output file
   * @param name
   */
  public void generateOutputFile(String name) {
    try (Writer writer = new BufferedWriter(new OutputStreamWriter(
        new FileOutputStream(name + ".s"), "utf-8"))) {
      writer.write(Output);
    } catch (Exception e) {
      e.getMessage();
    }
  }


}

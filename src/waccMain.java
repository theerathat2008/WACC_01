package src;

import ASTNodes.AST_Program;
import VisitorClass.AST_VisitCodeGen;
import VisitorClass.AST_VisitSemantic;
import VisitorClass.waccVisitor;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.*;

import antlr.*;

import java.util.ArrayList;
import java.util.List;

public class waccMain {

  public static boolean isInt(char in){
    return Character.isLetterOrDigit(in);
  }


  public static void main(String[] args) throws Exception {

    int fileCharLength = 999999999;
    CharStream input = CharStreams.fromStream(System.in);

    String inputText = input.getText(new Interval(0,fileCharLength));

    String outputText = textConverter(inputText);  //Used to add precedence to the input file.
     System.out.println("-- Compiling...");

    CharStream inputString = CharStreams.fromString(inputText);

    WaccLexer lexer = new WaccLexer(inputString);

    CommonTokenStream tokens = new CommonTokenStream(lexer);

    WaccParser parser = new WaccParser(tokens);

    ParseTree tree = parser.program();

    if (parser.getNumberOfSyntaxErrors() != 0) {
      System.out.println("Errors detected during compilation! Exit code 100 returned.");
      System.out.println("#syntax_error#");
      System.out.println(parser.getNumberOfSyntaxErrors() + " parser error(s) detected, " +
          "no further compilation attempted.");
      System.exit(100);
    }


    System.out.println("===");
    waccVisitor visitor = new waccVisitor();
    visitor.visit(tree);
    System.out.println("===");


    System.out.println("---------TESTING------------");
    AST_Program root = visitor.getRootNode();
    System.out.println("------------------CHECK SEMANTICS------------------------");
    root.accept(new AST_VisitSemantic());
    System.out.println("---------TESTING------------");

    System.out.println();


    System.out.println("------------------CODE GENERATION--------------------");
    AST_VisitCodeGen codeGen = new AST_VisitCodeGen(args[0]);
    codeGen.setRootNode(root);
    root.acceptPreProcess(codeGen.getRegisterAllocation());
    root.accept(codeGen);

    System.out.println("------------------CODE GENERATION--------------------");

    System.out.println();
    System.out.println("------------------GENERATING CODE--------------------");
    codeGen.generateAssembly();
    System.out.println("------------------GENERATING CODE--------------------");
  }

  /**
   * @param inputText
   * @return String of the input file after precedence is added.
   *
   * Takes the input text string and adds precedence to it by searching for certain tokens and adding brackets to the
   * expressions around it. This adds precedence by making enclosed expressions which force the parser to build the
   * token tree in a certain way.
   */
  public static String textConverter(String inputText){

    //System.out.println(inputText);

    List<Character> tempArray = new ArrayList<Character>();

    for(char c : inputText.toCharArray()){
      tempArray.add(c);
    }
    int counter = 0;

    for(int i = 0; i < inputText.length(); i++){
      char currChar = inputText.charAt(i);

      if(currChar == '*' || currChar == '/' || currChar == '%'){
        System.out.println(currChar + " at " + i);
        boolean hitBracket = false;
        for(int j = i + counter; j > 0; j--){
          if(isInt(tempArray.get(j)) && !isInt(tempArray.get(j - 1)) && !hitBracket){
            tempArray.add(j , '(');
            break;
          } else if(tempArray.get(j) == ')'){
            hitBracket = true;
          } else if(tempArray.get(j) == '('){
            tempArray.add(j, '(');
            hitBracket = false;
            break;
          }
        }
        for(int j = i + counter; j < inputText.length(); j++){
          if(isInt(tempArray.get(j)) && !isInt(tempArray.get(j + 1))){
            tempArray.add(j + 1, ')');
            break;
          }
        }
        counter += 2;
      } else if (currChar == '>' || currChar == '<' || currChar == '=' && inputText.charAt(i+1) == '=') {
        System.out.println(currChar + " at " + i);
        boolean hitBracket = false;
        for(int j = i + counter; j > 0; j--){
          if(isInt(tempArray.get(j)) && !hitBracket && !isInt(tempArray.get(j - 1))){
            tempArray.add(j , '(');
            break;
          } else if(tempArray.get(j) == ')'){
            hitBracket = true;
          } else if(tempArray.get(j) == '('){
            tempArray.add(j, '(');
            hitBracket = false;
            break;
          }
        }
        for(int j = i + counter; j < inputText.length(); j++){
          if(isInt(tempArray.get(j)) && !isInt(tempArray.get(j + 1))){
            tempArray.add(j + 1, ')');
            break;
          }
        }
        counter += 2;

      }
    }

    StringBuilder interString = new StringBuilder();
    for(int i = 0; i < tempArray.size(); i++){
      interString.append(tempArray.get(i));
    }

    String outputText = interString.toString();
    //System.out.println(outputText);


    return outputText;


  }


}

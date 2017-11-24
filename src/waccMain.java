package src;

import ASTNodes.AST_Node;
import ASTNodes.AST_Program;
import VisitorClass.AST_NodeVisitor;
import VisitorClass.AST_VisitCodeGen;
import VisitorClass.AST_VisitSemantic;
import VisitorClass.waccVisitor;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import antlr.*;

public class waccMain {


  public static void main(String[] args) throws Exception {

    System.out.println("-- Compiling...");

    CharStream input = CharStreams.fromStream(System.in);

    WaccLexer lexer = new WaccLexer(input);

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
    //root.printContents();
    //visitor.printNodes(root);
    System.out.println("------------------CHECK SEMANTICS------------------------");
    root.accept(new AST_VisitSemantic());
    System.out.println("---------TESTING------------");

    System.out.println();


    System.out.println("------------------CODE GENERATION--------------------");
    AST_VisitCodeGen codeGen = new AST_VisitCodeGen(args[0]);
    codeGen.setRootNode(root);
    root.accept(codeGen);

    System.out.println("------------------CODE GENERATION--------------------");

    System.out.println();
    System.out.println("------------------GENERATING CODE--------------------");
    codeGen.generateAssembly();
    System.out.println("------------------GENERATING CODE--------------------");


  }


}

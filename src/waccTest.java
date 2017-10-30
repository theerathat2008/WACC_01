import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import antlr.*;

public class waccTest {
  public static void main(String[] args) throws Exception {
    ANTLRInputStream input = new ANTLRInputStream(System.in);

    WaccLexer lexer = new WaccLexer(input);

    CommonTokenStream tokens = new CommonTokenStream(lexer);

    WaccParser parser = new WaccParser(tokens);

    ParseTree tree = parser.program();

    System.out.println("Printing out the tree: ");
    System.out.println(tree.toStringTree(parser));
  }
}

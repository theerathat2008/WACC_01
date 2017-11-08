package src;

import org.antlr.v4.runtime.ParserRuleContext;

public class FilePosition {

  int line;
  int column;

  public FilePosition (ParserRuleContext ctx){//, int column) {
    this.line = ctx.getStart().getLine();
   // this.column = column;
  }

 /* public int getColumn() {
    return this.column;
  }
*/
  public int getLine() {
    return this.line;
  }

  /**
   * Get String object representation of this class
   */
  public String toString(){
    return " on line: " + this.line; //+ "   column: " + this.column;
  }
}

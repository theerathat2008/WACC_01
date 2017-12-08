package ErrorMessages;

import org.antlr.v4.runtime.ParserRuleContext;

public class FilePosition {

  int line;

  public FilePosition(ParserRuleContext ctx) {
    this.line = ctx.getStart().getLine();
  }

  /**
   * @return Return the line attribute
   */
  public int getLine() {
    return this.line;
  }

  /**
   * Get String object representation of this class
   */
  public String toString() {
    return " on line: " + this.line;
  }
}

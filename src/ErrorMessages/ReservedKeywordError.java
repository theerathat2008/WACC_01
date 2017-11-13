package ErrorMessages;

import src.FilePosition;

public class ReservedKeywordError extends ErrorMessage {

  /**
   * WHEN IDENT THAT HAS NOT BEEN DECLARED YET IS USED
   *
   * @param filePosition
   */
  public ReservedKeywordError(FilePosition filePosition) {
    super(filePosition);
  }

  /**
   * Print out a unique error message
   */
  @Override
  public void printError() {
    System.out.print("ERROR: Variable name is a reserved keyword therefore not allowed "); //" on line:..."
  }
}

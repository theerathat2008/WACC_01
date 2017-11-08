package src.ErrorMessages;

import src.FilePosition;

public class UndefinedIdentError extends ErrorMessage {

  /**
   * WHEN IDENT THAT HAS NOT BEEN DECLARED YET IS USED
   *
   * @param filePosition
   */
  public UndefinedIdentError(FilePosition filePosition) {
    super(filePosition);
  }

  /**
   * Print out a unique error message
   */
  @Override
  public void printError() {
    System.out.print("ERROR: Undeclared Variable"); //" on line:..."
  }


}

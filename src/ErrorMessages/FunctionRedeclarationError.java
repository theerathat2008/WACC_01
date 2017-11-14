package src.ErrorMessages;

import src.FilePosition;

public class FunctionRedeclarationError extends ErrorMessage {

  /**
   * WHEN FUNCTION HAS ALREADY BEEN DECLARED
   *
   * @param filePosition
   */
  public FunctionRedeclarationError(FilePosition filePosition) {
    super(filePosition);
  }

  /**
   * Print out a unique error message
   */
  @Override
  public void printError() {
    System.out.print("ERROR: Function declared again"); //" on line:..."
  }
}

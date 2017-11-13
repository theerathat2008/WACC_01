package ErrorMessages;

import src.FilePosition;

public class OutOfBoundsError extends ErrorMessage {

  /**
   * WHEN ARRAY ELEM IS OUT OF BOUNDS OR EXIT CODE OUT OF BOUNDS
   *
   * @param filePosition
   */
  public OutOfBoundsError(FilePosition filePosition) {
    super(filePosition);
  }

  /**
   * Print out a unique error message
   */
  @Override
  public void printError() {
    System.out.print("ERROR: Value Out of Bounds"); //" on line:..."
  }

}

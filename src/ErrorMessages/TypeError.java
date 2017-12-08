package ErrorMessages;

public class TypeError extends ErrorMessage {

  /**
   * WHEN INCORRECT TYPE USED E.G. INT INSTEAD OF STRING
   * @param filePosition
   */
  public TypeError(FilePosition filePosition) {
    super(filePosition);
  }

  /**
   * Print out a unique error message
   */
  @Override
  public void printError() {
    System.out.print("ERROR: Incorrect type used"); //" on line:..."
  }
}

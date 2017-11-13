package ErrorMessages;

import src.FilePosition;

public class MissingParameterError extends ErrorMessage {

  /**
   * WHEN FUNCTIONS ARE MISSING ONE OR MORE PARAMETERS - USE TYPEERROR FOR INCORRECT TYPE OF PARAMS
   *
   * @param filePosition
   */
  public MissingParameterError(FilePosition filePosition) {
    super(filePosition);
  }

  /**
   * Print out a unique error message
   */
  @Override
  public void printError() {
    System.out.print("ERROR: Missing parameter(s) in function"); //" on line:..."
  }
}

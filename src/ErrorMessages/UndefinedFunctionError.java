package ErrorMessages;

public class UndefinedFunctionError extends ErrorMessage {

  /**
   * WHEN IDENT THAT HAS NOT BEEN DECLARED YET IS USED
   *
   * @param filePosition
   */
  public UndefinedFunctionError(FilePosition filePosition) {
    super(filePosition);
  }

  /**
   * Print out a unique error message
   */
  @Override
  public void printError() {
    System.out.print("ERROR: Undeclared Function"); //" on line:..."
  }

}

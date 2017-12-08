package ErrorMessages;

public class VariableRedeclarationError extends ErrorMessage {

  /**
   * WHEN VARIABLE HAS ALREADY BEEN DECLARED
   * @param filePosition
   */
  public VariableRedeclarationError(FilePosition filePosition) {
    super(filePosition);
  }

  /**
   * Print out a unique error message
   */
  @Override
  public void printError() {
    System.out.print("ERROR: Variable declared again"); //" on line:..."
  }
}

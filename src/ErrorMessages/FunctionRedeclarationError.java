package src.ErrorMessages;

import src.FilePosition;

public class FunctionRedeclarationError extends ErrorMessage {
  //WHEN FUNCTION HAS ALREADY BEEN DECLARED

  public FunctionRedeclarationError(FilePosition filePosition) {
    super(filePosition);
  }

  @Override
  public void printError() {
    System.out.println("ERROR: Function declared again"); //" on line:..."
  }
}

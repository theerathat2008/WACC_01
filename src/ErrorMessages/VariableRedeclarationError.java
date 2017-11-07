package src.ErrorMessages;

import src.FilePosition;

public class VariableRedeclarationError extends ErrorMessage{
  //WHEN VARIABLE HAS ALREADY BEEN DECLARED

  public VariableRedeclarationError(FilePosition filePosition) {
    super(filePosition);
  }


  @Override
  public void printError() {
    System.out.print("ERROR: Variable declared again"); //" on line:..."
  }

}




package src.ErrorMessages;

import src.FilePosition;

public class TypeError extends ErrorMessage {
  //WHEN INCORRECT TYPE USED E.G. INT INSTEAD OF STRING

  public TypeError(FilePosition filePosition) {
    super(filePosition);
  }

  @Override
  public void printError() {
    System.out.println("ERROR: Incorrect type used"); //" on line:..."
  }


}

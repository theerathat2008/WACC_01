package src.ErrorMessages;

import src.FilePosition;

public class OutOfBoundsError extends ErrorMessage{
  //WHEN ARRAY ELEM IS OUT OF BOUNDS OR EXIT CODE OUT OF BOUNDS

  public OutOfBoundsError(FilePosition filePosition) {
    super(filePosition);
  }

  @Override
  public void printError() {
    System.out.println("ERROR: Value Out of Bounds"); //" on line:..."
  }

}

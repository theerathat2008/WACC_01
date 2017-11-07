package src.ErrorMessages;

import src.FilePosition;

public class TypeMismatchError extends ErrorMessage {
  //WHEN DIFFERENT TYPES ARE USED IN COMPARISONS OR OPERATIONS

  public TypeMismatchError(FilePosition filePosition) {
    super(filePosition);
  }

  @Override
  public void printError() {
    System.out.print("ERROR: Different types used"); //" on line:..."
  }
}

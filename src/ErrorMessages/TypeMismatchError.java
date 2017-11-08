package src.ErrorMessages;

import src.FilePosition;

public class TypeMismatchError extends ErrorMessage {

  /**
   * WHEN DIFFERENT TYPES ARE USED IN COMPARISONS OR OPERATIONS
   * @param filePosition
   */
  public TypeMismatchError(FilePosition filePosition) {
    super(filePosition);
  }

  /**
   * Print out a unique error message
   */
  @Override
  public void printError() {
    System.out.print("ERROR: Different types used"); //" on line:..."
  }
}

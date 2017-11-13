package ErrorMessages;

import src.FilePosition;

import static java.lang.System.exit;

public abstract class ErrorMessage {

  //private field for storing the line of the code that the errors occur
  FilePosition filePosition;

  /**
   * Print out a unique error message
   */
  public abstract void printError();

  /**
   * Constructor for ErrorMessage class which initialises the value for the private field
   *
   * @param filePosition
   */
  public ErrorMessage(FilePosition filePosition) {
    this.filePosition = filePosition;
  }

  /**
   * Print out the line of code that the errors occur
   *
   * @param filePosition
   */
  public void printPos(FilePosition filePosition) {
    System.out.println(filePosition.toString());
  }

  /**
   * Print out error detected including the lines of code that the errors occur
   */
  public void printAll() {
    System.out.println("Errors detected during compilation! Exit code 200 returned.");
    System.out.println("#semantic_error#");
    printError();
    printPos(filePosition);
    exit(200);
  }
}

package src.ErrorMessages;

import src.FilePosition;

public class MissingParameterError  extends ErrorMessage{
  //WHEN FUNCTIONS ARE MISSING ONE OR MORE PARAMETERS - USE TYPEERROR FOR INCORRECT TYPE OF PARAMS

  public MissingParameterError(FilePosition filePosition) {
    super(filePosition);
  }

  @Override
  public void printError() {
    System.out.print("ERROR: Missing parameter(s) in function"); //" on line:..."
  }

}

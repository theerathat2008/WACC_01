package src.ErrorMessages;

import src.FilePosition;

public class UndefinedFunctionError extends ErrorMessage {
  //WHEN IDENT THAT HAS NOT BEEN DECLARED YET IS USED

  public UndefinedFunctionError(FilePosition filePosition) {
    super(filePosition);
  }

  @Override
  public void printError() {
    System.out.println("ERROR: Undeclared Function"); //" on line:..."
  }

}

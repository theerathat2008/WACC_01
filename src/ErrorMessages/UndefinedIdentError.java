package src.ErrorMessages;

import src.FilePosition;

public class UndefinedIdentError extends ErrorMessage{
  //WHEN IDENT THAT HAS NOT BEEN DECLARED YET IS USED

  public UndefinedIdentError(FilePosition filePosition) {
    super(filePosition);
  }

  @Override
  public void printError() {
    System.out.println("ERROR: Undeclared Variable"); //" on line:..."
  }


}

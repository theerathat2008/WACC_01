package src.ErrorMessages;

import src.FilePosition;

public class ReservedKeywordError extends ErrorMessage {
  //WHEN IDENT THAT HAS NOT BEEN DECLARED YET IS USED

  public ReservedKeywordError(FilePosition filePosition) {
    super(filePosition);
  }

  @Override
  public void printError() {
    System.out.print("ERROR: Variable name is a reserved keyword therefore not allowed "); //" on line:..."
  }

}

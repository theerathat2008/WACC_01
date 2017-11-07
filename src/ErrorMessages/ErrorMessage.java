package src.ErrorMessages;

import src.FilePosition;

public abstract class ErrorMessage {

  FilePosition filePosition;

  public abstract void printError();

  public ErrorMessage(FilePosition filePosition){
    this.filePosition = filePosition;
  }

  public void printPos(FilePosition filePosition){
    System.out.print(filePosition.toString());
  }

  public void printAll(){
    printError();
    printPos(filePosition);
  }


}

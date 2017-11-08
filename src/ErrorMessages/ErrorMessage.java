package src.ErrorMessages;

import src.FilePosition;

import static java.lang.System.exit;

public abstract class ErrorMessage {

  FilePosition filePosition;

  public abstract void printError();

  public ErrorMessage(FilePosition filePosition){
    this.filePosition = filePosition;
  }

  public void printPos(FilePosition filePosition){
    System.out.println(filePosition.toString());
  }

  public void printAll(){
    System.out.println("Errors detected during compilation! Exit code 200 returned.");
    System.out.println("#semantic_error#");
    printError();
    printPos(filePosition);
    exit(200);
  }


}

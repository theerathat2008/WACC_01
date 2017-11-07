package src;

public class FilePosition {
  int line;
  int column;

  public FilePosition (int line, int column) {
    this.line = line;
    this.column = column;
  }

  public int getColumn() {
    return this.column;
  }

  public int getLine() {
    return this.line;
  }

  public String toString(){
    return " on line: " + this.line + "   column: " + this.column;
  }
}

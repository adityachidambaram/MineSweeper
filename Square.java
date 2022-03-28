public class Square {
  private int row, column, value;
  private String space;
  public Square(int row, int column, int value, String space) {
      this.row = row;
      this.column = column;
      this.value = value;
      this.space = space;
  }

  public int getRow() {
      return row;
  }
  
  public String getSpace() {
      return space;
  }
  public int getColumn() {
      return column;
  }

  public int getValue() {
      return value;
  }

  public void changeValue(int nval) {
      value = nval;
      updateSpace();
  }

  public void setMine(){
      value = -1;
  }
  //increases the value to see if the square if a mine or a block.
  public void incrementVal() {
      value++;
  }

  //makes it look nicer to the user
  public void updateSpace() {
      switch (value) {
          case 0: space = " "; break;
          case -3: space = " "; break;
          case -1: space = "💣"; break;
          case -2: space = "🚩"; break;
          case 1: space = "1️⃣ "; break;
          case 2: space = "2️⃣ "; break;
          case 3: space = "3️⃣ "; break;
          case 4: space = "4️⃣ "; break;
          case 5: space = "5️⃣ "; break;
          case 6: space = "6️⃣ "; break;
          case 7: space = "7️⃣ "; break;
          case 8: space = "8️⃣ "; break;
          default: space = (""); break;
      }
  }

  public String toString() {
      return space + " ";
  }
}

public class Grid {
  private int width, height;
  private Square[][] squares;
  public static int mines;
  public Grid() {
      width = 9;
      height = 9;

      //creating the ground
      squares = new Square[width][height];
      for(int i = 0; i < width; i++) {
          for(int j = 0; j < height; j++){
              int val = 0;
              squares[i][j] = new Square(i, j, val, "🟩");
          }
      }
      //putting mines in random locations
      for(int i = 0; i < 10; i++){
          int randRow = (int)(Math.random()*9);
          int randCol = (int)(Math.random()*9);
          if (squares[randRow][randCol].getValue() == -1) 
            i--;
          else 
            mines++;
          squares[randRow][randCol].setMine();
      }
      //finding where the mines are to get the numbers for the surrounding blocks.
      for(int i = 0; i < width; i++){
          for(int j = 0; j < height; j++){
              int val = squares[i][j].getValue();
              if (val == 0){
                  for(int r = i-1; r < i+2; r++){
                      if (r < 0 || r > 8) continue;
                      for(int c = j-1; c < j+2; c++){
                          if (c < 0 || c > 8) continue;
                          if (r == i && c == j) continue;
                          if (squares[r][c].getValue() == -1){
                              squares[i][j].incrementVal();
                          }
                      }
                  }
              }
          }
      }
  }

  
  public void checkSquare(int r, int c) {
      squares[r][c].updateSpace();
      breakEmptySpots(squares[r][c]);
  }
  //opens all slots that are 0.
  public void breakEmptySpots(Square s){
      int row = s.getRow();
      int col = s.getColumn();
      if (s.getValue() != -1){
          s.updateSpace();
      } else return;
      if (s.getValue() != 0) { 
          return;
      } else {
          for(int i = row-1; i < row+2; i++){
              if (i < 0 || i > 8) {
                  continue;
              }
              for(int j = col-1; j < col + 2; j++){
                  if (j < 0 || j > 8) {
                      continue;
                  }
                  if (i == row && j == col) { 
                      continue;
                  } else if (squares[i][j].getValue() == -3) {
                      continue;
                  }
                  else { 
                      squares[row][col].changeValue(-3);
                      breakEmptySpots(squares[i][j]); 
                  }
              }
          }
      }
      return;
  }

  public void printGrid() {
      for(int i = 0; i < width; i++){
          for(int j = 0; j < height; j++){
              System.out.print(squares[i][j]);
          }
          System.out.println();
      }
  }

  public void flagSquare(int r, int c) {
      if (squares[r][c].getValue() == -1) mines--;
      squares[r][c].changeValue(-2);
  }

  public boolean gameOver() {
      for(int i = 0; i < width; i++) {
          for(int j = 0; j < height; j++) {
              if (squares[i][j].toString().contains("💣")) {
                  return true;
              }
          }
      }

      if (mines == 0) return true;
      return false;
  }


}

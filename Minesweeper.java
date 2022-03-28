import java.util.Scanner;

public class Minesweeper {
    public Minesweeper() {
        Grid g = new Grid();
		g.printGrid();
		Scanner reader = new Scanner(System.in);
		while(!g.gameOver())
		{

			System.out.print("Check (1) or Flag(2)?");
			int cf = reader.nextInt();
			System.out.print("Row: ");
			int r = reader.nextInt();
			if (r == -1) continue;
			System.out.print("Col: ");
			int c = reader.nextInt();
			if (c == -1) continue;
			if (cf == 2)
				g.flagSquare(r-1, c-1);
			else
				g.checkSquare(r-1, c-1);
				
			clearScreen();
			g.printGrid();
		}
		System.out.println("Mines left: " + Grid.mines);

		if (Grid.mines == 0) {
			System.out.println("\n\nY88b   d88P                                   d8b               888 888 888");
			System.out.println(" Y88b d88P                                    Y8P               888 888 888");
			System.out.println("  Y88o88P                                                       888 888 888");
			System.out.println("   Y888P  .d88b.  888  888      888  888  888 888 88888b.       888 888 888");
			System.out.println("    888  d88\"\"88b 888  888      888  888  888 888 888 \"88b      888 888 888");
			System.out.println("    888  888  888 888  888      888  888  888 888 888  888      Y8P Y8P Y8P");
			System.out.println("    888  Y88..88P Y88b 888      Y88b 888 d88P 888 888  888       \"   \"   \" ");
			System.out.println("    888   \"Y88P\"   \"Y88888       \"Y8888888P\"  888 888  888      888 888 888");
		}
		else 
			System.out.println("You lost...");

    }
	//clears the terminal everytime you click enter.
	static void clearScreen(){
		System.out.println("\033[H\033[2J");
		System.out.flush();
	  }
}

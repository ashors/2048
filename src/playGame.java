import java.util.Scanner;

public class playGame {
	
	public static round round;
	public static moveTiles move = new moveTiles();
	public static startGame game;
	public static int[][] board;
	public static int max;
	public static int moves;
	public static boolean gameOver = false;
	
	public static void makeNewGame() {
		round = new round();
		game = new startGame();
		board = game.board;
		max = 0;
		moves = 0;
	}
	
	public static void oneRound() { // this method is called every time the user makes another move
		Scanner sc = new Scanner(System.in);
		char direc = sc.next().charAt(0);
		if (direc == 'a') {
			gameOver = move.makeMove('a', board);
			moves += 1;
		}
		if (direc == 's') {
			gameOver = move.makeMove('s', board);
			moves += 1;
		}
		if (direc == 'd') {
			gameOver = move.makeMove('d', board);
			moves += 1;
		}
		if (direc == 'w') {
			gameOver = move.makeMove('w', board);
			moves += 1;
		}
		if (direc == 'q') {
			System.out.println("Are you sure you want to quit? ");
			char ans = sc.next().charAt(0);
			if (ans == 'y') {
				gameOver = true;
			}
			else {
				round.printArray(board);
			}
		}
		if (direc == 'r') {
			System.out.println("Are you sure you want to quit? ");
			char ans = sc.next().charAt(0);
			if (ans == 'y') {
				makeNewGame();
				round.printArray(board);
			}
			else {
				round.printArray(board);
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Enter a, s, w, or d to move left, right, up or down. "
				+ "Enter q to quit and r to restart. \n");
		makeNewGame();
		round.printArray(board);
		while (gameOver == false) {
			oneRound();
		}
		if (gameOver = true) {
			for (int[] row : board) {
				for (int num : row) {
					if (num > max) {
						max = num;
					}
				}
			}
		}
		System.out.println("Score: " + max);
		System.out.println("Moves: " + moves);
	}

}

import java.util.Random;

public class startGame {
	
	int[][] board = new int[4][4];;
	
	public startGame() {
		Random rand = new Random();
		// for the first number
		int index1 = rand.nextInt(16);
		double prob1 = Math.random();
		int num;
		if (prob1 <= .2) {
			num = 4;
		}
		else {
			num = 2;
		}
		if (index1 < 4) {
			board[0][index1] = num;
		}
		else if (index1 < 8) {
			board[1][index1 % 4] = num;
		}
		else if (index1 < 12) {
			board[2][index1 % 4] = num;
		}
		else {
			board[3][index1 % 4] = num;
		}
		// for the second number
		int index2 = rand.nextInt(16);
		while (index2 == index1) {
			index2 = rand.nextInt(16);
		}
		double prob2 = Math.random();
		if (prob2 <= .2) {
			num = 4;
		}
		else {
			num = 2;
		}
		if (index2 < 4) {
			board[0][index2] = num;
		}
		else if (index2 < 8) {
			board[1][index2 % 4] = num;
		}
		else if (index2 < 2) {
			board[2][index2 % 4] = num;
		}
		else {
			board[3][index2 % 4] = num;
		}
	}

}

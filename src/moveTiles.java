import java.util.Random;

public class moveTiles {
	
	int[][] prev = new int[4][4];
	
	public void moveLeftOnce(int[][] arr) {
		for (int[] row : arr) {
			for (int num = 0; num < 3; num++) {
				if (row[num] == 0) { // this moves all the nonzero numbers to the left by switching them with zeros. 
					int temp = row[num + 1];
					row[num + 1] = row[num];
					row[num] = temp;
				}
			}
		}
	}
	
	public void moveLeft(int[][] arr) { // this method calls moveLeftOnce until all the nonzero values are pushed to the left
		round round = new round();
		boolean empty1 = false;
		boolean empty2 = false;
		boolean empty3 = false;
		boolean empty4 = false;
		if (arr[0][0] == 0 && arr[0][1] == 0 && arr[0][2] == 0 && arr[0][3] == 0) {
			empty1 = true;
		}
		if (arr[1][0] == 0 && arr[1][1] == 0 && arr[1][2] == 0 && arr[1][3] == 0) {
			empty2 = true;
		}
		if (arr[2][0] == 0 && arr[2][1] == 0 && arr[2][2] == 0 && arr[2][3] == 0) {
			empty3 = true;
		}
		if (arr[3][0] == 0 && arr[3][1] == 0 && arr[3][2] == 0 && arr[3][3] == 0) {
			empty4 = true;
		}
		while ((arr[0][0] == 0 && empty1 == false) || (arr[1][0] == 0 && empty2 == false) || 
				(arr[2][0] == 0 && empty3 == false) || (arr[3][0] == 0 && empty4 == false)) {
			moveLeftOnce(arr); // if there is still moving left to do, continues to move left once
							   // until there are no more moves to make
		}
		for (int[] row : arr) { // this is for adding numbers in a row
			for (int num = 0; num < 3; num++) {
				if (row[num] == row[num + 1]) { 
					row[num] = row[num] + row[num + 1];
					row[num + 1] = 0;
				}
			}
			moveLeftOnce(arr); // shifts everything left again after numbers have been combined
		}
	}
	
	public void moveRightOnce(int[][] arr) { // same procedure as moveLeftOnce, just to the opposite direction
		for (int[] row : arr) {
			for (int num = 3; num > 0; num--) {
				if (row[num] == 0) {
					int temp = row[num - 1];
					row[num - 1] = row[num];
					row[num] = temp;
				}
			}
		}
	}
	
	public void moveRight(int[][] arr) {
		round round = new round();
		boolean empty1 = false;
		boolean empty2 = false;
		boolean empty3 = false;
		boolean empty4 = false;
		if (arr[0][0] == 0 && arr[0][1] == 0 && arr[0][2] == 0 && arr[0][3] == 0) {
			empty1 = true;
		}
		if (arr[1][0] == 0 && arr[1][1] == 0 && arr[1][2] == 0 && arr[1][3] == 0) {
			empty2 = true;
		}
		if (arr[2][0] == 0 && arr[2][1] == 0 && arr[2][2] == 0 && arr[2][3] == 0) {
			empty3 = true;
		}
		if (arr[3][0] == 0 && arr[3][1] == 0 && arr[3][2] == 0 && arr[3][3] == 0) {
			empty4 = true;
		}
		while ((arr[0][3] == 0 && empty1 == false) || (arr[1][3] == 0 && empty2 == false) || 
				(arr[2][3] == 0 && empty3 == false) || (arr[3][3] == 0 && empty4 == false)) {
			moveRightOnce(arr); // if there is still moving left to do, continues to move left once
							   // until there are no more movements to make
		}
		for (int[] row : arr) { // this is for adding numbers in a row
			for (int num = 3; num > 0; num--) {
				if (row[num] == row[num - 1]) { // this part might not work if there are a lot of 
					row[num] = 2 * row[num];
					row[num - 1] = 0;
				}
			}
			moveRightOnce(arr); // shifts everything right again after numbers have been combined
			moveRightOnce(arr);
		}
	}
	
	public void moveUpOnce(int[][] arr) { // same procedure as rows, but loops through columns instead
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				if (arr[i][j] == 0) {
					int temp = arr[i + 1][j];
					arr[i + 1][j] = arr[i][j];
					arr[i][j] = temp;
				}
			}
		}
	}
	
	public void moveUp(int[][] arr) {
		round round = new round();
		boolean empty1 = false;
		boolean empty2 = false;
		boolean empty3 = false;
		boolean empty4 = false;
		if (arr[0][0] == 0 && arr[1][0] == 0 && arr[2][0] == 0 && arr[3][0] == 0) {
			empty1 = true;
		}
		if (arr[0][1] == 0 && arr[1][1] == 0 && arr[2][1] == 0 && arr[3][1] == 0) {
			empty2 = true;
		}
		if (arr[0][2] == 0 && arr[1][2] == 0 && arr[2][2] == 0 && arr[3][2] == 0) {
			empty3 = true;
		}
		if (arr[0][3] == 0 && arr[1][3] == 0 && arr[2][3] == 0 && arr[3][3] == 0) {
			empty4 = true;
		}
		while ((arr[0][0] == 0 && empty1 == false) || (arr[0][1] == 0 && empty2 == false) || 
				(arr[0][2] == 0 && empty3 == false) || (arr[0][3] == 0 && empty4 == false)) {
			moveUpOnce(arr);
		}
		moveUpOnce(arr); // this is because after moving up, sometimes numbers are still 
		moveUpOnce(arr); // separated by one or two 0s
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				if (arr[i][j] == arr[i + 1][j]) {
					arr[i][j] = 2 * arr[i][j];
					arr[i + 1][j] = 0;
				}
			}
			moveUpOnce(arr); // makes sure everything is still in the right place after summing up numbers
		}
	}
	
	public void moveDownOnce(int[][] arr) {
		for (int i = 3; i > 0; i--) {
			for (int j = 3; j >= 0; j--) {
				if (arr[i][j] == 0) {
					int temp = arr[i - 1][j];
					arr[i - 1][j] = arr[i][j];
					arr[i][j] = temp;
				}
			}
		}
	}
	
	public void moveDown(int[][] arr) {
		round round = new round();
		boolean empty1 = false;
		boolean empty2 = false;
		boolean empty3 = false;
		boolean empty4 = false;
		if (arr[0][0] == 0 && arr[1][0] == 0 && arr[2][0] == 0 && arr[3][0] == 0) {
			empty1 = true;
		}
		if (arr[0][1] == 0 && arr[1][1] == 0 && arr[2][1] == 0 && arr[3][1] == 0) {
			empty2 = true;
		}
		if (arr[0][2] == 0 && arr[1][2] == 0 && arr[2][2] == 0 && arr[3][2] == 0) {
			empty3 = true;
		}
		if (arr[0][3] == 0 && arr[1][3] == 0 && arr[2][3] == 0 && arr[3][3] == 0) {
			empty4 = true;
		}
		while ((arr[3][0] == 0 && empty1 == false) || (arr[3][1] == 0 && empty2 == false) || 
				(arr[3][2] == 0 && empty3 == false) || (arr[3][3] == 0 && empty4 == false)) {
			moveDownOnce(arr);
		}
		moveDownOnce(arr); // this is because after moving down, sometimes numbers are still 
		moveDownOnce(arr); // separated by one or two 0s
		for (int i = 3; i > 0; i--) {
			for (int j = 3; j >= 0; j--) {
				if (arr[i][j] == arr[i - 1][j]) {
					arr[i][j] = arr[i][j] + arr[i - 1][j];
					arr[i - 1][j] = 0;
				}
			}
			moveDownOnce(arr); // makes sure everything is still in the right place after summing numbers
		}
	}
	
	public boolean makeMove(char direc, int[][] arr) { // this method shifts and adds tiles and adds another random
													// 2 or 4 to the board
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				prev[i][j] = arr[i][j];
			}
		}
		boolean valid = false;
		round round = new round();
		boolean full = true; // to see if theres anywhere to put another random number
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (arr[i][j] == 0) {
					full = false;
				}
			}
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (arr[i][j] == arr[i+1][j] || arr[i][j] == arr[i][j+1]) {
					full = false;
				}
			}
		}
		if (direc == 'a') {
			moveLeft(arr);
		}
		if (direc == 'd') {
			moveRight(arr);
		}
		if (direc == 'w') {
			moveUp(arr);
		}
		if (direc == 's') {
			moveDown(arr);
		}
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (prev[i][j] != arr[i][j]) {
					valid = true;
					break;
				}
			}
				
		}
		if (valid == true) { // if a valid move is made, adds another number to the board
			Random rand = new Random();
			int row = rand.nextInt(4); 
			int column = rand.nextInt(4);
			while (arr[row][column] != 0 && full == false) {
				row = rand.nextInt(4); 
				column = rand.nextInt(4);
			}
			double prob = Math.random();
			if (prob <= .2) {
				arr[row][column] = 4;
			}
			else {
				arr[row][column] = 2;
			}
		}
		System.out.println();
		round.printArray(arr);
		if (full == true) {
			boolean gameOver = true;
			for (int i = 1; i < 4; i ++) {
				for (int j = 1; j < 4; j++) {
					if (arr[i][j] == arr[i-1][j] || arr[i][j] == arr[i][j-1]) {
						gameOver = false;
					}
				}
			}
			if (gameOver == true) {
				System.out.println("GAME OVER");
			}
		}
		return full;
	}
}


public class round {
	
	public void printArray(int[][] arr) { // this just prints out the board
		for (int[] row: arr) {
			for (int num : row) {
				if (num < 10) {
					if (num == 0) {
						System.out.print("*    ");
					}
					else {
						System.out.print(num + "    ");
					}
				}
				else if (num < 100) {
					if (num == 0) {
						System.out.print("*   ");
					}
					else {
						System.out.print(num + "   ");
					}
				}
				else if (num < 1000) {
					if (num == 0) {
						System.out.print("*  ");
					}
					else {
						System.out.print(num + "  ");
					}
				}
				else {
					if (num == 0) {
						System.out.print("* ");
					}
					else {
						System.out.print(num + " ");
					}
				}
			}
			System.out.println();
		}
	}

}

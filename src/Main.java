import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("Filling 1st matrix.");

		int[][] matrix1 = fillMatrixWithInts(4, 4);

		System.out.println("Filling 2nd matrix.");

		int[][] matrix2 = fillMatrixWithInts(4, 4);

		System.out.println(isCovered(matrix1, matrix2));
	}

	static int[][] fillMatrixWithInts(int rows, int columns) {
		int[][] matrix = new int[rows][columns];

		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				System.out.println("Input a number.");
				matrix[row][col] = intInput();
			}
		}

		return matrix;
	}

	static int intInput() {
		Scanner keyType    = new Scanner(System.in);
		int     input      = 0;
		boolean validInput = false;

		while (!validInput) {
			try {
				input = keyType.nextInt();
				validInput = true;
			} catch (InputMismatchException i) {
				System.out.println("Not a valid number. Try again.");
				keyType.nextLine();
			}
		}

		return input;
	}

	static boolean isCovered(int[][] matrix1, int[][] matrix2) {
		int rows = Math.min(matrix1.length, matrix2.length);
		int cols = Math.min(matrix1[0].length, matrix2[0].length);
		int count = 0;

		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (matrix1[row][col] > matrix2[row][col]) {
					count++;
				}
			}
		}

		return count > ((rows * cols) / 2);
	}
}

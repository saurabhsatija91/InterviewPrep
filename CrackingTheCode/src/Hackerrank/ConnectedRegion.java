package Hackerrank;

public class ConnectedRegion {
	public static int getBiggestRegion (int[][] matrix) {
		int maxRegion = 0;
		
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[0].length; col++) {
				if (matrix[row][col] == 1) {
					int size = getRegionSize(matrix, row, col);
					maxRegion = Math.max(maxRegion, size);
				}
			}
		}
		
		return maxRegion;
	}
	
	public static int getRegionSize(int[][] matrix, int row, int col) {
		if(row < 0 || col < 0 || row > matrix.length || col > matrix[row].length) {
			return 0;
		}
		if(matrix[row][col] == 0)
			return 0;

		matrix[row][col] = 0;
		int size = 1;
		
		for (int r = row - 1; r <= row + 1; r++) {
			for(int c = col - 1; c <= col + 1; c++) {
				size += getRegionSize(matrix, r, c);
			}
		}
		
		return size;
	}
}

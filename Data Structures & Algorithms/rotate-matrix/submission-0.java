class Solution {
    public void rotate(int[][] matrix) {

        // reverse rows
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int r = 0; r < rows / 2; r++) {
            int[] first = matrix[r];
            int[] last = matrix[rows - r - 1];
            matrix[rows - r - 1] = first;
            matrix[r] = last;
        }

        // transpose
        for (int r = 0; r < rows; r++) {
            for (int c = r; c < cols; c++) {
                int temp = matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r] = temp;
            }
        }

    }
}

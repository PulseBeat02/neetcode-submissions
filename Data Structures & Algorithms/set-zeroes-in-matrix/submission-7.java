class Solution {
    public void setZeroes(int[][] matrix) {
        

        /*
        0 1
        1 1

        0

        */
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean firstRowZero = false;
        boolean firstColZero = false;

        // Check first row
        for (int c = 0; c < cols; c++) {
            if (matrix[0][c] == 0) firstRowZero = true;
        }

        // Check first column
        for (int r = 0; r < rows; r++) {
            if (matrix[r][0] == 0) firstColZero = true;
        }

        // set 0's
        for (int r = 1; r < rows; r++) {
            for (int c = 1; c < cols; c++) {
                if (matrix[r][c] == 0) {
                    matrix[r][0] = 0;
                    matrix[0][c] = 0;
                }
            }
        }

        // check rows
        for (int r = 1; r < rows; r++) {
            if (matrix[r][0] == 0) Arrays.fill(matrix[r], 0);
        }

        // check cols
        for (int c = 1; c < cols; c++) {
            if (matrix[0][c] == 0) {
                for (int r = 0; r < rows; r++) matrix[r][c] = 0;
            }
        }

        // Handle first row
        if (firstRowZero) Arrays.fill(matrix[0], 0);

        // Handle first column
        if (firstColZero) {
            for (int r = 0; r < rows; r++) {
                matrix[r][0] = 0;
            }
        }
    }
}

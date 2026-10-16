class Solution {


    /*

    1 2
    3 4

    1 3
    2 4


    */

    public void rotate(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;
        
        // Reflect
        for (int r = 0; r < rows; r++) {
            for (int c = r + 1; c < cols; c++) {
                int temp = matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r] = temp;
            }
        }

        System.out.println(Arrays.deepToString(matrix));

        // Reverse
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols / 2; c++) {
                int temp = matrix[r][c];
                matrix[r][c] = matrix[r][cols - c - 1];
                matrix[r][cols - c - 1] = temp;
            }
        }
    }
}

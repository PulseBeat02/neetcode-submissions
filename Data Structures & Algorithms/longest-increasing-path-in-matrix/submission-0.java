class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int max = 0;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                max = Math.max(max, dfs(matrix, r, c) + 1);
            }
        }
        return max;
    }

    int[][] directions = {
        {1, 0}, {-1, 0},
        {0, 1}, {0, -1}
    };

    public int dfs(int[][] matrix, int r, int c) {
        int max = 0;
        for (int[] direction : directions) {
            int nR = r + direction[0];
            int nC = c + direction[1];
            if (nR < 0 || nR >= matrix.length || nC < 0 || nC >= matrix[0].length) continue;
            if (matrix[nR][nC] <= matrix[r][c]) continue;
            max = Math.max(max, dfs(matrix, nR, nC) + 1);
        }
        return max;
    }
}

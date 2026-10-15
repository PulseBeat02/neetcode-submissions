class Solution {

    
    public int longestIncreasingPath(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        for (int[] arr : dp) Arrays.fill(arr, -1);
        int max = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                max = Math.max(max, dfs(dp, matrix, r, c));
            }
        }
        return max;
    }

    public int dfs(int[][] dp, int[][] matrix, int r, int c) {
        if (dp[r][c] != -1) return dp[r][c];
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] deltas = new int[][] {
            {1, 0}, {0, 1}, {-1, 0}, {0, -1}
        };
        int max = 1;
        for (int[] delta : deltas) {
            int dr = delta[0];
            int dc = delta[1];
            int nR = r + dr;
            int nC = c + dc;
            if (nR < 0 || nR >= rows || nC < 0 || nC >= cols) continue;
            if (matrix[nR][nC] <= matrix[r][c]) continue;
            max = Math.max(max, dfs(dp, matrix, nR, nC) + 1);
        }
        return dp[r][c] = max;
    }
}

class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        for (int[] arr : dp) Arrays.fill(arr, -1);
        int max = 0;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                max = Math.max(max, dfs(dp, matrix, r, c) + 1);
            }
        }
        return max;
    }

    int[][] directions = {
        {1, 0}, {-1, 0},
        {0, 1}, {0, -1}
    };

    public int dfs(int[][] dp, int[][] matrix, int r, int c) {
        if (dp[r][c] != -1) return dp[r][c];
        int max = 0;
        for (int[] direction : directions) {
            int nR = r + direction[0];
            int nC = c + direction[1];
            if (nR < 0 || nR >= matrix.length || nC < 0 || nC >= matrix[0].length) continue;
            if (matrix[nR][nC] <= matrix[r][c]) continue;
            max = Math.max(max, dfs(dp, matrix, nR, nC) + 1);
        }
        dp[r][c] = max;
        return dp[r][c];
    }
}

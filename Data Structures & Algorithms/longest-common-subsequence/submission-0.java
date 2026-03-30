class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int[] arr : dp) Arrays.fill(arr, -1);
        return dfs(dp, text1, text2, 0, 0);
    }

    private int dfs(int[][] dp, String text1, String text2, int i, int j) {
        if (i == text1.length() || j == text2.length()) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        if (text1.charAt(i) == text2.charAt(j)) {
            dp[i][j] = 1 + dfs(dp, text1, text2, i + 1, j + 1);
            return dp[i][j];
        }
        dp[i][j] = Math.max(dfs(dp, text1, text2, i + 1, j), dfs(dp, text1, text2, i, j + 1));
        return dp[i][j];
    }
}

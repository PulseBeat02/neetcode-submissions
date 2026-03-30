class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int[] arr : dp) Arrays.fill(arr, -1);
        return dfs(dp, s, t, 0, 0);
    }

    public int dfs(int[][] dp, String s, String t, int i, int j) {
        if (j == t.length()) return 1;
        if (i == s.length()) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        int res = dfs(dp, s, t, i + 1, j);
        if (s.charAt(i) == t.charAt(j)) {
            res += dfs(dp, s, t, i + 1, j + 1);
        }
        dp[i][j] = res;
        return dp[i][j];
    }
}

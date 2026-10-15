public class Solution {
    public boolean isMatch(String s, String p) {
        int[][] dp = new int[s.length() + 1][p.length() + 1];
        for (int[] arr : dp) Arrays.fill(arr, -1);
        return dfs(dp, 0, 0, s, p);
    }

    private boolean dfs(int[][] dp, int i, int j, String s, String p) {
        if (j == p.length()) return i == s.length();
        if (dp[i][j] != -1) return dp[i][j] == 1;

        boolean match = i < s.length() && (s.charAt(i) == p.charAt(j) ||
                        p.charAt(j) == '.');
        boolean works = false;
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            works = dfs(dp, i, j + 2, s, p) ||
                   (match && dfs(dp, i + 1, j, s, p));
        }

        if (match) {
            works = works || dfs(dp, i + 1, j + 1, s, p);
        }

        dp[i][j] = works ? 1 : 0;
        return works;
    }
}
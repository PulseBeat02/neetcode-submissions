public class Solution {

    public boolean isInterleave(String s1, String s2, String s3) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int[] arr : dp) Arrays.fill(arr, -1);
        return dfs(dp, 0, 0, 0, s1, s2, s3);
    }

    private boolean dfs(int[][] dp, int i, int j, int k, String s1, String s2, String s3) {

        if (k == s3.length()) return i == s1.length() && j == s2.length();
        if (dp[i][j] != -1) return dp[i][j] == 1;

        if (i < s1.length() && s3.charAt(k) == s1.charAt(i)) {
            if (dfs(dp, i + 1, j, k + 1, s1, s2, s3)) {
                dp[i + 1][j] = 1;
                return true;
            }
        }

        if (j < s2.length() && s3.charAt(k) == s2.charAt(j)) {
            if (dfs(dp, i, j + 1, k + 1, s1, s2, s3)) {
                dp[i][j + 1] = 1;
                return true;
            }
        }

        dp[i][j] = 0;
        return false;
    }
}
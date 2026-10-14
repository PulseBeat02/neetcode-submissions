class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for (int[] arr : dp) Arrays.fill(arr, -1);
        return longest(dp, text1, text2, 0, 0);
    }

    public int longest(int[][] dp, String first, String second, int i, int j) {
        if (i >= first.length() || j >= second.length()) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        int longest = 0;
        if (first.charAt(i) == second.charAt(j)) {
            return dp[i][j] = 1 + longest(dp, first, second, i + 1, j + 1);
        }
        return dp[i][j] = Math.max(longest(dp, first, second, i + 1, j), longest(dp, first, second, i, j + 1));
    }
}

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
        for (int k = i; k < first.length(); k++) {
            for (int l = j; l < second.length(); l++) {
                if (first.charAt(k) == second.charAt(l)) {
                    longest = Math.max(longest, longest(dp, first, second, k + 1, l + 1) + 1);
                }
            }
        }
        return dp[i][j] = longest;
    }
}

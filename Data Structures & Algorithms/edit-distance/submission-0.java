class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int[] arr : dp) Arrays.fill(arr, -1);
        return dfs(dp, word1, word2, 0, 0);
    }

    public int dfs(int[][] dp, String word1, String word2, int i, int j) {
        
        if (i == word1.length()) return (word2.length() - j);
        if (j == word2.length()) return (word1.length() - i);
        if (dp[i][j] != -1) return dp[i][j];

        if (word1.charAt(i) == word2.charAt(j)) {
            dp[i][j] = dfs(dp, word1, word2, i + 1, j + 1);
            return dp[i][j];
        }

        dp[i][j] = Math.min(dfs(dp, word1, word2, i, j + 1), Math.min(dfs(dp, word1, word2, i + 1, j), dfs(dp, word1, word2, i + 1, j + 1))) + 1; 
        return dp[i][j];
    }
}

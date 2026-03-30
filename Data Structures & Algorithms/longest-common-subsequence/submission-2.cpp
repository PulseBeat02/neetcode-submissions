class Solution {
public:

    int longestCommonSubsequence(string text1, string text2) {
        vector<vector<int>> dp(text1.size(), vector<int>(text2.size(), -1));
        return dfs(dp, text1, text2, 0, 0);
    }

    int dfs(vector<vector<int>>& dp, string& text1, string& text2, int i, int j) {
        if (i == text1.size() || j == text2.size()) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        int max = -1;
        if (text1[i] == text2[j]) {
            max = dfs(dp, text1, text2, i + 1, j + 1) + 1;
        }
        max = std::max(max, dfs(dp, text1, text2, i, j + 1));
        max = std::max(max, dfs(dp, text1, text2, i + 1, j));
        dp[i][j] = max;
        return dp[i][j];
    }
};

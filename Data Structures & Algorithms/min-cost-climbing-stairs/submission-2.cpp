class Solution {
public:
    int minCostClimbingStairs(vector<int>& cost) {
        vector<int> dp(cost.size() + 1, -1);
        return min(dfs(dp, cost, 0), dfs(dp, cost, 1));
    }

    int dfs(vector<int>& dp, vector<int>& cost, int index) {
        if (index >= cost.size()) return 0;
        if (dp[index] != -1) {
            return dp[index];
        }
        dp[index] = cost[index] + min(dfs(dp, cost, index + 1), dfs(dp, cost, index + 2));
        return dp[index];
    }
};

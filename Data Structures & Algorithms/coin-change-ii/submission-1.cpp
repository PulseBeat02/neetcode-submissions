class Solution {
public:
    int change(int amount, vector<int>& coins) {
        vector<vector<int>> dp(coins.size(), vector<int>(amount, -1));
        return combination(dp, coins, 0, 0, amount);
    }

    int combination(vector<vector<int>>& dp, vector<int>& coins, int start, int current, int target) {
        if (current == target) return 1;
        if (current > target) return 0;
        if (dp[start][current] != -1) return dp[start][current];
        int possible = 0;
        for (int i = start; i < coins.size(); i++) {
            int coin = coins[i];
            if (current + coin > target) continue;
            possible += combination(dp, coins, i, current + coin, target);
        }
        dp[start][current] = possible;
        return dp[start][current];
    }
};

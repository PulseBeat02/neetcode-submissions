class Solution {
public:

    vector<int> dp;

    int coinChange(vector<int>& coins, int amount) {
        dp.resize(amount, -1);
        int ans = calculate(coins, 0, amount);
        return ans == INT_MAX ? -1 : ans;
    }

    int calculate(vector<int>& coins, int current, int target) {
        if (current == target) return 0;
        if (dp[current] != -1) return dp[current];
        int min = INT_MAX;
        for (int& coin : coins) {
            if (coin > target - current) continue;
            int amount = calculate(coins, current + coin, target);
            if (amount == INT_MAX) continue;
            min = std::min(min, amount + 1);
        }
        dp[current] = min;
        return dp[current];
    }
};

class Solution {
public:

    vector<int> dp;

    int climbStairs(int n) {
        dp.resize(n + 1, 0);
        return climb(0, n);
    }

    int climb(int current, int n) {
        if (current == n) {
            return 1;
        }
        if (current > n) {
            return 0;
        }
        if (dp[current]) {
            return dp[current];
        }
        dp[current] = climb(current + 1, n) + climb(current + 2, n);
        return dp[current];
    }
};

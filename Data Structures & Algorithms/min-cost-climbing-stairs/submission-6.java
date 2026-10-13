class Solution {

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return Math.min(climb(dp, cost, 0, n), climb(dp, cost, 1, n));
    }

    public int climb(int[] dp, int[] cost, int i, int n) {
        if (i >= n) return 0;
        if (dp[i] != -1) return dp[i];
        dp[i] = cost[i] + Math.min(climb(dp, cost, i + 1, n), climb(dp, cost, i + 2, n));
        return dp[i];
    }
}

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        Arrays.fill(dp, -1);
        return Math.min(climb(dp, cost, 0), climb(dp, cost, 1));
    }

    public int climb(int[] dp, int[] cost, int index) {
        if (index >= cost.length) return 0;
        if (dp[index] != -1) return dp[index];
        dp[index] = cost[index] + Math.min(climb(dp, cost, index + 1), climb(dp, cost, index + 2));
        return dp[index];
    }
}

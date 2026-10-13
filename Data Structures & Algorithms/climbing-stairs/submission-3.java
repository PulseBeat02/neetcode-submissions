class Solution {

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return climb(dp, 0, n);
    }

    public int climb(int[] dp, int current, int target) {
        if (current == target) return 1;
        if (current > target) return 0;
        if (dp[current] != -1) return dp[current];
        dp[current] = climb(dp, current + 1, target) + climb(dp, current + 2, target);
        return dp[current];
    }
}

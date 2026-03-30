class Solution {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        int count = dfs(dp, coins, 0, amount);
        return count == Integer.MAX_VALUE ? -1 : count;
    }

    public int dfs(int[] dp, int[] coins, int current, int target) {
        if (current < 0) return Integer.MAX_VALUE;
        if (current == target) return 0;
        if (current > target) return Integer.MAX_VALUE;
        if (dp[current] != -1) return dp[current];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (current + coin > target) continue;
            int num = dfs(dp, coins, current + coin, target);
            if (num == Integer.MAX_VALUE) continue;
            min = Math.min(num + 1, min);
        }
        dp[current] = min;
        return dp[current];
    }
}

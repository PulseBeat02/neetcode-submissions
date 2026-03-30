class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -2);
        return coins(coins, dp, amount);
    }

    public int coins(int[] coins, int[] dp, int current) {
        if (current == 0) return 0;
        if (dp[current] != -2) return dp[current];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (current - coin >= 0) {
                int sub = coins(coins, dp, current - coin);
                if (sub != -1) min = Math.min(min, sub + 1);
            }
        }
        dp[current] = min == Integer.MAX_VALUE ? -1 : min;
        return dp[current];
    }
}

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        int val = coin(dp, coins, amount);
        return val == Integer.MAX_VALUE ? -1 : val;
    }

    public int coin(int[] dp, int[] coins, int amount) {
        if (amount == 0) return 0;
        if (dp[amount] != -1) return dp[amount];
        int count = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (amount - coin < 0) continue;
            int curr = coin(dp, coins, amount - coin);
            if (curr == Integer.MAX_VALUE) continue;
            count = Math.min(count, curr + 1);
        }
        return dp[amount] = count;
    }
}

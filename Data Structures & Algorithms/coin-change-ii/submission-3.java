class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[amount + 1][coins.length];
        for (int[] arr : dp) Arrays.fill(arr, -1);
        return coinChange(dp, coins, amount, 0);
    }

    public int coinChange(int[][] dp, int[] coins, int current, int index) {
        if (current == 0) return 1;
        if (current < 0) return 0;
        if (dp[current][index] != -1) return dp[current][index];
        int sum = 0;
        for (int i = index; i < coins.length; i++) {
            if (current - coins[i] < 0) continue;
            sum += coinChange(dp, coins, current - coins[i], i);
        }
        return dp[current][index] = sum;
    }
}

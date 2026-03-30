class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int[] arr : dp) Arrays.fill(arr, -1);
        return coinCombinations(coins, 0, amount, dp);
    }

    public int coinCombinations(int[] coins, int index, int amount, int[][] dp) {
        if (amount == 0) return 1;
        if (amount < 0 || index == coins.length) return 0;
        if (dp[index][amount] != -1) return dp[index][amount];
        int include = coinCombinations(coins, index, amount - coins[index], dp);
        int exclude = coinCombinations(coins, index + 1, amount, dp);
        dp[index][amount] = include + exclude;
        return dp[index][amount];
    }
}

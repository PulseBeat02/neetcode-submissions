class Solution {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][n];
        for (int[] arr : dp) Arrays.fill(arr, -1);
        return calculate(dp, prices, -1, 0);
    }

    public int calculate(int[][] dp, int[] prices, int buyIndex, int i) {
        if (i >= prices.length) return 0;
        if (buyIndex == -1) { // didn't choose buy
            return Math.max(calculate(dp, prices, i, i + 1), calculate(dp, prices, -1, i + 1));
        } else { // sell now or later
            if (dp[buyIndex][i] != -1) return dp[buyIndex][i];
            // 1) try sell now
            int now = prices[i] - prices[buyIndex];
            // 2) sell now, or later
            return dp[buyIndex][i] = Math.max(now + calculate(dp, prices, -1, i + 2), 
                calculate(dp, prices, buyIndex, i + 1));
        }
    }
}

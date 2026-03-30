class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int maxProfit = 0;
        for (int price : prices) {
            maxProfit = Math.max(price - min, maxProfit);
            min = Math.min(price, min);
        }
        return maxProfit;
    }
}

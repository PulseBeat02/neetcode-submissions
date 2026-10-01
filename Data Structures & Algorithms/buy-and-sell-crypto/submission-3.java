class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int current = prices[0];
        for (int price : prices) {
            max = Math.max(price - current, max);
            current = Math.min(current, price);
        }
        return max;
    }
}

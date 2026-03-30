public class Solution {

    Map<String, Integer> dp = new HashMap<>();

    public int maxProfit(int[] prices) {
        return dfs(0, true, prices);
    }

    private int dfs(int i, boolean buying, int[] prices) {
        if (i >= prices.length) {
            return 0;
        }
        String hash = i + "-" + buying;
        if (dp.containsKey(hash)) return dp.get(hash);

        int cooldown = dfs(i + 1, buying, prices);
        if (buying) {
            int buy = dfs(i + 1, false, prices) - prices[i];
            dp.put(hash, Math.max(buy, cooldown));
            return dp.get(hash);
        } else {
            int sell = dfs(i + 2, true, prices) + prices[i];
            dp.put(hash, Math.max(sell, cooldown));
            return dp.get(hash);
        }
    }
}
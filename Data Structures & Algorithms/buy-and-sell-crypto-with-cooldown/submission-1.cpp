class Solution {
public:
    int maxProfit(vector<int>& prices) {
        return dfs(prices, true, 0);
    }

    int dfs(vector<int>& prices, bool buy, int i) {
        if (i >= prices.size()) return 0;
        int first = dfs(prices, buy, i + 1);
        if (buy) {
            return max(first, dfs(prices, false, i + 1) - prices[i]);
        } else {
            return max(first, dfs(prices, true, i + 2) + prices[i]);
        }
    }
};

class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int runningMin = prices[0];
        int maxProfit = 0;
        for (int price : prices) {
            runningMin = min(price, runningMin);
            maxProfit = max(price - runningMin, maxProfit);
        }
        return maxProfit;
    }
};

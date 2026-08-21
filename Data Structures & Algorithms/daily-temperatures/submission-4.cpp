class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        // 30 38 30 36 35 40 28
        // [temperature, index]
        int n = temperatures.size();
        stack<pair<int, int>> temps;
        vector<int> ans(n, 0);
        for (int i = 0; i < n; i++) {
            int temp = temperatures[i];
            while (!temps.empty() && temp > temps.top().first) {
                int prev = temps.top().second;
                temps.pop();
                ans[prev] = i - prev;
            }
            temps.push({temp, i});
        }
        return ans;
        //
        //
        //
        // [35, 4]

        // [40, 5]
        // [28, 6]
    }
};

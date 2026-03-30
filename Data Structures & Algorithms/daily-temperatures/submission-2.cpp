class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        int n = temperatures.size();
        stack<pair<int, int>> st;
        vector<int> ans(n, 0); // temp, index
        // 0 1 3 5 7
        for (int i = 0; i < temperatures.size(); i++) {
            while (!st.empty() && st.top().first < temperatures[i]) {
                pair<int, int> top = st.top();
                ans[top.second] = i - top.second;
                st.pop();
            }
            st.push({temperatures[i], i});
        }
        return ans;
    }
};

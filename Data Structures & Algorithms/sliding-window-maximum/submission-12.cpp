class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        vector<int> result;
        multiset<int, greater<int>> window;
        for (int i = 0; i < nums.size(); i++) {
            window.insert(nums[i]);
            if (i >= k) {
                window.erase(window.find(nums[i - k]));
            }
            if (i >= k - 1) {
                result.push_back(*window.begin());
            }
        }
        return result;
    }
};

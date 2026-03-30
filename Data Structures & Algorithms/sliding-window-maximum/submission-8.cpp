class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {

        int n = nums.size();

        multiset<int> set;
        for (int i = 0; i < k; i++) set.insert(nums[i]);

        int len = n - k + 1;
        vector<int> ans;
        for (int i = 0; i < len; i++) {
            ans.push_back(*prev(set.end()));
            auto it = set.find(nums[i]);
            set.erase(it);
            if (i + k < n) set.insert(nums[i+k]);
        }

        return ans;
    }
};

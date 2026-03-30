class Solution {
public:
    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        vector<vector<int>> res;
        vector<int> current;
        backtrack(res, nums, current, 0);
        return res;
    }

    void backtrack(vector<vector<int>>& res, vector<int>& nums, vector<int>& current, int start) {
        res.push_back(vector(current));
        for (int i = start; i < nums.size(); i++) {
            if (i > start && nums[i] == nums[i-1]) continue;
            current.push_back(nums[i]);
            backtrack(res, nums, current, i + 1);
            current.pop_back();
        }
    }
};

class Solution {
public:
    vector<vector<int>> combinationSum(vector<int>& nums, int target) {
        sort(nums.begin(), nums.end());
        vector<vector<int>> res;
        vector<int> current;
        backtrack(res, nums, current, 0, target, 0);
        return res;
    }

    void backtrack(vector<vector<int>>& res, vector<int>& nums, vector<int>& current, int sum, int target, int start) {
        if (sum > target) return;
        if (sum == target) {
            res.push_back(vector(current));
            return;
        }
        for (int i = start; i < nums.size(); i++) {
            current.push_back(nums[i]);
            backtrack(res, nums, current, sum + nums[i], target, i);
            current.pop_back();
        }
    }
};

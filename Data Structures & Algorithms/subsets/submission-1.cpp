class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        vector<vector<int>> ans;
        vector<int> current;
        backtrack(ans, current, nums, 0);
        return ans;
    }

    void backtrack(vector<vector<int>>& ans, vector<int>& current, vector<int>& nums, int start) {
        ans.push_back(std::vector(current));
        for (int i = start; i < nums.size(); i++) {
            current.push_back(nums[i]);
            backtrack(ans, current, nums, i + 1);
            current.pop_back();
        }
    }
};

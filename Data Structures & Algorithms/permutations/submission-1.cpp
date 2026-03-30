class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> ans;
        vector<int> current;
        vector<bool> chosen(nums.size(), false);
        backtrack(ans, nums, current, chosen);
        return ans; 
    }

    void backtrack(vector<vector<int>>& ans, vector<int>& nums, vector<int>& current, vector<bool>& chosen) {
        if (current.size() == nums.size()) {
            ans.push_back(vector(current));
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            if (chosen[i]) continue;
            chosen[i] = true;
            current.push_back(nums[i]);
            backtrack(ans, nums, current, chosen);
            current.pop_back();
            chosen[i] = false;
        }
    }
};

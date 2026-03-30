class Solution {
public:
    int findTargetSumWays(vector<int>& nums, int target) {
        vector<unordered_map<int, int>> dp(nums.size());
        return calculate(dp, nums, 0, 0, target);
    }

    int calculate(vector<unordered_map<int, int>>& dp, vector<int>& nums, int index, int current, int target) {
        if (current == target && index == nums.size()) return 1;
        if (index >= nums.size()) return 0;
        auto it = dp[index].find(current);
        if (it != dp[index].end()) return it->second;
        
        int sum = 0;
        sum += calculate(dp, nums, index + 1, current + nums[index], target);
        sum += calculate(dp, nums, index + 1, current - nums[index], target);
        dp[index][current] = sum;
        return dp[index][current];
    }
};

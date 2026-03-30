class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        return dfs(nums, 0, -1);
    }

    int dfs(vector<int>& nums, int current, int prev) {
        if (current == nums.size()) return 0;
        int max = dfs(nums, current + 1, prev);
        if (prev == -1 || nums[prev] < nums[current]) {
            max = std::max(max, 1 + dfs(nums, current + 1, current));
        }
        return max;
    }
};

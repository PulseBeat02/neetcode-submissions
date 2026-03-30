class Solution {
public:
    int findTargetSumWays(vector<int>& nums, int target) {
        return calculate(nums, 0, 0, target);
    }

    int calculate(vector<int>& nums, int index, int current, int target) {
        if (current == target && index == nums.size()) return 1;
        if (index >= nums.size()) return 0;
        int sum = 0;
        sum += calculate(nums, index + 1, current + nums[index], target);
        sum += calculate(nums, index + 1, current - nums[index], target);
        return sum;
    }
};

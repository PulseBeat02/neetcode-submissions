class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums, 0, target);
    }

    public int dfs(int[] nums, int index, int target) {
        if (target == 0 && index == nums.length) return 1;
        if (index >= nums.length) return 0;
        return dfs(nums, index + 1, target + nums[index])
            + dfs(nums, index + 1, target - nums[index]);
    }
}

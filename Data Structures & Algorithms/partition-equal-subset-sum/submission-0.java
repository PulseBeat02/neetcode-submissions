class Solution {
    public boolean canPartition(int[] nums) {

        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 != 0) return false;

        int target = sum / 2;
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        return dfs(nums, dp, 0, target);
    }

    public boolean dfs(int[] nums, int[] dp, int index, int target) {
        if (index == nums.length) return target == 0;
        if (target < 0) return false;
        if (dp[target] != -1) return dp[target] == 1;
        dp[target] = (dfs(nums, dp, index + 1, target - nums[index]) || dfs(nums, dp, index + 1, target)) ? 1 : 0;
        return dp[target] == 1;
    }
}

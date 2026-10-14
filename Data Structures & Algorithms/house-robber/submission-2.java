class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return robMax(dp, nums, 0);
    }

    public int robMax(int[] dp, int[] nums, int i) {
        if (i >= nums.length) return 0;
        if (dp[i] != -1) return dp[i];
        return dp[i] = Math.max(robMax(dp, nums, i + 1), robMax(dp, nums, i + 2) + nums[i]);
    }
}

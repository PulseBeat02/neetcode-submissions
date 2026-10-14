class Solution {
    public int rob(int[] nums) {
        // 1 1 3 3
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[n - 1];
    }

    // public int rob(int[] nums) {
    //     int[] dp = new int[nums.length];
    //     Arrays.fill(dp, -1);
    //     return robMax(dp, nums, 0);
    // }

    // public int robMax(int[] dp, int[] nums, int i) {
    //     if (i >= nums.length) return 0;
    //     if (dp[i] != -1) return dp[i];
    //     return dp[i] = Math.max(robMax(dp, nums, i + 1), robMax(dp, nums, i + 2) + nums[i]);
    // }
}

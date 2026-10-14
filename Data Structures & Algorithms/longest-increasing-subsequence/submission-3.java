class Solution {
    public int lengthOfLIS(int[] nums) {
        int max = 0;
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        for (int i = 0; i < n; i++) max = Math.max(max, current(dp, nums, i));
        return max;
    }
    

    public int current(int[] dp, int[] nums, int i) {
        int n = nums.length;
        if (i >= n) return 0;
        if (dp[i] != -1) return dp[i];

        int max = 1;
        for (int j = i + 1; j < n; j++) {
            if (nums[j] > nums[i]) {
                max = Math.max(max, current(dp, nums, j) + 1);
            }
        }

        return dp[i] = max;
    }
}

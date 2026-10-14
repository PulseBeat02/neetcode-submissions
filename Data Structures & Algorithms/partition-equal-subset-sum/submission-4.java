class Solution {


    public boolean canPartition(int[] nums) {

        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 == 1) return false;

        int n = nums.length;
        int half = sum / 2;
        int[][] dp = new int[sum][n];
        for (int i = 0; i < sum; i++) {
            Arrays.fill(dp[i], -1);
        }
        return track(dp, nums, 0, 0, half, 0);
    }

    public boolean track(int[][] dp, int[] nums, int firstHalf, int secondHalf, int target, int i) {
        if (firstHalf > target || secondHalf > target) return false;
        int n = nums.length;
        if (i == n) return firstHalf == target && secondHalf == target;;
        if (dp[firstHalf][i] != -1) return dp[firstHalf][i] == 1;
        if (track(dp, nums, firstHalf + nums[i], secondHalf, target, i + 1)
            || track(dp, nums, firstHalf, secondHalf + nums[i], target, i + 1)) {
            dp[firstHalf][i] = 1;
            return true;
        }
        dp[firstHalf][i] = 0;
        return false;
    }
}

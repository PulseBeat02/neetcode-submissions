class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        int sum = 0;
        int max = nums[0];
        for (int num : nums) {
            if (sum < 0) {
                sum = 0;
            }
            sum += num;
            max = Math.max(max, sum);
        }
        return max;
    }
}

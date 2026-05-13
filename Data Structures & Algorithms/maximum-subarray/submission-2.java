class Solution {
    public int maxSubArray(int[] nums) {
        int largest = Integer.MIN_VALUE;
        int current = 0;
        for (int num : nums) {
            current = Math.max(num, current + num);
            largest = Math.max(largest, current);
        }
        return largest;
    }
}

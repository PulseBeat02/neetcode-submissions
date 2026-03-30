class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            if (nums[left] <= nums[right]) return nums[left];
            int mid = (left + right) / 2;
            if (mid > 0 && nums[mid] < nums[mid - 1]) return nums[mid];
            if (mid < n - 1 && nums[mid] > nums[mid + 1]) return nums[mid + 1];
            if (nums[mid] >= nums[left]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}

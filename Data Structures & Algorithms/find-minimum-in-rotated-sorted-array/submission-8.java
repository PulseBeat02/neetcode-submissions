class Solution {

    // n = 6
    // 3 4 5 6 1 2
    //     ^

    // 5 6 1 2 3 4
    //     ^

    public int findMin(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}

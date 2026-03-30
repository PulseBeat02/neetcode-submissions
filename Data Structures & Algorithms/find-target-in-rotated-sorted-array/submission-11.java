class Solution {

    // RIGHT
    //     |
    // [3, 4, 5, 6, 1, 2]
    //  L     M        R
    //

    //              |
    // [3, 4, 5, 6, 1, 2]
    //  L     M        R
    //

    // LEFT
    //     |
    // [5, 1, 2, 3, 4, 5]
    //  L     M        R
    //

    //              |
    // [5, 1, 2, 3, 4, 5]
    //  L     M        R
    //


    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > nums[right]) { // pivot is on the right of M
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else { // pivot is on the left of M
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}

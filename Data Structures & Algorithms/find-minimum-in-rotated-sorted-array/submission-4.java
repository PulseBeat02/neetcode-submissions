class Solution {
public int findMin(int[] nums) {
    int n = nums.length;
    int left = 0;
    int right = n - 1;

    while (left <= right) {
        // if current window is already sorted, left is the min
        if (nums[left] <= nums[right]) return nums[left];

        int mid = (left + right) / 2;

        // handle when mid itself is the minimum
        if (mid > 0 && nums[mid] < nums[mid - 1]) return nums[mid];
        // handle pivot boundary on the right
        if (mid < n - 1 && nums[mid] > nums[mid + 1]) return nums[mid + 1];

        // move toward the unsorted half
        if (nums[mid] >= nums[left]) {
            left = mid + 1;     // left half sorted -> min on right
        } else {
            right = mid - 1;    // right half sorted -> min on left
        }
    }

    // With the checks above we should have already returned.
    // This is a safe fallback:
    return nums[left % n];
}

}

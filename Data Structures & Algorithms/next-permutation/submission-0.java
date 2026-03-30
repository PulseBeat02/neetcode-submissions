class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] >= nums[i + 1]) continue;
            for (int j = n - 1; j > i; j--) {
                if (nums[j] <= nums[i]) continue;
                swap(nums, i, j);
                break;
            }
            int l = i + 1, r = n - 1;
            while (l < r) {
                swap(nums, l++, r--);
            }
            return;
        }
        for (int i = 0; i < n / 2; i++) {
            swap(nums, i, n - i - 1);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int canJump = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] + i >= canJump) {
                canJump = i;
            }
        }
        return canJump == 0;
    }
}

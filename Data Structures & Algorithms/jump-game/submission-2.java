class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] jump = new boolean[n];
        jump[0] = true;
        for (int i = 0; i < n; i++) {
            if (!jump[i]) continue;
            int far = nums[i] + i;
            if (far >= n - 1) return true;
            for (int j = i + 1; j <= far; j++) {
                jump[j] = true;
            }
        }
        return jump[n-1];
    }
}

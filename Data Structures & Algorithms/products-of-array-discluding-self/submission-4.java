class Solution {
    public int[] productExceptSelf(int[] nums) {
        // [1, 2, 4, 6]

        // [      1,  1,  2,  8, 48 ]
        // [ 48, 48, 24,  6,  1]

        // [ 48, 24, 12, 8 ]

        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        int[] suffix = new int[n];
        suffix[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = prefix[i] * suffix[i];
        }

        return ans;
    }


}  

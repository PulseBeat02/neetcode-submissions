class Solution {
    public int maxProduct(int[] nums) {

        int n = nums.length;

        int[] prefix = new int[n + 1];
        prefix[0] = 1;
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = nums[i] *
                (prefix[i] == 0 ? 1 : prefix[i]);
        }

        int[] suffix = new int[n + 1];
        suffix[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = nums[i] *
                (suffix[i + 1] == 0 ? 1 : suffix[i + 1]);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) max = Math.max(max, Math.max(prefix[i + 1], suffix[i]));
        
        return max;
    }
}

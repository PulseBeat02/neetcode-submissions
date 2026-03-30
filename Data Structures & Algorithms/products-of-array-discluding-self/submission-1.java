class Solution {
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;

        // PREFIX:
        // 1 1 2 8 48
        // 1 a a*b a*b*c a*b*c*d

        int[] prefix = new int[n+1];
        prefix[0] = 1;
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        // SUFFIX:
        // 1 6 24 48 1
        // 1 d c*d b*c*d a*b*c*d

        int[] suffix = new int[n+1];
        suffix[0] = 1;
        for (int i = 1; i < suffix.length; i++) {
            suffix[i] = suffix[i - 1] * nums[n - i];
        }

        // 48 24 12 8
        // b*c*d a*c*d a*b*d a*b*c
        // PREFIX[0] * SUFFIX[3]
        // PREFIX[1] * SUFFIX[2]
        // PREFIX[2] * SUFFIX[1]
        // PREFIX[3] * SUFFIX[0]
        int[] products = new int[n];
        for (int i = 0; i < n; i++) {
            products[i] = prefix[i] * suffix[n - i - 1];
        }

        return products;

    }
}  

class Solution {
    public int maxProduct(int[] nums) {
        int maxHere = nums[0];
        int minHere = nums[0];
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int x = nums[i];
            int prevMax = maxHere, prevMin = minHere;
            maxHere = Math.max(x, Math.max(x * prevMax, x * prevMin));
            minHere = Math.min(x, Math.min(x * prevMax, x * prevMin));
            ans = Math.max(ans, maxHere);
        }
        return ans;
    }
}

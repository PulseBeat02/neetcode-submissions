class Solution {


    /*

    2 4 1 1 1 1




    */

    public int jump(int[] nums) {
        int result = 0;
        int left = 0;
        int right = 0;
        while (right < nums.length - 1) {
            int max = 0;
            for (int i = left; i <= right; i++) {
                max = Math.max(max, nums[i] + i);
            }
            left = right + 1;
            right = max;
            result++;
        }
        return result;
    }
}

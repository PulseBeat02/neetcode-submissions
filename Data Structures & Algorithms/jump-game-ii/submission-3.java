class Solution {


    /*

    2 4 1 1 1 1




    */

    public int jump(int[] nums) {
        int n = nums.length;
        int[] canReach = new int[n];
        Arrays.fill(canReach, -1);
        canReach[0] = 0;
        for (int i = 0; i < n; i++) {
            if (canReach[i] == -1) continue;
            for (int j = i + 1; j <= i + nums[i] && j < n; j++) {
                if (canReach[j] == -1) {
                    canReach[j] = canReach[i] + 1;
                } else {
                    canReach[j] = Math.min(canReach[i] + 1, canReach[j]);
                }
            }
        }
        return canReach[n - 1];
    }
}

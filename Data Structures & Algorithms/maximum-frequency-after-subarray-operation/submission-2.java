class Solution {
    public int maxFrequency(int[] nums, int k) {
    

        int n = nums.length;
        int max = 0;
        for (int target = 1; target <= 50; target++) {
            if (target == k) continue;
            int count = 0;
            int best = 0;
            for (int num : nums) {
                if (num == target) count++;
                if (num == k) count--;
                count = Math.max(count, 0);
                best = Math.max(best, count);
            }
            max = Math.max(max, best);
        }

        int freq = 0;
        for (int num : nums) {
            if (num == k) freq++;
        }

        return freq + max;
    }
}
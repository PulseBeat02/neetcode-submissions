class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Set<Integer> starts = new HashSet<>();
        for (int num : nums) starts.add(num);

        int longest = 1;
        for (int num : nums) {
            if (!starts.contains(num - 1)) {
                int curr = 0;
                while (starts.contains(num + curr)) {
                    curr++;
                }
                longest = Math.max(longest, curr);
            }
        }
        
        return longest;
    }
}

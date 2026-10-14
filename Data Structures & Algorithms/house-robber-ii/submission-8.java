class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        List<Integer> orig = new ArrayList<>();
        for (int num : nums) orig.add(num);

        int removeFirst = orig.removeFirst();
        int first = rob0(orig);
        orig.addFirst(removeFirst);

        int removeLast = orig.removeLast();
        int second = rob0(orig);

        return Math.max(first, second);
    }

    public int rob0(List<Integer> nums) {
        int n = nums.size();
        if (n == 0) return 0;
        if (n == 1) return nums.get(0);
        int[] dp = new int[n];
        dp[0] = nums.get(0);
        dp[1] = Math.max(nums.get(0), nums.get(1));
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums.get(i));
        }
        return dp[n - 1];
    }
}

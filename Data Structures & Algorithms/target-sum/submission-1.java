class Solution {

    Map<String, Integer> dp = new HashMap<>();

    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums, 0, target);
    }

    public int dfs(int[] nums, int index, int target) {
        if (target == 0 && index == nums.length) return 1;
        if (index >= nums.length) return 0;
        String hash = index + "-" + target;
        if (dp.containsKey(hash)) {
            return dp.get(hash);
        }
        dp.put(hash, dfs(nums, index + 1, target + nums[index])
            + dfs(nums, index + 1, target - nums[index]));
        return dp.get(hash);
    }
}

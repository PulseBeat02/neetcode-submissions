class Solution {

    Map<String, Integer> dp = new HashMap<>();

    public int findTargetSumWays(int[] nums, int target) {
        return find(nums, 0, 0, target);
    }

    public int find(int[] nums, int index, int current, int target) {
        if (index == nums.length) return current == target ? 1 : 0;
        String key = index + "=" + current;
        if (dp.containsKey(key)) return dp.get(key);
        dp.put(key, find(nums, index + 1, current + nums[index], target)
            + find(nums, index + 1, current - nums[index], target));
        return dp.get(key);
    }
}

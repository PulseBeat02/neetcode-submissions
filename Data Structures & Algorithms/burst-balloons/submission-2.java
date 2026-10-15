class Solution {
    public int maxCoins(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) list.add(num);
        return dfs(new HashMap<>(), list);
    }
    
    public int dfs(Map<List<Integer>, Integer> dp, List<Integer> nums) {
        if (nums.isEmpty()) return 0;
        if (dp.containsKey(nums)) return dp.get(nums);
        int max = 0;
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            int before = i == 0 ? 1 : nums.get(i - 1);
            int middle = nums.get(i);
            int after = i == n - 1 ? 1 : nums.get(i + 1);
            int added = before * middle * after;
            List<Integer> copy = new ArrayList<>(nums);
            copy.remove(i);
            max = Math.max(max, dfs(dp, copy) + added);
        }
        dp.put(nums, max);
        return max;
    }
}

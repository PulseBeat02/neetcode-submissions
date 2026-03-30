class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> solutions = new ArrayList<>();
        backtrack(nums, target, 0, new ArrayList<>(), 0, solutions);
        return solutions;
    }

    public void backtrack(int[] nums, int target, int start, List<Integer> current, int sum, List<List<Integer>> ans) {
        if (sum == target) {
            ans.add(new ArrayList<>(current));
            return;
        }
        if (sum > target) return;
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            current.add(nums[i]);
            sum += nums[i];
            backtrack(nums, target, i + 1, current, sum, ans);
            sum -= nums[i];
            current.remove(current.size() - 1);
        }
    }
}

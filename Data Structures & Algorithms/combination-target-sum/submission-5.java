class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), 0, target, nums, 0);
        return ans;
    }

    public void backtrack(List<List<Integer>> ans, List<Integer> current, int currentSum, int target, int[] nums, int index) {
        if (currentSum == target) {
            ans.add(new ArrayList<>(current));
            return;
        }
        if (currentSum > target) return;
        for (int i = index; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            current.add(nums[i]);
            backtrack(ans, current, currentSum + nums[i], target, nums, i);
            current.removeLast();
        }
    }
}

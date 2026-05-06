class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), 0, target, 0, nums);
        return ans;
    }

    public void backtrack(List<List<Integer>> ans, List<Integer> current, int sum, int target, int n, int[] nums) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            ans.add(new ArrayList<>(current));
            return;
        }
        for (int i = n; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(ans, current, sum + nums[i], target, i, nums);
            current.removeLast();
        }
    }
}

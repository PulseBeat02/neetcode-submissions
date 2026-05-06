class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), 0, nums);
        return ans;
    }

    public void backtrack(List<List<Integer>> ans, List<Integer> current, int n, int[] nums) {
        ans.add(new ArrayList<>(current));
        for (int i = n; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(ans, current, i + 1, nums);
            current.removeLast();
        }
    }
}

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), nums, 0);
        return ans;
    }

    public void backtrack(List<List<Integer>> list, List<Integer> current, int[] nums, int index) {
        list.add(new ArrayList<>(current));
        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(list, current, nums, i + 1);
            current.removeLast();
        }
    }
}

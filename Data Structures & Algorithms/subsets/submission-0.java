class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), list);
        return list;
    }

    public void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> all) {
        all.add(new ArrayList<>(current));
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(nums, i + 1, current, all);
            current.remove(current.size() - 1);
        }
    }
}

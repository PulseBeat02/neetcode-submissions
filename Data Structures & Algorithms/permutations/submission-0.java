class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(nums, new boolean[nums.length], new ArrayList<>(), list);
        return list;
    }

    public void backtrack(int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> ans) {
        if (current.size() == nums.length) {
            ans.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            current.add(nums[i]);
            backtrack(nums, used, current, ans);
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}

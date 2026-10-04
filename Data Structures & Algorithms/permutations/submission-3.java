class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), new boolean[nums.length], nums);
        return ans;
    }

    public void backtrack(List<List<Integer>> ans, List<Integer> current, boolean[] used, int[] nums) {
        if (current.size() == nums.length) {
            ans.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            current.add(nums[i]);
            backtrack(ans, current, used, nums);
            current.removeLast();
            used[i] = false;
        }
    }
}

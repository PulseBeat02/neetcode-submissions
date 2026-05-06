class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), new boolean[nums.length], nums);
        return ans;
    }

    public void backtrack(List<List<Integer>> ans, List<Integer> current, boolean[] picked, int[] nums) {
        if (current.size() == nums.length) {
            ans.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (picked[i]) continue;
            picked[i] = true;
            current.add(nums[i]);
            backtrack(ans, current, picked, nums);
            current.removeLast();
            picked[i] = false;
        }
    }
}

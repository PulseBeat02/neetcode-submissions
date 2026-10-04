class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), 0, nums);
        return ans;
    }

    // 1 1 2
    // [[],[1],[1,2],[1,1],[1,1,2],[2]]



    public void backtrack(List<List<Integer>> ans, List<Integer> current, int index, int[] nums) {
        ans.add(new ArrayList<>(current));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue;
            current.add(nums[i]);
            backtrack(ans, current, i + 1, nums);
            current.removeLast();
        }
    }
}

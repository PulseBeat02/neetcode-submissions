class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), 0, target, 0, candidates);
        return ans;
    }

    public void backtrack(List<List<Integer>> ans, List<Integer> current, int currentSum, int target, int n, int[] candidates) {
        if (currentSum > target) return;
        if (currentSum == target) {
            ans.add(new ArrayList<>(current));
            return;
        }
        for (int i = n; i < candidates.length; i++) {
            if (i > n && candidates[i] == candidates[i - 1]) continue;
            current.add(candidates[i]);
            backtrack(ans, current, currentSum + candidates[i], target, i + 1, candidates);
            current.removeLast();
        }
    }
}

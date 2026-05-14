class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> valid, String current, int left, int right, int n) {
        if (left == n && right == n) {
            valid.add(current);
            return;
        }
        if (left < n) {
            backtrack(valid, current + "(", left + 1, right, n);
        }
        if (right < left) {
            backtrack(valid, current + ")", left, right + 1, n);
        }
    }
}

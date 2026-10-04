class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, String current, int left, int right, int n) {
        if (left == n && right == n) {
            ans.add(new String(current));
            return;
        }
        
        if (left + right > 2 * n) return;

        if (left < n) backtrack(ans, current + "(", left + 1, right, n);
        if (right < left) backtrack(ans, current + ")", left, right + 1, n);
    }
}

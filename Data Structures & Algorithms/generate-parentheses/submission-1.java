class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(0, 0, n, "", ans);
        return ans;
    }

    public void generate(int left, int right, int n, String current, List<String> running) {

        int length = current.length();
        if (length == n * 2 && left == right) {
            running.add(current);
            return;
        }

        if (length > n * 2) return;

        if (right > left) return;

        generate(left + 1, right, n, current + "(", running);
        generate(left, right + 1, n, current + ")", running);
    }
}

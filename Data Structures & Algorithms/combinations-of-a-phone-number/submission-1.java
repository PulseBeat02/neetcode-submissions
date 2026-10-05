class Solution {

    Map<Integer, String> map = 
        Map.of(
            2, "abc",
            3, "def",
            4, "ghi",
            5, "jkl",
            6, "mno",
            7, "pqrs",
            8, "tuv",
            9, "wxyz"
        );

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return List.of();
        List<String> ans = new ArrayList<>();
        backtrack(ans, "", 0, digits);
        return ans;
    }

    public void backtrack(List<String> ans, String current, int index, String digits) {
        if (index == digits.length()) {
            ans.add(new String(current));
            return;
        }
        String possible = map.get(digits.charAt(index) - '0');
        char[] chars = possible.toCharArray();
        for (char c : chars) {
            current += c;
            backtrack(ans, current, index + 1, digits);
            current = current.substring(0, current.length() - 1);
        }
    }
}

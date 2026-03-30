class Solution {

    Map<Character, String> map = Map.of(
        '2', "abc",
        '3', "def",
        '4', "ghi",
        '5', "jkl",
        '6', "mno",
        '7', "pqrs",
        '8', "tuv",
        '9', "wxyz"
    );

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) return List.of();
        List<String> ans = new ArrayList<>();
        backtrack(ans, digits, "", 0);
        return ans;
    }

    public void backtrack(List<String> ans, String digits, String current, int index) {
        if (index == digits.length()) {
            ans.add(new String(current));
            return;
        }
        char c = digits.charAt(index);
        char[] mappings = map.get(c).toCharArray();
        for (char map : mappings) {
            current += map;
            backtrack(ans, digits, current, index + 1);
            current = current.substring(0, current.length() - 1);
        }
    }
}

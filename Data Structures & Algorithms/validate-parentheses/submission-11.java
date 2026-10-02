class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = Map.of(
            ')', '(',
            '}', '{',
            ']', '['
        );

        // ([{}])

        // 
        // {
        // [
        // (

        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (map.containsKey(c)) {
                if (stack.isEmpty()) return false;
                char popped = stack.pop();
                if (popped != map.get(c)) return false;
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}

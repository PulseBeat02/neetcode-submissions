class Solution {
    public List<List<String>> partition(String s) {
        Map<Integer, Set<Integer>> substrings = getPalindromes(s);
        Set<List<String>> ans = new HashSet<>();
        backtrack(ans, new ArrayList<>(), 0, s, substrings);
        List<List<String>> res = new ArrayList<>();
        res.addAll(ans);
        return res;
    }

    public void backtrack(Set<List<String>> ans, List<String> current, int index, String target, Map<Integer, Set<Integer>> candidates) {
        if (index == target.length()) {
            ans.add(new ArrayList<>(current));
            return;
        }
        if (index > target.length()) return;
        final Set<Integer> ends = candidates.get(index);
        for (int end : ends) {
            current.add(target.substring(index, end + 1));
            backtrack(ans, current, end + 1, target, candidates);
            current.removeLast();
        }
    }

    public Map<Integer, Set<Integer>> getPalindromes(String s) {
        Map<Integer, Set<Integer>> palindromes = new HashMap<>();
        int n = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int start = i;
            int left = start;
            int right = start;
            while (left >= 0 && left < n 
                    && right >= 0 && right < n
                    && chars[left] == chars[right]) {
                palindromes.computeIfAbsent(left, k -> new HashSet<>())
                    .add(right);
                left--;
                right++;
            }
            left = start;
            right = start + 1;
            while (left >= 0 && left < n 
                    && right >= 0 && right < n
                    && chars[left] == chars[right]) {
                palindromes.computeIfAbsent(left, k -> new HashSet<>())
                    .add(right);
                left--;
                right++;
            }
        }
        return palindromes;
    }
}

class Solution {
    public String minWindow(String s, String t) {

        if (t.length() > s.length()) return "";

        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);

        Map<Character, Integer> check = new HashMap<>();
        int shortest = Integer.MAX_VALUE;
        String target = null;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            check.put(s.charAt(i), check.getOrDefault(s.charAt(i), 0) + 1);
            if (valid(check, map)) {
                while (valid(check, map)) {
                    if (i - left + 1 < shortest) {
                        shortest = i - left + 1;
                        target = s.substring(left, i + 1);
                    }
                    char c = s.charAt(left);
                    check.put(c, check.get(c) - 1);
                    left++;
                }
            }
        }

         return target == null ? "" : target;
    }

    public boolean valid(Map<Character, Integer> check, Map<Character, Integer> target) {
        for (char c : target.keySet()) {
            if (check.getOrDefault(c, 0) < target.get(c)) {
                return false;
            }
        }
        return true;
    }
}

class Solution {
    public String longestPalindrome(String s) {
        String max = "";
        for (int i = 0; i < s.length(); i++) {
            String tmp = expand(s, i);
            if (tmp.length() > max.length()) max = tmp;
        }
        return max;
    }

    public String expand(String s, int current) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int left = current;
        int right = current;
        String max = "";
        while (true) {
            if (left < 0 || left >= n || right < 0 || right >= n) break;
            if (chars[left] != chars[right]) break;
            if (right - left + 1 > max.length()) {
                max = s.substring(left, right + 1);
            }
            left--;
            right++;
        }
        left = current;
        right = current + 1;
                while (true) {
            if (left < 0 || left >= n || right < 0 || right >= n) break;
            if (chars[left] != chars[right]) break;
            if (right - left + 1 > max.length()) {
                max = s.substring(left, right + 1);
            }
            left--;
            right++;
        }
        return max;
    }


}

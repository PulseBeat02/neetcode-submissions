class Solution {
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        String max = "";
        for (int i = 0; i < n; i++) {

            // odd count (middle)
            int left = i;
            int right = i;
            while (true) {
                if (left < 0 || right >= n) break;
                if (chars[left] != chars[right]) break;
                String str = s.substring(left, right + 1);
                if (str.length() > max.length()) max = str;
                left--;
                right++;
            }

            // even count
            left = i;
            right = i + 1;
            while (true) {
                if (left < 0 || right >= n) break;
                if (chars[left] != chars[right]) break;
                String str = s.substring(left, right + 1);
                if (str.length() > max.length()) max = str;
                left--;
                right++;
            }
        }

        return max;
    }
}

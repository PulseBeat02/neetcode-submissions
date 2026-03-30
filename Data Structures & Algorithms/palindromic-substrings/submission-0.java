class Solution {
    public int countSubstrings(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int count = 0;
        for (int i = 0; i < n; i++) {

            // odd count (middle)
            int left = i;
            int right = i;
            while (true) {
                if (left < 0 || right >= n) break;
                if (chars[left] != chars[right]) break;
                count++;
                left--;
                right++;
            }

            // even count
            left = i;
            right = i + 1;
            while (true) {
                if (left < 0 || right >= n) break;
                if (chars[left] != chars[right]) break;
                count++;
                left--;
                right++;
            }
        }

        return count;
    }
}

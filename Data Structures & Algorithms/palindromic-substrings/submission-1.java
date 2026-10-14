class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            count += countAndExpand(s, i);
        }
        return count;
    }

    public int countAndExpand(String s, int current) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int count = 0;
        int left = current;
        int right = current;
        while (true) {
            if (left < 0 || left >= n || right < 0 || right >= n) break;
            if (chars[left] != chars[right]) break;
            count++;
            left--;
            right++;
        }
        left = current;
        right = current + 1;
        while (true) {
            if (left < 0 || left >= n || right < 0 || right >= n) break;
            if (chars[left] != chars[right]) break;
            count++;
            left--;
            right++;
        }
        return count;
    }

}

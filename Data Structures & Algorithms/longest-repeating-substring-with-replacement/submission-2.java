class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int[] count = new int[26];
        int max = 0;
        int maxCount = 0;
        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount, count[s.charAt(right) - 'A']);
            while ((right - left + 1) - maxCount > k) {
                count[s.charAt(left) - 'A']--;
                left++;
                maxCount = Math.max(maxCount, count[s.charAt(left) - 'A']);
            }
            max = Math.max(right - left + 1, max);
        }
        return max;
    }
}

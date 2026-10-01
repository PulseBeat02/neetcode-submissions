class Solution {
    public int characterReplacement(String s, int k) {
        // XYYK
        Map<Character, Integer> map = new HashMap<>();
        int maxFrequency = 0;
        char[] chars = s.toCharArray();
        int n = s.length();
        int left = 0;
        int max = 0;
        int maxFreq = 0;
        for (int right = 0; right < n; right++) {
            char c = chars[right];
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(c));
            while ((right - left + 1) - maxFreq > k) {
                map.put(chars[left], map.get(chars[left]) - 1);
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}

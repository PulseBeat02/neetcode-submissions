class Solution {
public int characterReplacement(String s, int k) {
    int[] count = new int[26];
    int left = 0, maxCount = 0, res = 0;
    for (int right = 0; right < s.length(); right++) {
        int idx = s.charAt(right) - 'A';
        count[idx]++;
        maxCount = Math.max(maxCount, count[idx]);
        while ((right - left + 1) - maxCount > k) {
            count[s.charAt(left) - 'A']--;
            left++;
        }
        res = Math.max(res, right - left + 1);
    }
    return res;
}

}

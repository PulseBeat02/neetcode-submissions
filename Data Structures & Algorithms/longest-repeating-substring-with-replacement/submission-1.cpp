class Solution {
public:
    int characterReplacement(string s, int k) {
        int left = 0;
        int arr[26] = {0};
        int maxCount = 0;
        int ans = 0;
        for (int right = 0; right < s.size(); right++) {
            arr[s[right] - 'A']++;
            maxCount = max(maxCount, arr[s[right] - 'A']);
            while ((right - left + 1) - maxCount > k) {
                arr[s[left] - 'A']--;
                left++;
            }
            ans = max(ans, right - left + 1);
        }
        return ans;
    }
};

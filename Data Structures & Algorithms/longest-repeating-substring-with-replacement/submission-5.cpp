class Solution {
public:
    int characterReplacement(string s, int k) {
        unordered_map<char, int> counts;
        int left = 0;
        int maxFreq = 0;
        int res = 0;
        for (int right = 0; right < s.size(); right++) {
            counts[s[right]]++;
            maxFreq = max(counts[s[right]], maxFreq);
            while ((right - left + 1) - maxFreq > k) {
                counts[s[left]]--;
                left++;
            }
            res = max(right - left + 1, res);
        }
        return res;
    }
};

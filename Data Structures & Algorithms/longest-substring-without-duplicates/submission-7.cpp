class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_set<char> window;
        int longest = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char current = s[right];
            if (window.count(current)) {
                while (window.count(current)) {
                    window.erase(s[left]);
                    left++;
                }
            }
            window.insert(current);
            longest = max(right - left + 1, longest);
        }
        return longest;
    }
};

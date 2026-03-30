class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int max = 0;
        int left = 0;
        unordered_set<char> set;
        for (int right = 0; right < s.size(); right++) {
            while (set.count(s[right])) {
                set.erase(s[left]);
                left++;
            }
            set.insert(s[right]);
            max = std::max(max, right - left + 1);
        }
        return max;
    }
};

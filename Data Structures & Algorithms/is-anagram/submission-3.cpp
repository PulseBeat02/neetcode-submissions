class Solution {
public:
    bool isAnagram(string s, string t) {
        int first[26] = {0};
        int second[26] = {0};
        for (char c : s) first[c - 'a']++;
        for (char c : t) second[c - 'a']++;
        return equal(first, first + 26, second);
    }
};

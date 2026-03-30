class Solution {
public:
    bool isAnagram(string s, string t) {
        int first[26] = {0};
        for (char c : s) first[c - 'a']++;

        int second[26] = {0};
        for (char c : t) second[c - 'a']++;

        for (int i = 0; i < 26; i++) {
            if (first[i] != second[i]) return false;
        } 

        return true;
    }
};
